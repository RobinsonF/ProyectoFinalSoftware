package co.edu.unbosque.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the turnocuadrilla database table.
 * 
 */
@Entity
@NamedQuery(name="Turnocuadrilla.findAll", query="SELECT t FROM Turnocuadrilla t")
public class Turnocuadrilla implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_turnocuadrilla")
	private Integer idTurnocuadrilla;

	private String estado;

	//bi-directional many-to-one association to Cuadrilla
	@ManyToOne
	@JoinColumn(name="id_cuadrilla")
	private Cuadrilla cuadrilla;

	//bi-directional many-to-one association to Turnotrabajo
	@ManyToOne
	@JoinColumn(name="id_turnotrabajo")
	private Turnotrabajo turnotrabajo;

	public Turnocuadrilla() {
	}

	public Turnocuadrilla(String estado) {
		this.estado = estado;
	}

	public Integer getIdTurnocuadrilla() {
		return this.idTurnocuadrilla;
	}

	public void setIdTurnocuadrilla(Integer idTurnocuadrilla) {
		this.idTurnocuadrilla = idTurnocuadrilla;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Cuadrilla getCuadrilla() {
		return this.cuadrilla;
	}

	public void setCuadrilla(Cuadrilla cuadrilla) {
		this.cuadrilla = cuadrilla;
	}

	public Turnotrabajo getTurnotrabajo() {
		return this.turnotrabajo;
	}

	public void setTurnotrabajo(Turnotrabajo turnotrabajo) {
		this.turnotrabajo = turnotrabajo;
	}

}