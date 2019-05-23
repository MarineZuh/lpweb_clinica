package lpweb.projeto.clinica.controller;

import java.util.List;
import java.util.Objects;

import java.net.URI;

import lpweb.projeto.clinica.controller.event.HeaderLocationEvento;
import lpweb.projeto.clinica.controller.response.Resposta;
import lpweb.projeto.clinica.controller.response.Error;
import lpweb.projeto.clinica.controller.validation.Validacao;
import lpweb.projeto.clinica.util.PropriedadesUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lpweb.projeto.clinica.model.Paciente;
import lpweb.projeto.clinica.service.PacienteService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Value("${paginacao.qtd_por_pagina}")
    private Integer quantidadePorPagina;
    private final PacienteService pacienteService;
    private ApplicationEventPublisher publisher;

    @Autowired
    public PacienteController(
        PacienteService pacienteService,
        ApplicationEventPublisher publisher
    ) {
        this.publisher = publisher;
        this.pacienteService = pacienteService;
    }

    @GetMapping
    public Resposta<Page<Paciente>> todos(
        @RequestParam(defaultValue = "0") Integer pagina,
        @RequestParam(defaultValue = "3")Integer tamanho,
        @RequestParam(defaultValue = "nomeCrianca")String orderBy,
        @RequestParam(defaultValue = "ASC")String direcao
    ) {
        final Pageable page = PageRequest.of(pagina, tamanho, Sort.Direction.valueOf(direcao), orderBy);
        Page<Paciente> pacientes = this.pacienteService.buscaPaginada(page);

        Resposta<Page<Paciente>> resposta = new Resposta<>();
        resposta.setDados(pacientes);
        return resposta;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Resposta<Paciente>> salva(
        @Valid @RequestBody Paciente paciente,
        HttpServletResponse response
    ) {
        Paciente salvo = pacienteService.salva(paciente);

        publisher.publishEvent(new HeaderLocationEvento(this, response, salvo.getId() ));

        Resposta<Paciente> resposta = new Resposta<>();
        resposta.setDados(paciente);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(resposta );
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
