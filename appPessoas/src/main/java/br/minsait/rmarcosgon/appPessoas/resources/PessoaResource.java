package br.minsait.rmarcosgon.appPessoas.resources;

import br.minsait.rmarcosgon.appPessoas.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaResource {

    @Autowired
    PessoaService pessoaService;


}
