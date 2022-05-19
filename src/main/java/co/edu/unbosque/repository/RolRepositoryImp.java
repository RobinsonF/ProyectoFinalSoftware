package co.edu.unbosque.repository;

import co.edu.unbosque.entity.Rol;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional

public class RolRepositoryImp implements RolRepository{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Optional<Rol> buscarPorId(Integer id) {
        Rol rol = entityManager.find(Rol.class, id);
        return rol != null ? Optional.of(rol) : Optional.empty();
    }

    @Override
    public List<Rol> listaRoles() {
        String query = "FROM Rol";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void registrar(Rol rol) {
        entityManager.merge(rol);
    }
}
