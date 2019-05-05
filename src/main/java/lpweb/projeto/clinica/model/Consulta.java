package lpweb.projeto.clinica.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "consulta")
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime dataHorario;
    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;
    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;
    private Boolean ehEncaixe;
    private Boolean ehPacienteNovo;
    @OneToOne
    @JoinColumn(name = "prontuario_id")
    private Prontuario prontuario;

    public Consulta() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDataHorario() {
        return dataHorario;
    }

    public void setDataHorario(LocalDateTime dataHorario) {
        this.dataHorario = dataHorario;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Boolean getEhEncaixe() {
        return ehEncaixe;
    }

    public void setEhEncaixe(Boolean ehEncaixe) {
        this.ehEncaixe = ehEncaixe;
    }

    public Boolean getEhPacienteNovo() {
        return ehPacienteNovo;
    }

    public void setEhPacienteNovo(Boolean ehPacienteNovo) {
        this.ehPacienteNovo = ehPacienteNovo;
    }

    public Prontuario getProntuario() {
        return prontuario;
    }

    public void setProntuario(Prontuario prontuario) {
        this.prontuario = prontuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Consulta consulta = (Consulta) o;
        return id.equals(consulta.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Consulta{" +
                "id=" + id +
                ", dataHorario=" + dataHorario +
                ", medico=" + medico +
                ", paciente=" + paciente +
                ", ehEncaixe=" + ehEncaixe +
                ", ehPacienteNovo=" + ehPacienteNovo +
                ", prontuario=" + prontuario +
                '}';
    }
}
