package lpweb.projeto.clinica.repository;

import lpweb.projeto.clinica.repository.paciente.PacienteRepositoryImpl;
import lpweb.projeto.clinica.repository.paciente.PacienteRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;

import lpweb.projeto.clinica.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Integer>, PacienteRepositoryQuery {

}
