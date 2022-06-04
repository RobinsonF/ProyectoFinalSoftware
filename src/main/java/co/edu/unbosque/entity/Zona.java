package co.edu.unbosque.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the zona database table.
 * 
 */
@Entity
@NamedQuery(name="Zona.findAll", query="SELECT z FROM Zona z")
public class Zona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_zona")
	private Integer idZona;

	private String estado;

	@Column(name="nombre")
	private String nombre;

	@Column(name="limite_norte")
	private String limiteNorte;

	@Column(name="limite_occidente")
	private String limiteOccidente;

	@Column(name="limite_oriente")
	private String limiteOriente;

	@Column(name="limite_sur")
	private String limiteSur;

	//bi-directional many-to-one association to Ordentrabajo
	@OneToMany(mappedBy="zona")
	private List<Ordentrabajo> ordentrabajos;

	//bi-directional many-to-one association to Ciudad
	@ManyToOne
	@JoinColumn(name="id_ciudad")
	private Ciudad ciudad;

	public Zona() {
	}

	public Zona(String nombre, String estado, String limiteNorte, String limiteOccidente, String limiteOriente, String limiteSur) {
		this.estado = estado;
		this.nombre = nombre;
		this.limiteNorte = limiteNorte;
		this.limiteOccidente = limiteOccidente;
		this.limiteOriente = limiteOriente;
		this.limiteSur = limiteSur;
	}

	public Integer getIdZona() {
		return this.idZona;
	}

	public void setIdZona(Integer idZona) {
		this.idZona = idZona;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getLimiteNorte() {
		return this.limiteNorte;
	}

	public void setLimiteNorte(String limiteNorte) {
		this.limiteNorte = limiteNorte;
	}

	public String getLimiteOccidente() {
		return this.limiteOccidente;
	}

	public void setLimiteOccidente(String limiteOccidente) {
		this.limiteOccidente = limiteOccidente;
	}

	public String getLimiteOriente() {
		return this.limiteOriente;
	}

	public void setLimiteOriente(String limiteOriente) {
		this.limiteOriente = limiteOriente;
	}

	public String getLimiteSur() {
		return this.limiteSur;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setLimiteSur(String limiteSur) {
		this.limiteSur = limiteSur;
	}

	public List<Ordentrabajo> getOrdentrabajos() {
		return this.ordentrabajos;
	}

	public void setOrdentrabajos(List<Ordentrabajo> ordentrabajos) {
		this.ordentrabajos = ordentrabajos;
	}

	public Ordentrabajo addOrdentrabajo(Ordentrabajo ordentrabajo) {
		getOrdentrabajos().add(ordentrabajo);
		ordentrabajo.setZona(this);

		return ordentrabajo;
	}

	public Ordentrabajo removeOrdentrabajo(Ordentrabajo ordentrabajo) {
		getOrdentrabajos().remove(ordentrabajo);
		ordentrabajo.setZona(null);

		return ordentrabajo;
	}

	public Ciudad getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

}