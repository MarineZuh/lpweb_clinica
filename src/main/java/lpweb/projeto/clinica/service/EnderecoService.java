package lpweb.projeto.clinica.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lpweb.projeto.clinica.model.Endereco;
import lpweb.projeto.clinica.repository.EnderecoRepository;

@Service
public class EnderecoService {
	private final EnderecoRepository enderecoRepository;

	@Autowired
	public EnderecoService(EnderecoRepository enderecoRepository) {
		this.enderecoRepository = enderecoRepository;
	}

	@Transactional(readOnly = true)
	public List<Endereco> todos() {
		return enderecoRepository.findAll();
	}

	@Transactional
	public Endereco salva(Endereco endereco) {
		return enderecoRepository.save(endereco);

	}

	@Transactional(readOnly = true)
	public Endereco buscaPor(Integer id) {
		return enderecoRepository.findById(id).get();

	}

	@Transactional
	public void excluiPor(Integer id) {
		enderecoRepository.deleteById(id);
	}
	
	@Transactional
    public Endereco atualiza(Integer id, Endereco endereco) {

        Endereco enderecoSalvo = this.buscaPor(id);
        BeanUtils.copyProperties(endereco, enderecoSalvo, "id");

        return  enderecoSalvo;
    }
}
