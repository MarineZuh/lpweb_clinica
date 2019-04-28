package lpweb.projeto.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import lpweb.projeto.clinica.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

}
