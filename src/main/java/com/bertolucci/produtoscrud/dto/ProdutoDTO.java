package com.bertolucci.produtoscrud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDTO {
    private long id;
    private String nome;
    private Double valor;
    private String descricao;
    private Integer desconto;
    private Double valorAposDesconto;
}
