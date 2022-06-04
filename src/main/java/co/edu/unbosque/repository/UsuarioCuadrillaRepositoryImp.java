package co.edu.unbosque.repository;

import co.edu.unbosque.entity.UsuarioCuadrilla;
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
    public Optional<UsuarioCuadrilla> buscarPorId(Integer id) {
        UsuarioCuadrilla usuarioCuadrilla = entityManager.find(UsuarioCuadrilla.class, id);
        return usuarioCuadrilla != null ? Optional.of(usuarioCuadrilla) : Optional.empty();
    }

    @Override
    public List<UsuarioCuadrilla> listaUsuarioCuadrillas() {
        String query = "FROM UsuarioCuadrilla";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void registrar(UsuarioCuadrilla usuarioCuadrilla) {
        entityManager.merge(usuarioCuadrilla);
    }
}
