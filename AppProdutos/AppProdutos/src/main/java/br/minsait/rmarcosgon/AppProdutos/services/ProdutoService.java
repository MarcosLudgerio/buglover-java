package br.minsait.rmarcosgon.AppProdutos.services;

import br.minsait.rmarcosgon.AppProdutos.models.Produto;
import br.minsait.rmarcosgon.AppProdutos.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto criar(Produto p){
        return produtoRepository.save(p);
    }

    public List<Produto> produtosList(){
        return produtoRepository.findAll();
    }

    public Optional<Produto> getProdutoId(Long id){
        return produtoRepository.findById(id);
    }

    public Produto update(Produto p){
        Optional<Produto> produtoFind = this.getProdutoId(p.getId());
        if(produtoFind.isPresent()) {
            Produto updateP = produtoFind.get();
            updateP.setCodBarra(p.getCodBarra());
            updateP.setNome(p.getNome());
            updateP.setPreco(p.getPreco());
        }
        return p;
    }

    public void delete(Long id){
        this.produtoRepository.deleteById(id);
    }
}
