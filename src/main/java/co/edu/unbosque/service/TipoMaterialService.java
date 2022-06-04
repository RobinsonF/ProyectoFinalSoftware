package co.edu.unbosque.service;

import co.edu.unbosque.entity.Departamento;
import co.edu.unbosque.entity.TipoMaterial;
import co.edu.unbosque.repository.DepartamentoRepository;
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

    public List<TipoMaterial> listaTipos() {
        return tipoMaterialRepository.listarTipos();
    }

    public TipoMaterial registrarTipoMaterial(TipoMaterial tipoMaterial) {
        TipoMaterial tipoMaterial1 = new TipoMaterial(tipoMaterial.getEstado(),tipoMaterial.getNombre(),tipoMaterial.getDescripcion());
        tipoMaterialRepository.registrar(tipoMaterial1);
        return tipoMaterial1;
    }

    public Integer obtenerIdPorNombre(String nombre){
        return tipoMaterialRepository.obtenerIdPorNombre(nombre);
    }
}
