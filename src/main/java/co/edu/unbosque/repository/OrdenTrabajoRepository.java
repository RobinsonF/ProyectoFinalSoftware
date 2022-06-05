package co.edu.unbosque.repository;

import co.edu.unbosque.entity.Ordentrabajo;
import co.edu.unbosque.entity.Zona;

import java.util.List;
import java.util.Optional;

public interface OrdenTrabajoRepository {
    List<Ordentrabajo> listaOrdenes();

    void registrar(Ordentrabajo ordentrabajo);

    Optional<Ordentrabajo> buscarPorId(Integer id);

    void eliminarOrden(Integer id);
}
