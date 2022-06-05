package co.edu.unbosque.repository;

import co.edu.unbosque.entity.Turnocuadrilla;

import java.util.List;
import java.util.Optional;

public interface TurnoCuadrillaRepository {
    List<Turnocuadrilla> listaTurnoCuadrillas();

    void registrar(Turnocuadrilla turnoCuadrilla);

    Optional<Turnocuadrilla> buscarPorId(Integer id);
}
