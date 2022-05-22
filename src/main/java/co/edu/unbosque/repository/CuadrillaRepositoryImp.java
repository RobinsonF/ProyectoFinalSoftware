package co.edu.unbosque.repository;

import co.edu.unbosque.entity.Cuadrilla;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class CuadrillaRepositoryImp implements CuadrillaRepository{
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public Optional<Cuadrilla> buscarPorId(Integer id) {
        Cuadrilla cuadrilla = entityManager.find(Cuadrilla.class, id);
        return cuadrilla != null ? Optional.of(cuadrilla) : Optional.empty();
    }

    @Override
    public List<Cuadrilla> listaCuadrillas() {
        String query = "FROM cuadrilla";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void registrar(Cuadrilla cuadrilla) {
        entityManager.merge(cuadrilla);
    }
}
