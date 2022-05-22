package co.edu.unbosque.repository;

import co.edu.unbosque.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioRespository {

    List<Usuario> getUsuarios();

    void eliminar(Integer id);

    void registrar(Usuario usuario);

    Usuario obtenerUsuarioPorCredenciales(Usuario usuario);;

    void editarEliminar(Integer id);

    Usuario buscarPorId2(Integer id);

    Optional<Usuario> buscarPorId(Integer id);

    Usuario buscarPorCorreo(String correo);

    String aumentarIntento(String correo);

    Integer obtenerIntentos(String correo);

    Integer obtenerIntentos(Integer id);

    void setearCeroIntentos(String correo);

    void desbloquearUsuario(Integer id);

}
