package lpweb.projeto.clinica.service;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lpweb.projeto.clinica.model.Telefone;
import lpweb.projeto.clinica.repository.TelefoneRepository;

@Service
public class TelefoneService {

    private final TelefoneRepository telefoneRepository;
    private final GenericService<Telefone> genericService;

    @Autowired
    public TelefoneService(TelefoneRepository telefoneRepository) {
        this.telefoneRepository = telefoneRepository;
        this.genericService = new GenericService<>(this.telefoneRepository);
    }

    @Transactional(readOnly = true)
    public List<Telefone> todos() {
        return genericService.todos();
    }

    @Transactional
    public Telefone salva(Telefone telefone) {

        return genericService.salva(telefone);

    }

    @Transactional(readOnly = true)
    public Telefone buscaPor(Integer id) {
        return genericService.buscaPor(id);

    }

    @Transactional
    public void excluiPor(Integer id) {
        genericService.excluirPor(id);
    }

    @Transactional
    public Telefone atualiza(Integer id, Telefone telefone) {

        return genericService.atualiza(telefone, id);
    }
}
