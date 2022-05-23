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

    public Cuadrilla registrarCuadrilla(Cuadrilla cuadrilla, Integer id_pro, Integer id_turno) {

        Cuadrilla cuadrilla1 = new Cuadrilla(cuadrilla.getEstado(),cuadrilla.getNombreCuadrilla());
        Optional<Usuario> usuario = usuarioRepository.buscarPorId(id_pro);
        usuario.ifPresent(a -> {
            a.addCuadrilla(cuadrilla1);
            usuarioRepository.registrar(a);
        });
        Optional<Turnotrabajo> turnotrabajo = turnoTrabajoRepository.buscarPorId(id_turno);
        turnotrabajo.ifPresent(a -> {
            a.addCuadrilla(cuadrilla1);
            turnoTrabajoRepository.registrar(a);
        });
        cuadrillaRepository.registrar(cuadrilla1);
        return cuadrilla1;


    }

}
