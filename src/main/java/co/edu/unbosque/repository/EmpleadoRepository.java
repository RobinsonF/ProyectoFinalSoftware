package co.edu.unbosque.repository;

import co.edu.unbosque.dto.CuadrillaDTO;
import co.edu.unbosque.dto.EmpleadoDTO;
import co.edu.unbosque.entity.Cuadrilla;
import co.edu.unbosque.entity.Empleado;

import java.util.List;
import java.util.Optional;

public interface EmpleadoRepository {
    List<Empleado> listaEmpleados();

    void registrar(Empleado empleado);

    Optional<Empleado> buscarPorId(Integer id);

    void eliminarEmpleado(Integer id);

    List<EmpleadoDTO> listaPorUsuario(Integer id);

    void editarEmpleado(EmpleadoDTO empleadoDTO);


}
