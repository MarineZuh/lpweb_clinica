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

import lpweb.projeto.clinica.model.Endereco;
import lpweb.projeto.clinica.service.EnderecoService;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {
	
	private final EnderecoService enderecoService;
	
	@Autowired
	public EnderecoController(EnderecoService enderecoService) {
		this.enderecoService = enderecoService;
	}
	
	@GetMapping
	public List<Endereco> todos() {
        return enderecoService.todos();
    }
	
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Endereco salva(@RequestBody Endereco endereco) {
        return enderecoService.salva(endereco);
    }
	
	@GetMapping("/{id}")
    public Endereco buscaPor(@PathVariable Integer id) {
        return enderecoService.buscaPor(id );
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void exclui(@PathVariable Integer id) {
        enderecoService.excluiPor(id );
    }

    @PutMapping("/{id}")
    public Endereco altera(@PathVariable  Integer id, @RequestBody Endereco endereco) {
       return  enderecoService.atualiza(id, endereco );
    }
}
