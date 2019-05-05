package lpweb.projeto.clinica.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "prontuario")
public class Prontuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String sintomas;
	private String observacaoClinica;

    @OneToOne(mappedBy = "prontuario")
	private Consulta consulta;

    @OneToOne
    @JoinColumn(name = "historico_peso_altura_id")
    private HistoricoPesoAltura historicoPesoAltura;

    @OneToMany
    @JoinColumn(name = "prontuario_id") // coluna na prescricao_medicamento
	private List<PrescricaoMedicamento> prescricoesMedicamento = new ArrayList();

    @ManyToMany
    @JoinTable(
            name = "prontuario_exames",
            joinColumns = @JoinColumn(name = "prontuario_id"),
            inverseJoinColumns = @JoinColumn(name = "exame_id")
    )
    private List<Exame> prescricoesExame = new ArrayList();

    public Prontuario() {
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
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

    public HistoricoPesoAltura getHistoricoPesoAltura() {
        return historicoPesoAltura;
    }
    public void setHistoricoPesoAltura(HistoricoPesoAltura historicoPesoAltura) {
        this.historicoPesoAltura = historicoPesoAltura;
    }

    public Consulta getConsulta() {
        return consulta;
    }
    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
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


}
