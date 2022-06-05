package co.edu.unbosque.repository;

import co.edu.unbosque.entity.Zona;

import java.util.List;
import java.util.Optional;

public interface ZonaRepository {
    List<Zona> listaZonas();

    void registrar(Zona zona);

    Zona buscarPorNombre(String nombre);

    Integer validarNombre(String nombre);

    Optional<Zona> buscarPorId(Integer id);

    Integer obtenerIdPorNombre(String nombre);

    void eliminarZona(Integer id);
}
