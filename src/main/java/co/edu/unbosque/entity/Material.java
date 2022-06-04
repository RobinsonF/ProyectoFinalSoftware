package co.edu.unbosque.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;


/**
 * The persistent class for the material database table.
 * 
 */
@Entity
@Table(name="material")
@NamedQuery(name="Material.findAll", query="SELECT m FROM Material m")
public class Material implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="id_material")
	private Integer idMaterial;
	@Column(name="cantidad")
	private Integer cantidad;
	@Column(name="estado")
	private String estado;

	@Column(name="nombre_material")
	private String nombreMaterial;

	//bi-directional many-to-one association to Ordentrabajo
	@ManyToOne
	@JoinColumn(name="id_tipo")
	private TipoMaterial tipoMaterial;

	//bi-directional many-to-one association to DetalleOrdenTrabajo
	@OneToMany(mappedBy="material")
	private List<DetalleOrdenTrabajo> detalleOrdenTrabajos;

	public Material() {
	}

	public Material(Integer cantidad, String estado, String nombreMaterial) {
		this.cantidad = cantidad;
		this.estado = estado;
		this.nombreMaterial = nombreMaterial;
	}

	public TipoMaterial getTipoMaterial() {
		return tipoMaterial;
	}

	public void setTipoMaterial(TipoMaterial tipoMaterial) {
		this.tipoMaterial = tipoMaterial;
	}

	public List<DetalleOrdenTrabajo> getDetalleOrdenTrabajos() {
		return detalleOrdenTrabajos;
	}

	public void setDetalleOrdenTrabajos(List<DetalleOrdenTrabajo> detalleOrdenTrabajos) {
		this.detalleOrdenTrabajos = detalleOrdenTrabajos;
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

	public DetalleOrdenTrabajo addDetalleOrdentrabajo(DetalleOrdenTrabajo detalleOrdenTrabajo) {
		getDetalleOrdenTrabajos().add(detalleOrdenTrabajo);
		detalleOrdenTrabajo.setMaterial(this);

		return detalleOrdenTrabajo;
	}

	public DetalleOrdenTrabajo removeDetalleOrdentrabajo(DetalleOrdenTrabajo detalleOrdenTrabajo) {
		getDetalleOrdenTrabajos().remove(detalleOrdenTrabajo);
		detalleOrdenTrabajo.setMaterial(null);

		return detalleOrdenTrabajo;
	}
}