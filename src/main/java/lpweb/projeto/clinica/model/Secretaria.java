package lpweb.projeto.clinica.model;

import java.util.Objects;

public class Secretaria {
    private Integer id;
    private String nome;

    public Secretaria() {
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
        Secretaria that = (Secretaria) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Secretaria{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
