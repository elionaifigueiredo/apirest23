package com.pacote.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pacote.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	
	Produto findById(long id);
	
}
