package co.edu.unbosque.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the parametro database table.
 * 
 */
@Entity
@NamedQuery(name="Parametro.findAll", query="SELECT p FROM Parametro p")
public class Parametro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_parametro")
	private Integer idParametro;

	private String descripcion;

	private String tipo;

	@Column(name="valor_char")
	private String valorChar;

	@Column(name="valor_int")
	private Integer valorInt;

	public Parametro() {
	}

	public Integer getIdParametro() {
		return this.idParametro;
	}

	public void setIdParametro(Integer idParametro) {
		this.idParametro = idParametro;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getValorChar() {
		return this.valorChar;
	}

	public void setValorChar(String valorChar) {
		this.valorChar = valorChar;
	}

	public Integer getValorInt() {
		return this.valorInt;
	}

	public void setValorInt(Integer valorInt) {
		this.valorInt = valorInt;
	}

}