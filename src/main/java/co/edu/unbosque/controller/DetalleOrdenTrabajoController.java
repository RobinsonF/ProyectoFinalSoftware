package co.edu.unbosque.controller;

import co.edu.unbosque.dto.DetalleOrdenTrabajoDTO;
import co.edu.unbosque.entity.Detalleordentrabajo;
import co.edu.unbosque.entity.Ordentrabajo;
import co.edu.unbosque.service.DetalleOrdenTrabajoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/detalleOrden")
@CrossOrigin(origins = "http://localhost:8080")
public class DetalleOrdenTrabajoController {
    @Autowired
    DetalleOrdenTrabajoService detalleOrdenTrabajoService;

    @GetMapping("/listaDetalleOrden")
    public ResponseEntity<List<DetalleOrdenTrabajoDTO>> listaDetalleOrden(){

        List<Detalleordentrabajo> detalleordentrabajos = detalleOrdenTrabajoService.listaDetalleOrdenTrabajo();
        List<DetalleOrdenTrabajoDTO> listaDetalleOrdenes = new ArrayList<>();
        for (Detalleordentrabajo detalleOrdenTrabajo: detalleordentrabajos) {
            listaDetalleOrdenes.add(
                    new DetalleOrdenTrabajoDTO(detalleOrdenTrabajo.getIdDetalle(),detalleOrdenTrabajo.getEstado())
            );
        }
        return new ResponseEntity<List<DetalleOrdenTrabajoDTO>>(listaDetalleOrdenes, HttpStatus.OK);
    }

    @PostMapping("/crearDetalleOrden")
    public ResponseEntity<Ordentrabajo> crearDetalleOrden(@RequestBody DetalleOrdenTrabajoDTO detalleOrdenTrabajoDTO){
        Detalleordentrabajo detalleOrdenTrabajo = new Detalleordentrabajo(detalleOrdenTrabajoDTO.getEstado());
        detalleOrdenTrabajoService.registrarDetalleOrdenTrabajo(detalleOrdenTrabajo, detalleOrdenTrabajoDTO.getOrden(),detalleOrdenTrabajoDTO.getMaterial());
        return new ResponseEntity(detalleOrdenTrabajo, HttpStatus.OK);
    }
}
