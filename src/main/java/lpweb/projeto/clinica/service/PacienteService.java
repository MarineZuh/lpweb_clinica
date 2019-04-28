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

	@Autowired
	public PacienteService(PacienteRepository pacienteRepository) {
		this.pacienteRepository = pacienteRepository;
	}

	@Transactional(readOnly = true)
	public List<Paciente> todos() {
		return pacienteRepository.findAll();
	}

	@Transactional
	public Paciente salva(Paciente paciente) {
		return pacienteRepository.save(paciente);

	}

	@Transactional(readOnly = true)
	public Paciente buscaPor(Integer id) {
		return pacienteRepository.findById(id).get();

	}

	@Transactional
	public void excluiPor(Integer id) {
		pacienteRepository.deleteById(id);
	}
	
	@Transactional
    public Paciente atualiza(Integer id, Paciente paciente) {

        Paciente pacienteSalvo = this.buscaPor(id);
        BeanUtils.copyProperties(paciente, pacienteSalvo, "id");

        return  pacienteSalvo;
    }
}
