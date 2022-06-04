package co.edu.unbosque.entity;

import javax.persistence.*;

@Entity
@Table(name="turnocuadrilla")
@NamedQuery(name="TurnoCuadrilla.findAll", query="SELECT c FROM TurnoCuadrilla c")
public class TurnoCuadrilla {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_turnocuadrilla")
    private Integer idTurnoCuadrilla;

    @Column(name="estado")
    private String estado;

    //bi-directional many-to-one association to Cuadrilla
    @ManyToOne
    @JoinColumn(name="id_cuadrilla")
    private Cuadrilla cuadrilla;

    //bi-directional many-to-one association to TurnoTrabajo
    @ManyToOne
    @JoinColumn(name="id_turnotrabajo")
    private Turnotrabajo turnotrabajo;

    public TurnoCuadrilla(String estado) {
        this.estado = estado;
    }

    public TurnoCuadrilla() {
    }

    public Integer getIdTurnoCuadrilla() {
        return idTurnoCuadrilla;
    }

    public void setIdTurnoCuadrilla(Integer idTurnoCuadrilla) {
        this.idTurnoCuadrilla = idTurnoCuadrilla;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cuadrilla getCuadrilla() {
        return cuadrilla;
    }

    public void setCuadrilla(Cuadrilla cuadrilla) {
        this.cuadrilla = cuadrilla;
    }

    public Turnotrabajo getTurnotrabajo() {
        return turnotrabajo;
    }

    public void setTurnotrabajo(Turnotrabajo turnotrabajo) {
        this.turnotrabajo = turnotrabajo;
    }
}
