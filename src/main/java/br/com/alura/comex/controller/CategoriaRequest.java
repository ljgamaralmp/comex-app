package br.com.alura.comex.controller;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CategoriaRequest {

    @NotBlank(message = "O nome não pode estar em branco.")
    @Size(min = 2, message = "O nome deve possuir pelo menos 2 caracteres.")
    private String nome;

 
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}