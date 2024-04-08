package br.minsait.rmarcosgon.appPessoas.dtos;

import br.minsait.rmarcosgon.appPessoas.models.Pessoa;
import lombok.Data;

@Data
public class PessoaNomeDto {
    private String nome;
    public PessoaNomeDto(Pessoa pessoa){
        this.nome = pessoa.getNome();
    }
}
