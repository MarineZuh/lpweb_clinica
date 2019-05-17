package lpweb.projeto.clinica.controller;

import java.util.List;
import java.util.Objects;

import java.net.URI;

import lpweb.projeto.clinica.controller.response.Resposta;
import lpweb.projeto.clinica.controller.response.Error;
import lpweb.projeto.clinica.controller.validation.Validacao;
import lpweb.projeto.clinica.util.PropriedadesUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import lpweb.projeto.clinica.model.Paciente;
import lpweb.projeto.clinica.service.PacienteService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private final PacienteService pacienteService;

    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping
    public Resposta<List<Paciente>> todos() {
        List<Paciente> pacientes = this.pacienteService.todos();

        Resposta<List<Paciente>> resposta = new Resposta<>();
        resposta.setDados(pacientes);
        return resposta;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Resposta<Paciente>> salva(@Valid @RequestBody Paciente paciente) {
        Paciente salvo = pacienteService.salva(paciente);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(salvo.getId()).toUri();
        Resposta<Paciente> resposta = new Resposta<>();
        resposta.setDados(paciente);

        return ResponseEntity.created(uri).body(resposta);
    }

    @GetMapping("/{id}")
    public Resposta<Paciente> buscaPor(@PathVariable Integer id) {
        Paciente paciente = pacienteService.buscaPor(id );
        Resposta<Paciente> resposta = new Resposta<>();
        resposta.setDados(paciente);

        return resposta;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void exclui(@PathVariable Integer id) {

        pacienteService.excluiPor(id );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Resposta<Paciente>> altera(@PathVariable  Integer id, @RequestBody Paciente paciente) {
        Paciente pacienteSalvo = this.pacienteService.buscaPor(id);

        BeanUtils.copyProperties(paciente,
                pacienteSalvo,
                PropriedadesUtil.obterPropriedadesComNullDe(paciente) );

        Resposta<Paciente> resposta = new Resposta<>();
        Validacao<Paciente> validacao = new Validacao<>();
        List<Error> erros =  validacao.valida(paciente );

        if (Objects.nonNull( erros ) &&  !erros.isEmpty() ) {
            resposta.setErros(erros );
            return ResponseEntity.badRequest().body(resposta );
        }

        Paciente pacienteAtualizado = this.pacienteService.atualiza(id, pacienteSalvo);

        resposta.setDados(pacienteAtualizado);

        return ResponseEntity.ok(resposta);
    }
}
