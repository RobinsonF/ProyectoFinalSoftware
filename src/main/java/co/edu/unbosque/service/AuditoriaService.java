package co.edu.unbosque.service;

import co.edu.unbosque.entity.Auditoria;
import co.edu.unbosque.entity.Usuario;
import co.edu.unbosque.repository.AuditoriaRepository;
import co.edu.unbosque.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AuditoriaService {

    @Autowired
    AuditoriaRepository auditoriaRepository;

    @Autowired
    UsuarioRepository usuarioRepository;


    public List<Auditoria> listaAuditoria(Integer id){
        return  auditoriaRepository.getAuditorias(id);
    }

    public Auditoria registrarAuditoria(Auditoria auditoria, Integer id) {

            Auditoria auditoria1 = new Auditoria(auditoria.getEstado(),auditoria.getEvento(),auditoria.getFecha());
            Optional<Usuario> usuario = usuarioRepository.buscarPorId(id);
            usuario.ifPresent(a -> {
                a.addAuditoria(auditoria1);
                usuarioRepository.registrar(a);
            });
            auditoriaRepository.registrar(auditoria1);
            return auditoria1;

    }

    public void eliminarAuditoria(Integer id){
        auditoriaRepository.eliminar(id);
    }


    public AuditoriaRepository getAuditoriaRepository() {
        return auditoriaRepository;
    }

    public void setAuditoriaRepository(AuditoriaRepository auditoriaRepository) {
        this.auditoriaRepository = auditoriaRepository;
    }

    public UsuarioRepository getUsuarioRepository() {
        return usuarioRepository;
    }

    public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
}
