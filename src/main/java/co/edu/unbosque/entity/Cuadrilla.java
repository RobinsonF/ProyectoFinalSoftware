package co.edu.unbosque.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cuadrilla database table.
 * 
 */
@Entity
@NamedQuery(name="Cuadrilla.findAll", query="SELECT c FROM Cuadrilla c")
public class Cuadrilla implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_cuadrilla")
	private Integer idCuadrilla;

	private String estado;

	@Column(name="nombre_cuadrilla")
	private String nombreCuadrilla;

	//bi-directional many-to-one association to Empleado
	@OneToMany(mappedBy="cuadrilla")
	private List<Empleado> empleados;

	//bi-directional many-to-one association to Ordentrabajo
	@OneToMany(mappedBy="cuadrilla")
	private List<Ordentrabajo> ordentrabajos;

	//bi-directional many-to-one association to Turnocuadrilla
	@OneToMany(mappedBy="cuadrilla")
	private List<Turnocuadrilla> turnocuadrillas;

	//bi-directional many-to-one association to Usuariocuadrilla
	@OneToMany(mappedBy="cuadrilla")
	private List<Usuariocuadrilla> usuarioCuadrillas;

	public Cuadrilla() {
	}

	public Cuadrilla(String estado, String nombreCuadrilla) {
		this.estado = estado;
		this.nombreCuadrilla = nombreCuadrilla;
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

	public List<Turnocuadrilla> getTurnocuadrillas() {
		return this.turnocuadrillas;
	}

	public void setTurnocuadrillas(List<Turnocuadrilla> turnocuadrillas) {
		this.turnocuadrillas = turnocuadrillas;
	}

	public Turnocuadrilla addTurnoCuadrilla(Turnocuadrilla turnocuadrilla) {
		getTurnocuadrillas().add(turnocuadrilla);
		turnocuadrilla.setCuadrilla(this);

		return turnocuadrilla;
	}

	public Turnocuadrilla removeTurnocuadrilla(Turnocuadrilla turnocuadrilla) {
		getTurnocuadrillas().remove(turnocuadrilla);
		turnocuadrilla.setCuadrilla(null);

		return turnocuadrilla;
	}

	public List<Usuariocuadrilla> getUsuariocuadrillas() {
		return this.usuarioCuadrillas;
	}

	public void setUsuariocuadrillas(List<Usuariocuadrilla> usuarioCuadrillas) {
		this.usuarioCuadrillas = usuarioCuadrillas;
	}

	public Usuariocuadrilla addUsuarioCuadrilla(Usuariocuadrilla usuariocuadrilla) {
		getUsuariocuadrillas().add(usuariocuadrilla);
		usuariocuadrilla.setCuadrilla(this);

		return usuariocuadrilla;
	}

	public Usuariocuadrilla removeUsuariocuadrilla(Usuariocuadrilla usuariocuadrilla) {
		getUsuariocuadrillas().remove(usuariocuadrilla);
		usuariocuadrilla.setCuadrilla(null);

		return usuariocuadrilla;
	}

}