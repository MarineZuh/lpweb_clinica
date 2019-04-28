package lpweb.projeto.clinica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lpweb.projeto.clinica.model.Paciente;
import lpweb.projeto.clinica.service.PacienteService;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
	
private final PacienteService pacienteService;
	
	@Autowired
	public PacienteController(PacienteService pacienteService) {
		this.pacienteService = pacienteService;
	}
	
	@GetMapping
	public List<Paciente> todos() {
        return pacienteService.todos();
    }
	
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Paciente salva(@RequestBody Paciente paciente) {
        return pacienteService.salva(paciente);
    }
	
	@GetMapping("/{id}")
    public Paciente buscaPor(@PathVariable Integer id) {
        return pacienteService.buscaPor(id );
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void exclui(@PathVariable Integer id) {
        pacienteService.excluiPor(id );
    }

    @PutMapping("/{id}")
    public Paciente altera(@PathVariable  Integer id, @RequestBody Paciente paciente) {
       return  pacienteService.atualiza(id, paciente );
    }

}
