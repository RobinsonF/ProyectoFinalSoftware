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
                    new CuadrillaDTO(cuadrilla.getIdCuadrilla(),cuadrilla.getEstado(),cuadrilla.getNombreCuadrilla(), cuadrilla.getOrdentrabajos().size())
            );
        }
        return new ResponseEntity<List<CuadrillaDTO>>(listaCuadrillas, HttpStatus.OK);
    }

    @GetMapping("/listaCuadrillaUsuario")
    public ResponseEntity<List<CuadrillaDTO>> listaCuadrillaUsuario(@RequestParam Integer id){
        List<CuadrillaDTO> cuadrillas = cuadrillaService.listaCuadrillaPorUsuario(id);
        return new ResponseEntity<List<CuadrillaDTO>>(cuadrillas, HttpStatus.OK);
    }

    @PostMapping("/crearCuadrilla")
    public EstadoDTO crearCuadrilla(@RequestBody CuadrillaDTO cuadrillaDTO){
        EstadoDTO estadoDTO = new EstadoDTO();
        String mensaje = cuadrillaService.registrarCuadrilla(cuadrillaDTO);
        estadoDTO.setMensaje(mensaje);
        return estadoDTO;
    }

    @GetMapping("/obtenerId")
    public EstadoDTO obtenerId(@RequestParam String nombre){
        EstadoDTO estadoDTO = new EstadoDTO();
        estadoDTO.setMensaje(cuadrillaService.obtenerIdPorNombre(nombre)+"");
        return estadoDTO;
    }

    @PutMapping("/eliminarCuadrilla")
    public EstadoDTO eliminarCuadrilla(@RequestParam Integer id){
        EstadoDTO estadoDTO = new EstadoDTO();
        cuadrillaService.eliminarCuadrilla(id);
        estadoDTO.setMensaje("Cuadrilla eliminada");
        return estadoDTO;
    }

    @PutMapping("/editarCuadrilla")
    public EstadoDTO editarCuadrilla(@RequestBody CuadrillaDTO cuadrillaDTO) {
        EstadoDTO estadoDTO = new EstadoDTO();
        String mensaje = cuadrillaService.editarCuadrilla(cuadrillaDTO);
        if(mensaje.equals("El nombre ya se encuentra registrado")){
            estadoDTO.setMensaje(mensaje);
        }else{
            estadoDTO.setMensaje(mensaje);
        }
        return estadoDTO;
    }

}
