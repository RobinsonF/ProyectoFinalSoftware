package co.edu.unbosque.service;

import co.edu.unbosque.entity.Turnotrabajo;
import co.edu.unbosque.repository.TurnoTrabajoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TurnoTrabajoService {
    @Autowired
    TurnoTrabajoRepository turnoTrabajoRepository;

    public List<Turnotrabajo> listaTurnos() {
        return turnoTrabajoRepository.listaTurnos();
    }

    public Turnotrabajo registrarTurno(Turnotrabajo turnotrabajo) {
        Turnotrabajo turnotrabajo1 = new Turnotrabajo(turnotrabajo.getEstado(), turnotrabajo.getNombre());
        turnoTrabajoRepository.registrar(turnotrabajo1);
        return turnotrabajo1;
    }
}
