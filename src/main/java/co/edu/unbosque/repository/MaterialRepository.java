package co.edu.unbosque.repository;


import co.edu.unbosque.dto.MaterialDTO;
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

    Material validarNombre2(String nombre, String nombre2);

    void editarMaterial(MaterialDTO materialDTO);

}
