package co.edu.unbosque.entity;

import javax.persistence.*;
/**
 * The persistent class for the usuariocuadrilla database table.
 *
 */
@Entity
@Table(name="usuariocuadrilla")
@NamedQuery(name="UsuarioCuadrilla.findAll", query="SELECT c FROM UsuarioCuadrilla c")
public class UsuarioCuadrilla {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_usuariocuadrilla")
    private Integer idUsuarioCuadrilla;

    @Column(name="estado")
    private String estado;

    //bi-directional many-to-one association to Usuario
    @ManyToOne
    @JoinColumn(name="id_usuario")
    private Usuario usuario;

    //bi-directional many-to-one association to Cuadrilla
    @ManyToOne
    @JoinColumn(name="id_cuadrilla")
    private Cuadrilla cuadrilla;

    public UsuarioCuadrilla(String estado) {
        this.estado = estado;
    }

    public UsuarioCuadrilla() {
    }

    public Integer getIdUsuarioCuadrilla() {
        return idUsuarioCuadrilla;
    }

    public void setIdUsuarioCuadrilla(Integer idUsuarioCuadrilla) {
        this.idUsuarioCuadrilla = idUsuarioCuadrilla;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Cuadrilla getCuadrilla() {
        return cuadrilla;
    }

    public void setCuadrilla(Cuadrilla cuadrilla) {
        this.cuadrilla = cuadrilla;
    }
}
