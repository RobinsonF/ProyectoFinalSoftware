package co.edu.unbosque.dto;

import javax.persistence.Column;

public class CiudadDTO {
    private Integer idCiudad;

    private String estado;

    private String nombre;

    private Integer id_departamento;

    private String nombreDepartamento;

    public CiudadDTO() {
    }

    public CiudadDTO(Integer idCiudad, String nombre, String nombreDepartamento) {
        this.idCiudad = idCiudad;
        this.nombre = nombre;
        this.nombreDepartamento = nombreDepartamento;
    }

    public Integer getIdCiudad() {
        return idCiudad;
    }

    public Integer getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(Integer id_departamento) {
        this.id_departamento = id_departamento;
    }

    public void setIdCiudad(Integer idCiudad) {
        this.idCiudad = idCiudad;
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

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }
}
