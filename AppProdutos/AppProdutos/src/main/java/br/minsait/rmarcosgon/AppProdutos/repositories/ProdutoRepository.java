package br.minsait.rmarcosgon.AppProdutos.repositories;

import br.minsait.rmarcosgon.AppProdutos.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
