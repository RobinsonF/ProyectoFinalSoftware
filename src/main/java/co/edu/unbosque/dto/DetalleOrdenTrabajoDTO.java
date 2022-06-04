package co.edu.unbosque.dto;

public class DetalleOrdenTrabajoDTO {
    private Integer id_detalle;

    private String estado;

    private Integer material;

    private Integer orden;

    public DetalleOrdenTrabajoDTO(Integer id_detalle, String estado) {
        this.id_detalle = id_detalle;
        this.estado = estado;
    }

    public DetalleOrdenTrabajoDTO() {
    }

    public Integer getId_detalle() {
        return id_detalle;
    }

    public void setId_detalle(Integer id_detalle) {
        this.id_detalle = id_detalle;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getMaterial() {
        return material;
    }

    public void setMaterial(Integer material) {
        this.material = material;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }
}
