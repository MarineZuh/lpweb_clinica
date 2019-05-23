package lpweb.projeto.clinica.repository.paciente;

import lpweb.projeto.clinica.model.Paciente;
import lpweb.projeto.clinica.repository.filter.PacienteFiltro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PacienteRepositoryImpl implements PacienteRepositoryQuery {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public Page<Paciente> filtrar(PacienteFiltro filtro, Pageable pageable) {

        // Usamos o CriteriaBuilder(cb) para criar a CriteriaQueyr (cQuery)
        // com a tipagem do tipo a ser selecionado (Paciente)
        CriteriaBuilder cBuilder = manager.getCriteriaBuilder();


        // 1. Select p From Paciente p
        CriteriaQuery<Paciente> cQuery = cBuilder.createQuery(Paciente.class );

        // 2. clausula from e joins
        Root<Paciente> pacienteRoot = cQuery.from(Paciente.class );

        // 3. adiciona as restrições (os predicados) que serão passadas na clausula where
        Predicate[] restricoes = this.criaRestricoes(filtro, cBuilder, pacienteRoot  );


        // 4. monta a consulta com as restrições
        cQuery.select(pacienteRoot)
                .where(restricoes )
                .orderBy( cBuilder.desc(pacienteRoot.get("nomeCrianca")) );

        // 5. cria e executa a consula
        TypedQuery<Paciente> query = manager.createQuery(cQuery);
        adicionaRestricoesDePaginacao(query, pageable);

        return new PageImpl<Paciente>(query.getResultList(), pageable, total(filtro) );
    }


    private Predicate[] criaRestricoes(PacienteFiltro filtro, CriteriaBuilder cBuilder, Root<Paciente> pacienteRoot) {

        List<Predicate> predicates = new ArrayList<>();

        if (Objects.nonNull(filtro.getId()) ) {
            predicates.add(cBuilder.equal(pacienteRoot.get("id"), filtro.getId()));
        }

        if (Objects.nonNull(filtro.getDataNascimento()) ) {
            predicates.add(cBuilder.equal(pacienteRoot.get("dataNascimento"), filtro.getDataNascimento()));
        }

        if (filtro.getSexo() != '\u0000' ) {
            predicates.add(cBuilder.equal(pacienteRoot.get("sexo"), filtro.getSexo()));
        }

        if ( !StringUtils.isEmpty( filtro.getNomeCrianca()) ) {
            predicates.add(
                cBuilder.like(cBuilder.lower(pacienteRoot.get("nome")),
                "%" + filtro.getNomeCrianca().toLowerCase() + "%" )
            );

        }
        /*
        if (Objects.nonNull(filtro.getCategoriaId()) ) {

            // antes fazemos o join com categorias
            Path<Integer> categoriaPath = pacienteRoot.join("categorias").<Integer>get("id");

            // semelhante a clausula "on" do critério de junção
            predicates.add ( cBuilder.equal(categoriaPath, filtro.getCategoriaId() ) );
        }
        */
        return predicates.toArray(new Predicate[ predicates.size() ] );
    }



    private void adicionaRestricoesDePaginacao(TypedQuery<Paciente> query, Pageable pageable) {
        Integer paginaAtual = pageable.getPageNumber();
        Integer totalObjetosPorPagina = pageable.getPageSize();
        Integer primeiroObjetoDaPagina = paginaAtual * totalObjetosPorPagina;

        // 0 a n-1, n - (2n -1), ...
        query.setFirstResult(primeiroObjetoDaPagina );
        query.setMaxResults(totalObjetosPorPagina );

    }

    private Long total(PacienteFiltro filtro) {
        CriteriaBuilder cBuilder = manager.getCriteriaBuilder();
        CriteriaQuery<Long> cQuery = cBuilder.createQuery(Long.class);

        Root<Paciente> rootPaciente = cQuery.from(Paciente.class);

        Predicate[] predicates = criaRestricoes(filtro, cBuilder, rootPaciente);

        cQuery.where(predicates );
        cQuery.select( cBuilder.count(rootPaciente) );

        return manager.createQuery(cQuery).getSingleResult();
    }
}
