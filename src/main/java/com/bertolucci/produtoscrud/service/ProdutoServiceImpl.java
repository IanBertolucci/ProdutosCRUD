package com.bertolucci.produtoscrud.service;

import com.bertolucci.produtoscrud.dto.ProdutoDTO;
import com.bertolucci.produtoscrud.model.Produto;
import com.bertolucci.produtoscrud.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServiceImpl implements ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Override
	public List<Produto> getProdutos() {
		return produtoRepository.findAll();
	}

	@Override
	public Optional<Produto> getProdutoById(long id) {
		return produtoRepository.findById(id);
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

	@Override
	public void updateProduto(ProdutoDTO produtoDTO) {
		Optional<Produto> produtoPersistance = produtoRepository.findById(produtoDTO.getId());
		if (produtoPersistance.isPresent()){
			Produto produto = produtoPersistance.get();
			produto.setNome(produtoDTO.getNome());
			produto.setDescricao(produtoDTO.getDescricao());
			produto.setValor(produtoDTO.getValor());
			produto.setDesconto(produtoDTO.getDesconto());
			produto.setValorAposDesconto(calcularValorAposDesconto(produtoDTO.getDesconto(), produtoDTO.getValor()));
			produtoRepository.save(produto);
		}
	}

	private Double calcularValorAposDesconto(Integer desconto, Double valor) {
		Double valorDescontado = valor * (desconto.doubleValue()/100);
		return BigDecimal.valueOf(valor - valorDescontado).setScale(2, RoundingMode.CEILING).doubleValue();
	}

	@Override
	public void deleteProduto(long id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		produto.ifPresent(this::delete);
	}

	private void delete(Produto obj) {
		produtoRepository.delete(obj);
	}
}