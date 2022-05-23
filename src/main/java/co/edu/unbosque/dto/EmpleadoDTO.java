package co.edu.unbosque.dto;


public class EmpleadoDTO {

    private Integer idEmpleado;

    private String apellido;

    private String cedula;

    private String estado;

    private String nombre;

    private Integer id_cuadrilla;

    public EmpleadoDTO(Integer idEmpleado, String apellido, String cedula, String estado, String nombre) {
        this.idEmpleado = idEmpleado;
        this.apellido = apellido;
        this.cedula = cedula;
        this.estado = estado;
        this.nombre = nombre;
    }

    public EmpleadoDTO() {
    }

    public Integer getId_cuadrilla() {
        return id_cuadrilla;
    }

    public void setId_cuadrilla(Integer id_cuadrilla) {
        this.id_cuadrilla = id_cuadrilla;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
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
