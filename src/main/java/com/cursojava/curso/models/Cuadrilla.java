package com.cursojava.curso.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cuadrilla database table.
 * 
 */
@Entity
@Table(name="cuadrilla")
@NamedQuery(name="Cuadrilla.findAll", query="SELECT c FROM Cuadrilla c")
public class Cuadrilla implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_cuadrilla")
	private Integer idCuadrilla;

	private String estado;

	@Column(name="nombre_cuadrilla")
	private String nombreCuadrilla;

	//bi-directional many-to-one association to Turnotrabajo
	@ManyToOne
	@JoinColumn(name="id_turnotrabajo")
	private Turnotrabajo turnotrabajo;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;

	//bi-directional many-to-one association to Empleado
	@OneToMany(mappedBy="cuadrilla")
	private List<Empleado> empleados;

	//bi-directional many-to-one association to Ordentrabajo
	@OneToMany(mappedBy="cuadrilla")
	private List<Ordentrabajo> ordentrabajos;

	public Cuadrilla() {
	}

	public Integer getIdCuadrilla() {
		return this.idCuadrilla;
	}

	public void setIdCuadrilla(Integer idCuadrilla) {
		this.idCuadrilla = idCuadrilla;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNombreCuadrilla() {
		return this.nombreCuadrilla;
	}

	public void setNombreCuadrilla(String nombreCuadrilla) {
		this.nombreCuadrilla = nombreCuadrilla;
	}

	public Turnotrabajo getTurnotrabajo() {
		return this.turnotrabajo;
	}

	public void setTurnotrabajo(Turnotrabajo turnotrabajo) {
		this.turnotrabajo = turnotrabajo;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Empleado> getEmpleados() {
		return this.empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	public Empleado addEmpleado(Empleado empleado) {
		getEmpleados().add(empleado);
		empleado.setCuadrilla(this);

		return empleado;
	}

	public Empleado removeEmpleado(Empleado empleado) {
		getEmpleados().remove(empleado);
		empleado.setCuadrilla(null);

		return empleado;
	}

	public List<Ordentrabajo> getOrdentrabajos() {
		return this.ordentrabajos;
	}

	public void setOrdentrabajos(List<Ordentrabajo> ordentrabajos) {
		this.ordentrabajos = ordentrabajos;
	}

	public Ordentrabajo addOrdentrabajo(Ordentrabajo ordentrabajo) {
		getOrdentrabajos().add(ordentrabajo);
		ordentrabajo.setCuadrilla(this);

		return ordentrabajo;
	}

	public Ordentrabajo removeOrdentrabajo(Ordentrabajo ordentrabajo) {
		getOrdentrabajos().remove(ordentrabajo);
		ordentrabajo.setCuadrilla(null);

		return ordentrabajo;
	}

}