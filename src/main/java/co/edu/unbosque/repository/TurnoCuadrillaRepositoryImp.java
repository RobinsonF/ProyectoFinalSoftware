package co.edu.unbosque.repository;

import co.edu.unbosque.entity.Turnocuadrilla;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class TurnoCuadrillaRepositoryImp implements TurnoCuadrillaRepository{
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public Optional<Turnocuadrilla> buscarPorId(Integer id) {
        Turnocuadrilla turnoCuadrilla = entityManager.find(Turnocuadrilla.class, id);
        return turnoCuadrilla != null ? Optional.of(turnoCuadrilla) : Optional.empty();
    }

    @Override
    public List<Turnocuadrilla> listaTurnoCuadrillas() {
        String query = "FROM TurnoCuadrilla";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void registrar(Turnocuadrilla turnoCuadrilla) {
        entityManager.merge(turnoCuadrilla);
    }
}
