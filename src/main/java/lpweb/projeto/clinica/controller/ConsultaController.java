package lpweb.projeto.clinica.controller;

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
    public Resposta<Consulta> altera(@PathVariable  Integer id, @RequestBody Consulta consulta) {
        Consulta consultaSalvo = this.consultaService.buscaPor(id);
        BeanUtils.copyProperties(consulta,
                consultaSalvo,
                PropriedadesUtil.obterPropriedadesComNullDe(consulta) );
        Consulta consultaAtualizado = this.consultaService.atualiza(id, consultaSalvo);
        BeanUtils.copyProperties(consultaAtualizado, consulta);

        Resposta<Consulta> resposta = new Resposta<>();
        resposta.setDados(consulta);

        return resposta;
    }
}
