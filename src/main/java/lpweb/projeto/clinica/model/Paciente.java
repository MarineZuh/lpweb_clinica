package lpweb.projeto.clinica.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "paciente")
public class Paciente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nome_crianca")
	private String nomeCrianca;

	@Column(name = "nome_responsavel")
	private String nomeResponsavel;

	@Column(name = "data_nascimento")
	private Date dataNascimento;

	private char sexo;

	@OneToMany( cascade = CascadeType.ALL)
    @JoinColumn(name = "paciente_id") // coluna na tabela telefone
	private List<Telefone> telefone = new ArrayList<>();
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
	private Endereco endereco;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "plano_saude_id")
	private PlanoSaude planoSaude;

	public Paciente() {
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

	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public List<Telefone> getTelefones() {
		return telefone;
	}
	public void setTelefones(List<Telefone> medicos) {
		this.telefone = medicos;
	}

	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getNomeResponsavel() { return nomeResponsavel; }
	public void setNomeResponsavel(String nomeResponsavel) { this.nomeResponsavel = nomeResponsavel; }

	public PlanoSaude getPlanoSaude() {	return planoSaude; }
	public void setPlanoSaude(PlanoSaude planoSaude) { this.planoSaude = planoSaude; }

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
		Paciente other = (Paciente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
