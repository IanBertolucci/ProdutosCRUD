package com.bertolucci.produtoscrud.repository;

import com.bertolucci.produtoscrud.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	Optional<Produto> findByNome(String nome);
}
