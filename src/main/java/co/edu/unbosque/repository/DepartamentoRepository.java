package co.edu.unbosque.repository;

import co.edu.unbosque.entity.Departamento;
import co.edu.unbosque.entity.Rol;

import java.util.List;
import java.util.Optional;

public interface DepartamentoRepository {

    Optional<Departamento> buscarPorId(Integer id);
    List<Departamento> listaDepartamentos();
    void registrar (Departamento departamento);

    Departamento buscarPorNombre(String nombre);

    Integer validarNombre(String nombre);

    Integer obtenerIdPorNombre(String nombre);

    void eliminarDepartamento(Integer id);
}
