
package br.com.alura.comex.controller;

import br.com.alura.comex.model.Categoria;
import br.com.alura.comex.model.StatusCategoria;
import br.com.alura.comex.repository.CategoriaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public ResponseEntity<List<Categoria>> listar() {
        List<Categoria> categorias = categoriaRepository.findAll();
        return ResponseEntity.ok(categorias);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscarPorId(@PathVariable Long id) {
        Optional<Categoria> categoriaOptional = categoriaRepository.findById(id);

        return categoriaOptional
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Categoria> cadastrar(@RequestBody @Valid CategoriaRequest request, UriComponentsBuilder uriBuilder) {
        Categoria categoria = new Categoria();
        categoria.setNome(request.getNome());
        categoria.setStatus(StatusCategoria.ATIVA); // Novas categorias sempre são ATIVAS

        categoriaRepository.save(categoria);

        URI uri = uriBuilder.path("/api/categorias/{id}").buildAndExpand(categoria.getId()).toUri();
        return ResponseEntity.created(uri).body(categoria);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Categoria> atualizar(@PathVariable Long id, @RequestBody @Valid CategoriaRequest request) {
        Optional<Categoria> categoriaOptional = categoriaRepository.findById(id);

        if (categoriaOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Categoria categoria = categoriaOptional.get();
        categoria.setNome(request.getNome());


        categoriaRepository.save(categoria);

        return ResponseEntity.ok(categoria);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        Optional<Categoria> categoriaOptional = categoriaRepository.findById(id);

        if (categoriaOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        categoriaRepository.deleteById(id);

        // Retorna 204 No Content, indicando sucesso sem conteúdo no corpo.
        return ResponseEntity.noContent().build();
    }
}