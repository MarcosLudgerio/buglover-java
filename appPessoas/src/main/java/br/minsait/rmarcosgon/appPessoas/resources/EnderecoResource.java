package br.minsait.rmarcosgon.appPessoas.resources;

import br.minsait.rmarcosgon.appPessoas.dtos.PessoaDto;
import br.minsait.rmarcosgon.appPessoas.models.Endereco;
import br.minsait.rmarcosgon.appPessoas.services.EnderecoService;
import br.minsait.rmarcosgon.appPessoas.services.exceptions.EnderecoNotFoundException;
import br.minsait.rmarcosgon.appPessoas.services.exceptions.PessoaNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/enderecos")
public class EnderecoResource {

    @Autowired
    EnderecoService enderecoService;

    @PostMapping("/")
    public ResponseEntity<?> cadastrarEndereco(@RequestBody Endereco endereco) throws PessoaNotFoundException {
        return new ResponseEntity<>(this.enderecoService.cadastrarNovoEndereco(endereco), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<?> pegarTodosOsEnderecos() {
        return new ResponseEntity<>(this.enderecoService.recuperarEnderecos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> pegarEnderecoPorID(@PathVariable Long id) throws EnderecoNotFoundException {
        return new ResponseEntity<>(this.enderecoService.pegarEnderecoPorID(id), HttpStatus.OK);
    }

    @GetMapping("/pessoa/{id}")
    public ResponseEntity<?> pegarPessoaComEndereco(@PathVariable Long id) throws PessoaNotFoundException, EnderecoNotFoundException {
        return new ResponseEntity<>(this.enderecoService.recuperarEnderecoDaPessoa(id), HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<?> atualizarEndereco(@RequestBody Endereco endereco) throws EnderecoNotFoundException {
        return new ResponseEntity<>(this.enderecoService.atualizarEndereco(endereco), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> atualizarEndereco(@PathVariable Long id) throws EnderecoNotFoundException {
        this.enderecoService.apagarEnderec(id);
        return ResponseEntity.noContent().build();
    }


}
