package com.bertolucci.produtoscrud.service;

import java.util.List;
import java.util.Optional;

import com.bertolucci.produtoscrud.dto.ProdutoDTO;
import com.bertolucci.produtoscrud.model.Produto;

public interface ProdutoService {

	List<Produto> getProdutos();

	Optional<Produto> getProdutoById(long id);

	void updateProduto(ProdutoDTO produtoDTO);

	void deleteProduto(long id);
	
	void saveProduto(Produto produto);

	Produto mapProdutoDtoParaProdutoPersistencia(ProdutoDTO produtoDTO);

}