package lpweb.projeto.clinica.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lpweb.projeto.clinica.model.Telefone;
import lpweb.projeto.clinica.repository.TelefoneRepository;

@Service
public class TelefoneService {
	private final TelefoneRepository telefoneRepository;

	@Autowired
	public TelefoneService(TelefoneRepository telefoneRepository) {
		this.telefoneRepository = telefoneRepository;
	}

	@Transactional(readOnly = true)
	public List<Telefone> todos() {
		return telefoneRepository.findAll();
	}

	@Transactional
	public Telefone salva(Telefone telefone) {
		return telefoneRepository.save(telefone);

	}

	@Transactional(readOnly = true)
	public Telefone buscaPor(Integer id) {
		return telefoneRepository.findById(id).get();

	}

	@Transactional
	public void excluiPor(Integer id) {
		telefoneRepository.deleteById(id);
	}
	
	@Transactional
    public Telefone atualiza(Integer id, Telefone telefone) {

        Telefone telefoneSalvo = this.buscaPor(id);
        BeanUtils.copyProperties(telefone, telefoneSalvo, "id");

        return  telefoneSalvo;
    }
}
