package co.edu.unbosque.controller;

import co.edu.unbosque.dto.CuadrillaDTO;
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
@CrossOrigin(origins = "http://localhost:8080")
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
    public ResponseEntity<Cuadrilla> crearCuadrilla(@RequestBody CuadrillaDTO cuadrillaDTO){
        Cuadrilla cuadrilla = new Cuadrilla("A",cuadrillaDTO.getNombreCuadrilla());
        cuadrillaService.registrarCuadrilla(cuadrilla);
        return new ResponseEntity(cuadrilla, HttpStatus.OK);
    }

    @PostMapping("/obtenerId/{id}")
    public Integer obtenerId(@RequestBody CuadrillaDTO cuadrillaDTO){
        return cuadrillaService.obtenerIdPorNombre(cuadrillaDTO.getNombreCuadrilla());
    }

}
