package co.edu.unbosque.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the turnotrabajo database table.
 * 
 */
@Entity
@NamedQuery(name="Turnotrabajo.findAll", query="SELECT t FROM Turnotrabajo t")
public class Turnotrabajo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_turnotrabajo")
	private Integer idTurnotrabajo;

	private String estado;

	private String nombre;

	//bi-directional many-to-one association to Turnocuadrilla
	@OneToMany(mappedBy="turnotrabajo")
	private List<TurnoCuadrilla> turnoCuadrillas;

	public Turnotrabajo() {
	}

	public Turnotrabajo(String estado, String nombre) {
		this.estado = estado;
		this.nombre = nombre;
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

	public List<TurnoCuadrilla> getTurnocuadrillas() {
		return this.turnoCuadrillas;
	}

	public void setTurnocuadrillas(List<TurnoCuadrilla> turnoCuadrillas) {
		this.turnoCuadrillas = turnoCuadrillas;
	}

	public TurnoCuadrilla addTurnoCuadrilla(TurnoCuadrilla turnocuadrilla) {
		getTurnocuadrillas().add(turnocuadrilla);
		turnocuadrilla.setTurnotrabajo(this);

		return turnocuadrilla;
	}

	public TurnoCuadrilla removeTurnocuadrilla(TurnoCuadrilla turnocuadrilla) {
		getTurnocuadrillas().remove(turnocuadrilla);
		turnocuadrilla.setTurnotrabajo(null);

		return turnocuadrilla;
	}

}