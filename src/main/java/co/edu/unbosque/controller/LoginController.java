package co.edu.unbosque.controller;

import co.edu.unbosque.entity.Usuario;
import co.edu.unbosque.service.LoginService;
import co.edu.unbosque.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "http://localhost:8080")
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping("/usuario")
    public String login(@RequestBody Usuario usuario){
        return loginService.login(usuario);
    }
}
