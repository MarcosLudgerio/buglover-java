package br.minsait.rmarcosgon.AppProdutos.repositories;

import br.minsait.rmarcosgon.AppProdutos.models.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {
}
