package co.edu.unbosque.controller;

import co.edu.unbosque.dto.AuditoriaDTO;
import co.edu.unbosque.dto.UsuarioDTO;
import co.edu.unbosque.entity.Auditoria;
import co.edu.unbosque.entity.Usuario;
import co.edu.unbosque.service.AuditoriaService;
import co.edu.unbosque.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/auditoria")
@CrossOrigin(origins = "http://localhost:8080")
public class AuditoriaController {
    @Autowired
    AuditoriaService auditoriaService;

    @GetMapping("/listaAuditoria")
    public ResponseEntity<List<AuditoriaDTO>> listaAuditoria(){

        List<Auditoria> auditorias = auditoriaService.listaAuditoria();
        List<AuditoriaDTO> listaAuditorias = new ArrayList<>();
        for (Auditoria auditoria: auditorias) {
            listaAuditorias.add(new AuditoriaDTO(auditoria.getIdAuditoria(), auditoria.getEvento(), auditoria.getFecha()));
        }
        return new ResponseEntity<List<AuditoriaDTO>>(listaAuditorias, HttpStatus.OK);
    }

    @PostMapping("/crearUsuario")
    public ResponseEntity<Usuario> crearAuditoria(@RequestBody AuditoriaDTO auditoriaDTO){
        Auditoria auditoria = new Auditoria(auditoriaDTO.getEstado(),auditoriaDTO.getEvento(),auditoriaDTO.getFecha());
        auditoriaService.registrarAuditoria(auditoria, auditoriaDTO.getId_usuario());
        return new ResponseEntity(auditoria, HttpStatus.OK);
    }

    @PostMapping("/eliminarAuditoria/{id}")
    public String eliminarAuditoria(@RequestBody AuditoriaDTO auditoriaDTO){
        auditoriaService.eliminarAuditoria(auditoriaDTO.getIdAuditoria());
        return auditoriaDTO.getIdAuditoria() + "";
    }
}
