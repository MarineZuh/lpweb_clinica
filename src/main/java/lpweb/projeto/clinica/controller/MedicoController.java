package lpweb.projeto.clinica.controller;

import java.net.URI;
import java.util.List;
import java.util.Objects;

import lpweb.projeto.clinica.controller.response.Error;
import lpweb.projeto.clinica.controller.response.Resposta;
import lpweb.projeto.clinica.controller.validation.Validacao;
import lpweb.projeto.clinica.util.PropriedadesUtil;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;

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
	public Resposta<List<Medico>> todos() {
	    List<Medico> medicos = this.medicoService.todos();

	    Resposta<List<Medico>> resposta = new Resposta<>();
	    resposta.setDados(medicos);
        return resposta;
    }
	
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Resposta<Medico>> salva(@Valid     @RequestBody Medico medico) {
        Medico salvo = medicoService.salva(medico);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(salvo.getId()).toUri();
        Resposta<Medico> resposta = new Resposta<>();
        resposta.setDados(medico);

        return ResponseEntity.created(uri).body(resposta);
    }
	
	@GetMapping("/{id}")
    public Resposta<Medico> buscaPor(@PathVariable Integer id) {
        Medico medico = medicoService.buscaPor(id );
        Resposta<Medico> resposta = new Resposta<>();
        resposta.setDados(medico);

        return resposta;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void exclui(@PathVariable Integer id) {

	    medicoService.excluiPor(id );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Resposta<Medico>> altera(@PathVariable  Integer id, @RequestBody Medico medico) {
       Medico medicoSalvo = this.medicoService.buscaPor(id);

        BeanUtils.copyProperties(medico,
                medicoSalvo,
                PropriedadesUtil.obterPropriedadesComNullDe(medico) );

        Resposta<Medico> resposta = new Resposta<>();
        Validacao<Medico> validacao = new Validacao<>();
        List<Error> erros =  validacao.valida(medico );

        if (Objects.nonNull( erros ) &&  !erros.isEmpty() ) {
            resposta.setErros(erros );
            return ResponseEntity.badRequest().body(resposta );
        }

        Medico medicoAtualizado = this.medicoService.atualiza(id, medicoSalvo);

        resposta.setDados(medicoAtualizado);

        return ResponseEntity.ok(resposta);
    }
}
