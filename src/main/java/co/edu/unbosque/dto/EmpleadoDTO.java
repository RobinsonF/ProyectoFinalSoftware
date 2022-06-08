package co.edu.unbosque.dto;


public class EmpleadoDTO {

    private Integer idEmpleado;

    private String apellido;

    private String cedula;

    private String estado;

    private String nombre;

    private String nombreCuadrilla;

    private Integer id_cuadrilla;

    public EmpleadoDTO(Integer idEmpleado, String apellido, String cedula, String estado, String nombre, String nombreCuadrilla) {
        this.idEmpleado = idEmpleado;
        this.apellido = apellido;
        this.cedula = cedula;
        this.estado = estado;
        this.nombre = nombre;
        this.nombreCuadrilla = nombreCuadrilla;
    }

    public EmpleadoDTO(Integer idEmpleado, String nombre, String apellido, String cedula, String nombreCuadrilla) {
        this.idEmpleado = idEmpleado;
        this.apellido = apellido;
        this.cedula = cedula;
        this.nombre = nombre;
        this.nombreCuadrilla = nombreCuadrilla;
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

    public String getNombreCuadrilla() {
        return nombreCuadrilla;
    }

    public void setNombreCuadrilla(String nombreCuadrilla) {
        this.nombreCuadrilla = nombreCuadrilla;
    }
}
