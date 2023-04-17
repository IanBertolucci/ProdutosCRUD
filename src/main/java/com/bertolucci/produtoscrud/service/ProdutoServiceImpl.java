package com.bertolucci.produtoscrud.service;

import java.util.List;
import java.util.Optional;

import com.bertolucci.produtoscrud.dto.ProdutoDTO;
import com.bertolucci.produtoscrud.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bertolucci.produtoscrud.repository.ProdutoRepository;

@Service
public class ProdutoServiceImpl implements ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Override
	public List<Produto> getProdutos() {
		return produtoRepository.findAll();
	}

	@Override
	public Produto getProdutoByNome(String nome) {
		return produtoRepository.findByNome(nome).orElse(null);
	}

	@Override
	public void saveProduto(Produto produto) {
		produtoRepository.save(produto);
	}

	@Override
	public Produto mapProdutoDtoParaProdutoPersistencia(ProdutoDTO produtoDTO) {
		Produto persistanceProduto = new Produto();
		persistanceProduto.setNome(produtoDTO.getNome());
		persistanceProduto.setDescricao(produtoDTO.getDescricao());
		persistanceProduto.setValor(produtoDTO.getValor());
		persistanceProduto.setDesconto(produtoDTO.getDesconto());
		persistanceProduto.setValorAposDesconto(calcularValorAposDesconto(produtoDTO.getDesconto(), produtoDTO.getValor()));
		return persistanceProduto;
	}

	private Double calcularValorAposDesconto(Integer desconto, Double valor) {
		Double valorDescontado = valor * (desconto.doubleValue()/100);
		return valor - valorDescontado;
	}

	@Override
	public void updateProduto(Produto produto) {
		produtoRepository.save(produto);
	}

	@Override
	public void deleteProduto(String nome) {
		Optional<Produto> produto = produtoRepository.findByNome(nome);
		produto.ifPresent(this::delete);
	}

	private void delete(Produto obj) {
		produtoRepository.delete(obj);
	}
}