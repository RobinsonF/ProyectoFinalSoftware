package co.edu.unbosque.repository;

import co.edu.unbosque.entity.Auditoria;
import co.edu.unbosque.entity.Rol;


import java.util.List;
import java.util.Optional;

public interface AuditoriaRepository {

    Optional<Auditoria> buscarPorId(Integer id);
    List<Auditoria> getAuditorias(Integer id);

    void eliminar(Integer id);

    void registrar(Auditoria auditoria);

    Auditoria obtenerAuditoriaPorId(Auditoria auditoria);;

    void editarEliminar(Integer id);
}
