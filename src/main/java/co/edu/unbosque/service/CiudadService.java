package co.edu.unbosque.service;

import co.edu.unbosque.entity.Auditoria;
import co.edu.unbosque.entity.Ciudad;
import co.edu.unbosque.entity.Departamento;
import co.edu.unbosque.entity.Usuario;
import co.edu.unbosque.repository.CiudadRepository;
import co.edu.unbosque.repository.DepartamentoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CiudadService {
    @Autowired
    CiudadRepository ciudadRepository;

    @Autowired
    DepartamentoRepository departamentoRepository;


    public List<Ciudad> listaCiudad(){
        return  ciudadRepository.listaCiudades();
    }

    public Ciudad registrarCiudad(Ciudad ciudad, Integer id) {

        Ciudad ciudad1 = new Ciudad("A",ciudad.getNombre());
        Optional<Departamento> departamento = departamentoRepository.buscarPorId(id);
        departamento.ifPresent(a -> {
            a.addCiudad(ciudad1);
            departamentoRepository.registrar(a);
        });
        ciudadRepository.registrar(ciudad1);
        return ciudad1;
    }

    public Integer obtenerIdPorNombre(String nombre){
        return ciudadRepository.obtenerIdPorNombre(nombre);
    }
}
