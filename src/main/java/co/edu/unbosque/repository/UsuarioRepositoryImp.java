package co.edu.unbosque.repository;

import co.edu.unbosque.dto.UsuarioDTO;
import co.edu.unbosque.entity.Auditoria;
import co.edu.unbosque.entity.Usuario;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class UsuarioRepositoryImp implements UsuarioRespository{
    @PersistenceContext
    EntityManager entityManager;

    UsuarioDTO usuarioDTO;

    @Override
    @Transactional
    public List<Usuario> getUsuarios() {
        String query = "FROM Usuario where estado = 'A'";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void eliminar(Integer id) {
        Usuario usuario = entityManager.find(Usuario.class, id);
        usuario.setEstado("I");
        entityManager.merge(usuario);
    }

    @Override
    public void registrar(Usuario usuario) {
        entityManager.merge(usuario);
    }

    @Override
    public Usuario obtenerUsuarioPorCredenciales(Usuario usuario) {
        try {
            usuarioDTO = new UsuarioDTO();
            String query = "FROM Usuario WHERE correo = " + "'" + usuario.getCorreo() + "'";

            List<Usuario> lista = entityManager.createQuery(query).getResultList();

            if (lista.isEmpty()) {
                return null;
            }
            String passwordHashed = lista.get(0).getPassword();
            String passwordLocal = usuarioDTO.shaEncode(usuario.getPassword());

            if(passwordLocal.equals(passwordHashed)){
                return lista.get(0);
            }else{
                return null;
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void editarEliminar(Integer id) {
        Usuario usuario = entityManager.find(Usuario.class, id);
    }


    @Override
    public Optional<Usuario> buscarPorId(Integer id) {
        Usuario usuario = entityManager.find(Usuario.class, id);
        return usuario != null ? Optional.of(usuario) : Optional.empty();
    }

    @Override
    public Usuario buscarPorId2(Integer id) {
        String query = "FROM Usuario where id_usuario = " + id;
        List<Usuario> lista = entityManager.createQuery(query).getResultList();
        return lista.get(0);
    }

    @Override
    public Usuario buscarPorCorreo(String correo) {
        String query = "FROM Usuario where correo = '" + correo + "'";
        List<Usuario> lista = entityManager.createQuery(query).getResultList();
        return lista.get(0);
    }

    @Override
    public String aumentarIntento(String correo) {
        Usuario usuario1 = buscarPorCorreo(correo);
        Usuario usuario = entityManager.find(Usuario.class, usuario1.getIdUsuario());
        try{
            usuario.setIntento(usuario.getIntento() + 1);
            entityManager.merge(usuario);
            return "Aumento";
        }catch (Exception e){
            return "No aumento";
        }
    }

    @Override
    public Integer obtenerIntentos(String correo){
        Usuario usuario = buscarPorCorreo(correo);
        return usuario.getIntento();
    }

    @Override
    public Integer obtenerIntentos(Integer id) {
        Usuario usuario = buscarPorId2(id);
        return usuario.getIntento();
    }

    @Override
    public void setearCeroIntentos(String correo) {
        Usuario usuario1 = buscarPorCorreo(correo);
        Usuario usuario = entityManager.find(Usuario.class, usuario1.getIdUsuario());
        usuario.setIntento(0);
        entityManager.merge(usuario);
    }

    @Override
    public void desbloquearUsuario(Integer id) {
        Usuario usuario = entityManager.find(Usuario.class, id);
        usuario.setIntento(0);
        entityManager.merge(usuario);
    }
}
