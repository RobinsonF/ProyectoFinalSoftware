package co.edu.unbosque.controller;

import co.edu.unbosque.dto.CorreoDTO;
import co.edu.unbosque.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/correo")
@CrossOrigin(origins = "http://localhost:8080")

public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/enviarCorreo")
    public ResponseEntity<String> sendMail(@RequestBody CorreoDTO correo) {
        return emailService.enviarCorreo(correo);
    }
}
