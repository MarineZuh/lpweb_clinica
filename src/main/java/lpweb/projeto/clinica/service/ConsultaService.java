package lpweb.projeto.clinica.service;

import lpweb.projeto.clinica.model.Consulta;
import lpweb.projeto.clinica.repository.ConsultaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ConsultaService {
    private final ConsultaRepository consultaRepository;

    @Autowired
    public ConsultaService(ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }

    @Transactional(readOnly = true)
    public List<Consulta> todos() {
        return consultaRepository.findAll();
    }

    @Transactional
    public Consulta salva(Consulta consulta) {
        return consultaRepository.save(consulta);

    }

    @Transactional(readOnly = true)
    public Consulta buscaPor(Integer id) {
        return consultaRepository.findById(id).get();

    }

    @Transactional
    public void excluiPor(Integer id) {
        consultaRepository.deleteById(id);
    }

    @Transactional
    public Consulta atualiza(Integer id, Consulta consulta) {

        Consulta consultaSalvo = this.buscaPor(id);
        BeanUtils.copyProperties(consulta, consultaSalvo, "id");

        return consultaSalvo;
    }
}
