package com.bertolucci.produtoscrud.controller;

import com.bertolucci.produtoscrud.dto.ProdutoDTO;
import com.bertolucci.produtoscrud.model.Produto;
import com.bertolucci.produtoscrud.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	private static final String PRODUTO = "produto";
	private static final String REDIRECT = "redirect:/list";

	@GetMapping("/list")
	public String listProduto(ModelMap model) {
		model.put("produtos", produtoService.getProdutos());
		return "list";
	}

	@PostMapping("/add")
	public String addProduto(ProdutoDTO produtoDTO, BindingResult result) {
		if (result.hasErrors()) {
			return PRODUTO;
		}

		Produto persistanceProduto = produtoService.mapProdutoDtoParaProdutoPersistencia(produtoDTO);
		produtoService.saveProduto(persistanceProduto);
		return REDIRECT;
	}

	@GetMapping("/add")
	public String addProdutoPage(ModelMap model) {
		model.addAttribute(PRODUTO, new Produto());
		return PRODUTO;
	}

	@PostMapping("/update")
	public String updateProduto(ProdutoDTO produtoDTO, BindingResult result) {
		if (result.hasErrors()) {
			return PRODUTO;
		}

		produtoService.updateProduto(produtoDTO);
		return REDIRECT;
	}

	@GetMapping("/update")
	public String updateProdutoPage(@RequestParam long id, ModelMap model) {
		Optional<Produto> produto = produtoService.getProdutoById(id);
		produto.ifPresent(value -> model.put(PRODUTO, value));
		return PRODUTO;
	}

	@GetMapping("/delete")
	public String deleteTodo(@RequestParam long id) {
		produtoService.deleteProduto(id);
		return REDIRECT;
	}
}
