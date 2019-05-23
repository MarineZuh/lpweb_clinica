package lpweb.projeto.clinica.repository.paciente;

import lpweb.projeto.clinica.model.Paciente;
import lpweb.projeto.clinica.repository.filter.PacienteFiltro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PacienteRepositoryQuery {

    Page<Paciente> filtrar(PacienteFiltro filtro, Pageable pageable);
}
