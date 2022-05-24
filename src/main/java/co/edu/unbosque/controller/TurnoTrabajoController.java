package co.edu.unbosque.controller;

import co.edu.unbosque.dto.TurnoTrabajoDTO;
import co.edu.unbosque.dto.UsuarioDTO;
import co.edu.unbosque.entity.Turnotrabajo;
import co.edu.unbosque.service.TurnoTrabajoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/turno")
@CrossOrigin(origins = "http://localhost:8080")
public class TurnoTrabajoController {
    @Autowired
    TurnoTrabajoService turnoTrabajoService;

    @GetMapping("/listaTurno")
    public ResponseEntity<List<TurnoTrabajoDTO>> listaTurno() {

        List<Turnotrabajo> turnotrabajos = turnoTrabajoService.listaTurnos();
        List<TurnoTrabajoDTO> listaTurnos = new ArrayList<>();
        for (Turnotrabajo turnotrabajo : turnotrabajos) {
            listaTurnos.add(
                    new TurnoTrabajoDTO(turnotrabajo.getIdTurnotrabajo(),turnotrabajo.getEstado(),turnotrabajo.getNombre())
            );
        }
        return new ResponseEntity<List<TurnoTrabajoDTO>>(listaTurnos, HttpStatus.OK);
    }

    @PostMapping("/crearTurno")
    public ResponseEntity<Turnotrabajo> crearTurno(@RequestBody TurnoTrabajoDTO turnoTrabajoDTO) {
        Turnotrabajo turnotrabajo = new Turnotrabajo("A",turnoTrabajoDTO.getNombre());
        turnoTrabajoService.registrarTurno(turnotrabajo);
        return new ResponseEntity(turnotrabajo, HttpStatus.OK);
    }

    @PostMapping("/turnoId/{id}")
    public Integer obtenerId(@RequestBody TurnoTrabajoDTO turnoTrabajoDTO){
        return turnoTrabajoService.obtenerId(turnoTrabajoDTO.getNombre());
    }
}
