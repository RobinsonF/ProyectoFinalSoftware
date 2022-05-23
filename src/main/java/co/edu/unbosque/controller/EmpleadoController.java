package co.edu.unbosque.controller;

import co.edu.unbosque.dto.EmpleadoDTO;
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
@CrossOrigin(origins = "http://localhost:8080")
public class EmpleadoController {
    @Autowired
    EmpleadoService empleadoService;

    @GetMapping("/listaEmpleado")
    public ResponseEntity<List<EmpleadoDTO>> listaEmpleado(){

        List<Empleado> empleados = empleadoService.listaEmpleados();
        List<EmpleadoDTO> listaEmpleados = new ArrayList<>();
        for (Empleado empleado: empleados) {
            listaEmpleados.add(
                    new EmpleadoDTO(empleado.getIdEmpleado(),empleado.getApellido(),empleado.getCedula(),empleado.getEstado(),empleado.getNombre())
            );
        }
        return new ResponseEntity<List<EmpleadoDTO>>(listaEmpleados, HttpStatus.OK);
    }

    @PostMapping("/crearEmpleado")
    public ResponseEntity<Empleado> crearEmpleado(@RequestBody EmpleadoDTO empleadoDTO){
        Empleado empleado = new Empleado(empleadoDTO.getApellido(),empleadoDTO.getCedula(),empleadoDTO.getEstado(),empleadoDTO.getNombre());
        empleadoService.registrarEmpleado(empleado,empleadoDTO.getId_cuadrilla());
        return new ResponseEntity(empleado, HttpStatus.OK);
    }
}
