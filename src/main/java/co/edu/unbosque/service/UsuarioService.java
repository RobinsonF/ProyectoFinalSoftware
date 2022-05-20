package co.edu.unbosque.service;

import co.edu.unbosque.dto.UsuarioDTO;
import co.edu.unbosque.entity.Rol;
import co.edu.unbosque.entity.Usuario;
import co.edu.unbosque.repository.RolRepository;
import co.edu.unbosque.repository.UsuarioRespository;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.transaction.Transactional;
import java.nio.charset.Charset;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Service
@Transactional
public class UsuarioService {
    @Autowired
    UsuarioRespository usuarioRepository;

    @Autowired
    RolRepository rolRepository;

    UsuarioDTO usuarioDTO;

    public List<Usuario> listaUsuario(){
        return  usuarioRepository.getUsuarios();
    }

    public Usuario registrarUsuario(Usuario usuario, Integer id) {
        String hash = "";

        try {
            usuarioDTO = new UsuarioDTO();
            hash = usuarioDTO.shaEncode(usuario.getPassword());
            Usuario usuario1 = new Usuario(usuario.getCorreo(), usuario.getDireccion(), usuario.getEstado(), usuario.getLogin(), usuario.getNombre(), hash, usuario.getTelefono());
            Optional<Rol> rol = rolRepository.buscarPorId(id);
            rol.ifPresent(a -> {
                a.addUsuario(usuario1);
                rolRepository.registrar(a);
            });
            usuarioRepository.registrar(usuario1);
            return usuario1;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void eliminarUsuario(Integer id){
        usuarioRepository.eliminar(id);
    }


    public UsuarioRespository getUsuarioRepository() {
        return usuarioRepository;
    }

    public void setUsuarioRepository(UsuarioRespository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

}
