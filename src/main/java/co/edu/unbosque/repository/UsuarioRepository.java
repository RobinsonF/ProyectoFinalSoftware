package co.edu.unbosque.repository;

import co.edu.unbosque.dto.UsuarioDTO;
import co.edu.unbosque.entity.Usuario;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface UsuarioRepository {

    List<Usuario> getUsuarios();

    void eliminar(Integer id);

    void registrar(Usuario usuario);

    Usuario obtenerUsuarioPorCredenciales(Usuario usuario);

    Usuario buscarPorId2(Integer id);

    Optional<Usuario> buscarPorId(Integer id);

    Usuario buscarPorCorreo(String correo);

    Usuario buscarPorLogin(String login);

    Usuario buscarPorCorreo2(String correo, String correo2);

    Usuario buscarPorLogin2(String login, String correo2);

    Usuario buscarPorPass(String pass, String pass2, String correo);

    Usuario buscarPorNombre(String nombre);

    String aumentarIntento(String correo);

    Integer obtenerIntentos(String correo);

    Integer obtenerIntentos(Integer id);

    String obtenerRol(String correo);

    Integer obtenerId(String nombre);

    void setearCeroIntentos(String correo);

    void desbloquearUsuario(Integer id);

    Integer validarCorreo(String correo);

    Integer validarCorreo2(String correo, String correo2);

    Integer validarLogin(String login);

    Integer validarLogin2(String login, String login2);

    Integer validarPassword(String pass, String pass2, String correo);

    void editarUsuario(UsuarioDTO usuarioDTO);

    Date obtenerFechaPass(String correo);

    void cambiarPassword(String correo, String pass);

}
