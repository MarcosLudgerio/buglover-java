package br.minsait.rmarcosgon.AppProdutos.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String codBarra;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private double preco;


    public Produto(Long id, String codBarra, String nome, double preco) {
        this.id = id;
        this.codBarra = codBarra;
        this.nome = nome;
        this.preco = preco;
    }

    public Produto() {
        this(0L, "*", "", 0d);
    }

    @Override
    public String toString() {
        return "Produto: [id=" + this.id + ", " + "nome=" + this.nome + ", codBarra=" + this.codBarra + ", preco=" + this.preco + "]";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodBarra() {
        return codBarra;
    }

    public void setCodBarra(String codBarra) {
        this.codBarra = codBarra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

}
