package co.edu.unbosque.repository;

import co.edu.unbosque.dto.AuditoriaDTO;
import co.edu.unbosque.dto.UsuarioDTO;
import co.edu.unbosque.entity.Auditoria;
import co.edu.unbosque.entity.Rol;
import co.edu.unbosque.entity.Usuario;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class AuditoriaRepositoryImp implements AuditoriaRepository {
    @PersistenceContext
    EntityManager entityManager;

    AuditoriaDTO auditoriaDTO;

    @Override
    public Optional<Auditoria> buscarPorId(Integer id) {
        Auditoria auditoria = entityManager.find(Auditoria.class, id);
        return auditoria != null ? Optional.of(auditoria) : Optional.empty();
    }
    @Override
    @Transactional
    public List<Auditoria> getAuditorias() {
        String query = "FROM Usuario where estado = 'A'";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void eliminar(Integer id) {
        Auditoria auditoria = entityManager.find(Auditoria.class, id);
        entityManager.remove(auditoria);
    }

    @Override
    public void registrar(Auditoria auditoria) {
        entityManager.merge(auditoria);
    }

    @Override
    public Auditoria obtenerAuditoriaPorId(Auditoria auditoria) {
        try {
            auditoriaDTO = new AuditoriaDTO();
            String query = "FROM Auditoria WHERE id = " + "'" + auditoria.getIdAuditoria() + "'";

            List<Auditoria> lista = entityManager.createQuery(query).getResultList();

            if (lista.isEmpty()) {
                return null;
            }
                return lista.get(0);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void editarEliminar(Integer id) {
        Auditoria auditoria = entityManager.find(Auditoria.class, id);


    }
}
