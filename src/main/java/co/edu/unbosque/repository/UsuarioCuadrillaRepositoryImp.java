package co.edu.unbosque.repository;

import co.edu.unbosque.entity.Usuariocuadrilla;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Repository
@Transactional
public class UsuarioCuadrillaRepositoryImp implements UsuarioCuadrillaRepository {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public Optional<Usuariocuadrilla> buscarPorId(Integer id) {
        Usuariocuadrilla usuarioCuadrilla = entityManager.find(Usuariocuadrilla.class, id);
        return usuarioCuadrilla != null ? Optional.of(usuarioCuadrilla) : Optional.empty();
    }

    @Override
    public List<Usuariocuadrilla> listaUsuarioCuadrillas() {
        String query = "FROM UsuarioCuadrilla";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void registrar(Usuariocuadrilla usuarioCuadrilla) {
        entityManager.merge(usuarioCuadrilla);
    }
}
