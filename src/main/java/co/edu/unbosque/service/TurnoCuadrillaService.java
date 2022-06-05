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
public class TurnoCuadrillaService {
    @Autowired
    TurnoCuadrillaRepository turnoCuadrillaRepository;
    @Autowired
    TurnoTrabajoRepository turnoTrabajoRepository;
    @Autowired
    CuadrillaRepository cuadrillaRepository;

    public List<Turnocuadrilla> listaTurnoCuadrilla() {
        return turnoCuadrillaRepository.listaTurnoCuadrillas();
    }
    public Turnocuadrilla registrarTurnoCuadrilla(Turnocuadrilla turnoCuadrilla, Integer id_turno, Integer id_cuadrilla) {

        Turnocuadrilla turnocuadrilla1 = new Turnocuadrilla(turnoCuadrilla.getEstado());
        Optional<Turnotrabajo> turnotrabajo = turnoTrabajoRepository.buscarPorId(id_turno);
        turnotrabajo.ifPresent(a -> {
            a.addTurnoCuadrilla(turnocuadrilla1);
            turnoTrabajoRepository.registrar(a);
        });
        Optional<Cuadrilla> cuadrilla = cuadrillaRepository.buscarPorId(id_cuadrilla);
        cuadrilla.ifPresent(a -> {
            a.addTurnoCuadrilla(turnocuadrilla1);
            cuadrillaRepository.registrar(a);
        });
        turnoCuadrillaRepository.registrar(turnocuadrilla1);
        return turnocuadrilla1;


    }
}
