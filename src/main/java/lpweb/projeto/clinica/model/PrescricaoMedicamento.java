package lpweb.projeto.clinica.model;


import javax.persistence.*;

@Entity
@Table(name = "prescricao_medicamento")
public class PrescricaoMedicamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "medicamento_id")
    private Medicamento medicamento;
    private String dosagem;
    private String administração;
    private String tempoUso;

    public PrescricaoMedicamento() {
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    public String getDosagem() {
        return dosagem;
    }

    public void setDosagem(String dosagem) {
        this.dosagem = dosagem;
    }

    public String getAdministração() {
        return administração;
    }

    public void setAdministração(String administração) {
        this.administração = administração;
    }

    public String getTempoUso() {
        return tempoUso;
    }

    public void setTempoUso(String tempoUso) {
        this.tempoUso = tempoUso;
    }
}
