package br.minsait.rmarcosgon.appPessoas.resources.exceptions;

import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
public class ApiErros {

    private List<String> erros;

    public ApiErros(String messagemErrro){
        this.erros = Arrays.asList(messagemErrro);
    }

    public ApiErros(List<String> erros) {
        this.erros = erros;
    }
}
