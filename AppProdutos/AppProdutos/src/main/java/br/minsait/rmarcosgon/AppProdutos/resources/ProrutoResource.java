package br.minsait.rmarcosgon.AppProdutos.resources;

import br.minsait.rmarcosgon.AppProdutos.model.Produto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/produtos")
public class ProrutoResource {
    @GetMapping("/hello")
    public String hello(){
        return "Olá!";
    }

    @GetMapping("/")
    public ResponseEntity<Produto> getProduto(){
        Produto p =  new Produto(1L, "1323123", "Java", 1.50);
        System.out.println(p);
        return ResponseEntity.ok(p);
    }
}
