package lpweb.projeto.clinica.controller.event;

import org.springframework.context.ApplicationListener;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;

public class HeaderLocationListener implements ApplicationListener<HeaderLocationEvento> {

    @Override
    public void onApplicationEvent(HeaderLocationEvento event) {
        adicionaHeaderLocationNaRespostaHTTP(event);
    }

    private void adicionaHeaderLocationNaRespostaHTTP(HeaderLocationEvento event) {
        HttpServletResponse response = event.getResponse();
        Integer id = event.getId();

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(id).toUri();

        response.setHeader("Location", uri.toString() );
    }
}