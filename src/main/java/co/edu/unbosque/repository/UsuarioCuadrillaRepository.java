package co.edu.unbosque.repository;


import co.edu.unbosque.entity.UsuarioCuadrilla;

import java.util.List;
import java.util.Optional;

public interface UsuarioCuadrillaRepository {
    List<UsuarioCuadrilla> listaUsuarioCuadrillas();

    void registrar(UsuarioCuadrilla usuarioCuadrilla);

    Optional<UsuarioCuadrilla> buscarPorId(Integer id);
}
