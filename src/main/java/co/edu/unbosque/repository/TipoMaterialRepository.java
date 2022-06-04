package co.edu.unbosque.repository;

import co.edu.unbosque.entity.Departamento;
import co.edu.unbosque.entity.TipoMaterial;

import java.util.List;
import java.util.Optional;

public interface TipoMaterialRepository {
    Optional<TipoMaterial> buscarPorId(Integer id);
    List<TipoMaterial> listarTipos();
    void registrar (TipoMaterial tipoMaterial);

    TipoMaterial buscarPorNombre(String nombre);

    Integer obtenerIdPorNombre(String nombre);
}
