package co.edu.unbosque.repository;

import co.edu.unbosque.dto.UsuarioDTO;
import co.edu.unbosque.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository {

    List<Usuario> getUsuarios();

    void eliminar(Integer id);

    void registrar(Usuario usuario);

    Usuario obtenerUsuarioPorCredenciales(Usuario usuario);;

    void editarEliminar(Integer id);

    Usuario buscarPorId2(Integer id);

    Optional<Usuario> buscarPorId(Integer id);

    Usuario buscarPorCorreo(String correo);

    Usuario buscarPorLogin(String login);

    Usuario buscarPorNombre(String nombre);

    String aumentarIntento(String correo);

    Integer obtenerIntentos(String correo);

    Integer obtenerIntentos(Integer id);

    String obtenerRol(String correo);

    Integer obtenerId(String nombre);

    void setearCeroIntentos(String correo);

    void desbloquearUsuario(Integer id);

    Integer validarCorreo(String correo);

    Integer validarLogin(String login);

    void editarUsuario(UsuarioDTO usuarioDTO);

}
