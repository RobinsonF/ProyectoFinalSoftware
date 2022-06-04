package co.edu.unbosque.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ciudad database table.
 * 
 */
@Entity
@NamedQuery(name="Ciudad.findAll", query="SELECT c FROM Ciudad c")
public class Ciudad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_ciudad")
	private Integer idCiudad;

	private String estado;

	private String nombre;

	//bi-directional many-to-one association to Departamento
	@ManyToOne
	@JoinColumn(name="id_departamento")
	private Departamento departamento;

	//bi-directional many-to-one association to Zona
	@OneToMany(mappedBy="ciudad")
	private List<Zona> zonas;

	public Ciudad() {
	}

	public Ciudad(String estado, String nombre) {
		this.estado = estado;
		this.nombre = nombre;
	}

	public Integer getIdCiudad() {
		return this.idCiudad;
	}

	public void setIdCiudad(Integer idCiudad) {
		this.idCiudad = idCiudad;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Departamento getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<Zona> getZonas() {
		return this.zonas;
	}

	public void setZonas(List<Zona> zonas) {
		this.zonas = zonas;
	}

	public Zona addZona(Zona zona) {
		getZonas().add(zona);
		zona.setCiudad(this);

		return zona;
	}

	public Zona removeZona(Zona zona) {
		getZonas().remove(zona);
		zona.setCiudad(null);

		return zona;
	}

}