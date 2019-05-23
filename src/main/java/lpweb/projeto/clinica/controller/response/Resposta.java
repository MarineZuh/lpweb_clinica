package lpweb.projeto.clinica.controller.response;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Resposta<T> {
    private T dados;
    private List<Error> erros = new ArrayList<>();

    private Resposta() { }

    public static Resposta comDadosDe(Object dados) {
        Resposta resposta = new Resposta<>();
        resposta.setDados(dados );
        return resposta;
    }

    public static Resposta com(List<Error> erros) {
        Resposta resposta = new Resposta<>();
        resposta.setErros(erros );
        return resposta;
    }

    public static Resposta com(Error erro) {
        Resposta resposta = new Resposta<>();
        resposta.setErros(Arrays.asList(erro) );
        return resposta;
    }

    public void setErros(List<Error> erros) {
        this.erros = erros;
    }

    public T getDados() {
        return dados;
    }

    public void setDados(T dados) {
        this.dados = dados;
    }

    public List<Error> getErros() {
        return erros;
    }
}
