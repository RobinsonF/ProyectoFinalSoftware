package co.edu.unbosque.controller;

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
@CrossOrigin(origins = "http://localhost:8080")
public class ZonaController {
    @Autowired
    ZonaService zonaService;

    @GetMapping("/listaZona")
    public ResponseEntity<List<ZonaDTO>> listaZona(){

        List<Zona> zonas = zonaService.listaZona();
        List<ZonaDTO> listaZonas = new ArrayList<>();
        for (Zona zona: zonas) {
            listaZonas.add(
                    new ZonaDTO(zona.getIdZona(),zona.getEstado(),zona.getLimiteNorte(),zona.getLimiteOccidente(),zona.getLimiteOriente(),zona.getLimiteSur())
            );
        }
        return new ResponseEntity<List<ZonaDTO>>(listaZonas, HttpStatus.OK);
    }

    @PostMapping("/crearZona")
    public ResponseEntity<Ciudad> crearZona(@RequestBody ZonaDTO zonaDTO){
        Zona zona = new Zona("A",zonaDTO.getLimiteNorte(),zonaDTO.getLimiteOccidente(),zonaDTO.getLimiteOriente(),zonaDTO.getLimiteSur());
        zonaService.registrarZona(zona, zonaDTO.getId_ciudad());
        return new ResponseEntity(zona, HttpStatus.OK);
    }
}
