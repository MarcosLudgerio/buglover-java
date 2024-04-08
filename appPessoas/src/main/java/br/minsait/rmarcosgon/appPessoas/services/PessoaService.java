package br.minsait.rmarcosgon.appPessoas.services;

import br.minsait.rmarcosgon.appPessoas.models.Pessoa;
import br.minsait.rmarcosgon.appPessoas.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    PessoaRepository pessoaRepository;

    public Pessoa cadastrarPessoa(Pessoa pessoa) {
        return this.pessoaRepository.save(pessoa);
    }

    public List<Pessoa> listarTodas() {
        return this.pessoaRepository.findAll();
    }

    public Optional<Pessoa> pegarPorId(Long id) {
        return this.pessoaRepository.findById(id);
    }

    public Pessoa atualizarPessoa(Pessoa pessoa) throws Exception {
        Optional<Pessoa> pessoaOptional = this.pegarPorId(pessoa.getId());
        if (pessoaOptional.isEmpty()) throw new Exception("Pessoa não encontrada, verifique o ID!");
        Pessoa pessoaUpdate = pessoaOptional.get();
        pessoaUpdate.setDocumento(pessoa.getDocumento());
        pessoaUpdate.setNome(pessoa.getNome());
        this.pessoaRepository.save(pessoaUpdate);
        return pessoaUpdate;
    }

    public void apagarPessoa(Long id) throws Exception {
        Optional<Pessoa> pessoaOptional = this.pegarPorId(id);
        if (pessoaOptional.isEmpty()) throw new Exception("Pessoa não encontrada, verifique o ID!");
        this.pessoaRepository.delete(pessoaOptional.get());
    }

}
