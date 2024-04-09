package br.minsait.rmarcosgon.appPessoas.resources;

import br.minsait.rmarcosgon.appPessoas.models.Endereco;
import br.minsait.rmarcosgon.appPessoas.services.EnderecoService;
import br.minsait.rmarcosgon.appPessoas.services.exceptions.EnderecoNotFoundException;
import br.minsait.rmarcosgon.appPessoas.services.exceptions.PessoaNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/enderecos")
@Tag(name = "Endereço", description = "Requisições para endereço")
public class EnderecoResource {

    @Autowired
    EnderecoService enderecoService;

    @Operation(
            summary = "Cadastrar Endereço",
            description = "Cadastra um novo endereço na base de dados")
    @PostMapping("/")
    public ResponseEntity<?> cadastrarEndereco(@RequestBody Endereco endereco) throws PessoaNotFoundException {
        return new ResponseEntity<>(this.enderecoService.cadastrarNovoEndereco(endereco), HttpStatus.CREATED);
    }

    @Operation(
            summary = "Recuperar todos os endereços",
            description = "Recuperar todos os endereços cadastrados na base de dados")
    @GetMapping("/")
    public ResponseEntity<?> pegarTodosOsEnderecos() {
        return new ResponseEntity<>(this.enderecoService.recuperarEnderecos(), HttpStatus.OK);
    }

    @Operation(
            summary = "Recuperar um único endereço",
            description = "Recupera um único endereço através do ID")
    @GetMapping("/{id}")
    public ResponseEntity<?> pegarEnderecoPorID(@PathVariable Long id) throws EnderecoNotFoundException {
        return new ResponseEntity<>(this.enderecoService.pegarEnderecoPorID(id), HttpStatus.OK);
    }

    @Operation(
            summary = "Pegar o endereço de uma pessoa",
            description = "Recupera o endereço de uma pessoa informado pelo ID da pessoa")
    @GetMapping("/pessoa/{id}")
    public ResponseEntity<?> pegarPessoaComEndereco(@PathVariable Long id) throws PessoaNotFoundException, EnderecoNotFoundException {
        return new ResponseEntity<>(this.enderecoService.recuperarEnderecoDaPessoa(id), HttpStatus.OK);
    }

    @Operation(
            summary = "Atualizar endereço",
            description = "Atualizar dados do endereço informado")
    @PutMapping("/")
    public ResponseEntity<?> atualizarEndereco(@RequestBody Endereco endereco) throws EnderecoNotFoundException {
        return new ResponseEntity<>(this.enderecoService.atualizarEndereco(endereco), HttpStatus.OK);
    }

    @Operation(
            summary = "Apagar endereço",
            description = "Apagar <strong>permanentemente</strong> os dados do endereço informado por ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> atualizarEndereco(@PathVariable Long id) throws EnderecoNotFoundException {
        this.enderecoService.apagarEndereco(id);
        return ResponseEntity.noContent().build();
    }

}
