package co.edu.unbosque.dto;

public class TipoMaterialDTO {

    private Integer idTipoMaterial;

    private String estado;

    private String nombre;

    private String descripcion;

    public TipoMaterialDTO(Integer idTipoMaterial, String estado, String nombre, String descripcion) {
        this.idTipoMaterial = idTipoMaterial;
        this.estado = estado;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public TipoMaterialDTO() {
    }

    public Integer getIdTipoMaterial() {
        return idTipoMaterial;
    }

    public void setIdTipoMaterial(Integer idTipoMaterial) {
        this.idTipoMaterial = idTipoMaterial;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
