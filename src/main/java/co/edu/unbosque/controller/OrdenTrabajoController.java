package co.edu.unbosque.controller;

import co.edu.unbosque.dto.EstadoDTO;
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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/orden")
@CrossOrigin(origins = "http://localhost:4200")
public class OrdenTrabajoController {
    @Autowired
    OrdenTrabajoService ordenTrabajoService;

    @GetMapping("/listaOrden")
    public ResponseEntity<List<OrdenTrabajoDTO>> listaOrden(){

        List<Ordentrabajo> ordenes = ordenTrabajoService.listaOrden();
        List<OrdenTrabajoDTO> listaOrdenes = new ArrayList<>();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        for (Ordentrabajo ordentrabajo: ordenes) {
            listaOrdenes.add(
                    new OrdenTrabajoDTO(ordentrabajo.getIdTrabajo(),ordentrabajo.getNombreTrabajo(), ordentrabajo.getCuadrilla().getNombreCuadrilla(), ordentrabajo.getZona().getNombre(), formato.format(ordentrabajo.getFechaTrabajoi()))
            );
        }
        return new ResponseEntity<List<OrdenTrabajoDTO>>(listaOrdenes, HttpStatus.OK);
    }

    @GetMapping("/listaOrdenUsuario")
    public ResponseEntity<List<OrdenTrabajoDTO>> listaOrden(@RequestParam Integer id){
        List<OrdenTrabajoDTO> listaOrdenes = ordenTrabajoService.listaPorUsuario(id);
        return new ResponseEntity<List<OrdenTrabajoDTO>>(listaOrdenes, HttpStatus.OK);
    }

    @PostMapping("/crearOrden")
    public EstadoDTO crearOrden(@RequestBody OrdenTrabajoDTO ordenTrabajoDTO) {
        EstadoDTO estadoDTO = new EstadoDTO();
        String mensaje = ordenTrabajoService.registrarOrden(ordenTrabajoDTO);
        estadoDTO.setMensaje(mensaje);
        return estadoDTO;
    }

    @PutMapping("/eliminarOrden")
    public EstadoDTO eliminarCiudad(@RequestParam Integer id){
        EstadoDTO estadoDTO = new EstadoDTO();
        ordenTrabajoService.eliminarOrden(id);
        estadoDTO.setMensaje("Orden eliminada");
        return estadoDTO;
    }
}
