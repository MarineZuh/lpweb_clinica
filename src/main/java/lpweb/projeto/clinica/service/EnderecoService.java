package lpweb.projeto.clinica.service;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lpweb.projeto.clinica.model.Endereco;
import lpweb.projeto.clinica.repository.EnderecoRepository;

@Service
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;
    private final GenericService<Endereco> genericService;

    @Autowired
    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
        this.genericService = new GenericService<>(this.enderecoRepository);
    }

    @Transactional(readOnly = true)
    public List<Endereco> todos() {
        return genericService.todos();
    }

    @Transactional
    public Endereco salva(Endereco endereco) {

        return genericService.salva(endereco);

    }

    @Transactional(readOnly = true)
    public Endereco buscaPor(Integer id) {
        return genericService.buscaPor(id);

    }

    @Transactional
    public void excluiPor(Integer id) {
        genericService.excluirPor(id);
    }

    @Transactional
    public Endereco atualiza(Integer id, Endereco endereco) {

        return genericService.atualiza(endereco, id);
    }
}
