package br.minsait.rmarcosgon.appPessoas.services;

import br.minsait.rmarcosgon.appPessoas.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;
}
