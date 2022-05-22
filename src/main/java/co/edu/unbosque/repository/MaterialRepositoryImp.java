package co.edu.unbosque.repository;

import co.edu.unbosque.entity.Material;

import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Repository
@Transactional
public class MaterialRepositoryImp implements MaterialRepository {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public Optional<Material> buscarPorId(Integer id) {
        Material material = entityManager.find(Material.class, id);
        return material != null ? Optional.of(material) : Optional.empty();
    }

    @Override
    public List<Material> listaMateriales() {
        String query = "FROM material";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void registrar(Material material) {
        entityManager.merge(material);
    }
}
