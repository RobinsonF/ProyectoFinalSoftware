package co.edu.unbosque.repository;

import co.edu.unbosque.entity.TurnoCuadrilla;
import co.edu.unbosque.entity.UsuarioCuadrilla;
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
    public Optional<TurnoCuadrilla> buscarPorId(Integer id) {
        TurnoCuadrilla turnoCuadrilla = entityManager.find(TurnoCuadrilla.class, id);
        return turnoCuadrilla != null ? Optional.of(turnoCuadrilla) : Optional.empty();
    }

    @Override
    public List<TurnoCuadrilla> listaTurnoCuadrillas() {
        String query = "FROM TurnoCuadrilla";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void registrar(TurnoCuadrilla turnoCuadrilla) {
        entityManager.merge(turnoCuadrilla);
    }
}
