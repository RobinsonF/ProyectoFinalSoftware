package co.edu.unbosque.dto;



public class TurnoTrabajoDTO {
    private Integer idTurnotrabajo;

    private String estado;

    private String nombre;

    public TurnoTrabajoDTO() {
    }

    public TurnoTrabajoDTO(Integer idTurnotrabajo, String estado, String nombre) {
        this.idTurnotrabajo = idTurnotrabajo;
        this.estado = estado;
        this.nombre = nombre;
    }

    public Integer getIdTurnotrabajo() {
        return idTurnotrabajo;
    }

    public void setIdTurnotrabajo(Integer idTurnotrabajo) {
        this.idTurnotrabajo = idTurnotrabajo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
