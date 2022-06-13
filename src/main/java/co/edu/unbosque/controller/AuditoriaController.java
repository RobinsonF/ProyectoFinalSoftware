package co.edu.unbosque.controller;

import co.edu.unbosque.dto.AuditoriaDTO;
import co.edu.unbosque.dto.EstadoDTO;
import co.edu.unbosque.dto.UsuarioDTO;
import co.edu.unbosque.entity.Auditoria;
import co.edu.unbosque.entity.Usuario;
import co.edu.unbosque.service.AuditoriaService;
import co.edu.unbosque.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/auditoria")
@CrossOrigin(origins = "http://localhost:4200")
public class AuditoriaController {
    @Autowired
    AuditoriaService auditoriaService;

    @GetMapping("/listaAuditoria")
    public ResponseEntity<List<AuditoriaDTO>> listaAuditoria(@RequestParam Integer id){
        SimpleDateFormat formato = new SimpleDateFormat("hh: mm: ss a dd-MM-YYYY");
        List<Auditoria> auditorias = auditoriaService.listaAuditoria(id);
        List<AuditoriaDTO> listaAuditorias = new ArrayList<>();
        for (Auditoria auditoria: auditorias) {
            listaAuditorias.add(new AuditoriaDTO(auditoria.getEvento(), auditoria.getUsuario().getNombre(), formato.format(auditoria.getFecha())));
        }
        return new ResponseEntity<List<AuditoriaDTO>>(listaAuditorias, HttpStatus.OK);
    }

    @GetMapping("/listaAuditoriaFecha")
    public ResponseEntity<List<AuditoriaDTO>> listaAuditoriaPorFechas(@RequestParam String fecha1, String fecha2, Integer id){
        SimpleDateFormat formato = new SimpleDateFormat("hh: mm: ss a dd-MM-YYYY");
        List<Auditoria> auditorias = auditoriaService.obtenerAuditoriasPorFechas(fecha1,fecha2, id);
        List<AuditoriaDTO> listaAuditorias = new ArrayList<>();
        for (Auditoria auditoria: auditorias) {
            listaAuditorias.add(new AuditoriaDTO(auditoria.getEvento(), auditoria.getUsuario().getNombre(), formato.format(auditoria.getFecha())));
        }
        return new ResponseEntity<List<AuditoriaDTO>>(listaAuditorias, HttpStatus.OK);
    }

    @PostMapping("/crearAuditoria")
    public EstadoDTO crearAuditoria(@RequestBody AuditoriaDTO auditoriaDTO){
        EstadoDTO estadoDTO = new EstadoDTO();
        Date date = new Date();
        Timestamp time = new Timestamp(date.getYear(),date.getMonth(), date.getDay() , date.getHours(),date.getMinutes(),date.getSeconds(), date.getSeconds());
        Auditoria auditoria = new Auditoria("A",auditoriaDTO.getEvento(),time);
        auditoriaService.registrarAuditoria(auditoria, auditoriaDTO.getId_usuario());
        estadoDTO.setMensaje("Creado correctamente");
        return estadoDTO;
    }
}
