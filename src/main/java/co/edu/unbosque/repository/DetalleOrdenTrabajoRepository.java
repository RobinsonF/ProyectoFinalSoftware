package co.edu.unbosque.repository;

import co.edu.unbosque.entity.Detalleordentrabajo;

import java.util.List;
import java.util.Optional;

public interface DetalleOrdenTrabajoRepository {
    List<Detalleordentrabajo> listaDetalleOrdenTrabajos();

    void registrar(Detalleordentrabajo detalleOrdenTrabajo);

    Optional<Detalleordentrabajo> buscarPorId(Integer id);
}

