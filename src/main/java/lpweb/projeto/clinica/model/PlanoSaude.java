package lpweb.projeto.clinica.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "plano_saude")
public class PlanoSaude {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;

    public PlanoSaude() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlanoSaude that = (PlanoSaude) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "PlanoSaude{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}

