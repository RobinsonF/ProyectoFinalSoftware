package co.edu.unbosque.dto;

import co.edu.unbosque.entity.Cuadrilla;
import co.edu.unbosque.entity.Material;
import co.edu.unbosque.entity.Zona;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

public class OrdenTrabajoDTO {
    private Integer idTrabajo;

    private String estado;

    private Date fechaTrabajof;

    private Date fechaTrabajoi;

    private String nombreTrabajo;

    private String nombreCuadrilla;

    private String nombreZona;

    private Integer cuadrilla;

    private Integer zona;

    private String fechaInicial;

    private String direccion;


    public OrdenTrabajoDTO(Integer idTrabajo, String estado, Date fechaTrabajof, Date fechaTrabajoi, String nombreTrabajo) {
        this.idTrabajo = idTrabajo;
        this.estado = estado;
        this.fechaTrabajof = fechaTrabajof;
        this.fechaTrabajoi = fechaTrabajoi;
        this.nombreTrabajo = nombreTrabajo;
    }

    public OrdenTrabajoDTO(Integer idTrabajo, String nombreTrabajo, String nombreCuadrilla, String nombreZona, String fechaInicial) {
        this.idTrabajo = idTrabajo;
        this.nombreTrabajo = nombreTrabajo;
        this.nombreCuadrilla = nombreCuadrilla;
        this.nombreZona = nombreZona;
        this.fechaInicial = fechaInicial;
    }

    public OrdenTrabajoDTO() {
    }

    public Integer getIdTrabajo() {
        return idTrabajo;
    }

    public void setIdTrabajo(Integer idTrabajo) {
        this.idTrabajo = idTrabajo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaTrabajof() {
        return fechaTrabajof;
    }

    public void setFechaTrabajof(Date fechaTrabajof) {
        this.fechaTrabajof = fechaTrabajof;
    }

    public Date getFechaTrabajoi() {
        return fechaTrabajoi;
    }

    public void setFechaTrabajoi(Date fechaTrabajoi) {
        this.fechaTrabajoi = fechaTrabajoi;
    }

    public String getNombreTrabajo() {
        return nombreTrabajo;
    }

    public void setNombreTrabajo(String nombreTrabajo) {
        this.nombreTrabajo = nombreTrabajo;
    }

    public Integer getCuadrilla() {
        return cuadrilla;
    }

    public void setCuadrilla(Integer cuadrilla) {
        this.cuadrilla = cuadrilla;
    }

    public Integer getZona() {
        return zona;
    }

    public void setZona(Integer zona) {
        this.zona = zona;
    }

    public String getNombreCuadrilla() {
        return nombreCuadrilla;
    }

    public void setNombreCuadrilla(String nombreCuadrilla) {
        this.nombreCuadrilla = nombreCuadrilla;
    }

    public String getNombreZona() {
        return nombreZona;
    }

    public void setNombreZona(String nombreZona) {
        this.nombreZona = nombreZona;
    }

    public String getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(String fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
