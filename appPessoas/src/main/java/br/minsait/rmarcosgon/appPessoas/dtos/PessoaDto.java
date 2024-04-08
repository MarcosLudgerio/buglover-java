package br.minsait.rmarcosgon.appPessoas.dtos;

import br.minsait.rmarcosgon.appPessoas.models.Pessoa;
import lombok.Data;

@Data
public class PessoaDto {

    private String nome;
    private String documento;

    public PessoaDto(){
        this.nome ="";
        this.documento = "";
    }
    public PessoaDto(Pessoa p){
        this.nome = p.getNome();
        this.documento = p.getDocumento();
    }

}
