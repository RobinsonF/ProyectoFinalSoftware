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
        Usuario usuario = new Usuario(usuarioDTO.getCorreo(), usuarioDTO.getDireccion(), "A", usuarioDTO.getLogin(), usuarioDTO.getNombre(), usuarioDTO.getPassword(), usuarioDTO.getTelefono(), usuarioDTO.getIntentos());
        usuarioService.registrarUsuario(usuario, usuarioDTO.getId_rol());
        return new ResponseEntity(usuario, HttpStatus.OK);
    }

    @PostMapping("/eliminarUsuario/{id}")
    public String eliminarUsuario(@RequestBody UsuarioDTO usuarioDTO){
        usuarioService.eliminarUsuario(usuarioDTO.getId_usuario());
        return usuarioDTO.getId_usuario() + "";
    }

}
