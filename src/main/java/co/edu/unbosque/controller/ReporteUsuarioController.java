package co.edu.unbosque.controller;

import co.edu.unbosque.commons.TipoReporteEnum;
import co.edu.unbosque.dto.ReporteUsuarioDTO;
import co.edu.unbosque.repository.ReporteUsuarioRepository;
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
public class ReporteUsuarioController {

    @Autowired
    private ReporteUsuarioRepository reporteUsuarioRepository;

    @GetMapping(path = "/usuarios/download")
    public ResponseEntity<Resource> download(@RequestParam Map<String, Object> params) {
        ReporteUsuarioDTO dto = reporteUsuarioRepository.obtenerReporteUsuario(params);

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
