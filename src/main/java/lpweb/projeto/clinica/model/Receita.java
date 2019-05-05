package lpweb.projeto.clinica.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "receita")
public class Receita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToMany
    @JoinTable(
            name = "receita_prescrioes_medicamento",
            joinColumns = @JoinColumn(name = "receita_id"),
            inverseJoinColumns = @JoinColumn(name = "pescricao_medicamento_id")
    )
    private List<PrescricaoMedicamento> prescricoes = new ArrayList();

    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;

    public Receita() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<PrescricaoMedicamento> getPrescricoes() {
        return prescricoes;
    }

    public void setPrescricoes(List<PrescricaoMedicamento> prescricoes) {
        this.prescricoes = prescricoes;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Receita receita = (Receita) o;
        return id.equals(receita.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Receita{" +
                "id=" + id +
                ", prescricoes=" + prescricoes +
                ", medico=" + medico +
                '}';
    }
}
