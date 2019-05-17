package lpweb.projeto.clinica.controller.response;

import java.util.ArrayList;
import java.util.List;

public class Resposta<T> {
    private T dados;
    private List<Error> erros = new ArrayList<>();


    public T getDados() {
        return dados;
    }

    public void setDados(T dados) {
        this.dados = dados;
    }

    public List<Error> getErros() {
        return erros;
    }

    public void setErros(List<Error> erros) {
        this.erros = erros;
    }

    public void adiciona(Error erro) {
        erros.add(erro );
    }
}
