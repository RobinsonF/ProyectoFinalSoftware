package co.edu.unbosque.controller;

import co.edu.unbosque.dto.TipoMaterialDTO;
import co.edu.unbosque.entity.Tipomaterial;
import co.edu.unbosque.service.TipoMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tipomaterial")
@CrossOrigin(origins = "http://localhost:4200")
public class TipoMaterialController {
    @Autowired
    TipoMaterialService tipoMaterialService;

    @GetMapping("/listaTipoMaterial")
    public ResponseEntity<List<TipoMaterialDTO>> listaTipoMateriales() {

        List<Tipomaterial> tipomaterials = tipoMaterialService.listaTipos();
        List<TipoMaterialDTO> listaTipoMaterials = new ArrayList<>();
        for (Tipomaterial tipoMaterial : tipomaterials) {
            listaTipoMaterials.add(
                    new TipoMaterialDTO(tipoMaterial.getIdTipoMaterial(),tipoMaterial.getEstado(),tipoMaterial.getNombre(),tipoMaterial.getDescripcion())
            );
        }
        return new ResponseEntity<List<TipoMaterialDTO>>(listaTipoMaterials, HttpStatus.OK);
    }

    @PostMapping("/crearTipoMaterial")
    public ResponseEntity<Tipomaterial> crearTipoMaterial(@RequestBody TipoMaterialDTO tipoMaterialDTO) {
        Tipomaterial tipoMaterial = new Tipomaterial("A",tipoMaterialDTO.getNombre(),tipoMaterialDTO.getDescripcion());
        tipoMaterialService.registrarTipoMaterial(tipoMaterial);
        return new ResponseEntity(tipoMaterial, HttpStatus.OK);
    }

    @PostMapping("/obtenerId/{id}")
    public Integer obtenerId(@RequestBody TipoMaterialDTO tipoMaterialDTO){
        return tipoMaterialService.obtenerIdPorNombre(tipoMaterialDTO.getNombre());
    }
}
