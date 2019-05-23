package lpweb.projeto.clinica.service;

import java.util.List;

import lpweb.projeto.clinica.model.Endereco;

import lpweb.projeto.clinica.repository.filter.PacienteFiltro;
import lpweb.projeto.clinica.util.PropriedadesUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
			BeanUtils.copyProperties(
					endereco,
					paciente.getEndereco(),
					PropriedadesUtil.obterPropriedadesComNullDe(paciente.getEndereco())
			);

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

	public Page<Paciente> buscaPaginada(Pageable page) {
		return this.pacienteRepository.findAll(page );
	}
	public Page<Paciente> busca(PacienteFiltro filtro, Pageable pageable) {
		return pacienteRepository.filtrar(filtro, pageable );
	}
}
