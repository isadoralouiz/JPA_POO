package br.com.example;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String nome;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "documento_id", referencedColumnName = "id")
    private Documento documento;

    @OneToMany(mappedBy = "Pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Telefone> telefones = new ArrayList<Telefone>();

    @ManyToMany
    @JoinTable(
        name = "nome_projeto", 
        joinColumns = @JoinColumn(name = "pessoa_id"),
        inverseJoinColumns = @JoinColumn(name = "projeto_id")
        )
    
    private List<Projeto> projeto = new ArrayList<Projeto>();

    public Pessoa(String nome, Documento documento, List<Telefone> telefones, List<Projeto> projeto) {
        this.nome = nome;
        this.documento = documento;
        this.telefones = telefones;
        this.projeto = projeto;
    }
    public Pessoa(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }
    public List<Projeto> getProjeto() {
        return projeto;
    }
    public void setProjeto(List<Projeto> projeto) {
        this.projeto = projeto;
    }
}
