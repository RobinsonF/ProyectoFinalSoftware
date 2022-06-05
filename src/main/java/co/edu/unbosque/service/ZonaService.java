package co.edu.unbosque.service;

import co.edu.unbosque.dto.ZonaDTO;
import co.edu.unbosque.entity.Ciudad;
import co.edu.unbosque.entity.Zona;
import co.edu.unbosque.repository.CiudadRepository;
import co.edu.unbosque.repository.ZonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class ZonaService {
    @Autowired
    CiudadRepository ciudadRepository;

    @Autowired
    ZonaRepository zonaRepository;


    public List<Zona> listaZona(){
        return  zonaRepository.listaZonas();
    }

    Integer validarNombre(String nombre){
        return zonaRepository.validarNombre(nombre);
    }

    public String registrarZona(ZonaDTO zona) {

        Integer id = ciudadRepository.obtenerIdPorNombre(zona.getNombreCiudad());

        if(validarNombre(zona.getNombre())==1){
            return "El nombre de la zona se encuentra en uso";
        }else{
            Zona zona1 = new Zona(zona.getNombre(), "A",zona.getLimiteNorte(),zona.getLimiteOccidente(),zona.getLimiteOriente(),zona.getLimiteSur());
            Optional<Ciudad> ciudad = ciudadRepository.buscarPorId(id);
            ciudad.ifPresent(a -> {
                a.addZona(zona1);
                ciudadRepository.registrar(a);
            });
            zonaRepository.registrar(zona1);
            return "Registrado correctamente";
        }
    }

    public void eliminarZona(Integer id){
        zonaRepository.eliminarZona(id);
    }
}
