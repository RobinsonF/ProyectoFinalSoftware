package co.edu.unbosque.entity;
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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cuadrilla")
	private Integer idCuadrilla;
	@Column(name="estado")
	private String estado;

	@Column(name="nombre_cuadrilla")
	private String nombreCuadrilla;


	//bi-directional many-to-one association to Empleado
	@OneToMany(mappedBy="cuadrilla")
	private List<Empleado> empleados;

	//bi-directional many-to-one association to Ordentrabajo
	@OneToMany(mappedBy="cuadrilla")
	private List<Ordentrabajo> ordentrabajos;

	//bi-directional many-to-one association to UsuarioCuadrilla
	@OneToMany(mappedBy="cuadrilla")
	private List<UsuarioCuadrilla> usuarioCuadrillas;

	//bi-directional many-to-one association to TurnoCuadrilla
	@OneToMany(mappedBy="cuadrilla")
	private List<TurnoCuadrilla> turnoCuadrillas;

	public Cuadrilla() {
	}

	public Cuadrilla(String estado, String nombreCuadrilla) {
		this.estado = estado;
		this.nombreCuadrilla = nombreCuadrilla;
	}

	public List<UsuarioCuadrilla> getUsuarioCuadrillas() {
		return usuarioCuadrillas;
	}

	public void setUsuarioCuadrillas(List<UsuarioCuadrilla> usuarioCuadrillas) {
		this.usuarioCuadrillas = usuarioCuadrillas;
	}

	public List<TurnoCuadrilla> getTurnoCuadrillas() {
		return turnoCuadrillas;
	}

	public void setTurnoCuadrillas(List<TurnoCuadrilla> turnoCuadrillas) {
		this.turnoCuadrillas = turnoCuadrillas;
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
	public TurnoCuadrilla addTurnoCuadrilla(TurnoCuadrilla turnoCuadrilla) {
		getTurnoCuadrillas().add(turnoCuadrilla);
		turnoCuadrilla.setCuadrilla(this);

		return turnoCuadrilla;
	}

	public TurnoCuadrilla removeTurnoTrabajo(TurnoCuadrilla turnoCuadrilla) {
		getTurnoCuadrillas()	.remove(turnoCuadrilla);
		turnoCuadrilla.setCuadrilla(null);

		return turnoCuadrilla;
	}

	public UsuarioCuadrilla addUsuarioCuadrilla(UsuarioCuadrilla usuarioCuadrilla) {
		getUsuarioCuadrillas().add(usuarioCuadrilla);
		usuarioCuadrilla.setCuadrilla(this);

		return usuarioCuadrilla;
	}

	public UsuarioCuadrilla removeUsuarioCuadrilla(UsuarioCuadrilla usuarioCuadrilla) {
		getUsuarioCuadrillas().remove(usuarioCuadrilla);
		usuarioCuadrilla.setCuadrilla(null);

		return usuarioCuadrilla;
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