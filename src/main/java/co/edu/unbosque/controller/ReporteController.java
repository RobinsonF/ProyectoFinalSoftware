package co.edu.unbosque.controller;

import co.edu.unbosque.commons.TipoReporteEnum;
import co.edu.unbosque.dto.ReporteUsuarioDTO;
import co.edu.unbosque.repository.ReporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/reporte")
@CrossOrigin(origins = "http://localhost:4200")
public class ReporteController {

    @Autowired
    private ReporteRepository reporteRepository;

    @GetMapping(path = "/usuarios")
    public ResponseEntity<Resource> reporteUsuarios(@RequestParam Map<String, Object> params) {
        ReporteUsuarioDTO dto = reporteRepository.obtenerReporteUsuario(params);

        InputStreamResource streamResource = new InputStreamResource(dto.getStream());
        MediaType mediaType = null;
        if (params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name())) {
            mediaType = MediaType.APPLICATION_OCTET_STREAM;
        } else {
            mediaType = MediaType.APPLICATION_PDF;
        }

        return ResponseEntity.ok().header("Content-Disposition", "inline; filename=\"" + dto.getFileName() + "\"")
                .contentLength(dto.getLength()).contentType(mediaType).body(streamResource);
    }

    @GetMapping(path = "/cuadrillas")
    public ResponseEntity<Resource> reporteCuadrillas(@RequestParam Map<String, Object> params) {
        ReporteUsuarioDTO dto = reporteRepository.obtenerReporteCuadrilla(params);

        InputStreamResource streamResource = new InputStreamResource(dto.getStream());
        MediaType mediaType = null;
        if (params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name())) {
            mediaType = MediaType.APPLICATION_OCTET_STREAM;
        } else {
            mediaType = MediaType.APPLICATION_PDF;
        }

        return ResponseEntity.ok().header("Content-Disposition", "inline; filename=\"" + dto.getFileName() + "\"")
                .contentLength(dto.getLength()).contentType(mediaType).body(streamResource);
    }

    @GetMapping(path = "/materiales")
    public ResponseEntity<Resource> reporteMateriales(@RequestParam Map<String, Object> params) {
        ReporteUsuarioDTO dto = reporteRepository.obtenerReporteMaterial(params);

        InputStreamResource streamResource = new InputStreamResource(dto.getStream());
        MediaType mediaType = null;
        if (params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name())) {
            mediaType = MediaType.APPLICATION_OCTET_STREAM;
        } else {
            mediaType = MediaType.APPLICATION_PDF;
        }

        return ResponseEntity.ok().header("Content-Disposition", "inline; filename=\"" + dto.getFileName() + "\"")
                .contentLength(dto.getLength()).contentType(mediaType).body(streamResource);
    }

    @GetMapping(path = "/ordenes")
    public ResponseEntity<Resource> reporteOrdenes(@RequestParam Map<String, Object> params) {
        ReporteUsuarioDTO dto = reporteRepository.obtenerReporteOrdenes(params);

        InputStreamResource streamResource = new InputStreamResource(dto.getStream());
        MediaType mediaType = null;
        if (params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name())) {
            mediaType = MediaType.APPLICATION_OCTET_STREAM;
        } else {
            mediaType = MediaType.APPLICATION_PDF;
        }

        return ResponseEntity.ok().header("Content-Disposition", "inline; filename=\"" + dto.getFileName() + "\"")
                .contentLength(dto.getLength()).contentType(mediaType).body(streamResource);
    }

    @GetMapping(path = "/empleados")
    public ResponseEntity<Resource> reporteEmpleados(@RequestParam Map<String, Object> params) {
        ReporteUsuarioDTO dto = reporteRepository.obtenerReporteEmpleados(params);

        InputStreamResource streamResource = new InputStreamResource(dto.getStream());
        MediaType mediaType = null;
        if (params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name())) {
            mediaType = MediaType.APPLICATION_OCTET_STREAM;
        } else {
            mediaType = MediaType.APPLICATION_PDF;
        }

        return ResponseEntity.ok().header("Content-Disposition", "inline; filename=\"" + dto.getFileName() + "\"")
                .contentLength(dto.getLength()).contentType(mediaType).body(streamResource);
    }

    @GetMapping(path = "/graficaCuadrillas")
    public ResponseEntity<Resource> reporteGraficaCuadrillas(@RequestParam Map<String, Object> params) {
        ReporteUsuarioDTO dto = reporteRepository.obtenerGraficaCuadrillas(params);

        InputStreamResource streamResource = new InputStreamResource(dto.getStream());
        MediaType mediaType = null;
        if (params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name())) {
            mediaType = MediaType.APPLICATION_OCTET_STREAM;
        } else {
            mediaType = MediaType.APPLICATION_PDF;
        }

        return ResponseEntity.ok().header("Content-Disposition", "inline; filename=\"" + dto.getFileName() + "\"")
                .contentLength(dto.getLength()).contentType(mediaType).body(streamResource);
    }

    @GetMapping(path = "/ordenesCumplidas")
    public ResponseEntity<Resource> reporteOrdenesCumplidas(@RequestParam Map<String, Object> params) {
        ReporteUsuarioDTO dto = reporteRepository.obtenerGraficaOrdenesCumplidas(params);

        InputStreamResource streamResource = new InputStreamResource(dto.getStream());
        MediaType mediaType = null;
        if (params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name())) {
            mediaType = MediaType.APPLICATION_OCTET_STREAM;
        } else {
            mediaType = MediaType.APPLICATION_PDF;
        }

        return ResponseEntity.ok().header("Content-Disposition", "inline; filename=\"" + dto.getFileName() + "\"")
                .contentLength(dto.getLength()).contentType(mediaType).body(streamResource);
    }

    @GetMapping(path = "/ordenesNoCumplidas")
    public ResponseEntity<Resource> reporteOrdenesNoCumplidas(@RequestParam Map<String, Object> params) {
        ReporteUsuarioDTO dto = reporteRepository.obtenerGraficaOrdenesNoCumplidas(params);

        InputStreamResource streamResource = new InputStreamResource(dto.getStream());
        MediaType mediaType = null;
        if (params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name())) {
            mediaType = MediaType.APPLICATION_OCTET_STREAM;
        } else {
            mediaType = MediaType.APPLICATION_PDF;
        }

        return ResponseEntity.ok().header("Content-Disposition", "inline; filename=\"" + dto.getFileName() + "\"")
                .contentLength(dto.getLength()).contentType(mediaType).body(streamResource);
    }
}
