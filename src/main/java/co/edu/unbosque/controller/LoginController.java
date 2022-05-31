package co.edu.unbosque.controller;

import co.edu.unbosque.dto.EstadoDTO;
import co.edu.unbosque.dto.UsuarioDTO;
import co.edu.unbosque.entity.Usuario;
import co.edu.unbosque.service.LoginService;
import co.edu.unbosque.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping("/usuario")
    public EstadoDTO login(@RequestBody Usuario usuario){
        String token = loginService.login(usuario);
        EstadoDTO estadoDTO = new EstadoDTO(token, "Funciona");
        return estadoDTO;
    }

    @PostMapping("/usuarioIntento/{id}")
    public String aumentarIntento(@RequestBody UsuarioDTO usuarioDTO){
        return loginService.aumentarIntento(usuarioDTO.getCorreo());
    }

    @PostMapping("/usuarioNumeroIntentos/{id}")
    public Integer obtenerIntentos(@RequestBody UsuarioDTO usuarioDTO){
        return loginService.obtenerIntentos(usuarioDTO.getCorreo());
    }

    @PostMapping("/usuarioCeroIntentos/{id}")
    public void setearCeroIntentos(@RequestBody UsuarioDTO usuarioDTO){
        loginService.setearCeroIntentos(usuarioDTO.getCorreo());
    }

}
