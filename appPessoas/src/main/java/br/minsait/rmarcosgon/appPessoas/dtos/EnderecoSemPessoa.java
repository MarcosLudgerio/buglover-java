package br.minsait.rmarcosgon.appPessoas.dtos;

import br.minsait.rmarcosgon.appPessoas.models.Endereco;
import lombok.Data;

@Data
public class EnderecoSemPessoa {
    private String tipoLogradouro;
    private String logradouro;
    private String cep;
    private String cidade;
    private String uf;

    public EnderecoSemPessoa(String tipoLogradouro, String logradouro, String cep, String cidade, String uf) {
        this.tipoLogradouro = tipoLogradouro;
        this.logradouro = logradouro;
        this.cep = cep;
        this.cidade = cidade;
        this.uf = uf;
    }

    public EnderecoSemPessoa() {
        this("", "", "", "", "");
    }

    public EnderecoSemPessoa(Endereco endereco){
        this(endereco.getTipoLogradouro(), endereco.getLogradouro(), endereco.getCep(), endereco.getCidade(), endereco.getUf());
    }
}
