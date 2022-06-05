package co.edu.unbosque.service;

import co.edu.unbosque.entity.Parametro;
import co.edu.unbosque.repository.ParametroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ParametroService {

    @Autowired
    ParametroRepository parametroRepository;

    public Parametro obtenerParametro(String tipo){
        return parametroRepository.obtenerParametro(tipo);
    }

    public Integer obtenerParametro2(String tipo){
        Parametro parametro = obtenerParametro(tipo);
        return parametro.getValorInt();
    }
}
