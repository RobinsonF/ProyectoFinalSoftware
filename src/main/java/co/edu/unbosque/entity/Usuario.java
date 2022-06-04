package co.edu.unbosque.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 */
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Column(name = "correo")
    private String correo;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "estado")
    private String estado;
    @Column(name = "login")
    private String login;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "password")
    private String password;
    @Column(name = "telefono")
    private String telefono;

    @Column(name = "intento")
    private Integer intento;

    @Column(name="fecha_pass")
    private Date fechaPass;

    //bi-directional many-to-one association to Auditoria
    @OneToMany(mappedBy = "usuario")
    private List<Auditoria> auditorias;

    //bi-directional many-to-one association to Cuadrilla
    @OneToMany(mappedBy = "usuario")
    private List<UsuarioCuadrilla> usuarioCuadrillas;

    //bi-directional many-to-one association to Rol
    @ManyToOne
    @JoinColumn(name = "id_rol")
    private Rol rol;

    public Usuario() {
    }

    public Usuario(String correo, String direccion, String estado, String login, String nombre, String password, String telefono, Integer intentos) {
        this.correo = correo;
        this.direccion = direccion;
        this.estado = estado;
        this.login = login;
        this.nombre = nombre;
        this.password = password;
        this.telefono = telefono;
        this.intento = intentos;
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

    public Integer getIntento() {
        return intento;
    }

    public void setIntento(Integer intento) {
        this.intento = intento;
    }

    public Date getFechaPass() {
        return fechaPass;
    }

    public void setFechaPass(Date fechaPass) {
        this.fechaPass = fechaPass;
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

    public List<UsuarioCuadrilla> getUsuarioCuadrillas() {
        return this.usuarioCuadrillas;
    }

    public void setUsuarioCuadrillas(List<UsuarioCuadrilla> usuarioCuadrillas) {
        this.usuarioCuadrillas = usuarioCuadrillas;
    }

    public UsuarioCuadrilla addUsuarioCuadrilla(UsuarioCuadrilla usuarioCuadrilla) {
        getUsuarioCuadrillas().add(usuarioCuadrilla);
        usuarioCuadrilla.setUsuario(this);

        return usuarioCuadrilla;
    }

    public UsuarioCuadrilla removeUsuarioCuadrilla(UsuarioCuadrilla usuarioCuadrilla) {
        getUsuarioCuadrillas().remove(usuarioCuadrilla);
        usuarioCuadrilla.setUsuario(null);

        return usuarioCuadrilla;
    }

    public Rol getRol() {
        return this.rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

}