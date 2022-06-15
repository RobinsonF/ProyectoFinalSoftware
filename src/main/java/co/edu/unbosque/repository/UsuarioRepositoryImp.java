package co.edu.unbosque.repository;

import co.edu.unbosque.dto.UsuarioDTO;
import co.edu.unbosque.entity.Usuario;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class UsuarioRepositoryImp implements UsuarioRepository {
    @PersistenceContext
    EntityManager entityManager;

    UsuarioDTO usuarioDTO;

    @Override
    @Transactional
    public List<Usuario> getUsuarios() {
        String query = "FROM Usuario where estado = 'A' and rol = 2";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public String eliminar(Integer id) {
        Usuario usuario = entityManager.find(Usuario.class, id);
        if(usuario.getUsuariocuadrillas().size()!=0){
            return "No es posible eliminar al usuario porque cuanta con cuadrillas activas";
        }else {
            usuario.setEstado("I");
            entityManager.merge(usuario);
            return "Eliminado correctamente";
        }
    }

    @Override
    public void registrar(Usuario usuario) {
        entityManager.merge(usuario);
    }

    @Override
    public Usuario obtenerUsuarioPorCredenciales(Usuario usuario) {
        try {
            usuarioDTO = new UsuarioDTO();
            String query = "FROM Usuario WHERE lower(correo) = " + "'" + usuario.getCorreo().toLowerCase() + "' and estado = 'A'";

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
    public Optional<Usuario> buscarPorId(Integer id) {
        System.out.println(id);
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
        String query = "FROM Usuario where lower(correo) = '" + correo.toLowerCase() + "'";
        List<Usuario> lista = entityManager.createQuery(query).getResultList();
        if(lista.size()!= 0){
            return lista.get(0);
        }else{
            return null;
        }
    }

    @Override
    public Usuario buscarPorLogin(String login) {
        String query = "FROM Usuario where lower(login) = '" + login.toLowerCase() + "'";
        List<Usuario> lista = entityManager.createQuery(query).getResultList();
        if(lista.size()!= 0){
            return lista.get(0);
        }else{
            return null;
        }
    }

    @Override
    public Usuario buscarPorCorreo2(String correo, String correo2) {
        String query = "FROM Usuario where lower(correo) not in ('" + correo2.toLowerCase() + "') and lower(correo) = '" + correo.toLowerCase() +"'";
        List<Usuario> lista = entityManager.createQuery(query).getResultList();
        if(lista.size()!= 0){
            return lista.get(0);
        }else{
            return null;
        }
    }

    @Override
    public Usuario buscarPorLogin2(String login, String login2) {
        String query = "FROM Usuario where lower(login) not in ('" + login2.toLowerCase() + "') and lower(login) = '" + login.toLowerCase() +"'";
        List<Usuario> lista = entityManager.createQuery(query).getResultList();
        if(lista.size()!= 0){
            return lista.get(0);
        }else{
            return null;
        }
    }

    @Override
    public Usuario buscarPorTelefono(String telefono) {
        String query = "FROM Usuario where telefono = '" + telefono + "'";
        List<Usuario> lista = entityManager.createQuery(query).getResultList();
        if(lista.size()!= 0){
            return lista.get(0);
        }else{
            return null;
        }
    }

    @Override
    public Usuario buscarPorTelefono2(String telefono, String telefono2) {
        String query = "FROM Usuario where telefono not in ('" + telefono2 + "') and telefono = '" + telefono +"'";
        List<Usuario> lista = entityManager.createQuery(query).getResultList();
        if(lista.size()!= 0){
            return lista.get(0);
        }else{
            return null;
        }
    }

    @Override
    public Usuario buscarPorPass(String pass, String pass2, String correo) {
        String query = "FROM Usuario where lower(correo) = '" + correo.toLowerCase() +"' and password = '" + pass2 + "'";
        System.out.println(query);
        List<Usuario> lista = entityManager.createQuery(query).getResultList();
        System.out.println(lista.size());
        if(lista.size()!= 0){
            return lista.get(0);
        }else{
            return null;
        }
    }

    @Override
    public Usuario buscarPorNombre(String nombre) {
        String query = "FROM Usuario where nombre = '" + nombre + "'";
        List<Usuario> lista = entityManager.createQuery(query).getResultList();
        if(lista.size()!= 0){
            return lista.get(0);
        }else{
            return null;
        }
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
    public String obtenerRol(String correo) {
        Usuario usuario = buscarPorCorreo(correo);
        return usuario.getRol().getNombre();
    }

    @Override
    public Integer obtenerId(String nombre) {
        Usuario usuario = buscarPorNombre(nombre);
        return usuario.getIdUsuario();
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

    @Override
    public Integer validarCorreo(String correo) {
        Usuario usuario = buscarPorCorreo(correo);
        if(usuario == null){
            return 0;
        }else{
            return 1;
        }
    }

    @Override
    public Integer validarCorreo2(String correo, String correo2) {
        Usuario usuario = buscarPorCorreo2(correo, correo2);
        if(usuario == null){
            return 0;
        }else{
            return 1;
        }
    }

    @Override
    public Integer validarLogin(String login) {
        Usuario usuario = buscarPorLogin(login);
        if(usuario == null){
            return 0;
        }else{
            return 1;
        }
    }

    @Override
    public Integer validarLogin2(String login, String login2) {
        Usuario usuario = buscarPorLogin2(login, login2);
        if(usuario == null){
            return 0;
        }else{
            return 1;
        }
    }

    @Override
    public Integer validarTelefono(String telefono) {
        Usuario usuario = buscarPorTelefono(telefono);
        if(usuario == null){
            return 0;
        }else{
            return 1;
        }
    }

    @Override
    public Integer validarTelefono2(String telefono, String telefono2) {
        Usuario usuario = buscarPorTelefono2(telefono, telefono2);
        if(usuario == null){
            return 0;
        }else{
            return 1;
        }
    }

    @Override
    public Integer validarPassword(String pass, String pass2, String correo) {
        Usuario usuario = buscarPorPass(pass, pass2, correo);
        if(usuario == null){
            return 0;
        }else{
            return 1;
        }
    }

    @Override
    public void editarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = entityManager.find(Usuario.class, usuarioDTO.getId_usuario());
        usuario.setLogin(usuarioDTO.getLogin());
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setDireccion(usuarioDTO.getDireccion());
        usuario.setTelefono(usuarioDTO.getTelefono());
        usuario.setCorreo(usuarioDTO.getCorreo());
        entityManager.merge(usuario);
    }
    @Override
    public Date obtenerFechaPass(String correo) {
        Usuario usuario = buscarPorCorreo(correo);
        return usuario.getFechaPass();
    }

    @Override
    public void cambiarPassword(String correo, String pass) {
        Usuario usuario = buscarPorCorreo(correo);
        usuario.setPassword(pass);
        usuario.setFechaPass(new Date());
        entityManager.merge(usuario);
    }
}
