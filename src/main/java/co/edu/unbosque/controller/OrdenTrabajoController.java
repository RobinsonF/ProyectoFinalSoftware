package co.edu.unbosque.controller;

import co.edu.unbosque.dto.OrdenTrabajoDTO;
import co.edu.unbosque.dto.ZonaDTO;
import co.edu.unbosque.entity.Ciudad;
import co.edu.unbosque.entity.Ordentrabajo;
import co.edu.unbosque.entity.Zona;
import co.edu.unbosque.service.OrdenTrabajoService;
import co.edu.unbosque.service.ZonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/orden")
@CrossOrigin(origins = "http://localhost:8080")
public class OrdenTrabajoController {
    @Autowired
    OrdenTrabajoService ordenTrabajoService;

    @GetMapping("/listaOrden")
    public ResponseEntity<List<OrdenTrabajoDTO>> listaOrden(){

        List<Ordentrabajo> ordenes = ordenTrabajoService.listaOrden();
        List<OrdenTrabajoDTO> listaOrdenes = new ArrayList<>();
        for (Ordentrabajo ordentrabajo: ordenes) {
            listaOrdenes.add(
                    new OrdenTrabajoDTO(ordentrabajo.getIdTrabajo(),ordentrabajo.getEstado(),ordentrabajo.getFechaTrabajof(),ordentrabajo.getFechaTrabajoi(),ordentrabajo.getNombreTrabajo())
            );
        }
        return new ResponseEntity<List<OrdenTrabajoDTO>>(listaOrdenes, HttpStatus.OK);
    }

    @PostMapping("/crearOrden")
    public ResponseEntity<Ordentrabajo> crearZona(@RequestBody OrdenTrabajoDTO ordenTrabajoDTO){
        Ordentrabajo ordentrabajo = new Ordentrabajo("A",ordenTrabajoDTO.getFechaTrabajof(),ordenTrabajoDTO.getFechaTrabajoi(),ordenTrabajoDTO.getNombreTrabajo());
        ordenTrabajoService.registrarOrden(ordentrabajo, ordenTrabajoDTO.getZona(),ordenTrabajoDTO.getCuadrilla());
        return new ResponseEntity(ordentrabajo, HttpStatus.OK);
    }
}
