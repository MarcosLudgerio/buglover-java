package br.minsait.rmarcosgon.appPessoas.resources;

import br.minsait.rmarcosgon.appPessoas.dtos.PessoaDto;
import br.minsait.rmarcosgon.appPessoas.dtos.PessoaNomeDto;
import br.minsait.rmarcosgon.appPessoas.models.Pessoa;
import br.minsait.rmarcosgon.appPessoas.services.PessoaService;
import br.minsait.rmarcosgon.appPessoas.services.exceptions.PessoaNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pessoas")
@Tag(name = "Pessoa", description = "Requisições para pessoas")
public class PessoaResource {

    @Autowired
    PessoaService pessoaService;

    @Operation(
            summary = "Recuperar Pessoas",
            description = "Exibir todas as pessoas cadastradas na base de dados")
    @GetMapping("/")
    public ResponseEntity<List<PessoaNomeDto>> getPessoas() {
        return new ResponseEntity<>(this.pessoaService.listarTodas(), HttpStatus.OK);
    }

    @Operation(
            summary = "Recuperar uma pessoas",
            description = "Exibir dados de uma única pessoa pelo ID")
    @GetMapping("/{id}")
    public ResponseEntity<?> getPessoas(@PathVariable Long id) throws PessoaNotFoundException {
        return new ResponseEntity<>(this.pessoaService.pegarPorId(id), HttpStatus.OK);
    }

    @Operation(
            summary = "Cadastrar nova pessoa",
            description = "Cadastrar uma nova pessoa na base de dados")
    @PostMapping("/")
    public ResponseEntity<?> criarPessoa(@RequestBody PessoaDto pessoa) {
        return new ResponseEntity<>(this.pessoaService.cadastrarPessoa(pessoa), HttpStatus.CREATED);
    }

    @Operation(
            summary = "Atualizar pessoa",
            description = "Atualizar dados de uma pessoa")
    @PutMapping("/")
    public ResponseEntity<Pessoa> atualizarPessoa(@RequestBody Pessoa pessoa) throws PessoaNotFoundException {
        return new ResponseEntity<>(this.pessoaService.atualizarPessoa(pessoa), HttpStatus.OK);
    }

    @Operation(
            summary = "Apagar pessoa",
            description = "Apagar <strong>permanentemente</strong> o registro do banco de dados da pessoa pelo ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> apagarPessoa(@PathVariable Long id) throws PessoaNotFoundException {
        this.pessoaService.apagarPessoa(id);
        return ResponseEntity.noContent().build();
    }
}
