package co.edu.unbosque.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="tipomaterial")
@NamedQuery(name="TipoMaterial.findAll", query="SELECT m FROM TipoMaterial m")
public class TipoMaterial {
    @Id
    @GeneratedValue
    @Column(name="id_tipoMaterial")
    private Integer idMaterial;

    @Column(name="estado")
    private String estado;

    @Column(name="nombre")
    private String nombre;

    @Column(name="descripcion")
    private String descripcion;

    //bi-directional many-to-one association to material
    @OneToMany(mappedBy="tipomaterial")
    private List<Material> materials;

    public TipoMaterial() {
    }

    public TipoMaterial(String estado, String nombre, String descripcion) {
        this.estado = estado;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Integer getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(Integer idMaterial) {
        this.idMaterial = idMaterial;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(List<Material> materials) {
        this.materials = materials;
    }

    public Material addMaterial(Material material) {
        getMaterials().add(material);
        material.setTipoMaterial(this);

        return material;
    }

    public Material removeMaterial(Material material) {
        getMaterials().remove(material);
        material.setTipoMaterial(null);

        return material;
    }
}
