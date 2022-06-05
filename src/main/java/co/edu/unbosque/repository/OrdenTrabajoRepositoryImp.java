package co.edu.unbosque.repository;

import co.edu.unbosque.entity.Ordentrabajo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class OrdenTrabajoRepositoryImp implements OrdenTrabajoRepository{
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public Optional<Ordentrabajo> buscarPorId(Integer id) {
        Ordentrabajo ordentrabajo = entityManager.find(Ordentrabajo.class, id);
        return ordentrabajo != null ? Optional.of(ordentrabajo) : Optional.empty();
    }

    @Override
    public void eliminarOrden(Integer id) {
        Ordentrabajo ordentrabajo = entityManager.find(Ordentrabajo.class, id);
        ordentrabajo.setEstado("I");
        entityManager.merge(ordentrabajo);
    }

    @Override
    public List<Ordentrabajo> listaOrdenes() {
        String query = "FROM Ordentrabajo WHERE estado = 'A'";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void registrar(Ordentrabajo ordentrabajo) {
        entityManager.merge(ordentrabajo);
    }
}
