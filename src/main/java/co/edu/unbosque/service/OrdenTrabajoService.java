package co.edu.unbosque.service;


import co.edu.unbosque.dto.OrdenTrabajoDTO;
import co.edu.unbosque.entity.Cuadrilla;
import co.edu.unbosque.entity.Ordentrabajo;
import co.edu.unbosque.entity.Zona;
import co.edu.unbosque.repository.CuadrillaRepository;
import co.edu.unbosque.repository.OrdenTrabajoRepository;
import co.edu.unbosque.repository.ZonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrdenTrabajoService {
    @Autowired
    OrdenTrabajoRepository ordenTrabajoRepository;
    @Autowired
    ZonaRepository zonaRepository;
    @Autowired
    CuadrillaRepository cuadrillaRepository;


    public List<Ordentrabajo> listaOrden() {
        return ordenTrabajoRepository.listaOrdenes();
    }

    public String registrarOrden(OrdenTrabajoDTO ordentrabajo) {
        try{
            SimpleDateFormat formato=new SimpleDateFormat("yyyy-MM-dd");
            Integer id_zona = zonaRepository.obtenerIdPorNombre(ordentrabajo.getNombreZona());
            Integer id_cuadrilla = cuadrillaRepository.obtenerIdPorNombre(ordentrabajo.getNombreCuadrilla());
            Ordentrabajo ordentrabajo1 = new Ordentrabajo("A",ordentrabajo.getFechaTrabajof(),formato.parse(ordentrabajo.getFechaInicial()),ordentrabajo.getNombreTrabajo());
            Optional<Zona> zona = zonaRepository.buscarPorId(id_zona);
            zona.ifPresent(a -> {
                a.addOrdentrabajo(ordentrabajo1);
                zonaRepository.registrar(a);
            });
            Optional<Cuadrilla> cuadrilla = cuadrillaRepository.buscarPorId(id_cuadrilla);
            cuadrilla.ifPresent(a -> {
                a.addOrdentrabajo(ordentrabajo1);
                cuadrillaRepository.registrar(a);
            });
            ordenTrabajoRepository.registrar(ordentrabajo1);
            return "Registrado correctamente";
        }catch (Exception e){
            return e.getMessage();
        }
    }
}
