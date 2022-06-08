package co.edu.unbosque.controller;

import co.edu.unbosque.dto.EstadoDTO;
import co.edu.unbosque.dto.UsuarioDTO;
import co.edu.unbosque.entity.Usuario;
import co.edu.unbosque.service.LoginService;
import co.edu.unbosque.service.ParametroService;
import co.edu.unbosque.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {

    @Autowired
    LoginService loginService;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    ParametroService parametroService;

    @PostMapping("/usuario")
    public EstadoDTO login(@RequestBody Usuario usuario){
        String token = loginService.login(usuario);
        Integer intentosUsuario = loginService.obtenerIntentos(usuario.getCorreo());
        Integer intentosBloqueo = parametroService.obtenerParametro2("I");
        Integer cambiarContra = parametroService.obtenerParametro2("C");
        String rol = usuarioService.obtenerRol(usuario.getCorreo());

        EstadoDTO estadoDTO = new EstadoDTO();
        if(intentosUsuario >= intentosBloqueo){
           estadoDTO.setMensaje("La cuenta se encuentra bloqueada");
        }else{
            if(!token.equals("FAIL")){
                Date fecha = usuarioService.obtenerFechaPass(usuario.getCorreo());
                Date fecha1 = new Date();
                TimeUnit time = TimeUnit.DAYS;
                long diffrence = time.convert(fecha1.getTime()-fecha.getTime(), TimeUnit.MILLISECONDS);
                if(cambiarContra<=diffrence){
                    estadoDTO.setMensaje("Para poder iniciar sesión es necesario cambiar la contraseña");
                }
                estadoDTO.setRol(rol);
                estadoDTO.setEstado(token);
            }else{
                estadoDTO.setEstado("FAIL");
                estadoDTO.setMensaje("Error login");
            }
        }
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
