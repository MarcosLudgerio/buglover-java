package br.minsait.rmarcosgon.AppProdutos.models;

import jakarta.persistence.*;

@Entity()
@Table(name = "tb_estoque")
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Integer quantidade;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "produto_id", referencedColumnName = "id")
    private Produto produto;

    public Estoque(Long id, Integer quantidade) {
        this.id = id;
        this.quantidade = quantidade;
    }

    public Estoque() {
        this(1L, 0);
    }

    @Override
    public String toString() {
        return "Estoque{" +
                "id=" + id +
                ", quantidade=" + quantidade +
                '}';
    }

    public Long getId() {
        return id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
