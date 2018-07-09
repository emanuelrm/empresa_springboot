package br.com.tnd.api.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Fornecedor implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    public Fornecedor() {
    }

    public Fornecedor(String nome, Empresa empresa) {
        this.nome = nome;
        this.empresa = empresa;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
