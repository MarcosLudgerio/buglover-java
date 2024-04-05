package br.minsait.rmarcosgon.AppProdutos.resources;

import br.minsait.rmarcosgon.AppProdutos.models.Estoque;
import br.minsait.rmarcosgon.AppProdutos.services.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estoque")
public class EstoqueResource {

    @Autowired
    EstoqueService estoqueService;

    @PostMapping
    public ResponseEntity<Estoque> save(@RequestBody Estoque estoque) {
        try {
            return ResponseEntity.ok(this.estoqueService.save(estoque));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Estoque>> findAll(){
        return ResponseEntity.ok(this.estoqueService.getAll());
    }

}
