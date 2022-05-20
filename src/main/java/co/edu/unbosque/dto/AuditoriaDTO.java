package co.edu.unbosque.dto;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class AuditoriaDTO {
    private Integer idAuditoria;

    private String estado;

    private Integer id_usuario;
    private String evento;

    private Date fecha;

    public AuditoriaDTO(Integer idAuditoria, String evento, Date fecha) {
        this.idAuditoria = idAuditoria;
        this.evento = evento;
        this.fecha = fecha;
    }

    public AuditoriaDTO(){

    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Integer getIdAuditoria() {
        return idAuditoria;
    }

    public void setIdAuditoria(Integer idAuditoria) {
        this.idAuditoria = idAuditoria;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
