package br.minsait.rmarcosgon.appPessoas.services;

import br.minsait.rmarcosgon.appPessoas.dtos.PessoaDto;
import br.minsait.rmarcosgon.appPessoas.dtos.PessoaNomeDto;
import br.minsait.rmarcosgon.appPessoas.models.Pessoa;
import br.minsait.rmarcosgon.appPessoas.repositories.PessoaRepository;
import br.minsait.rmarcosgon.appPessoas.services.exceptions.PessoaNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    PessoaRepository pessoaRepository;

    public Pessoa cadastrarPessoa(PessoaDto pessoaDto) {
        Pessoa pessoa = this.fromDto(pessoaDto);
        return this.pessoaRepository.save(pessoa);
    }

    private Pessoa fromDto(PessoaDto pessoaDto) {
        return new Pessoa(pessoaDto);
    }

    public List<PessoaNomeDto> listarTodas() {
        List<Pessoa> pessoaList = this.pessoaRepository.findAll();
        List<PessoaNomeDto> pessoaNomeDtos = new ArrayList<>();
        for (Pessoa p : pessoaList) {
            pessoaNomeDtos.add(new PessoaNomeDto(p));
        }
        return pessoaNomeDtos;
    }

    public Pessoa pegarPorId(Long id) throws PessoaNotFoundException {
        Optional<Pessoa> pessoaOptional = this.pessoaRepository.findById(id);
        return pessoaOptional.orElseThrow(() -> new PessoaNotFoundException("Pessoa não encontrada, verifique o ID!"));
    }

    public Pessoa atualizarPessoa(Pessoa pessoa) throws PessoaNotFoundException {
        Pessoa pessoaUpdate = this.pegarPorId(pessoa.getId());
        pessoaUpdate.setDocumento(pessoa.getDocumento());
        pessoaUpdate.setNome(pessoa.getNome());
        this.pessoaRepository.save(pessoaUpdate);
        return pessoaUpdate;
    }

    public boolean apagarPessoa(Long id) throws PessoaNotFoundException {
        this.pessoaRepository.delete(this.pegarPorId(id));
        return true;
    }

}
