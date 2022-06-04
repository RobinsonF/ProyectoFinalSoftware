package co.edu.unbosque.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the usuariocuadrilla database table.
 * 
 */
@Entity
@NamedQuery(name="Usuariocuadrilla.findAll", query="SELECT u FROM UsuarioCuadrilla u")
public class UsuarioCuadrilla implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_usuariocuadrilla")
	private Integer idUsuariocuadrilla;

	private String estado;

	//bi-directional many-to-one association to Cuadrilla
	@ManyToOne
	@JoinColumn(name="id_cuadrilla")
	private Cuadrilla cuadrilla;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;

	public UsuarioCuadrilla() {
	}

	public UsuarioCuadrilla(String estado) {
		this.estado = estado;
	}

	public Integer getIdUsuariocuadrilla() {
		return this.idUsuariocuadrilla;
	}

	public void setIdUsuariocuadrilla(Integer idUsuariocuadrilla) {
		this.idUsuariocuadrilla = idUsuariocuadrilla;
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

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}