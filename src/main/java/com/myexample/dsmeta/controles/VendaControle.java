package com.myexample.dsmeta.controles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myexample.dsmeta.entidades.Venda;
import com.myexample.dsmeta.servicos.VendaServico;

@RestController
@RequestMapping(value = "/vendas")
public class VendaControle {
	@Autowired
	private VendaServico service;
	
	@GetMapping
	public List<Venda> buscaVenda(){
		return service.buscaVendas();
	}
}
