package com.cursojava.curso.models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the material database table.
 * 
 */
@Entity
@Table(name="material")
@NamedQuery(name="Material.findAll", query="SELECT m FROM Material m")
public class Material implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_material")
	private Integer idMaterial;

	private Integer cantidad;

	private String estado;

	@Column(name="nombre_material")
	private String nombreMaterial;

	//bi-directional many-to-one association to Ordentrabajo
	@ManyToOne
	@JoinColumn(name="id_trabajo")
	private Ordentrabajo ordentrabajo;

	public Material() {
	}

	public Integer getIdMaterial() {
		return this.idMaterial;
	}

	public void setIdMaterial(Integer idMaterial) {
		this.idMaterial = idMaterial;
	}

	public Integer getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNombreMaterial() {
		return this.nombreMaterial;
	}

	public void setNombreMaterial(String nombreMaterial) {
		this.nombreMaterial = nombreMaterial;
	}

	public Ordentrabajo getOrdentrabajo() {
		return this.ordentrabajo;
	}

	public void setOrdentrabajo(Ordentrabajo ordentrabajo) {
		this.ordentrabajo = ordentrabajo;
	}

}