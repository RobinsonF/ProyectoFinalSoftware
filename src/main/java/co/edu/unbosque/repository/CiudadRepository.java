package co.edu.unbosque.repository;

import co.edu.unbosque.entity.Ciudad;
import co.edu.unbosque.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface CiudadRepository {

    List<Ciudad> listaCiudades();

    void registrar(Ciudad ciudad);

    Optional<Ciudad> buscarPorId(Integer id);
}
