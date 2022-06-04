package co.edu.unbosque.repository;

import co.edu.unbosque.entity.DetalleOrdenTrabajo;

import java.util.List;
import java.util.Optional;

public interface DetalleOrdenTrabajoRepository {
    List<DetalleOrdenTrabajo> listaDetalleOrdenTrabajos();

    void registrar(DetalleOrdenTrabajo detalleOrdenTrabajo);

    Optional<DetalleOrdenTrabajo> buscarPorId(Integer id);
}

