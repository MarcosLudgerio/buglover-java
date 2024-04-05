package br.minsait.rmarcosgon.AppProdutos.services;

import br.minsait.rmarcosgon.AppProdutos.models.Estoque;
import br.minsait.rmarcosgon.AppProdutos.models.Produto;
import br.minsait.rmarcosgon.AppProdutos.repositories.EstoqueRepository;
import br.minsait.rmarcosgon.AppProdutos.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstoqueService {
    @Autowired
    private EstoqueRepository estoqueRepository;
    @Autowired
    private ProdutoRepository produtoRepository;


    public boolean estaCadastrado(Estoque estoque) {
        return this.produtoRepository.findById(estoque.getProduto().getId()).isPresent();
    }

    public List<Estoque> getAll(){
        return this.estoqueRepository.findAll();
    }

    public Estoque save(Estoque estoque) throws Exception {
        if (this.estaCadastrado(estoque)) return this.estoqueRepository.save(estoque);
        throw new Exception("Produto não encontrado.");
    }

    public Estoque uptade(Estoque estoque) throws Exception {
        if(!this.estaCadastrado(estoque)) throw new Exception("Produto não encontrado.");
        Optional<Estoque> optEstoque = this.estoqueRepository.findById(estoque.getProduto().getId());
        if(optEstoque.isPresent()){
            optEstoque.get().setProduto(estoque.getProduto());
            estoque.setQuantidade(optEstoque.get().getQuantidade());
        }
        return this.estoqueRepository.save(estoque);
    }
}
