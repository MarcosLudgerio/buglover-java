package br.minsait.rmarcosgon.appPessoas.resources.exceptions;

import br.minsait.rmarcosgon.appPessoas.services.exceptions.PessoaNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationAdviceController {

    @ExceptionHandler(PessoaNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErros handleUserApiException(PessoaNotFoundException ex) {
        return new ApiErros(ex.getMessage());
    }

}
