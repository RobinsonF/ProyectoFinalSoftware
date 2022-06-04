package co.edu.unbosque.controller;

import co.edu.unbosque.dto.DepartamentoDTO;
import co.edu.unbosque.dto.TipoMaterialDTO;
import co.edu.unbosque.entity.Departamento;
import co.edu.unbosque.entity.TipoMaterial;
import co.edu.unbosque.service.DepartamentoService;
import co.edu.unbosque.service.TipoMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tipomaterial")
@CrossOrigin(origins = "http://localhost:8080")
public class TipoMaterialController {
    @Autowired
    TipoMaterialService tipoMaterialService;

    @GetMapping("/listaTipoMaterial")
    public ResponseEntity<List<TipoMaterialDTO>> listaTipoMateriales() {

        List<TipoMaterial> tipoMaterials = tipoMaterialService.listaTipos();
        List<TipoMaterialDTO> listaTipoMaterials = new ArrayList<>();
        for (TipoMaterial tipoMaterial : tipoMaterials) {
            listaTipoMaterials.add(
                    new TipoMaterialDTO(tipoMaterial.getIdMaterial(),tipoMaterial.getEstado(),tipoMaterial.getNombre(),tipoMaterial.getDescripcion())
            );
        }
        return new ResponseEntity<List<TipoMaterialDTO>>(listaTipoMaterials, HttpStatus.OK);
    }

    @PostMapping("/crearTipoMaterial")
    public ResponseEntity<TipoMaterial> crearTipoMaterial(@RequestBody TipoMaterialDTO tipoMaterialDTO) {
        TipoMaterial tipoMaterial = new TipoMaterial("A",tipoMaterialDTO.getNombre(),tipoMaterialDTO.getDescripcion());
        tipoMaterialService.registrarTipoMaterial(tipoMaterial);
        return new ResponseEntity(tipoMaterial, HttpStatus.OK);
    }

    @PostMapping("/obtenerId/{id}")
    public Integer obtenerId(@RequestBody TipoMaterialDTO tipoMaterialDTO){
        return tipoMaterialService.obtenerIdPorNombre(tipoMaterialDTO.getNombre());
    }
}
