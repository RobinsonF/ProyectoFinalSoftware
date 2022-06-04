package co.edu.unbosque.service;

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

    public Cuadrilla registrarCuadrilla(Cuadrilla cuadrilla) {

        Cuadrilla cuadrilla1 = new Cuadrilla(cuadrilla.getEstado(),cuadrilla.getNombreCuadrilla());

        cuadrillaRepository.registrar(cuadrilla1);
        return cuadrilla1;
    }

    public Integer obtenerIdPorNombre(String nombre){
        return cuadrillaRepository.obtenerIdPorNombre(nombre);
    }

}
