package co.edu.unbosque.repository;

import co.edu.unbosque.entity.Empleado;

import java.util.List;
import java.util.Optional;

public interface EmpleadoRepository {
    List<Empleado> listaEmpleados();

    void registrar(Empleado empleado);

    Optional<Empleado> buscarPorId(Integer id);

}
