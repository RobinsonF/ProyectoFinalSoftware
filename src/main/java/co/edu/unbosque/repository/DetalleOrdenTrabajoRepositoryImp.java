package co.edu.unbosque.repository;

import co.edu.unbosque.entity.DetalleOrdenTrabajo;
import co.edu.unbosque.entity.TurnoCuadrilla;
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
    public Optional<DetalleOrdenTrabajo> buscarPorId(Integer id) {
        DetalleOrdenTrabajo detalleOrdenTrabajo = entityManager.find(DetalleOrdenTrabajo.class, id);
        return detalleOrdenTrabajo != null ? Optional.of(detalleOrdenTrabajo) : Optional.empty();
    }

    @Override
    public List<DetalleOrdenTrabajo> listaDetalleOrdenTrabajos() {
        String query = "FROM DetalleOrdenTrabajo";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void registrar(DetalleOrdenTrabajo detalleOrdenTrabajo) {
        entityManager.merge(detalleOrdenTrabajo);
    }
}
