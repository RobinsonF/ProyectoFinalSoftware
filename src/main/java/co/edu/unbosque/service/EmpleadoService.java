package co.edu.unbosque.service;


import co.edu.unbosque.dto.CuadrillaDTO;
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

    public List<EmpleadoDTO> listaPorUsuario(Integer id){
        return empleadoRepository.listaPorUsuario(id);
    }

    public String registrarEmpleado(EmpleadoDTO empleado) {
        if(empleadoRepository.validarCedula(empleado.getCedula()) != 0){
            return "La cédula se encuentra en uso";
        }else {
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

    public void eliminarEmpleado(Integer id){
        empleadoRepository.eliminarEmpleado(id);
    }

    public Integer validarCedula2(String cedula, String cedula2){
        return empleadoRepository.validarCedula2(cedula, cedula2);
    }

    public String editarEmpleado(EmpleadoDTO empleadoDTO){
        Empleado empleado = empleadoRepository.buscarPorId2(empleadoDTO.getIdEmpleado());
        if(validarCedula2(empleadoDTO.getCedula(), empleado.getCedula())==1){
            return "La cedula ya se encuentra registrada";
        }else{
            empleadoRepository.editarEmpleado(empleadoDTO);
            return "Guardado Correctamente";
        }
    }

    public Empleado buscarPorId(Integer id){
        return empleadoRepository.buscarPorId2(id);
    }
}
