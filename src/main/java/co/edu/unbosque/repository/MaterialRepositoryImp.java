package co.edu.unbosque.repository;


import co.edu.unbosque.dto.MaterialDTO;
import co.edu.unbosque.entity.Cuadrilla;
import co.edu.unbosque.entity.Material;


import co.edu.unbosque.entity.Usuario;
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
    public Material buscarPorId2(Integer id) {
        String query = "FROM Material where id_material = " + id;
        List<Material> lista = entityManager.createQuery(query).getResultList();
        return lista.get(0);
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
    public Material buscarPorNombre2(String nombreMaterial, String nombreMaterial2) {
        String query = "FROM Material where nombreMaterial not in ('" + nombreMaterial2 + "') and nombreMaterial = '" + nombreMaterial + "'";
        List<Material> lista = entityManager.createQuery(query).getResultList();
        if (lista.size() != 0) {
            return lista.get(0);
        } else {
            return null;
        }
    }
    @Override
    public Integer validarNombre2(String nombre, String nombre2) {
        Material material = buscarPorNombre2(nombre, nombre2);
        if(material == null){
            return 0;
        }else{
            return 1;
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
