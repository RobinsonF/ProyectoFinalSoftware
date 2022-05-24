package co.edu.unbosque.repository;

import co.edu.unbosque.entity.Turnotrabajo;

import java.util.List;
import java.util.Optional;

public interface TurnoTrabajoRepository {
    List<Turnotrabajo> listaTurnos();

    void registrar(Turnotrabajo turnotrabajo);

    Optional<Turnotrabajo> buscarPorId(Integer id);

    Turnotrabajo buscarPorNombre(String nombre);

    Integer obtenerId(String nombre);
}
