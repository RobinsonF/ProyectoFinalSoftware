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
public class DetalleOrdenTrabajoService {
    @Autowired
    DetalleOrdenTrabajoRepository detalleOrdenTrabajoRepository;
    @Autowired
    OrdenTrabajoRepository ordenTrabajoRepository;
    @Autowired
    MaterialRepository materialRepository;

    public List<Detalleordentrabajo> listaDetalleOrdenTrabajo() {
        return detalleOrdenTrabajoRepository.listaDetalleOrdenTrabajos();
    }
    public Detalleordentrabajo registrarDetalleOrdenTrabajo(Detalleordentrabajo detalleOrdenTrabajo, Integer id_orden, Integer id_material) {

        Detalleordentrabajo detalleordentrabajo1 = new Detalleordentrabajo(detalleOrdenTrabajo.getEstado());
        Optional<Ordentrabajo> ordentrabajo = ordenTrabajoRepository.buscarPorId(id_orden);
        ordentrabajo.ifPresent(a -> {
            a.addDetalleOrdentrabajo(detalleordentrabajo1);
            ordenTrabajoRepository.registrar(a);
        });
        Optional<Material> material = materialRepository.buscarPorId(id_material);
        material.ifPresent(a -> {
            a.addDetalleOrdentrabajo(detalleordentrabajo1);
            materialRepository.registrar(a);
        });
        detalleOrdenTrabajoRepository.registrar(detalleordentrabajo1);
        return detalleordentrabajo1;


    }
}
