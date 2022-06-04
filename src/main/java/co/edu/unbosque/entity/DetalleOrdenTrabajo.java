package co.edu.unbosque.entity;

import javax.persistence.*;

@Entity
@Table(name="detalleordentrabajo")
@NamedQuery(name="DetalleOrdenTrabajo.findAll", query="SELECT c FROM DetalleOrdenTrabajo c")
public class DetalleOrdenTrabajo {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_detalle")
    private Integer idDetalle;

    @Column(name="estado")
    private String estado;

    //bi-directional many-to-one association to OrdenTrabajo
    @ManyToOne
    @JoinColumn(name="id_trabajo")
    private Ordentrabajo ordentrabajo;

    //bi-directional many-to-one association to Material
    @ManyToOne
    @JoinColumn(name="id_material")
    private Material material;

    public DetalleOrdenTrabajo() {
    }

    public DetalleOrdenTrabajo(String estado) {
        this.estado = estado;
    }

    public Integer getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(Integer idDetalle) {
        this.idDetalle = idDetalle;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Ordentrabajo getOrdentrabajo() {
        return ordentrabajo;
    }

    public void setOrdentrabajo(Ordentrabajo ordentrabajo) {
        this.ordentrabajo = ordentrabajo;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }
}
