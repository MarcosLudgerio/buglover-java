package br.minsait.rmarcosgon.AppProdutos.repositories;

import br.minsait.rmarcosgon.AppProdutos.model.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {
}
