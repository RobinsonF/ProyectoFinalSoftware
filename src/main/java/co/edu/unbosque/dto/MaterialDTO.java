package co.edu.unbosque.dto;

import co.edu.unbosque.entity.Ordentrabajo;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class MaterialDTO {

    private Integer idMaterial;

    private Integer cantidad;

    private String estado;

    private String nombreMaterial;

    private Integer ordentrabajo;

    public MaterialDTO() {
    }

    public MaterialDTO(Integer idMaterial, Integer cantidad, String estado, String nombreMaterial) {
        this.idMaterial = idMaterial;
        this.cantidad = cantidad;
        this.estado = estado;
        this.nombreMaterial = nombreMaterial;
    }

    public Integer getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(Integer idMaterial) {
        this.idMaterial = idMaterial;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombreMaterial() {
        return nombreMaterial;
    }

    public void setNombreMaterial(String nombreMaterial) {
        this.nombreMaterial = nombreMaterial;
    }

    public Integer getOrdentrabajo() {
        return ordentrabajo;
    }

    public void setOrdentrabajo(Integer ordentrabajo) {
        this.ordentrabajo = ordentrabajo;
    }
}
