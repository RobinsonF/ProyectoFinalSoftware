package co.edu.unbosque.service;

import co.edu.unbosque.entity.*;
import co.edu.unbosque.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class UsuarioCuadrillaService {
    @Autowired
    UsuarioCuadrillaRepository usuarioCuadrillaRepository;
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    CuadrillaRepository cuadrillaRepository;

    public List<Usuariocuadrilla> listaUsuarioCuadrilla() {
        return usuarioCuadrillaRepository.listaUsuarioCuadrillas();
    }

    public Usuariocuadrilla registrarUsuarioCuadrilla(Usuariocuadrilla usuarioCuadrilla, Integer id_usuario, Integer id_cuadrilla) {

        Usuariocuadrilla usuarioCuadrilla1 = new Usuariocuadrilla(usuarioCuadrilla.getEstado());
        Optional<Usuario> usuario = usuarioRepository.buscarPorId(id_usuario);
        usuario.ifPresent(a -> {
            a.addUsuarioCuadrilla(usuarioCuadrilla1);
            usuarioRepository.registrar(a);
        });
        Optional<Cuadrilla> cuadrilla = cuadrillaRepository.buscarPorId(id_cuadrilla);
        cuadrilla.ifPresent(a -> {
            a.addUsuarioCuadrilla(usuarioCuadrilla1);
            cuadrillaRepository.registrar(a);
        });
        usuarioCuadrillaRepository.registrar(usuarioCuadrilla1);
        return usuarioCuadrilla1;


    }
}
