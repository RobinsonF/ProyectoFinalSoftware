package co.edu.unbosque.controller;

import co.edu.unbosque.dto.UsuarioDTO;
import co.edu.unbosque.entity.Usuario;
import co.edu.unbosque.service.UsuarioService;
import co.edu.unbosque.util.JWTUtil2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "http://localhost:8080")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    private JWTUtil2 jwtUtil;

    @GetMapping("/listaUsuario")
    public ResponseEntity<List<UsuarioDTO>> listaUsuarios(){

        List<Usuario> usuarios = usuarioService.listaUsuario();
        List<UsuarioDTO> listaUsuarios = new ArrayList<>();
        for (Usuario usuario: usuarios) {
            listaUsuarios.add(
            new UsuarioDTO(usuario.getIdUsuario(),
                    usuario.getNombre(),
                    usuario.getLogin(),
                    usuario.getDireccion(),
                    usuario.getTelefono(),
                    usuario.getCorreo())
            );
        }
        return new ResponseEntity<List<UsuarioDTO>>(listaUsuarios, HttpStatus.OK);
    }

    @PostMapping("/crearUsuario")
    public ResponseEntity<Usuario> crearUsuario(@RequestBody UsuarioDTO usuarioDTO){
        Usuario usuario = new Usuario(usuarioDTO.getCorreo(), usuarioDTO.getDireccion(), "A", usuarioDTO.getLogin(), usuarioDTO.getNombre(), usuarioDTO.getPassword(), usuarioDTO.getTelefono());
        usuarioService.registrarUsuario(usuario, usuarioDTO.getId_rol());
        return new ResponseEntity(usuario, HttpStatus.OK);
    }

    @PostMapping("/loginUsuario")
    public String login(@RequestBody Usuario usuario){
        Usuario usuarioLogueado = usuarioService.getUsuarioRepository().obtenerUsuarioPorCredenciales(usuario);
        if (usuarioLogueado != null) {
            String tokenJwt = jwtUtil.create(String.valueOf(usuarioLogueado.getIdUsuario()), usuarioLogueado.getCorreo());
            return tokenJwt;
        }
        return "FAIL";
    }
}
