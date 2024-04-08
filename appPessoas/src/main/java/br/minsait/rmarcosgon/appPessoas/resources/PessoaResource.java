package br.minsait.rmarcosgon.appPessoas.resources;

import br.minsait.rmarcosgon.appPessoas.dtos.PessoaDto;
import br.minsait.rmarcosgon.appPessoas.dtos.PessoaNomeDto;
import br.minsait.rmarcosgon.appPessoas.models.Pessoa;
import br.minsait.rmarcosgon.appPessoas.services.PessoaService;
import br.minsait.rmarcosgon.appPessoas.services.exceptions.PessoaNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pessoas")
@Api(value = "App Pessoa")
@CrossOrigin(origins = "*")
public class PessoaResource {

    @Autowired
    PessoaService pessoaService;

    @GetMapping("/")
    @ApiOperation(value = "Retorna todas as pessoas cadastradas")
    public ResponseEntity<List<PessoaNomeDto>> getPessoas() {
        return new ResponseEntity<>(this.pessoaService.listarTodas(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Retorna detalhes de uma única pessoa")
    public ResponseEntity<?> getPessoas(@PathVariable Long id) throws PessoaNotFoundException {
        return new ResponseEntity<>(this.pessoaService.pegarPorId(id), HttpStatus.OK);
    }

    @PostMapping("/")
    @ApiOperation(value = "Cadastra nova pessoa no sistema")
    public ResponseEntity<?> criarPessoa(@RequestBody PessoaDto pessoa) {
        return new ResponseEntity<>(this.pessoaService.cadastrarPessoa(pessoa), HttpStatus.CREATED);
    }

    @PutMapping("/")
    @ApiOperation(value = "Atualiza dados de uma pessoa cadastrada")
    public ResponseEntity<Pessoa> atualizarPessoa(@RequestBody Pessoa pessoa) throws PessoaNotFoundException {
        return new ResponseEntity<>(this.pessoaService.atualizarPessoa(pessoa), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    @ApiOperation(value = "Apaga pessoa pelo id")
    public ResponseEntity<?> apagarPessoa(@PathVariable Long id) throws PessoaNotFoundException {
        this.pessoaService.apagarPessoa(id);
        return ResponseEntity.noContent().build();
    }
}
