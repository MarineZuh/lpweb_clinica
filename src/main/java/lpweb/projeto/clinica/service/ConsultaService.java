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
    private final GenericService<Consulta> genericService;

    @Autowired
    public ConsultaService(ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
        this.genericService = new GenericService<>(this.consultaRepository);
    }

    @Transactional(readOnly = true)
    public List<Consulta> todos() {
        return genericService.todos();
    }

    @Transactional
    public Consulta salva(Consulta consulta) {
        return genericService.salva(consulta);

    }

    @Transactional(readOnly = true)
    public Consulta buscaPor(Integer id) {
        return genericService.buscaPor(id);

    }

    @Transactional
    public void excluiPor(Integer id) {
        genericService.excluirPor(id);
    }

    @Transactional
    public Consulta atualiza(Integer id, Consulta consulta) {
        return genericService.atualiza(consulta, id);
    }
}
