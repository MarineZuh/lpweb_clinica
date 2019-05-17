package lpweb.projeto.clinica.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lpweb.projeto.clinica.model.Paciente;
import lpweb.projeto.clinica.repository.PacienteRepository;

@Service
public class PacienteService {

	private final PacienteRepository pacienteRepository;
	private final GenericService<Paciente> genericService;
	@Autowired
	public PacienteService(PacienteRepository pacienteRepository) {
		this.pacienteRepository = pacienteRepository;
		this.genericService = new GenericService<>(this.pacienteRepository);
	}

	@Transactional(readOnly = true)
	public List<Paciente> todos() {
		return genericService.todos();
	}

	@Transactional
	public Paciente salva(Paciente paciente) {
		return genericService.salva(paciente);

	}

	@Transactional(readOnly = true)
	public Paciente buscaPor(Integer id) {
		return genericService.buscaPor(id);

	}

	@Transactional
	public void excluiPor(Integer id) {
		genericService.excluirPor(id);
	}
	
	@Transactional
    public Paciente atualiza(Integer id, Paciente paciente) {

      return genericService.atualiza(paciente, id);
    }
}
