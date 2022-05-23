package co.edu.unbosque.controller;

import co.edu.unbosque.dto.MaterialDTO;
import co.edu.unbosque.entity.Ciudad;
import co.edu.unbosque.entity.Material;
import co.edu.unbosque.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/material")
@CrossOrigin(origins = "http://localhost:8080")
public class MaterialController {
    @Autowired
    MaterialService materialService;

    @GetMapping("/listaMaterial")
    public ResponseEntity<List<MaterialDTO>> listaMaterial() {

        List<Material> materiales = materialService.listaMaterial();
        List<MaterialDTO> listaMateriales = new ArrayList<>();
        for (Material material : materiales) {
            listaMateriales.add(
                    new MaterialDTO(material.getIdMaterial(),material.getCantidad(),material.getEstado(),material.getNombreMaterial())
            );
        }
        return new ResponseEntity<List<MaterialDTO>>(listaMateriales, HttpStatus.OK);
    }

    @PostMapping("/crearMaterial")
    public ResponseEntity<Ciudad> crearZona(@RequestBody MaterialDTO materialDTO) {
        Material material = new Material(materialDTO.getCantidad(),"A",materialDTO.getNombreMaterial());
        materialService.registrarMaterial(material, materialDTO.getOrdentrabajo());
        return new ResponseEntity(material, HttpStatus.OK);
    }
}
