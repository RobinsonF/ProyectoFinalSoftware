package co.edu.unbosque.repository;

import co.edu.unbosque.dto.CuadrillaDTO;
import co.edu.unbosque.entity.Cuadrilla;
import co.edu.unbosque.entity.Material;


import java.util.List;
import java.util.Optional;

public interface CuadrillaRepository {
    List<Cuadrilla> listaCuadrillas();

    void registrar(Cuadrilla cuadrilla);
    Optional<Cuadrilla> buscarPorId(Integer id);
    Cuadrilla buscarPorId2(Integer id);

    Cuadrilla buscarPorNombre(String nombre);

    Integer validarNombre(String nombre);

    Integer obtenerIdPorNombre(String nombre);

    void eliminarCuadrilla(Integer id);

    List<CuadrillaDTO> listaCuadrillaUsuario(Integer id);

    Cuadrilla buscarPorNombre2(String nombre, String nombre2);

    Integer validarNombre2(String nombre, String nombre2);

    void editarCuadrilla(CuadrillaDTO cuadrillaDTO);
}
