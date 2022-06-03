package co.edu.unbosque.service;

import co.edu.unbosque.dto.UsuarioDTO;
import co.edu.unbosque.entity.Rol;
import co.edu.unbosque.entity.Usuario;
import co.edu.unbosque.repository.RolRepository;
import co.edu.unbosque.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    RolRepository rolRepository;

    UsuarioDTO usuarioDTO;

    public List<Usuario> listaUsuario(){
        return  usuarioRepository.getUsuarios();
    }

    public String registrarUsuario(Usuario usuario, Integer id) {
        String hash = "";
        if(validarCorreo(usuario.getCorreo()) == 1){
            return "El correo ya se encuentra registrado";
        }else if(validarLogin(usuario.getLogin()) == 1){
            return "El login ya se encuentra registrado";
        }else{
            try {
                usuarioDTO = new UsuarioDTO();
                hash = usuarioDTO.shaEncode(usuario.getPassword());
                Usuario usuario1 = new Usuario(usuario.getCorreo(), usuario.getDireccion(), usuario.getEstado(), usuario.getLogin(), usuario.getNombre(), hash, usuario.getTelefono(), 0);
                Optional<Rol> rol = rolRepository.buscarPorId(id);
                rol.ifPresent(a -> {
                    a.addUsuario(usuario1);
                    rolRepository.registrar(a);
                });
                usuarioRepository.registrar(usuario1);
                return "Registro correcto";
            }catch (Exception e){
                System.out.println(e.getMessage());
                return "Error al registrar usuario";
            }
        }
    }
    public Usuario obtenerUsuario(Integer id){
        return usuarioRepository.buscarPorId2(id);
    }

    public void eliminarUsuario(Integer id){
        usuarioRepository.eliminar(id);
    }

    public void desbloquearUsuario(Integer id){
        usuarioRepository.desbloquearUsuario(id);
    }
    public Integer obtenerIntentos(String correo){
        return usuarioRepository.obtenerIntentos(correo);
    }

    public Integer obtenerIntentos(Integer id){
        return usuarioRepository.obtenerIntentos(id);
    }

    public String obtenerRol(String correo){
        return usuarioRepository.obtenerRol(correo);
    }

    public Integer validarCorreo(String correo){
        return usuarioRepository.validarCorreo(correo);
    }

    public Integer validarLogin(String login){
        return usuarioRepository.validarLogin(login);
    }

    public Integer validarCorreo2(String correo, String correo2){
        return usuarioRepository.validarCorreo2(correo, correo2);
    }

    public Integer validarLogin2(String login, String login2){
        return usuarioRepository.validarLogin2(login, login2);
    }

    public Integer obtenerId(String nombre){
        return usuarioRepository.obtenerId(nombre);
    }

    public String editarUsuario(UsuarioDTO usuarioDTO){
        Usuario usuario = usuarioRepository.buscarPorId2(usuarioDTO.getId_usuario());
        if(validarCorreo2(usuarioDTO.getCorreo(), usuario.getCorreo())==1){
            return "El correo ya se encuentra registrado";
        }else if(validarLogin2(usuarioDTO.getLogin(), usuario.getLogin())==1){
            return "El login ya se encuentra registrado";
        }else{
            usuarioRepository.editarUsuario(usuarioDTO);
            return "Guardado Correctamente";
        }

    }

}
