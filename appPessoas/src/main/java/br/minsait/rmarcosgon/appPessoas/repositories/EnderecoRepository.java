package br.minsait.rmarcosgon.appPessoas.repositories;

import br.minsait.rmarcosgon.appPessoas.models.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}