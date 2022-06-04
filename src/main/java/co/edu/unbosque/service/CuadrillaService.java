package co.edu.unbosque.service;

import co.edu.unbosque.dto.CuadrillaDTO;
import co.edu.unbosque.entity.*;
import co.edu.unbosque.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CuadrillaService {
    @Autowired
    CuadrillaRepository cuadrillaRepository;
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    TurnoTrabajoRepository turnoTrabajoRepository;

    public List<Cuadrilla> listaCuadrilla() {
        return cuadrillaRepository.listaCuadrillas();
    }

    public String registrarCuadrilla(CuadrillaDTO cuadrillaDTO) {
        Cuadrilla cuadrilla1 = new Cuadrilla("A",cuadrillaDTO.getNombreCuadrilla());
        if(validarNombre(cuadrillaDTO.getNombreCuadrilla())==1){
            return "El nombre de la cuadrilla se encuentra en uso";
        }else{
            cuadrillaRepository.registrar(cuadrilla1);
            return "Registrado  correctamente";
        }
    }

    public Integer obtenerIdPorNombre(String nombre){
        return cuadrillaRepository.obtenerIdPorNombre(nombre);
    }

    public Integer validarNombre(String nombre){
        return cuadrillaRepository.validarNombre(nombre);
    }
}
