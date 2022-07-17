package com.myexample.dsmeta.servicos;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.myexample.dsmeta.entidades.Venda;
import com.myexample.dsmeta.repositorios.VendaRepositorio;

@Service
public class VendaServico {
	
	@Autowired
	private VendaRepositorio repository;
	public Page<Venda> buscaVendas(
			String minDate,
			String maxDate,
			Pageable paginacao){
		
		LocalDate hoje = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		LocalDate dataInicio = hoje.minusDays(7);
		
		LocalDate min = minDate.equals("") ? dataInicio : LocalDate.parse(minDate);
		LocalDate max = maxDate.equals("") ? hoje : LocalDate.parse(maxDate);
		
		return repository.findSales(min, max, paginacao);
	}
	
	//PEGAR TUDO NO RETORNO
	//private VendaRepositorio repository;
	//public List<Venda> buscaVendas(){
	//	return repository.findAll();
	//}

}
