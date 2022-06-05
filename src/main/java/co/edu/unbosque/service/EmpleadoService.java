package co.edu.unbosque.service;


import co.edu.unbosque.dto.EmpleadoDTO;
import co.edu.unbosque.entity.Cuadrilla;
import co.edu.unbosque.entity.Empleado;
import co.edu.unbosque.repository.CuadrillaRepository;
import co.edu.unbosque.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmpleadoService {
    @Autowired
    EmpleadoRepository empleadoRepository;

    @Autowired
    CuadrillaRepository cuadrillaRepository;


    public List<Empleado> listaEmpleados(){
        return  empleadoRepository.listaEmpleados();
    }

    public String registrarEmpleado(EmpleadoDTO empleado) {
        Integer id = cuadrillaRepository.obtenerIdPorNombre(empleado.getNombreCuadrilla());
        Empleado empleado1 = new Empleado(empleado.getApellido(),empleado.getCedula(),"A",empleado.getNombre());
        Optional<Cuadrilla> cuadrilla = cuadrillaRepository.buscarPorId(id);
        cuadrilla.ifPresent(a -> {
            a.addEmpleado(empleado1);
            cuadrillaRepository.registrar(a);
        });
        empleadoRepository.registrar(empleado1);
        return "Registrado correctamente";

    }
}
