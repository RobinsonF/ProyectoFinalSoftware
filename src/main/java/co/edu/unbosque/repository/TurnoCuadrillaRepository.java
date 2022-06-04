package co.edu.unbosque.repository;

import co.edu.unbosque.entity.TurnoCuadrilla;
import co.edu.unbosque.entity.UsuarioCuadrilla;

import java.util.List;
import java.util.Optional;

public interface TurnoCuadrillaRepository {
    List<TurnoCuadrilla> listaTurnoCuadrillas();

    void registrar(TurnoCuadrilla turnoCuadrilla);

    Optional<TurnoCuadrilla> buscarPorId(Integer id);
}
