package com.myexample.dsmeta.repositorios;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.myexample.dsmeta.entidades.Venda;

public interface VendaRepositorio extends JpaRepository<Venda, Long> {
	@Query("SELECT obj FROM Venda obj WHERE obj.date BETWEEN :min AND :max ORDER BY obj.amount DESC")
	Page<Venda> findSales(LocalDate min, LocalDate max, Pageable paginacao);
}
