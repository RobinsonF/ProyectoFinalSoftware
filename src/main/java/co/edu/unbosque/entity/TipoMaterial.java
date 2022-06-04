package co.edu.unbosque.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipomaterial database table.
 * 
 */
@Entity
@NamedQuery(name="Tipomaterial.findAll", query="SELECT t FROM TipoMaterial t")
public class TipoMaterial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_tipomaterial")
	private Integer idTipomaterial;

	private String descripcion;

	private String estado;

	private String nombre;

	//bi-directional many-to-one association to Material
	@OneToMany(mappedBy="tipomaterial")
	private List<Material> materials;

	public TipoMaterial() {
	}

	public TipoMaterial(String estado, String nombre, String descripcion) {
		this.descripcion = descripcion;
		this.estado = estado;
		this.nombre = nombre;
	}

	public Integer getIdTipoMaterial() {
		return this.idTipomaterial;
	}

	public void setIdTipomaterial(Integer idTipomaterial) {
		this.idTipomaterial = idTipomaterial;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	public List<Material> getMaterials() {
		return this.materials;
	}

	public void setMaterials(List<Material> materials) {
		this.materials = materials;
	}

	public Material addMaterial(Material material) {
		getMaterials().add(material);
		material.setTipomaterial(this);

		return material;
	}

	public Material removeMaterial(Material material) {
		getMaterials().remove(material);
		material.setTipomaterial(null);

		return material;
	}

}