package com.myexample.dsmeta.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.myexample.dsmeta.entidades.Venda;

public interface VendaRepositorio extends JpaRepository<Venda, Long> {

}
