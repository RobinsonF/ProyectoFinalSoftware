package co.edu.unbosque.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ordentrabajo database table.
 * 
 */
@Entity
@NamedQuery(name="Ordentrabajo.findAll", query="SELECT o FROM Ordentrabajo o")
public class Ordentrabajo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_trabajo")
	private Integer idTrabajo;

	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_trabajof")
	private Date fechaTrabajof;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_trabajoi")
	private Date fechaTrabajoi;

	@Column(name="nombre_trabajo")
	private String nombreTrabajo;

	//bi-directional many-to-one association to Detalleordentrabajo
	@OneToMany(mappedBy="ordentrabajo")
	private List<Detalleordentrabajo> detalleordentrabajos;

	//bi-directional many-to-one association to Cuadrilla
	@ManyToOne
	@JoinColumn(name="id_cuadrilla")
	private Cuadrilla cuadrilla;

	//bi-directional many-to-one association to Zona
	@ManyToOne
	@JoinColumn(name="id_zona")
	private Zona zona;

	public Ordentrabajo() {
	}

	public Ordentrabajo(String estado, Date fechaTrabajof, Date fechaTrabajoi, String nombreTrabajo) {
		this.estado = estado;
		this.fechaTrabajof = fechaTrabajof;
		this.fechaTrabajoi = fechaTrabajoi;
		this.nombreTrabajo = nombreTrabajo;
	}

	public Integer getIdTrabajo() {
		return this.idTrabajo;
	}

	public void setIdTrabajo(Integer idTrabajo) {
		this.idTrabajo = idTrabajo;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaTrabajof() {
		return this.fechaTrabajof;
	}

	public void setFechaTrabajof(Date fechaTrabajof) {
		this.fechaTrabajof = fechaTrabajof;
	}

	public Date getFechaTrabajoi() {
		return this.fechaTrabajoi;
	}

	public void setFechaTrabajoi(Date fechaTrabajoi) {
		this.fechaTrabajoi = fechaTrabajoi;
	}

	public String getNombreTrabajo() {
		return this.nombreTrabajo;
	}

	public void setNombreTrabajo(String nombreTrabajo) {
		this.nombreTrabajo = nombreTrabajo;
	}

	public List<Detalleordentrabajo> getDetalleordentrabajos() {
		return this.detalleordentrabajos;
	}

	public void setDetalleordentrabajos(List<Detalleordentrabajo> detalleordentrabajos) {
		this.detalleordentrabajos = detalleordentrabajos;
	}

	public Detalleordentrabajo addDetalleOrdentrabajo(Detalleordentrabajo detalleordentrabajo) {
		getDetalleordentrabajos().add(detalleordentrabajo);
		detalleordentrabajo.setOrdentrabajo(this);

		return detalleordentrabajo;
	}

	public Detalleordentrabajo removeDetalleordentrabajo(Detalleordentrabajo detalleordentrabajo) {
		getDetalleordentrabajos().remove(detalleordentrabajo);
		detalleordentrabajo.setOrdentrabajo(null);

		return detalleordentrabajo;
	}

	public Cuadrilla getCuadrilla() {
		return this.cuadrilla;
	}

	public void setCuadrilla(Cuadrilla cuadrilla) {
		this.cuadrilla = cuadrilla;
	}

	public Zona getZona() {
		return this.zona;
	}

	public void setZona(Zona zona) {
		this.zona = zona;
	}

}