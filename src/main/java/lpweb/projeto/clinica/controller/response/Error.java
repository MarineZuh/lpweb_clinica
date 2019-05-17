package lpweb.projeto.clinica.controller.response;

public class Error {
    private final String mensagem;
    private final String detalhes;

    public Error(String mensagem, String detalhes) {
        this.mensagem = mensagem;
        this.detalhes = detalhes;
    }

    public String getMensagem() {
        return mensagem;
    }

    public String getDetalhes() {
        return detalhes;
    }
}
