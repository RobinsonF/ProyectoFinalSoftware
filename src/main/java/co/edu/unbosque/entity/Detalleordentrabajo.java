package co.edu.unbosque.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the detalleordentrabajo database table.
 * 
 */
@Entity
@NamedQuery(name="Detalleordentrabajo.findAll", query="SELECT d FROM Detalleordentrabajo d")
public class Detalleordentrabajo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_detalle")
	private Integer idDetalle;

	private String estado;

	//bi-directional many-to-one association to Material
	@ManyToOne
	@JoinColumn(name="id_material")
	private Material material;

	//bi-directional many-to-one association to Ordentrabajo
	@ManyToOne
	@JoinColumn(name="id_trabajoorden")
	private Ordentrabajo ordentrabajo;

	public Detalleordentrabajo() {
	}

	public Detalleordentrabajo(String estado) {
		this.estado = estado;
	}

	public Integer getIdDetalle() {
		return this.idDetalle;
	}

	public void setIdDetalle(Integer idDetalle) {
		this.idDetalle = idDetalle;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Material getMaterial() {
		return this.material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public Ordentrabajo getOrdentrabajo() {
		return this.ordentrabajo;
	}

	public void setOrdentrabajo(Ordentrabajo ordentrabajo) {
		this.ordentrabajo = ordentrabajo;
	}

}