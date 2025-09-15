
package br.com.alura.comex.controller;

import br.com.alura.comex.model.Produto;
import br.com.alura.comex.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Produto> cadastrar(@RequestBody @Valid ProdutoRequest request, UriComponentsBuilder uriBuilder) {
        Produto produtoSalvo = produtoService.cadastrar(request);

        URI uri = uriBuilder.path("/api/produtos/{id}").buildAndExpand(produtoSalvo.getId()).toUri();
        return ResponseEntity.created(uri).body(produtoSalvo);
    }
}