package co.edu.unbosque.dto;

public class TurnoCuadrillaDTO {

    private Integer idTurnoCuadrilla;

    private String estado;

    private Integer cuadrilla;

    private Integer turno;

    public TurnoCuadrillaDTO() {
    }

    public TurnoCuadrillaDTO(Integer idTurnoCuadrilla, String estado) {
        this.idTurnoCuadrilla = idTurnoCuadrilla;
        this.estado = estado;
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

    public Integer getCuadrilla() {
        return cuadrilla;
    }

    public void setCuadrilla(Integer cuadrilla) {
        this.cuadrilla = cuadrilla;
    }

    public Integer getTurno() {
        return turno;
    }

    public void setTurno(Integer turno) {
        this.turno = turno;
    }
}
