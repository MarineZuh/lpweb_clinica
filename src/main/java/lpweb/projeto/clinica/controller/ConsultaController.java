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

        return Resposta.comDadosDe(consultas);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Resposta<Consulta>> salva(@RequestBody Consulta consulta) {
        Consulta salvo = consultaService.salva(consulta);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(salvo.getId()).toUri();


        return ResponseEntity.created(uri).body(Resposta.comDadosDe(consulta));
    }

    @GetMapping("/{id}")
    public Resposta<Consulta> buscaPor(@PathVariable Integer id) {
        Consulta consulta = consultaService.buscaPor(id );



        return Resposta.comDadosDe(consulta);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void exclui(@PathVariable Integer id) {

        consultaService.excluiPor(id );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Resposta<Consulta>> altera(@PathVariable  Integer id, @RequestBody Consulta consulta) {

        Consulta consultaSalva = consultaService.buscaPor(id );
        PropriedadesUtil.copiarPropriedades(consulta, consultaSalva);
        List<Error> erros = this.getErros(consultaSalva );
        if (existe(erros) ) {
            return ResponseEntity.badRequest().body(Resposta.com(erros ) );
        }

        Consulta consultaAtualizada = consultaService.atualiza(id, consultaSalva);
        return ResponseEntity.ok(Resposta.comDadosDe(consultaAtualizada ));
    }

    private boolean existe(List<Error> erros) {
        return Objects.nonNull( erros ) &&  !erros.isEmpty();
    }
    private List<Error> getErros(Consulta c) {
        Validacao<Consulta> validacao = new Validacao<>();
        return validacao.valida(c);
    }
}
