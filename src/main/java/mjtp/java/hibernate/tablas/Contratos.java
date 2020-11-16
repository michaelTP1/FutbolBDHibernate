package mjtp.java.hibernate.tablas;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
@Table(name = "contratos")
public class Contratos implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codContrato;

	
	@ManyToOne
	@JoinColumn(name="coddnionie")
	private Futbolistas futbolista;

	@ManyToOne
	@JoinColumn(name="codEquipo")
	private Equipos equipo;
	

	@Temporal(TemporalType.DATE)
	private Date fechaInicio;
	
	@Temporal(TemporalType.DATE)
	private Date fechaFin;
	
	private int precioanual;
	private int preciorecision;
	
	
	
	
	public int getCodContrato() {
		return codContrato;
	}
	public void setCodContrato(int codContrato) {
		this.codContrato = codContrato;
	}

	
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public int getPrecioanual() {
		return precioanual;
	}
	public void setPrecioanual(int precioanual) {
		this.precioanual = precioanual;
	}
	public int getPreciorecision() {
		return preciorecision;
	}
	public void setPreciorecision(int preciorecision) {
		this.preciorecision = preciorecision;
	}
	
}
