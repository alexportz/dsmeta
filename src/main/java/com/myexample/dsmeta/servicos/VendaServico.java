package com.myexample.dsmeta.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myexample.dsmeta.entidades.Venda;
import com.myexample.dsmeta.repositorios.VendaRepositorio;

@Service
public class VendaServico {
	
	@Autowired
	private VendaRepositorio repository;
	public List<Venda> buscaVendas(){
		return repository.findAll();
	}

}
