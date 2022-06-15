package co.edu.unbosque.controller;

import co.edu.unbosque.dto.EmpleadoDTO;
import co.edu.unbosque.dto.EstadoDTO;
import co.edu.unbosque.dto.MaterialDTO;
import co.edu.unbosque.entity.Ciudad;
import co.edu.unbosque.entity.Empleado;
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
@CrossOrigin(origins = "http://localhost:4200")
public class MaterialController {
    @Autowired
    MaterialService materialService;

    @GetMapping("/listaMaterial")
    public ResponseEntity<List<MaterialDTO>> listaMaterial() {

        List<Material> materiales = materialService.listaMaterial();
        List<MaterialDTO> listaMateriales = new ArrayList<>();
        for (Material material : materiales) {
            listaMateriales.add(
                    new MaterialDTO(material.getIdMaterial(),material.getCantidad(),material.getEstado(),material.getNombreMaterial(), material.getTipomaterial().getNombre())
            );
        }
        return new ResponseEntity<List<MaterialDTO>>(listaMateriales, HttpStatus.OK);
    }

    @PostMapping("/crearMaterial")
    public EstadoDTO crearZona(@RequestBody MaterialDTO materialDTO) {
        EstadoDTO estadoDTO = new EstadoDTO();
        String mensaje = materialService.registrarMaterial(materialDTO);
        estadoDTO.setMensaje(mensaje);
        return estadoDTO;
    }

    @PutMapping("/eliminarMaterial")
    public EstadoDTO eliminarCiudad(@RequestParam Integer id){
        EstadoDTO estadoDTO = new EstadoDTO();
        materialService.eliminarMaterial(id);
        estadoDTO.setMensaje("Material eliminado");
        return estadoDTO;
    }

    @PutMapping("/editarMaterial")
    public EstadoDTO editarMaterial(@RequestBody MaterialDTO materialDTO) {
        EstadoDTO estadoDTO = new EstadoDTO();
        String mensaje = materialService.editarMaterial(materialDTO);
        if(mensaje.equals("El nombre ya se encuentra registrado")){
            estadoDTO.setMensaje(mensaje);
        }else{
            estadoDTO.setMensaje(mensaje);
        }
        return estadoDTO;
    }

    @GetMapping("/obtenerMaterial")
    public MaterialDTO buscarPorId(@RequestParam Integer id){
        Material material = materialService.buscarPorId(id);
        MaterialDTO materialDTO = new MaterialDTO();
        materialDTO.setNombreMaterial(material.getNombreMaterial());
        materialDTO.setCantidad(material.getCantidad());
        return materialDTO;
    }
}
