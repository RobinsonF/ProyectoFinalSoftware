package co.edu.unbosque.repository;

import co.edu.unbosque.dto.ReporteUsuarioDTO;

import java.util.Map;

public interface ReporteRepository {

    ReporteUsuarioDTO obtenerReporteUsuario(Map<String, Object> params);

    ReporteUsuarioDTO obtenerReporteCuadrilla(Map<String, Object> params);

    ReporteUsuarioDTO obtenerReporteMaterial(Map<String, Object> params);

    ReporteUsuarioDTO obtenerReporteOrdenes(Map<String, Object> params);

    ReporteUsuarioDTO obtenerReporteEmpleados(Map<String, Object> params);

}
