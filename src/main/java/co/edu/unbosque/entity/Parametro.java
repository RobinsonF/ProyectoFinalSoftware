package co.edu.unbosque.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "parametro")
@NamedQuery(name="Parametro.findAll", query="SELECT p FROM Parametro p")
public class Parametro implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="id_parametro")
    private Integer idParametro;

    @Column(name="descripcion")
    private String descripcion;

    @Column(name="tipo")
    private String tipo;

    @Column(name="valor_int")
    private Integer valor_int;

    @Column(name="valor_char")
    private String valor_char;

    public Parametro(Integer idParametro, String descripcion, String tipo, Integer valor_int, String valor_char) {
        this.idParametro = idParametro;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.valor_int = valor_int;
        this.valor_char = valor_char;
    }

    public Parametro() {

    }

    public Integer getIdParametro() {
        return idParametro;
    }

    public void setIdParametro(Integer idParametro) {
        this.idParametro = idParametro;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getValor_int() {
        return valor_int;
    }

    public void setValor_int(Integer valor_int) {
        this.valor_int = valor_int;
    }

    public String getValor_char() {
        return valor_char;
    }

    public void setValor_char(String valor_char) {
        this.valor_char = valor_char;
    }
}
