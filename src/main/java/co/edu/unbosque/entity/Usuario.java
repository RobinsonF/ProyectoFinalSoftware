package co.edu.unbosque.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_usuario")
	private Integer idUsuario;

	private String correo;

	private String direccion;

	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_pass")
	private Date fechaPass;

	private Integer intento;

	private String login;

	private String nombre;

	private String password;

	private String telefono;

	//bi-directional many-to-one association to Auditoria
	@OneToMany(mappedBy="usuario")
	private List<Auditoria> auditorias;

	//bi-directional many-to-one association to Rol
	@ManyToOne
	@JoinColumn(name="id_rol")
	private Rol rol;

	//bi-directional many-to-one association to Usuariocuadrilla
	@OneToMany(mappedBy="usuario")
	private List<Usuariocuadrilla> usuarioCuadrillas;

	public Usuario() {
	}

	public Usuario(String correo, String direccion, String estado, String login, String nombre, String password, String telefono, Integer intento, Date fechaPass) {
		this.correo = correo;
		this.direccion = direccion;
		this.estado = estado;
		this.fechaPass = fechaPass;
		this.intento = intento;
		this.login = login;
		this.nombre = nombre;
		this.password = password;
		this.telefono = telefono;
	}

	public Integer getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaPass() {
		return this.fechaPass;
	}

	public void setFechaPass(Date fechaPass) {
		this.fechaPass = fechaPass;
	}

	public Integer getIntento() {
		return this.intento;
	}

	public void setIntento(Integer intento) {
		this.intento = intento;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Auditoria> getAuditorias() {
		return this.auditorias;
	}

	public void setAuditorias(List<Auditoria> auditorias) {
		this.auditorias = auditorias;
	}

	public Auditoria addAuditoria(Auditoria auditoria) {
		getAuditorias().add(auditoria);
		auditoria.setUsuario(this);

		return auditoria;
	}

	public Auditoria removeAuditoria(Auditoria auditoria) {
		getAuditorias().remove(auditoria);
		auditoria.setUsuario(null);

		return auditoria;
	}

	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public List<Usuariocuadrilla> getUsuariocuadrillas() {
		return this.usuarioCuadrillas;
	}

	public void setUsuariocuadrillas(List<Usuariocuadrilla> usuarioCuadrillas) {
		this.usuarioCuadrillas = usuarioCuadrillas;
	}

	public Usuariocuadrilla addUsuarioCuadrilla(Usuariocuadrilla usuariocuadrilla) {
		getUsuariocuadrillas().add(usuariocuadrilla);
		usuariocuadrilla.setUsuario(this);

		return usuariocuadrilla;
	}

	public Usuariocuadrilla removeUsuariocuadrilla(Usuariocuadrilla usuariocuadrilla) {
		getUsuariocuadrillas().remove(usuariocuadrilla);
		usuariocuadrilla.setUsuario(null);

		return usuariocuadrilla;
	}

}