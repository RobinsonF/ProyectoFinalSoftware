package co.edu.unbosque.repository;

import co.edu.unbosque.entity.Rol;

import java.util.List;
import java.util.Optional;

public interface RolRepository {

    Optional<Rol> buscarPorId(Integer id);
    List<Rol> listaRoles();

    void registrar (Rol rol);
}
