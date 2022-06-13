package co.edu.unbosque.controller;

import co.edu.unbosque.dto.EstadoDTO;
import co.edu.unbosque.dto.UsuarioDTO;
import co.edu.unbosque.entity.Usuario;
import co.edu.unbosque.service.UsuarioService;
import co.edu.unbosque.util.JWTUtil2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/listaUsuario")
    public ResponseEntity<List<UsuarioDTO>> listaUsuarios() {

        List<Usuario> usuarios = usuarioService.listaUsuario();
        List<UsuarioDTO> listaUsuarios = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            listaUsuarios.add(
                    new UsuarioDTO(usuario.getIdUsuario(),
                            usuario.getNombre(),
                            usuario.getLogin(),
                            usuario.getDireccion(),
                            usuario.getTelefono(),
                            usuario.getCorreo(),
                            usuario.getRol().getNombre()
            ));
        }
        return new ResponseEntity<List<UsuarioDTO>>(listaUsuarios, HttpStatus.OK);
    }

    @GetMapping("/obtenerUsuario")
    public UsuarioDTO obtenerUsuario(@RequestParam Integer id) {
        Usuario usuario = usuarioService.obtenerUsuario(id);
        UsuarioDTO usuarioDTO = new UsuarioDTO(usuario.getIdUsuario(), usuario.getNombre(), usuario.getLogin(), usuario.getDireccion(), usuario.getTelefono(), usuario. getCorreo(), usuario.getRol().getNombre());
        return usuarioDTO;
    }

    @GetMapping("/obtenerUsuarioCorreo")
    public EstadoDTO obtenerUsuarioPorCorreo(@RequestParam String correo) {
        EstadoDTO estadoDTO = new EstadoDTO();
        Integer id = usuarioService.obtenerIdPorCorreo(correo);
        estadoDTO.setMensaje(id+"");
        return estadoDTO;
    }

    @PostMapping("/crearUsuario")
    public EstadoDTO crearUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        EstadoDTO estadoDTO = new EstadoDTO();
        Usuario usuario = new Usuario(usuarioDTO.getCorreo(), usuarioDTO.getDireccion(), "A", usuarioDTO.getLogin(), usuarioDTO.getNombre(), usuarioDTO.getPassword(), usuarioDTO.getTelefono(), usuarioDTO.getIntentos(), new Date());
        String mensajeCrear = usuarioService.registrarUsuario(usuario, usuarioDTO.getId_rol());
        estadoDTO.setMensaje(mensajeCrear);
        return estadoDTO;
    }

    @PutMapping("/eliminarUsuario")
    public EstadoDTO eliminarUsuario(@RequestParam Integer id) {
        usuarioService.eliminarUsuario(id);
        EstadoDTO estadoDTO = new EstadoDTO(id + "", "Funciona");
        return estadoDTO;
    }

    @PutMapping("/editarUsuario")
    public EstadoDTO editarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        EstadoDTO estadoDTO = new EstadoDTO();
        String mensaje = usuarioService.editarUsuario(usuarioDTO);
        if(mensaje.equals("El correo ya se encuentra registrado")){
            estadoDTO.setMensaje(mensaje);
        }else if(mensaje.equals("El login ya se encuentra registrado")){
            estadoDTO.setMensaje(mensaje);
        }else{
            estadoDTO.setMensaje(mensaje);
        }
        return estadoDTO;
    }

    @PostMapping("/desbloquearUsuario/{id}")
    public String desbloquearUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        usuarioService.desbloquearUsuario(usuarioDTO.getId_usuario());
        return usuarioDTO.getId_usuario() + "";
    }

    @PostMapping("/usuarioNumeroIntento/{id}")
    public Integer obtenerIntentos(@RequestBody UsuarioDTO usuarioDTO) {
        return usuarioService.obtenerIntentos(usuarioDTO.getId_usuario());
    }

    @GetMapping("/usuarioRol")
    public EstadoDTO obtenerRol(@RequestParam String correo) {
        EstadoDTO estadoDTO = new EstadoDTO();
        estadoDTO.setMensaje(usuarioService.obtenerRol(correo));
        return estadoDTO;
    }

    @PostMapping("/obtenerId/{id}")
    public Integer obtenerId(@RequestBody UsuarioDTO usuarioDTO) {
        return usuarioService.obtenerId(usuarioDTO.getNombre());
    }

    @GetMapping("/fechaPass")
    public EstadoDTO obtenerFechaPass(@RequestParam String correo){
        SimpleDateFormat formato = new SimpleDateFormat("YYYY-MM-DD");
        EstadoDTO estadoDTO = new EstadoDTO();
        Date fecha = usuarioService.obtenerFechaPass(correo);
        Date fecha1 = new Date();
        TimeUnit time = TimeUnit.DAYS;
        long diffrence = time.convert(fecha1.getTime()-fecha.getTime(), TimeUnit.MILLISECONDS);
        estadoDTO.setMensaje(""+diffrence);
        return estadoDTO;
    }

    @PostMapping("/cambiarPass")
    public EstadoDTO cambiarPass(@RequestBody UsuarioDTO usuarioDTO) {
        EstadoDTO estadoDTO = new EstadoDTO();
        String mensaje = usuarioService.cambiarPass(usuarioDTO, usuarioDTO.getPassword2());
        estadoDTO.setMensaje(mensaje);
        return estadoDTO;
    }

}
