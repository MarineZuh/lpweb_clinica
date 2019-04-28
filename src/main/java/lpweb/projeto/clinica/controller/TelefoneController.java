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

import lpweb.projeto.clinica.model.Telefone;
import lpweb.projeto.clinica.service.TelefoneService;

@RestController
@RequestMapping("/telefones")
public class TelefoneController {

	private final TelefoneService telefoneService;
	
	@Autowired
	public TelefoneController(TelefoneService telefoneService) {
		this.telefoneService = telefoneService;
	}
	
	@GetMapping
	public List<Telefone> todos() {
        return telefoneService.todos();
    }
	
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Telefone salva(@RequestBody Telefone telefone) {
        return telefoneService.salva(telefone);
    }
	
	@GetMapping("/{id}")
    public Telefone buscaPor(@PathVariable Integer id) {
        return telefoneService.buscaPor(id );
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void exclui(@PathVariable Integer id) {
        telefoneService.excluiPor(id );
    }

    @PutMapping("/{id}")
    public Telefone altera(@PathVariable  Integer id, @RequestBody Telefone telefone) {
       return  telefoneService.atualiza(id, telefone );
    }
}
