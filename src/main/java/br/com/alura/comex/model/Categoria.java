
package br.com.alura.comex.model;

import jakarta.persistence.*;

@Entity
@Table(name = "categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusCategoria status;

    // Construtor padrão exigido pelo JPA
    public Categoria() {}
    

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public StatusCategoria getStatus() { return status; }
    public void setStatus(StatusCategoria status) { this.status = status; }
}