package co.edu.unbosque.service;


import co.edu.unbosque.dto.MaterialDTO;
import co.edu.unbosque.entity.Cuadrilla;
import co.edu.unbosque.entity.Material;
import co.edu.unbosque.entity.Tipomaterial;
import co.edu.unbosque.repository.MaterialRepository;
import co.edu.unbosque.repository.TipoMaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class MaterialService {
    @Autowired
    MaterialRepository materialRepository;

    @Autowired
    TipoMaterialRepository tipoMaterialRepository;


    public List<Material> listaMaterial(){
        return  materialRepository.listaMateriales();
    }

    public String registrarMaterial(MaterialDTO material) {

        Integer id = tipoMaterialRepository.obtenerIdPorNombre(material.getNombreTipoMaterial());
        if(validarNombre(material.getNombreMaterial())==1){
            return "El nombre del material se encuentra en uso";
        }else {
            Material material1 = new Material(material.getCantidad(), "A", material.getNombreMaterial());
            Optional<Tipomaterial> tipoMaterial = tipoMaterialRepository.buscarPorId(id);
            tipoMaterial.ifPresent(a -> {
                a.addMaterial(material1);
                tipoMaterialRepository.registrar(a);
            });
            materialRepository.registrar(material1);
            return "Registrado correctamente";
        }
    }
    public Integer validarNombre2(String nombre, String nombre2){
        return materialRepository.validarNombre2(nombre, nombre2);
    }

    public Integer validarNombre(String nombre){
        return materialRepository.validarNombre(nombre);
    }

    public void eliminarMaterial(Integer id){
        materialRepository.eliminarMaterial(id);
    }

    public String editarMaterial(MaterialDTO materialDTO){
        Material material = materialRepository.buscarPorId2(materialDTO.getIdMaterial());
        if(validarNombre2(materialDTO.getNombreMaterial(), material.getNombreMaterial())==1){
            return "El nombre ya se encuentra registrado";
        }else{
            materialRepository.editarMaterial(materialDTO);
            return "Guardado Correctamente";
        }
    }

    public Material buscarPorId(Integer id){
        return materialRepository.buscarPorId2(id);
    }
}
