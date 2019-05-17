package lpweb.projeto.clinica.controller;

import lpweb.projeto.clinica.controller.response.Error;
import lpweb.projeto.clinica.controller.validation.Validacao;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import lpweb.projeto.clinica.controller.response.Resposta;
import lpweb.projeto.clinica.model.Consulta;
import lpweb.projeto.clinica.service.ConsultaService;
import lpweb.projeto.clinica.util.PropriedadesUtil;

import java.net.URI;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {
    private final ConsultaService consultaService;

    @Autowired
    public ConsultaController(ConsultaService consultaService) {
        this.consultaService = consultaService;
    }

    @GetMapping
    public Resposta<List<Consulta>> todos() {
        List<Consulta> consultas = this.consultaService.todos();

        Resposta<List<Consulta>> resposta = new Resposta<>();
        resposta.setDados(consultas);
        return resposta;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Resposta<Consulta>> salva(@RequestBody Consulta consulta) {
        Consulta salvo = consultaService.salva(consulta);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(salvo.getId()).toUri();
        Resposta<Consulta> resposta = new Resposta<>();
        resposta.setDados(consulta);

        return ResponseEntity.created(uri).body(resposta);
    }

    @GetMapping("/{id}")
    public Resposta<Consulta> buscaPor(@PathVariable Integer id) {
        Consulta consulta = consultaService.buscaPor(id );
        Resposta<Consulta> resposta = new Resposta<>();
        resposta.setDados(consulta);

        return resposta;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void exclui(@PathVariable Integer id) {

        consultaService.excluiPor(id );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Resposta<Consulta>> altera(@PathVariable  Integer id, @RequestBody Consulta consulta) {
        Consulta consultaSalva = this.consultaService.buscaPor(id);

        BeanUtils.copyProperties(consulta,
                consultaSalva,
                PropriedadesUtil.obterPropriedadesComNullDe(consulta) );

        Resposta<Consulta> resposta = new Resposta<>();
        Validacao<Consulta> validacao = new Validacao<>();
        List<Error> erros =  validacao.valida(consulta );

        if (Objects.nonNull( erros ) &&  !erros.isEmpty() ) {
            resposta.setErros(erros );
            return ResponseEntity.badRequest().body(resposta );
        }

        Consulta consultaAtualizado = this.consultaService.atualiza(id, consultaSalva);

        resposta.setDados(consultaAtualizado);

        return ResponseEntity.ok(resposta);
    }
}
