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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

	@PutMapping("/update")
	public String updateProduto(Produto produto, BindingResult result) {
		if (result.hasErrors()) {
			return PRODUTO;
		}

		produtoService.updateProduto(produto);
		return REDIRECT;
	}

	@GetMapping("/update")
	public String updateProdutoPage(@RequestParam String nome, ModelMap model) {
		model.put(PRODUTO, produtoService.getProdutoByNome(nome));
		return PRODUTO;
	}

	@GetMapping("/delete")
	public String deleteTodo(@RequestParam String nome) {
		produtoService.deleteProduto(nome);
		return REDIRECT;
	}
}
