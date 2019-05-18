package lpweb.projeto.clinica.service;

import java.util.List;

import lpweb.projeto.clinica.model.Endereco;
import lpweb.projeto.clinica.repository.EnderecoRepository;
import lpweb.projeto.clinica.repository.TelefoneRepository;
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
	private final EnderecoService enderecoService;
	private final TelefoneService telefoneService;

	@Autowired
	public PacienteService(
		PacienteRepository pacienteRepository,
		EnderecoService enderecoService,
		TelefoneService telefoneService
	) {
		this.pacienteRepository = pacienteRepository;
		this.enderecoService = enderecoService;
		this.telefoneService = telefoneService;
		this.genericService = new GenericService<>(this.pacienteRepository);
	}

	@Transactional(readOnly = true)
	public List<Paciente> todos() {
		return genericService.todos();
	}

	@Transactional
	public Paciente salva(Paciente paciente) {
		Endereco endereco = paciente.getEndereco();
		if(endereco.getId() != null) {
			endereco = this.enderecoService.buscaPor(endereco.getId());
			// copiar novos valores? para update
		}
		paciente.setEndereco(endereco);
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
