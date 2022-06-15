package co.edu.unbosque.repository;

import co.edu.unbosque.dto.OrdenTrabajoDTO;
import co.edu.unbosque.entity.Cuadrilla;
import co.edu.unbosque.entity.Ordentrabajo;

import java.util.List;
import java.util.Optional;

public interface OrdenTrabajoRepository {
    List<Ordentrabajo> listaOrdenes();

    void registrar(Ordentrabajo ordentrabajo);

    Optional<Ordentrabajo> buscarPorId(Integer id);

    Ordentrabajo buscarPorId2(Integer id);

    void eliminarOrden(Integer id);

    List<OrdenTrabajoDTO> listaPorUsuario(Integer id);

    Ordentrabajo buscarPorNombre2(String nombre, String nombre2);

    Integer validarNombre2(String nombre, String nombre2);

    void editarOrden(OrdenTrabajoDTO ordenTrabajoDTO);

}
