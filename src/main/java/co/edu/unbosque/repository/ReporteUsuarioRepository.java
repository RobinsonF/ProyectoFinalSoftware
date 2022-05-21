package co.edu.unbosque.repository;

import co.edu.unbosque.dto.ReporteUsuarioDTO;

import java.util.Map;

public interface ReporteUsuarioRepository {

    ReporteUsuarioDTO obtenerReporteUsuario(Map<String, Object> params);
}
