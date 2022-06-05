package co.edu.unbosque.service;

import co.edu.unbosque.entity.Departamento;
import co.edu.unbosque.repository.DepartamentoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class DepartamentoService {
    @Autowired
    DepartamentoRepository departamentoRepository;

    public List<Departamento> listaDepartamentos() {
        return departamentoRepository.listaDepartamentos();
    }

    public String registrarDepartamento(Departamento departamento) {
        Departamento departamento1 = new Departamento(departamento.getEstado(), departamento.getNombre());
        if(validarNombre(departamento.getNombre())==1){
            return "El nombre del departamento se encuentra en uso";
        }else{
            departamentoRepository.registrar(departamento1);
            return "Registrado correctamente";
        }
    }
    public Integer obtenerIdPorNombre(String nombre){
        return departamentoRepository.obtenerIdPorNombre(nombre);
    }

    public Integer validarNombre(String nombre){
        return departamentoRepository.validarNombre(nombre);
    }

    public void eliminarDepartamento(Integer id){
        departamentoRepository.eliminarDepartamento(id);
    }
}
