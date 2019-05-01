package lpweb.projeto.clinica.model;

import java.util.Objects;

public abstract class AbstractPrescricao {

    private Integer id;

    public AbstractPrescricao() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractPrescricao that = (AbstractPrescricao) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
