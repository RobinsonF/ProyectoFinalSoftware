package co.edu.unbosque.repository;


import co.edu.unbosque.dto.MaterialDTO;
import co.edu.unbosque.entity.Cuadrilla;
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
    public Integer validarNombre(String nombre) {
        Material material = buscarPorNombre(nombre);
        if (material != null) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public void eliminarMaterial(Integer id) {
        Material material = entityManager.find(Material.class, id);
        material.setEstado("I");
        entityManager.merge(material);
    }

    @Override
    public List<Material> listaMateriales() {
        String query = "FROM Material WHERE estado = 'A'";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void registrar(Material material) {
        entityManager.merge(material);
    }

    @Override
    public Material buscarPorNombre(String nombre) {
        String query = "FROM Material where nombreMaterial = '" + nombre + "'";
        List<Material> lista = entityManager.createQuery(query).getResultList();
        if (lista.size() != 0) {
            return lista.get(0);
        } else {
            return null;
        }
    }

    @Override
    public Material validarNombre2(String nombre, String nombre2) {
        String query = "FROM Material where nombre not in ('" + nombre2 + "') and nombre = '" + nombre + "'";
        List<Material> lista = entityManager.createQuery(query).getResultList();
        if (lista.size() != 0) {
            return lista.get(0);
        } else {
            return null;
        }
    }

    @Override
    public void editarMaterial(MaterialDTO materialDTO) {
        Material material = entityManager.find(Material.class, materialDTO.getIdMaterial());
        material.setNombreMaterial(materialDTO.getNombreMaterial());
        material.setCantidad(materialDTO.getCantidad());
        entityManager.merge(material);
    }
}
