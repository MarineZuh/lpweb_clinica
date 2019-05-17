package lpweb.projeto.clinica.exception;

import lpweb.projeto.clinica.controller.response.Error;
import lpweb.projeto.clinica.controller.response.Resposta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.Locale;

@RestControllerAdvice
public class ApiVendasExceptionHandler  extends ResponseEntityExceptionHandler {
    @Autowired
    private MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
                                                                  HttpHeaders headers, HttpStatus status,
                                                                  WebRequest request) {
        final Resposta<Error> resp = new Resposta<>();
        final String mensagem = messageSource.getMessage("parametro.invalido", null, new Locale("pt", "BR"));

        resp.adiciona(new Error(mensagem, ex.getLocalizedMessage()) );

        return super.handleExceptionInternal(ex, resp, headers, HttpStatus.BAD_REQUEST, request);
    }


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {

        final Resposta<Error> resp = new Resposta<>();
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();

        fieldErrors.forEach(fieldError ->
                resp.adiciona(
                        new Error(fieldError.getDefaultMessage(),
                                ex.getLocalizedMessage() )) );

        return super.handleExceptionInternal(ex, resp, headers, HttpStatus.BAD_REQUEST, request);

    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public Resposta<Error> handleEmptyResultDataAccess(EmptyResultDataAccessException ex) {

        Resposta<Error> resposta = new Resposta<>();

        String mensagem = String.format("Recurso nao encontrado, esperado %d, encontrado %d ",
                ex.getExpectedSize(), ex.getActualSize());
        resposta.adiciona(new Error(mensagem, ex.getMostSpecificCause().toString() ));

        return resposta;


    }
}
