package com.cursojava.curso.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ordentrabajo database table.
 * 
 */
@Entity
@Table(name="ordentrabajo")
@NamedQuery(name="Ordentrabajo.findAll", query="SELECT o FROM Ordentrabajo o")
public class Ordentrabajo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_trabajo")
	private Integer idTrabajo;
	@Column(name="estado")
	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_trabajof")
	private Date fechaTrabajof;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_trabajoi")
	private Date fechaTrabajoi;

	@Column(name="nombre_trabajo")
	private String nombreTrabajo;

	//bi-directional many-to-one association to Material
	@OneToMany(mappedBy="ordentrabajo")
	private List<Material> materials;

	//bi-directional many-to-one association to Cuadrilla
	@ManyToOne
	@JoinColumn(name="id_cuadrilla")
	private Cuadrilla cuadrilla;

	//bi-directional many-to-one association to Zona
	@ManyToOne
	@JoinColumn(name="id_zona")
	private Zona zona;

	public Ordentrabajo() {
	}

	public Integer getIdTrabajo() {
		return this.idTrabajo;
	}

	public void setIdTrabajo(Integer idTrabajo) {
		this.idTrabajo = idTrabajo;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaTrabajof() {
		return this.fechaTrabajof;
	}

	public void setFechaTrabajof(Date fechaTrabajof) {
		this.fechaTrabajof = fechaTrabajof;
	}

	public Date getFechaTrabajoi() {
		return this.fechaTrabajoi;
	}

	public void setFechaTrabajoi(Date fechaTrabajoi) {
		this.fechaTrabajoi = fechaTrabajoi;
	}

	public String getNombreTrabajo() {
		return this.nombreTrabajo;
	}

	public void setNombreTrabajo(String nombreTrabajo) {
		this.nombreTrabajo = nombreTrabajo;
	}

	public List<Material> getMaterials() {
		return this.materials;
	}

	public void setMaterials(List<Material> materials) {
		this.materials = materials;
	}

	public Material addMaterial(Material material) {
		getMaterials().add(material);
		material.setOrdentrabajo(this);

		return material;
	}

	public Material removeMaterial(Material material) {
		getMaterials().remove(material);
		material.setOrdentrabajo(null);

		return material;
	}

	public Cuadrilla getCuadrilla() {
		return this.cuadrilla;
	}

	public void setCuadrilla(Cuadrilla cuadrilla) {
		this.cuadrilla = cuadrilla;
	}

	public Zona getZona() {
		return this.zona;
	}

	public void setZona(Zona zona) {
		this.zona = zona;
	}

}