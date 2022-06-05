package co.edu.unbosque.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the material database table.
 * 
 */
@Entity
@NamedQuery(name="Material.findAll", query="SELECT m FROM Material m")
public class Material implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_material")
	private Integer idMaterial;

	private Integer cantidad;

	private String estado;

	@Column(name="nombre_material")
	private String nombreMaterial;

	//bi-directional many-to-one association to Detalleordentrabajo
	@OneToMany(mappedBy="material")
	private List<Detalleordentrabajo> detalleordentrabajos;

	//bi-directional many-to-one association to Tipomaterial
	@ManyToOne
	@JoinColumn(name="id_tipomaterial")
	private Tipomaterial tipomaterial;

	public Material() {
	}

	public Material(Integer cantidad, String estado, String nombreMaterial) {
		this.cantidad = cantidad;
		this.estado = estado;
		this.nombreMaterial = nombreMaterial;
	}

	public Integer getIdMaterial() {
		return this.idMaterial;
	}

	public void setIdMaterial(Integer idMaterial) {
		this.idMaterial = idMaterial;
	}

	public Integer getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNombreMaterial() {
		return this.nombreMaterial;
	}

	public void setNombreMaterial(String nombreMaterial) {
		this.nombreMaterial = nombreMaterial;
	}

	public List<Detalleordentrabajo> getDetalleordentrabajos() {
		return this.detalleordentrabajos;
	}

	public void setDetalleordentrabajos(List<Detalleordentrabajo> detalleordentrabajos) {
		this.detalleordentrabajos = detalleordentrabajos;
	}

	public Detalleordentrabajo addDetalleOrdentrabajo(Detalleordentrabajo detalleordentrabajo) {
		getDetalleordentrabajos().add(detalleordentrabajo);
		detalleordentrabajo.setMaterial(this);

		return detalleordentrabajo;
	}

	public Detalleordentrabajo removeDetalleordentrabajo(Detalleordentrabajo detalleordentrabajo) {
		getDetalleordentrabajos().remove(detalleordentrabajo);
		detalleordentrabajo.setMaterial(null);

		return detalleordentrabajo;
	}

	public Tipomaterial getTipomaterial() {
		return this.tipomaterial;
	}

	public void setTipomaterial(Tipomaterial tipomaterial) {
		this.tipomaterial = tipomaterial;
	}

}