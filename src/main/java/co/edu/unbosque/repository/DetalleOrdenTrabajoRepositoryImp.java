package co.edu.unbosque.repository;

import co.edu.unbosque.entity.Detalleordentrabajo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Repository
@Transactional
public class DetalleOrdenTrabajoRepositoryImp implements DetalleOrdenTrabajoRepository{
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public Optional<Detalleordentrabajo> buscarPorId(Integer id) {
        Detalleordentrabajo detalleOrdenTrabajo = entityManager.find(Detalleordentrabajo.class, id);
        return detalleOrdenTrabajo != null ? Optional.of(detalleOrdenTrabajo) : Optional.empty();
    }

    @Override
    public List<Detalleordentrabajo> listaDetalleOrdenTrabajos() {
        String query = "FROM DetalleOrdenTrabajo";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void registrar(Detalleordentrabajo detalleOrdenTrabajo) {
        entityManager.merge(detalleOrdenTrabajo);
    }
}
