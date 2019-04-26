package lpweb.projeto.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lpweb.projeto.clinica.model.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Integer> {

}
