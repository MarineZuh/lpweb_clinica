package lpweb.projeto.clinica.repository.filter;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PacienteFiltro {

    private Integer id;
    private String nomeCrianca;
    private String nomeResponsavel;

    private String dataNascimento;
    private char sexo;

    public PacienteFiltro() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeCrianca() {
        return nomeCrianca;
    }

    public void setNomeCrianca(String nomeCrianca) {
        this.nomeCrianca = nomeCrianca;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    public Date getDataNascimento() {
        SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return s.parse(this.dataNascimento);
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return null;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "PacienteFiltro{" +
                "nomeCrianca='" + nomeCrianca + '\'' +
                ", nomeResponsavel='" + nomeResponsavel + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", sexo=" + sexo +
                '}';
    }
}
