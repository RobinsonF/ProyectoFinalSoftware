package co.edu.unbosque.repository;

import co.edu.unbosque.entity.Material;

import java.util.List;
import java.util.Optional;

public interface MaterialRepository {
    List<Material> listaMateriales();

    void registrar(Material material);

    Material buscarPorNombre(String nombre);

    Optional<Material> buscarPorId(Integer id);

    Integer validarNombre(String nombre);

    void eliminarMaterial(Integer id);
}
