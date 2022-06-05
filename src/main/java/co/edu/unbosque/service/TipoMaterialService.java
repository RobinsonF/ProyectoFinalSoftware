package co.edu.unbosque.service;

import co.edu.unbosque.entity.Tipomaterial;
import co.edu.unbosque.repository.TipoMaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class TipoMaterialService {
    @Autowired
    TipoMaterialRepository tipoMaterialRepository;

    public List<Tipomaterial> listaTipos() {
        return tipoMaterialRepository.listarTipos();
    }

    public Tipomaterial registrarTipoMaterial(Tipomaterial tipoMaterial) {
        Tipomaterial tipomaterial1 = new Tipomaterial(tipoMaterial.getEstado(),tipoMaterial.getNombre(),tipoMaterial.getDescripcion());
        tipoMaterialRepository.registrar(tipomaterial1);
        return tipomaterial1;
    }

    public Integer obtenerIdPorNombre(String nombre){
        return tipoMaterialRepository.obtenerIdPorNombre(nombre);
    }
}
