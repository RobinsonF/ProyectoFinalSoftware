package co.edu.unbosque.controller;

import co.edu.unbosque.dto.EstadoDTO;
import co.edu.unbosque.dto.ZonaDTO;
import co.edu.unbosque.entity.Ciudad;
import co.edu.unbosque.entity.Zona;
import co.edu.unbosque.service.ZonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/zona")
@CrossOrigin(origins = "http://localhost:4200")
public class ZonaController {
    @Autowired
    ZonaService zonaService;

    @GetMapping("/listaZona")
    public ResponseEntity<List<ZonaDTO>> listaZona(){

        List<Zona> zonas = zonaService.listaZona();
        List<ZonaDTO> listaZonas = new ArrayList<>();
        for (Zona zona: zonas) {
            listaZonas.add(
                    new ZonaDTO(zona.getIdZona(),zona.getNombre(), zona.getCiudad().getNombre(),zona.getLimiteNorte(),zona.getLimiteOccidente(),zona.getLimiteOriente(),zona.getLimiteSur(), zona.getOrdentrabajos().size())
            );
        }
        return new ResponseEntity<List<ZonaDTO>>(listaZonas, HttpStatus.OK);
    }

    @PostMapping("/crearZona")
    public EstadoDTO crearZona(@RequestBody ZonaDTO zonaDTO){
        EstadoDTO estadoDTO = new EstadoDTO();
        String mensaje = zonaService.registrarZona(zonaDTO);
        estadoDTO.setMensaje(mensaje);
        return estadoDTO;
    }

    @PutMapping("/eliminarZona")
    public EstadoDTO eliminarCuadrilla(@RequestParam Integer id){
        EstadoDTO estadoDTO = new EstadoDTO();
        zonaService.eliminarZona(id);
        estadoDTO.setMensaje("Zona eliminada");
        return estadoDTO;
    }
}
