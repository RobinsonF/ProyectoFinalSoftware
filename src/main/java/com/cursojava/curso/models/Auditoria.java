package com.cursojava.curso.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the auditoria database table.
 * 
 */
@Entity
@Table(name = "auditoria")
@NamedQuery(name="Auditoria.findAll", query="SELECT a FROM Auditoria a")
public class Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_auditoria")
	private Integer idAuditoria;

	private String estado;

	private String evento;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;

	public Auditoria() {
	}

	public Integer getIdAuditoria() {
		return this.idAuditoria;
	}

	public void setIdAuditoria(Integer idAuditoria) {
		this.idAuditoria = idAuditoria;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getEvento() {
		return this.evento;
	}

	public void setEvento(String evento) {
		this.evento = evento;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}