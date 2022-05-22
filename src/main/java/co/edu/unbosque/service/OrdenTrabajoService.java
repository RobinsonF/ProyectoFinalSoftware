package co.edu.unbosque.service;


import co.edu.unbosque.entity.Cuadrilla;
import co.edu.unbosque.entity.Ordentrabajo;
import co.edu.unbosque.entity.Zona;
import co.edu.unbosque.repository.CuadrillaRepository;
import co.edu.unbosque.repository.OrdenTrabajoRepository;
import co.edu.unbosque.repository.ZonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrdenTrabajoService {
    @Autowired
    OrdenTrabajoRepository ordenTrabajoRepository;
    @Autowired
    ZonaRepository zonaRepository;

    @Autowired
    CuadrillaRepository cuadrillaRepository;


    public List<Ordentrabajo> listaOrden() {
        return ordenTrabajoRepository.listaOrdenes();
    }

    public Ordentrabajo registrarOrden(Ordentrabajo ordentrabajo, Integer id_zona, Integer id_cuadrilla) {

        Ordentrabajo ordentrabajo1 = new Ordentrabajo(ordentrabajo.getEstado(),ordentrabajo.getFechaTrabajof(),ordentrabajo.getFechaTrabajoi(),ordentrabajo.getNombreTrabajo());
        Optional<Zona> zona = zonaRepository.buscarPorId(id_zona);
        zona.ifPresent(a -> {
            a.addOrdentrabajo(ordentrabajo1);
            zonaRepository.registrar(a);
        });
        Optional<Cuadrilla> cuadrilla = cuadrillaRepository.buscarPorId(id_cuadrilla);
        cuadrilla.ifPresent(a -> {
            a.addOrdentrabajo(ordentrabajo1);
            cuadrillaRepository.registrar(a);
        });
        ordenTrabajoRepository.registrar(ordentrabajo1);
        return ordentrabajo1;


    }
}
