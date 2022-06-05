package co.edu.unbosque.service;


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

    public Material registrarMaterial(Material material, Integer id) {

        Material material1 = new Material(material.getCantidad(),material.getEstado(),material.getNombreMaterial());
        Optional<Tipomaterial> tipoMaterial = tipoMaterialRepository.buscarPorId(id);
        tipoMaterial.ifPresent(a -> {
            a.addMaterial(material1);
            tipoMaterialRepository.registrar(a);
        });
        materialRepository.registrar(material1);
        return material1;

    }
}
