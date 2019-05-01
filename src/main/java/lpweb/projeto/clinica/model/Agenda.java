package lpweb.projeto.clinica.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lpweb.projeto.clinica.model.enums.DiaDaSemana;

@Entity
@Table(name = "agenda")
public class Agenda {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

	@Enumerated(EnumType.STRING)
	private DiaDaSemana diaDaSemana;

	@ElementCollection
	@CollectionTable(name = "agenda_datas", joinColumns = @JoinColumn(name = "agenda_id"))
	@Column(name = "data")
	private List<LocalDateTime> datas = new ArrayList();
	
	// @ManyToOne
	// @JoinColumn(name = "medico_id")
	// @JsonIgnore
	// private Medico medico;

	
	public Agenda() {}
	/*
	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	*/

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public DiaDaSemana getDiaDaSemana() {
		return diaDaSemana;
	}

	public void setDiaDaSemana(DiaDaSemana diaDaSemana) {
		this.diaDaSemana = diaDaSemana;
	}

	public List<LocalDateTime> getDatas() {
		return datas;
	}

	public void setDatas(List<LocalDateTime> datas) {
		this.datas = datas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agenda other = (Agenda) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Agenda{" +
				"id=" + id +
				", diaDaSemana=" + diaDaSemana +
				", datas=" + datas +
				'}';
	}
}
