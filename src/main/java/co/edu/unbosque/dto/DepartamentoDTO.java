package co.edu.unbosque.dto;

import javax.persistence.Column;

public class DepartamentoDTO {
    private Integer idDepartamento;

    private String estado;

    private String nombre;

    public DepartamentoDTO(Integer idDepartamento, String estado, String nombre) {
        this.idDepartamento = idDepartamento;
        this.estado = estado;
        this.nombre = nombre;
    }

    public DepartamentoDTO() {
    }

    public Integer getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Integer idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
