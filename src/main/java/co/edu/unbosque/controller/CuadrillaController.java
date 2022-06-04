package co.edu.unbosque.controller;

import co.edu.unbosque.dto.CuadrillaDTO;
import co.edu.unbosque.dto.EstadoDTO;
import co.edu.unbosque.dto.UsuarioDTO;
import co.edu.unbosque.entity.Cuadrilla;
import co.edu.unbosque.service.CuadrillaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cuadrilla")
@CrossOrigin(origins = "http://localhost:4200")
public class CuadrillaController {
    @Autowired
    CuadrillaService cuadrillaService;

    @GetMapping("/listaCuadrilla")
    public ResponseEntity<List<CuadrillaDTO>> listaCuadrilla(){

        List<Cuadrilla> cuadrillas = cuadrillaService.listaCuadrilla();
        List<CuadrillaDTO> listaCuadrillas = new ArrayList<>();
        for (Cuadrilla cuadrilla: cuadrillas) {
            listaCuadrillas.add(
                    new CuadrillaDTO(cuadrilla.getIdCuadrilla(),cuadrilla.getEstado(),cuadrilla.getNombreCuadrilla())
            );
        }
        return new ResponseEntity<List<CuadrillaDTO>>(listaCuadrillas, HttpStatus.OK);
    }

    @PostMapping("/crearCuadrilla")
    public EstadoDTO crearCuadrilla(@RequestBody CuadrillaDTO cuadrillaDTO){
        EstadoDTO estadoDTO = new EstadoDTO();
        String mensaje = cuadrillaService.registrarCuadrilla(cuadrillaDTO);
        estadoDTO.setMensaje(mensaje);
        return estadoDTO;
    }

    @PostMapping("/obtenerId/{id}")
    public Integer obtenerId(@RequestBody CuadrillaDTO cuadrillaDTO){
        return cuadrillaService.obtenerIdPorNombre(cuadrillaDTO.getNombreCuadrilla());
    }

}
