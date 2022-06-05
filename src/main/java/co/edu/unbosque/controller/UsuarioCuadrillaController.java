package co.edu.unbosque.controller;


import co.edu.unbosque.dto.UsuarioCuadrillaDTO;
import co.edu.unbosque.entity.Ordentrabajo;
import co.edu.unbosque.entity.Usuariocuadrilla;
import co.edu.unbosque.service.UsuarioCuadrillaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/usuarioCuadrilla")
@CrossOrigin(origins = "http://localhost:8080")
public class UsuarioCuadrillaController {
    @Autowired
    UsuarioCuadrillaService usuarioCuadrillaService;

    @GetMapping("/listaUsuarioCuadrilla")
    public ResponseEntity<List<UsuarioCuadrillaDTO>> listaUsuarioCuadrilla(){

        List<Usuariocuadrilla> usuarioCuadrillas = usuarioCuadrillaService.listaUsuarioCuadrilla();
        List<UsuarioCuadrillaDTO> listaUsuarioCuadrillas = new ArrayList<>();
        for (Usuariocuadrilla usuarioCuadrilla: usuarioCuadrillas) {
            listaUsuarioCuadrillas.add(
                    new UsuarioCuadrillaDTO(usuarioCuadrilla.getIdUsuariocuadrilla(),usuarioCuadrilla.getEstado())
            );
        }
        return new ResponseEntity<List<UsuarioCuadrillaDTO>>(listaUsuarioCuadrillas, HttpStatus.OK);
    }

    @PostMapping("/crearUsuarioCuadrilla")
    public ResponseEntity<Ordentrabajo> crearUsuarioCuadrilla(@RequestBody UsuarioCuadrillaDTO usuarioCuadrillaDTO){
        Usuariocuadrilla usuarioCuadrilla = new Usuariocuadrilla(usuarioCuadrillaDTO.getEstado());
        usuarioCuadrillaService.registrarUsuarioCuadrilla(usuarioCuadrilla, usuarioCuadrillaDTO.getUsuario(),usuarioCuadrillaDTO.getCuadrilla());
        return new ResponseEntity(usuarioCuadrilla, HttpStatus.OK);
    }
}
