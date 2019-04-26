package lpweb.projeto.clinica.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lpweb.projeto.clinica.model.Medico;
import lpweb.projeto.clinica.service.MedicoService;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
	
	private final MedicoService medicoService;
	
	@Autowired
	public MedicoController(MedicoService medicoService) {
		this.medicoService = medicoService;
	}
	
	@GetMapping
	public List<Medico> todos() {
        return medicoService.todos();
    }
	
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Medico salva(@RequestBody Medico medico) {
        return medicoService.salva(medico);
    }
	
	@GetMapping("/{id}")
    public Medico buscaPor(@PathVariable Integer id) {
        return medicoService.buscaPor(id );
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void exclui(@PathVariable Integer id) {
        medicoService.excluiPor(id );
    }

    @PutMapping("/{id}")
    public Medico altera(@PathVariable  Integer id, @RequestBody Medico medico) {
       return  medicoService.atualiza(id, medico );
    }
}
