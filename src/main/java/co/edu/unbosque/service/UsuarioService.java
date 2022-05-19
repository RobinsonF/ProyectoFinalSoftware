package co.edu.unbosque.service;

import co.edu.unbosque.entity.Rol;
import co.edu.unbosque.entity.Usuario;
import co.edu.unbosque.repository.RolRepository;
import co.edu.unbosque.repository.UsuarioRespository;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    public List<Usuario> listaUsuario(){
        return  usuarioRepository.getUsuarios();
    }

    public Usuario registrarUsuario(Usuario usuario, Integer id){
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1, 1024, 1, usuario.getPassword());
        Usuario usuario1 = new Usuario(usuario.getCorreo(), usuario.getDireccion(), usuario.getEstado(), usuario.getLogin(), usuario.getNombre(), hash, usuario.getTelefono());
        Optional<Rol> rol = rolRepository.buscarPorId(id);
        rol.ifPresent(a -> {
            a.addUsuario(usuario1);
            rolRepository.registrar(a);
        });
        usuarioRepository.registrar(usuario1);
        return usuario1;
    }


    public UsuarioRespository getUsuarioRepository() {
        return usuarioRepository;
    }

    public void setUsuarioRepository(UsuarioRespository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
}
