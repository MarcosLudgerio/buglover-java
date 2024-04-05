package br.minsait.rmarcosgon.AppProdutos.resources;

import br.minsait.rmarcosgon.AppProdutos.models.Produto;
import br.minsait.rmarcosgon.AppProdutos.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoResource {

    @Autowired
    ProdutoService produtoService;

    @GetMapping("/hello")
    public String hello() {
        return "Olá!";
    }

    @GetMapping("/")
    public ResponseEntity<List<Produto>> getProdutos() {
        return ResponseEntity.ok(this.produtoService.produtosList());
    }

    @PostMapping("/")
    public ResponseEntity<Produto> save(@RequestBody Produto produto) {
        return ResponseEntity.ok(this.produtoService.criar(produto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Produto>> getById(@PathVariable Long id) {
        Optional<Produto> produtoOptional = this.produtoService.getProdutoId(id);
        if (produtoOptional.isPresent()) return ResponseEntity.ok(produtoOptional);
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/")
    public ResponseEntity<Produto> update(@RequestBody Produto produto) {
        return ResponseEntity.ok(this.produtoService.update(produto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        this.produtoService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
