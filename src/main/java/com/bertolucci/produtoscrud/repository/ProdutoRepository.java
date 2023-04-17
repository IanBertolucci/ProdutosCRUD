package com.bertolucci.produtoscrud.repository;

import com.bertolucci.produtoscrud.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
}
