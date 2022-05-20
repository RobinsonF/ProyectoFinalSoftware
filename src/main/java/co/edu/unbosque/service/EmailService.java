package co.edu.unbosque.service;

import co.edu.unbosque.dto.CorreoDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;

import javax.mail.MessagingException;

@Service
public class EmailService {

    Logger log = LoggerFactory.getLogger(getClass());
    @Autowired
    private JavaMailSender javaMailSender;

    public ResponseEntity<String> enviarCorreo(CorreoDTO correo){
        SimpleMailMessage mail = new SimpleMailMessage();

        try{
        mail.setFrom("electricidad023@gmail.com");
        mail.setTo(correo.getTo());
        mail.setSubject(correo.getSubject());
        mail.setText(correo.getText());

        javaMailSender.send(mail);

    } catch (MailException e) {
        log.info("error in sending mail, detail: [{}]", e.getMessage());
        return new ResponseEntity<>("Error in sending mail", HttpStatus.INTERNAL_SERVER_ERROR);
    }
		return ResponseEntity.ok("Mail send");

    }

}
