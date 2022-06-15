package co.edu.unbosque.controller;

import co.edu.unbosque.dto.EstadoDTO;
import co.edu.unbosque.dto.OrdenTrabajoDTO;
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
import java.util.Optional;

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

    @GetMapping("/obtenerZona")
    public ZonaDTO obtenerPorid(@RequestParam Integer id){
        return zonaService.buscarPorId(id);
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

    @PutMapping("/editarZona")
    public EstadoDTO editarZona(@RequestBody ZonaDTO zonaDTO) {
        EstadoDTO estadoDTO = new EstadoDTO();
        String mensaje = zonaService.editarZona(zonaDTO);
        if(mensaje.equals("El nombre ya se encuentra registrado")){
            estadoDTO.setMensaje(mensaje);
        }else{
            estadoDTO.setMensaje(mensaje);
        }
        return estadoDTO;
    }
}
