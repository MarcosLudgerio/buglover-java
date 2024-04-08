package br.minsait.rmarcosgon.appPessoas.services;

import br.minsait.rmarcosgon.appPessoas.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    PessoaRepository pessoaRepository;
}
