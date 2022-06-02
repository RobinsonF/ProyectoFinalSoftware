package co.edu.unbosque.repository;

import co.edu.unbosque.entity.Parametro;

public interface ParametroRepository {
    Parametro obtenerParametro(String tipo);
}
