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

    public List<DetalleOrdenTrabajo> listaDetalleOrdenTrabajo() {
        return detalleOrdenTrabajoRepository.listaDetalleOrdenTrabajos();
    }
    public DetalleOrdenTrabajo registrarDetalleOrdenTrabajo(DetalleOrdenTrabajo detalleOrdenTrabajo, Integer id_orden, Integer id_material) {

        DetalleOrdenTrabajo detalleOrdenTrabajo1 = new DetalleOrdenTrabajo(detalleOrdenTrabajo.getEstado());
        Optional<Ordentrabajo> ordentrabajo = ordenTrabajoRepository.buscarPorId(id_orden);
        ordentrabajo.ifPresent(a -> {
            a.addDetalleOrdentrabajo(detalleOrdenTrabajo1);
            ordenTrabajoRepository.registrar(a);
        });
        Optional<Material> material = materialRepository.buscarPorId(id_material);
        material.ifPresent(a -> {
            a.addDetalleOrdentrabajo(detalleOrdenTrabajo1);
            materialRepository.registrar(a);
        });
        detalleOrdenTrabajoRepository.registrar(detalleOrdenTrabajo1);
        return detalleOrdenTrabajo1;


    }
}
