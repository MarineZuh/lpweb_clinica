package lpweb.projeto.clinica.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Prontuario {
	private Integer id;
	private Consulta consulta;
	private String sintomas;
	private String observacaoClinica;
	private List<PrescricaoMedicamento> prescricoesMedicamento = new ArrayList();
    private List<Exame> prescricoesExame = new ArrayList();
    public Prontuario() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public String getObservacaoClinica() {
        return observacaoClinica;
    }

    public void setObservacaoClinica(String observacaoClinica) {
        this.observacaoClinica = observacaoClinica;
    }

    public List<PrescricaoMedicamento> getPrescricoesMedicamento() {
        return prescricoesMedicamento;
    }

    public void setPrescricoesMedicamento(List<PrescricaoMedicamento> prescricoesMedicamento) {
        this.prescricoesMedicamento = prescricoesMedicamento;
    }

    public List<Exame> getPrescricoesExame() {
        return prescricoesExame;
    }

    public void setPrescricoesExame(List<Exame> prescricoesExame) {
        this.prescricoesExame = prescricoesExame;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prontuario that = (Prontuario) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Prontuario{" +
                "id=" + id +
                ", consulta=" + consulta +
                ", sintomas='" + sintomas + '\'' +
                ", observacaoClinica='" + observacaoClinica + '\'' +
                ", prescricoesMedicamento=" + prescricoesMedicamento +
                ", prescricoesExame=" + prescricoesExame +
                '}';
    }
}
