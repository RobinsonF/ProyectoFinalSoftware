package co.edu.unbosque.dto;

public class UsuarioCuadrillaDTO {

    private Integer idUsuarioCuadrilla;

    private String estado;

    private Integer cuadrilla;

    private Integer usuario;

    public UsuarioCuadrillaDTO(Integer idUsuarioCuadrilla, String estado) {
        this.idUsuarioCuadrilla = idUsuarioCuadrilla;
        this.estado = estado;
    }

    public UsuarioCuadrillaDTO() {
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

    public Integer getCuadrilla() {
        return cuadrilla;
    }

    public void setCuadrilla(Integer cuadrilla) {
        this.cuadrilla = cuadrilla;
    }

    public Integer getUsuario() {
        return usuario;
    }

    public void setUsuario(Integer usuario) {
        this.usuario = usuario;
    }
}
