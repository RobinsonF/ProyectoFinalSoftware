package co.edu.unbosque.service;

import co.edu.unbosque.entity.Usuario;
import co.edu.unbosque.repository.UsuarioRespository;
import co.edu.unbosque.util.JWTUtil2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    UsuarioRespository usuarioRepository;

    @Autowired
    private JWTUtil2 jwtUtil;

    public String login(Usuario usuario){
        Usuario usuarioLogueado = usuarioRepository.obtenerUsuarioPorCredenciales(usuario);
        if (usuarioLogueado != null) {
            String tokenJwt = jwtUtil.create(String.valueOf(usuarioLogueado.getIdUsuario()), usuarioLogueado.getCorreo());
            return tokenJwt;
        }else{
            return "FAIL";
        }
    }
}
