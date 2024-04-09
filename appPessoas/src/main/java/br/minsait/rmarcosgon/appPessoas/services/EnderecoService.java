package br.minsait.rmarcosgon.appPessoas.services;

import br.minsait.rmarcosgon.appPessoas.dtos.EnderecoSemPessoa;
import br.minsait.rmarcosgon.appPessoas.dtos.PessoaEnderecoDto;
import br.minsait.rmarcosgon.appPessoas.models.Endereco;
import br.minsait.rmarcosgon.appPessoas.models.Pessoa;
import br.minsait.rmarcosgon.appPessoas.repositories.EnderecoRepository;
import br.minsait.rmarcosgon.appPessoas.services.exceptions.EnderecoNotFoundException;
import br.minsait.rmarcosgon.appPessoas.services.exceptions.PessoaNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PessoaService pessoaService;


    public Endereco cadastrarNovoEndereco(Endereco endereco) throws PessoaNotFoundException {
        Pessoa pessoa = this.pessoaService.pegarPorId(endereco.getPessoa().getId());
        endereco.setPessoa(pessoa);
        return this.enderecoRepository.save(endereco);
    }

    public List<Endereco> recuperarEnderecos() {
        return this.enderecoRepository.findAll();
    }

    public Endereco pegarEnderecoPorID(Long id) throws EnderecoNotFoundException {
        Optional<Endereco> enderecoOptional = this.enderecoRepository.findById(id);
        return enderecoOptional.orElseThrow(() -> new EnderecoNotFoundException("Endereco não encontrado, por favor verifique o ID!"));
    }

    public PessoaEnderecoDto recuperarEnderecoDaPessoa(Long idEndereco) throws PessoaNotFoundException, EnderecoNotFoundException {
        Endereco endereco = this.pegarEnderecoPorID(idEndereco);
        Pessoa pessoa = this.pessoaService.pegarPorId(endereco.getPessoa().getId());
        return new PessoaEnderecoDto(pessoa.getNome(), new EnderecoSemPessoa(endereco));
    }
    public Endereco atualizarEndereco(Endereco endereco) throws EnderecoNotFoundException {
        Endereco enderecoUpdate = this.pegarEnderecoPorID(endereco.getId());
        enderecoUpdate.setTipoLogradouro(endereco.getTipoLogradouro());
        enderecoUpdate.setLogradouro(endereco.getLogradouro());
        enderecoUpdate.setCep(endereco.getCep());
        enderecoUpdate.setCidade(endereco.getCidade());
        enderecoUpdate.setUf(endereco.getUf());
        enderecoUpdate.setPessoa(endereco.getPessoa());
        return this.enderecoRepository.save(enderecoUpdate);
    }

    public boolean apagarEndereco(Long id) throws EnderecoNotFoundException {
        Endereco endereco = this.pegarEnderecoPorID(id);
        this.enderecoRepository.delete(endereco);
        return true;
    }
}
