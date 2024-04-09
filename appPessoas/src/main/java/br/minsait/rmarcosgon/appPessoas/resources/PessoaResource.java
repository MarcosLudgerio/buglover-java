package br.minsait.rmarcosgon.appPessoas.resources;

import br.minsait.rmarcosgon.appPessoas.dtos.PessoaDto;
import br.minsait.rmarcosgon.appPessoas.dtos.PessoaNomeDto;
import br.minsait.rmarcosgon.appPessoas.models.Pessoa;
import br.minsait.rmarcosgon.appPessoas.services.PessoaService;
import br.minsait.rmarcosgon.appPessoas.services.exceptions.PessoaNotFoundException;
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
    public ResponseEntity<List<PessoaNomeDto>> getPessoas() {
        return new ResponseEntity<>(this.pessoaService.listarTodas(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPessoas(@PathVariable Long id) throws PessoaNotFoundException {
        return new ResponseEntity<>(this.pessoaService.pegarPorId(id), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> criarPessoa(@RequestBody PessoaDto pessoa) {
        return new ResponseEntity<>(this.pessoaService.cadastrarPessoa(pessoa), HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<Pessoa> atualizarPessoa(@RequestBody Pessoa pessoa) throws PessoaNotFoundException {
        return new ResponseEntity<>(this.pessoaService.atualizarPessoa(pessoa), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> apagarPessoa(@PathVariable Long id) throws PessoaNotFoundException {
        this.pessoaService.apagarPessoa(id);
        return ResponseEntity.noContent().build();
    }
}
