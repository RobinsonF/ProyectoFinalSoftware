package co.edu.unbosque.repository;

import co.edu.unbosque.entity.Usuario;

import java.util.List;

public interface UsuarioRespository {

    List<Usuario> getUsuarios();

    void eliminar(Integer id);

    void registrar(Usuario usuario);

    Usuario obtenerUsuarioPorCredenciales(Usuario usuario);;

    void editarEliminar(Integer id);
}
