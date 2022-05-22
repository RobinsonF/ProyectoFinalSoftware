package co.edu.unbosque.repository;

import co.edu.unbosque.entity.Departamento;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class DepartamentoRepositoryImp implements DepartamentoRepository{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Optional<Departamento> buscarPorId(Integer id) {
        Departamento departamento = entityManager.find(Departamento.class, id);
        return departamento != null ? Optional.of(departamento) : Optional.empty();
    }

    @Override
    public List<Departamento> listaDepartamentos() {
        String query = "FROM departamento";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void registrar(Departamento departamento) {
        entityManager.merge(departamento);
    }
}
