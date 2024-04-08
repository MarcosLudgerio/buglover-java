package br.minsait.rmarcosgon.appPessoas.dtos;

import br.minsait.rmarcosgon.appPessoas.models.Endereco;
import lombok.Data;

@Data
public class PessoaEnderecoDto {
    private String nome;
    private EnderecoSemPessoa endereco;

    public PessoaEnderecoDto(String nome, EnderecoSemPessoa endereco){
        this.nome = nome;
        this.endereco = endereco;
    }
    public PessoaEnderecoDto(){
        this("", new EnderecoSemPessoa());
    }
}
