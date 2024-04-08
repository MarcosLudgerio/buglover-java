package br.minsait.rmarcosgon.appPessoas.resources.exceptions;

import br.minsait.rmarcosgon.appPessoas.services.exceptions.EnderecoNotFoundException;
import br.minsait.rmarcosgon.appPessoas.services.exceptions.PessoaNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationAdviceController {

    @ExceptionHandler(PessoaNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiErros handleUserApiException(PessoaNotFoundException ex) {
        return new ApiErros(ex.getMessage());
    }

    @ExceptionHandler(EnderecoNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiErros handleUserApiException(EnderecoNotFoundException ex) {
        return new ApiErros(ex.getMessage());
    }

}
