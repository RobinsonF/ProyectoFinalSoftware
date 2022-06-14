package co.edu.unbosque.dto;


public class ZonaDTO {
    private Integer idZona;

    private String estado;

    private String nombre;

    private String nombreCiudad;

    private String limiteNorte;

    private String limiteOccidente;

    private String limiteOriente;

    private String limiteSur;

    private Integer id_ciudad;


    private Integer numeroOrdenes;

    public ZonaDTO() {
    }

    public ZonaDTO(Integer idZona, String estado, String limiteNorte, String limiteOccidente, String limiteOriente, String limiteSur) {
        this.idZona = idZona;
        this.estado = estado;
        this.limiteNorte = limiteNorte;
        this.limiteOccidente = limiteOccidente;
        this.limiteOriente = limiteOriente;
        this.limiteSur = limiteSur;
    }

    public ZonaDTO(String nombre, String limiteNorte, String limiteOccidente, String limiteOriente, String limiteSur) {
        this.nombre = nombre;
        this.limiteNorte = limiteNorte;
        this.limiteOccidente = limiteOccidente;
        this.limiteOriente = limiteOriente;
        this.limiteSur = limiteSur;
    }

    public ZonaDTO(Integer idZona, String nombre, String nombreCiudad, String limiteNorte, String limiteOccidente, String limiteOriente, String limiteSur, Integer numeroOrdenes) {
        this.idZona = idZona;
        this.nombre = nombre;
        this.nombreCiudad = nombreCiudad;
        this.limiteNorte = limiteNorte;
        this.limiteOccidente = limiteOccidente;
        this.limiteOriente = limiteOriente;
        this.limiteSur = limiteSur;
        this.numeroOrdenes = numeroOrdenes;
    }

    public Integer getIdZona() {
        return idZona;
    }

    public void setIdZona(Integer idZona) {
        this.idZona = idZona;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getLimiteNorte() {
        return limiteNorte;
    }

    public void setLimiteNorte(String limiteNorte) {
        this.limiteNorte = limiteNorte;
    }

    public String getLimiteOccidente() {
        return limiteOccidente;
    }

    public void setLimiteOccidente(String limiteOccidente) {
        this.limiteOccidente = limiteOccidente;
    }

    public String getLimiteOriente() {
        return limiteOriente;
    }

    public void setLimiteOriente(String limiteOriente) {
        this.limiteOriente = limiteOriente;
    }

    public String getLimiteSur() {
        return limiteSur;
    }

    public void setLimiteSur(String limiteSur) {
        this.limiteSur = limiteSur;
    }

    public Integer getId_ciudad() {
        return id_ciudad;
    }

    public void setId_ciudad(Integer id_ciudad) {
        this.id_ciudad = id_ciudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public Integer getNumeroOrdenes() {
        return numeroOrdenes;
    }

    public void setNumeroOrdenes(Integer numeroOrdenes) {
        this.numeroOrdenes = numeroOrdenes;
    }
}
