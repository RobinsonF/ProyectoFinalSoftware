package co.edu.unbosque.repository;

import co.edu.unbosque.dto.ReporteUsuarioDTO;

import java.util.Map;

public interface ReporteRepository {

    ReporteUsuarioDTO obtenerReporteUsuario(Map<String, Object> params);

    ReporteUsuarioDTO obtenerReporteCuadrilla(Map<String, Object> params);

    ReporteUsuarioDTO obtenerReporteMaterial(Map<String, Object> params);

    ReporteUsuarioDTO obtenerReporteOrdenes(Map<String, Object> params);

    ReporteUsuarioDTO obtenerReporteOrdenes2(Map<String, Object> params);

    ReporteUsuarioDTO obtenerReporteEmpleados(Map<String, Object> params);

    ReporteUsuarioDTO obtenerReporteEmpleados2(Map<String, Object> params);

    ReporteUsuarioDTO obtenerGraficaCuadrillas(Map<String, Object> params);

    ReporteUsuarioDTO obtenerGraficaCuadrillas2(Map<String, Object> params);

    ReporteUsuarioDTO obtenerReporteCuadrilla2(Map<String, Object> params);

    ReporteUsuarioDTO obtenerGraficaOrdenesCumplidas(Map<String, Object> params);

    ReporteUsuarioDTO obtenerGraficaOrdenesNoCumplidas(Map<String, Object> params);




}
