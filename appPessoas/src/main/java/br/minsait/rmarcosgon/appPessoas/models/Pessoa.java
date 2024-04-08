package br.minsait.rmarcosgon.appPessoas.models;

import br.minsait.rmarcosgon.appPessoas.dtos.PessoaDto;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String documento;

    public Pessoa(Long id, String nome, String documento) {
        this.id = id;
        this.nome = nome;
        this.documento = documento;
    }


    public Pessoa() {
       this(0L, "", "");
    }

    public Pessoa(PessoaDto pessoaDto) {
        this(0L, pessoaDto.getNome(), pessoaDto.getDocumento());
    }
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }


}
