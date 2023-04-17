package com.bertolucci.produtoscrud.service;

import java.util.List;

import com.bertolucci.produtoscrud.dto.ProdutoDTO;
import com.bertolucci.produtoscrud.model.Produto;

public interface ProdutoService {

	List<Produto> getProdutos();

	Produto getProdutoByNome(String nome);

	void updateProduto(Produto produto);

	void deleteProduto(String nome);
	
	void saveProduto(Produto produto);

	Produto mapProdutoDtoParaProdutoPersistencia(ProdutoDTO produtoDTO);

}