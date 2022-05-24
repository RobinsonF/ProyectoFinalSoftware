package co.edu.unbosque.controller;

import co.edu.unbosque.dto.CiudadDTO;
import co.edu.unbosque.dto.UsuarioDTO;
import co.edu.unbosque.entity.Ciudad;
import co.edu.unbosque.entity.Usuario;
import co.edu.unbosque.service.CiudadService;
import co.edu.unbosque.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/ciudad")
@CrossOrigin(origins = "http://localhost:8080")
public class CiudadController {
    @Autowired
    CiudadService ciudadService;

    @GetMapping("/listaCiudad")
    public ResponseEntity<List<CiudadDTO>> listaCiudad(){

        List<Ciudad> ciudades = ciudadService.listaCiudad();
        List<CiudadDTO> listaCiudades = new ArrayList<>();
        for (Ciudad ciudad: ciudades) {
            listaCiudades.add(
                    new CiudadDTO(ciudad.getIdCiudad(),ciudad.getNombre(),ciudad.getDepartamento().getNombre())
            );
        }
        return new ResponseEntity<List<CiudadDTO>>(listaCiudades, HttpStatus.OK);
    }

    @PostMapping("/crearCiudad")
    public ResponseEntity<Ciudad> crearCiudad(@RequestBody CiudadDTO ciudadDTO){
        Ciudad ciudad = new Ciudad(ciudadDTO.getEstado(),ciudadDTO.getNombre());
        ciudadService.registrarCiudad(ciudad, ciudadDTO.getId_departamento());
        return new ResponseEntity(ciudad, HttpStatus.OK);
    }

    @PostMapping("/obtenerId/{id}")
    public Integer obtenerId(@RequestBody CiudadDTO ciudadDTO){
        return ciudadService.obtenerIdPorNombre(ciudadDTO.getNombre());
    }

}
