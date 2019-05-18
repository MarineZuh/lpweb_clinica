package lpweb.projeto.clinica.service;

import lpweb.projeto.clinica.model.Medico;
import lpweb.projeto.clinica.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class MedicoService {

	private final MedicoRepository medicoRepository;
	private final GenericService<Medico> genericService;

	@Autowired
	public MedicoService(MedicoRepository medicoRepository) {
		this.medicoRepository = medicoRepository;
		this.genericService = new GenericService<>(this.medicoRepository);
	}

	@Transactional(readOnly = true)
	public List<Medico> todos() {
		return genericService.todos();
	}

	@Transactional
	public Medico salva(Medico medico) {

		return genericService.salva(medico);

	}

	@Transactional(readOnly = true)
	public Medico buscaPor(Integer id) {
		return genericService.buscaPor(id);

	}

	@Transactional
	public void excluiPor(Integer id) {
		genericService.excluirPor(id);
	}
	
	@Transactional
    public Medico atualiza(Integer id, Medico medico) {

        return genericService.atualiza(medico, id);
    }
}
