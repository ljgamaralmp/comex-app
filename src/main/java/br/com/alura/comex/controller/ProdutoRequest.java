package br.com.alura.comex.controller;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;

public class ProdutoRequest {

    @NotBlank(message = "O nome é obrigatório.")
    @Size(min = 2, message = "O nome deve ter pelo menos 2 caracteres.")
    private String nome;

    @NotNull(message = "O preço é obrigatório.")
    @Positive(message = "O preço deve ser um valor positivo.")
    private BigDecimal preco;

    private String descricao;

    @NotNull(message = "A quantidade em estoque é obrigatória.")
    private Integer quantidadeEstoque;

    @NotNull(message = "O ID da categoria é obrigatório.")
    private Long categoriaId;


    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public BigDecimal getPreco() { return preco; }
    public void setPreco(BigDecimal preco) { this.preco = preco; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public Integer getQuantidadeEstoque() { return quantidadeEstoque; }
    public void setQuantidadeEstoque(Integer quantidadeEstoque) { this.quantidadeEstoque = quantidadeEstoque; }
    public Long getCategoriaId() { return categoriaId; }
    public void setCategoriaId(Long categoriaId) { this.categoriaId = categoriaId; }
}