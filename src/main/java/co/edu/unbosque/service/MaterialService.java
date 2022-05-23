package co.edu.unbosque.service;


import co.edu.unbosque.entity.Material;
import co.edu.unbosque.entity.Ordentrabajo;
import co.edu.unbosque.repository.MaterialRepository;
import co.edu.unbosque.repository.OrdenTrabajoRepository;
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
    OrdenTrabajoRepository ordenTrabajoRepository;


    public List<Material> listaMaterial(){
        return  materialRepository.listaMateriales();
    }

    public Material registrarMaterial(Material material, Integer id) {

        Material material1 = new Material(material.getCantidad(),material.getEstado(),material.getNombreMaterial());
        Optional<Ordentrabajo> ordentrabajo = ordenTrabajoRepository.buscarPorId(id);
        ordentrabajo.ifPresent(a -> {
            a.addMaterial(material1);
            ordenTrabajoRepository.registrar(a);
        });
        materialRepository.registrar(material1);
        return material1;

    }
}
