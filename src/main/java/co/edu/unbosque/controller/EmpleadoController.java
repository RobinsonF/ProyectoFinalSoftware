package co.edu.unbosque.controller;

import co.edu.unbosque.dto.CuadrillaDTO;
import co.edu.unbosque.dto.EmpleadoDTO;
import co.edu.unbosque.dto.EstadoDTO;
import co.edu.unbosque.entity.Cuadrilla;
import co.edu.unbosque.entity.Empleado;
import co.edu.unbosque.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/empleado")
@CrossOrigin(origins = "http://localhost:4200")
public class EmpleadoController {
    @Autowired
    EmpleadoService empleadoService;

    @GetMapping("/listaEmpleado")
    public ResponseEntity<List<EmpleadoDTO>> listaEmpleado(){

        List<Empleado> empleados = empleadoService.listaEmpleados();
        List<EmpleadoDTO> listaEmpleados = new ArrayList<>();
        for (Empleado empleado: empleados) {
            listaEmpleados.add(
                    new EmpleadoDTO(empleado.getIdEmpleado(),empleado.getApellido(),empleado.getCedula(),empleado.getEstado(),empleado.getNombre(), empleado.getCuadrilla().getNombreCuadrilla())
            );
        }
        return new ResponseEntity<List<EmpleadoDTO>>(listaEmpleados, HttpStatus.OK);
    }

    @GetMapping("/listaEmpleadoUsuario")
    public ResponseEntity<List<EmpleadoDTO>> listaEmpleadoUsuario(@RequestParam Integer id){
        List<EmpleadoDTO> listaEmpleados = empleadoService.listaPorUsuario(id);
        return new ResponseEntity<List<EmpleadoDTO>>(listaEmpleados, HttpStatus.OK);
    }

    @PostMapping("/crearEmpleado")
    public EstadoDTO crearEmpleado(@RequestBody EmpleadoDTO empleadoDTO){
        EstadoDTO estadoDTO = new EstadoDTO();
        String mensaje = empleadoService.registrarEmpleado(empleadoDTO);
        estadoDTO.setMensaje(mensaje);
        return estadoDTO;
    }

    @PutMapping("/eliminarEmpleado")
    public EstadoDTO eliminarEmplado(@RequestParam Integer id){
        EstadoDTO estadoDTO = new EstadoDTO();
        empleadoService.eliminarEmpleado(id);
        estadoDTO.setMensaje("Empleado eliminado");
        return estadoDTO;
    }

    @GetMapping("/obtenerEmpleado")
    public EmpleadoDTO buscarPorId(@RequestParam Integer id){
        Empleado empleado = empleadoService.buscarPorId(id);
        EmpleadoDTO empleadoDTO = new EmpleadoDTO();
        empleadoDTO.setCedula(empleado.getCedula());
        return empleadoDTO;
    }

    @PutMapping("/editarEmpleado")
    public EstadoDTO editarEmpleado(@RequestBody EmpleadoDTO empleadoDTO) {
        EstadoDTO estadoDTO = new EstadoDTO();
        String mensaje = empleadoService.editarEmpleado(empleadoDTO);
        if(mensaje.equals("La cedula ya se encuentra registrada")){
            estadoDTO.setMensaje(mensaje);
        }else{
            estadoDTO.setMensaje(mensaje);
        }
        return estadoDTO;
    }
}
