package co.edu.unbosque.service;

import co.edu.unbosque.entity.Departamento;
import co.edu.unbosque.repository.DepartamentoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class DepartamentoService {
    @Autowired
    DepartamentoRepository departamentoRepository;


    public List<Departamento> listaDepartamentos() {
        return departamentoRepository.listaDepartamentos();
    }

    public Departamento registrarDepartamento(Departamento departamento) {
        String hash = "";


        Departamento departamento1 = new Departamento(departamento.getEstado(), departamento.getNombre());

        departamentoRepository.registrar(departamento1);
        return departamento1;

    }
}
