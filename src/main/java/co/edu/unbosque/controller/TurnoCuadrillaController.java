package co.edu.unbosque.controller;

import co.edu.unbosque.dto.TurnoCuadrillaDTO;
import co.edu.unbosque.entity.Ordentrabajo;
import co.edu.unbosque.entity.TurnoCuadrilla;
import co.edu.unbosque.service.TurnoCuadrillaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/turnoCuadrilla")
@CrossOrigin(origins = "http://localhost:8080")
public class TurnoCuadrillaController {
    @Autowired
    TurnoCuadrillaService turnoCuadrillaService;

    @GetMapping("/listaTurnoCuadrilla")
    public ResponseEntity<List<TurnoCuadrillaDTO>> listaTurnoCuadrilla(){

        List<TurnoCuadrilla> turnoCuadrillas = turnoCuadrillaService.listaTurnoCuadrilla();
        List<TurnoCuadrillaDTO> listaTurnoCuadrillas = new ArrayList<>();
        for (TurnoCuadrilla turnoCuadrilla: turnoCuadrillas) {
            listaTurnoCuadrillas.add(
                    new TurnoCuadrillaDTO(turnoCuadrilla.getIdTurnoCuadrilla(),turnoCuadrilla.getEstado())
            );
        }
        return new ResponseEntity<List<TurnoCuadrillaDTO>>(listaTurnoCuadrillas, HttpStatus.OK);
    }

    @PostMapping("/crearTurnoCuadrilla")
    public ResponseEntity<Ordentrabajo> crearTurnoCuadrilla(@RequestBody TurnoCuadrillaDTO turnoCuadrillaDTO){
        TurnoCuadrilla turnoCuadrilla = new TurnoCuadrilla(turnoCuadrillaDTO.getEstado());
        turnoCuadrillaService.registrarTurnoCuadrilla(turnoCuadrilla, turnoCuadrillaDTO.getTurno(),turnoCuadrillaDTO.getCuadrilla());
        return new ResponseEntity(turnoCuadrilla, HttpStatus.OK);
    }
}
