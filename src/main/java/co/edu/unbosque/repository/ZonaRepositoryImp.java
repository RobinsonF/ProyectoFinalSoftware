package co.edu.unbosque.repository;

import co.edu.unbosque.entity.Ciudad;
import co.edu.unbosque.entity.Zona;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class ZonaRepositoryImp implements ZonaRepository{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Optional<Zona> buscarPorId(Integer id) {
        Zona zona = entityManager.find(Zona.class, id);
        return zona != null ? Optional.of(zona) : Optional.empty();
    }

    @Override
    public List<Zona> listaZonas() {
        String query = "FROM Zona";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void registrar(Zona zona) {
        entityManager.merge(zona);
    }
}
