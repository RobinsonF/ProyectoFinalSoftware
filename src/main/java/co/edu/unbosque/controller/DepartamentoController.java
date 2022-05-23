package co.edu.unbosque.controller;

import co.edu.unbosque.dto.DepartamentoDTO;
import co.edu.unbosque.entity.Departamento;
import co.edu.unbosque.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/departamento")
@CrossOrigin(origins = "http://localhost:8080")
public class DepartamentoController {
    @Autowired
    DepartamentoService departamentoService;

    @GetMapping("/listaDepartamento")
    public ResponseEntity<List<DepartamentoDTO>> listaDepartamentos() {

        List<Departamento> departamentos = departamentoService.listaDepartamentos();
        List<DepartamentoDTO> listaDepartamentos = new ArrayList<>();
        for (Departamento departamento : departamentos) {
            listaDepartamentos.add(
                    new DepartamentoDTO(departamento.getIdDepartamento(), departamento.getEstado(), departamento.getNombre())
            );
        }
        return new ResponseEntity<List<DepartamentoDTO>>(listaDepartamentos, HttpStatus.OK);
    }

    @PostMapping("/crearDepartamento")
    public ResponseEntity<Departamento> creardepartamento(@RequestBody DepartamentoDTO departamentoDTO) {
        Departamento departamento = new Departamento("A",departamentoDTO.getNombre());
        departamentoService.registrarDepartamento(departamento);
        return new ResponseEntity(departamento, HttpStatus.OK);
    }
}
