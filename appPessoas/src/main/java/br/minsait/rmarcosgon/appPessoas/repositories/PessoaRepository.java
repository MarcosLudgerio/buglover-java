package br.minsait.rmarcosgon.appPessoas.repositories;

import br.minsait.rmarcosgon.appPessoas.models.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
