package co.edu.unbosque.repository;

import co.edu.unbosque.entity.Empleado;
import co.edu.unbosque.entity.Turnotrabajo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Repository
@Transactional
public class TurnoTrabajoRepositoryImp implements TurnoTrabajoRepository {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public Optional<Turnotrabajo> buscarPorId(Integer id) {
        Turnotrabajo turnotrabajo = entityManager.find(Turnotrabajo.class, id);
        return turnotrabajo != null ? Optional.of(turnotrabajo) : Optional.empty();
    }

    @Override
    public List<Turnotrabajo> listaTurnos() {
        String query = "FROM turnotrabajo";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void registrar(Turnotrabajo turnotrabajo) {
        entityManager.merge(turnotrabajo);
    }
}
