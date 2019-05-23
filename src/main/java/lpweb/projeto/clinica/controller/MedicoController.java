package lpweb.projeto.clinica.controller;

import java.net.URI;
import java.util.List;
import java.util.Objects;

import lpweb.projeto.clinica.controller.response.Error;
import lpweb.projeto.clinica.controller.response.Resposta;
import lpweb.projeto.clinica.controller.validation.Validacao;
import lpweb.projeto.clinica.util.PropriedadesUtil;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
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

        return Resposta.comDadosDe(medicos);
    }
	
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Resposta<Medico>> salva(@Valid     @RequestBody Medico medico) {
        Medico salvo = medicoService.salva(medico);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(salvo.getId()).toUri();

        return ResponseEntity.created(uri).body(Resposta.comDadosDe(medico));
    }
	
	@GetMapping("/{id}")
    public Resposta<Medico> buscaPor(@PathVariable Integer id) {
        Medico medico = medicoService.buscaPor(id );

        return Resposta.comDadosDe(medico);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void exclui(@PathVariable Integer id) {

	    medicoService.excluiPor(id );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Resposta<Medico>> altera(@PathVariable  Integer id, @RequestBody Medico medico) {

        Medico medicoSalvo = medicoService.buscaPor(id );
        BeanUtils.copyProperties(medico,
                medicoSalvo,
                PropriedadesUtil.obterPropriedadesComNullDe(medico));
        List<Error> erros = this.getErros(medicoSalvo);
        if (existe(erros) ) {
            return ResponseEntity.badRequest().body(Resposta.com(erros ) );
        }

        Medico medicoAtualizada = medicoService.atualiza(id, medicoSalvo);
        return ResponseEntity.ok(Resposta.comDadosDe(medicoAtualizada ));
    }

    private boolean existe(List<Error> erros) {
        return Objects.nonNull( erros ) &&  !erros.isEmpty();
    }
    private List<Error> getErros(Medico c) {
        Validacao<Medico> validacao = new Validacao<>();
        return validacao.valida(c);
    }
}
