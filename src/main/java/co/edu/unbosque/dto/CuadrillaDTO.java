package co.edu.unbosque.dto;

import co.edu.unbosque.entity.Turnotrabajo;
import co.edu.unbosque.entity.Usuario;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class CuadrillaDTO {
    private Integer idCuadrilla;

    private String estado;

    private String nombreCuadrilla;

    private Integer turnotrabajo;

    private Integer usuario;

    public CuadrillaDTO(Integer idCuadrilla, String estado, String nombreCuadrilla) {
        this.idCuadrilla = idCuadrilla;
        this.estado = estado;
        this.nombreCuadrilla = nombreCuadrilla;
    }

    public CuadrillaDTO() {
    }

    public Integer getIdCuadrilla() {
        return idCuadrilla;
    }

    public void setIdCuadrilla(Integer idCuadrilla) {
        this.idCuadrilla = idCuadrilla;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombreCuadrilla() {
        return nombreCuadrilla;
    }

    public void setNombreCuadrilla(String nombreCuadrilla) {
        this.nombreCuadrilla = nombreCuadrilla;
    }

    public Integer getTurnotrabajo() {
        return turnotrabajo;
    }

    public void setTurnotrabajo(Integer turnotrabajo) {
        this.turnotrabajo = turnotrabajo;
    }

    public Integer getUsuario() {
        return usuario;
    }

    public void setUsuario(Integer usuario) {
        this.usuario = usuario;
    }
}
