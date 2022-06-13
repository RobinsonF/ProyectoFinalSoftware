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
import java.text.SimpleDateFormat;
import java.util.Date;
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
    public List<Auditoria> getAuditorias(Integer id) {
        String query = "FROM Auditoria where id_usuario = " + id;
        return entityManager.createQuery(query).getResultList();
    }

    public List<Auditoria> getAuditorias() {
        String query = "FROM Auditoria";
        return entityManager.createQuery(query).getResultList();
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
    public List<Auditoria> obtenerAuditoriasPorFecha(String fecha1, String fecha2, Integer id) {
        try {
            String query = "";
            SimpleDateFormat formato=new SimpleDateFormat("yyyy-MM-dd");
            Date fecha3 = formato.parse(fecha1);
            Date fecha4 = formato.parse(fecha2);
            if(fecha3.after(fecha4)){
                query = "FROM Auditoria where fecha >= '" + fecha2 + "' and fecha <= '" + fecha1 + "' and id_usuario = " + id;
            } else{
                query = "FROM Auditoria where fecha >= '" + fecha1 + "' and fecha <= '" + fecha2 + "'";
            }
            return entityManager.createQuery(query).getResultList();
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public void actualizarFecha(String fecha, Integer id) {
        String query = "update Auditoria set fecha = '" + fecha + "' where idAuditoria = " + id;
        entityManager.createQuery(query).executeUpdate();
    }
}
