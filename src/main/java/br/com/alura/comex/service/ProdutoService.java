package br.com.alura.comex.service;

import br.com.alura.comex.controller.ProdutoRequest;
import br.com.alura.comex.model.Categoria;
import br.com.alura.comex.model.Produto;
import br.com.alura.comex.repository.CategoriaRepository;
import br.com.alura.comex.repository.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Produto cadastrar(ProdutoRequest request) {
        // Regra: ID da categoria deve ser válido
        Categoria categoria = categoriaRepository.findById(request.getCategoriaId())
                .orElseThrow(() -> new EntityNotFoundException("Categoria não encontrada com o ID: " + request.getCategoriaId()));

        // Mapeamento do DTO para a Entidade
        Produto produto = new Produto();
        produto.setNome(request.getNome());
        produto.setDescricao(request.getDescricao());
        produto.setPreco(request.getPreco());
        produto.setQuantidadeEstoque(request.getQuantidadeEstoque());
        produto.setCategoria(categoria);

        return produtoRepository.save(produto);
    }
}