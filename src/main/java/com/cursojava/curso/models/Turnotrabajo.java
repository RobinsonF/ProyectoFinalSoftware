package com.cursojava.curso.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the turnotrabajo database table.
 * 
 */
@Entity
@Table(name="turnotrabajo")
@NamedQuery(name="Turnotrabajo.findAll", query="SELECT t FROM Turnotrabajo t")
public class Turnotrabajo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_turnotrabajo")
	private Integer idTurnotrabajo;

	private String estado;

	private String nombre;

	//bi-directional many-to-one association to Cuadrilla
	@OneToMany(mappedBy="turnotrabajo")
	private List<Cuadrilla> cuadrillas;

	public Turnotrabajo() {
	}

	public Integer getIdTurnotrabajo() {
		return this.idTurnotrabajo;
	}

	public void setIdTurnotrabajo(Integer idTurnotrabajo) {
		this.idTurnotrabajo = idTurnotrabajo;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Cuadrilla> getCuadrillas() {
		return this.cuadrillas;
	}

	public void setCuadrillas(List<Cuadrilla> cuadrillas) {
		this.cuadrillas = cuadrillas;
	}

	public Cuadrilla addCuadrilla(Cuadrilla cuadrilla) {
		getCuadrillas().add(cuadrilla);
		cuadrilla.setTurnotrabajo(this);

		return cuadrilla;
	}

	public Cuadrilla removeCuadrilla(Cuadrilla cuadrilla) {
		getCuadrillas().remove(cuadrilla);
		cuadrilla.setTurnotrabajo(null);

		return cuadrilla;
	}

}