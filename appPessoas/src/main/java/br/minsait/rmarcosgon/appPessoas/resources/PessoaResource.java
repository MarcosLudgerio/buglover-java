package br.minsait.rmarcosgon.appPessoas.resources;

import br.minsait.rmarcosgon.appPessoas.models.Pessoa;
import br.minsait.rmarcosgon.appPessoas.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaResource {

    @Autowired
    PessoaService pessoaService;

    @GetMapping("/")
    public ResponseEntity<?> getPessoas() {
        return new ResponseEntity<>(this.pessoaService.listarTodas(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Pessoa> criarPessoa(@RequestBody Pessoa pessoa) {
        return new ResponseEntity<>(this.pessoaService.cadastrarPessoa(pessoa), HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<Pessoa> atualizarPessoa(@RequestBody Pessoa pessoa) {
        try {
            return new ResponseEntity<>(this.pessoaService.atualizarPessoa(pessoa), HttpStatus.CREATED);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
