package com.myexample.dsmeta.controles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myexample.dsmeta.entidades.Venda;
import com.myexample.dsmeta.servicos.VendaServico;

@RestController
@RequestMapping(value = "/vendas")
public class VendaControle {
	@Autowired
	private VendaServico service;
	
	//Resultado Paginado
	@GetMapping
	public Page<Venda> buscaVenda(
			@RequestParam(value="minDate", defaultValue = "") String minDate,
			@RequestParam(value="maxDate", defaultValue = "") String maxDate,
			Pageable paginacao){
		return service.buscaVendas(minDate, maxDate, paginacao);
	}
	
	//PEGAR GERAL TODOS
	//public List<Venda> buscaVenda(){
	//	return service.buscaVendas();
	//}
}
