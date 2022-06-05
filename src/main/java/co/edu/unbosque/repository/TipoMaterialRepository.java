package co.edu.unbosque.repository;

import co.edu.unbosque.entity.Tipomaterial;

import java.util.List;
import java.util.Optional;

public interface TipoMaterialRepository {
    Optional<Tipomaterial> buscarPorId(Integer id);
    List<Tipomaterial> listarTipos();
    void registrar (Tipomaterial tipoMaterial);

    Tipomaterial buscarPorNombre(String nombre);

    Integer obtenerIdPorNombre(String nombre);
}
