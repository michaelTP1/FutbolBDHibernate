package mjtp.java.hibernate.tablas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@SuppressWarnings("serial")

@Entity
@Table(name = "equipos")
public class Equipos implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codEquipo;
	
	@OneToOne (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn 
	private EquiposObservaciones equiposobservaciones;
	
	@OneToMany(cascade=CascadeType.ALL,
			fetch=FetchType.LAZY, mappedBy="equipo")
			private List<Contratos> contratos = new ArrayList<Contratos>();
	
	@Column(columnDefinition="char(40)")
	private String nomEquipo;
	
	@ManyToOne
	@JoinColumn(name="liga")
	private Ligas liga;
	
	@Column(length = 50)
	private String localidad;
	
	private boolean internacional;

	public int getCodEquipo() {
		return codEquipo;
	}

	public void setCodEquipo(int codEquipo) {
		this.codEquipo = codEquipo;
	}

	public String getNomEquipo() {
		return nomEquipo;
	}

	public void setNomEquipo(String nomEquipo) {
		this.nomEquipo = nomEquipo;
	}

	

	public EquiposObservaciones getEquiposobservaciones() {
		return equiposobservaciones;
	}

	public void setEquiposobservaciones(EquiposObservaciones equiposobservaciones) {
		this.equiposobservaciones = equiposobservaciones;
	}

	public List<Contratos> getContratos() {
		return contratos;
	}

	public void setContratos(List<Contratos> contratos) {
		this.contratos = contratos;
	}

	public Ligas getLiga() {
		return liga;
	}

	public void setLiga(Ligas liga) {
		this.liga = liga;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public boolean isInternacional() {
		return internacional;
	}

	public void setInternacional(boolean internacional) {
		this.internacional = internacional;
	}
	public String getDatos() {
		return "codEquipo: "+ codEquipo+" nombre: "+nomEquipo+" liga: "+liga.getCodLiga()+" localidad: "+localidad+" internacional: "+ internacional;
	}
	public String getDatosObservaciones(){
		return "codEquipo: "+ codEquipo+" nombre: "+nomEquipo+" liga: "+liga.getCodLiga()+" localidad: "+localidad+" internacional: "+ internacional+" Observaciones: "+equiposobservaciones.getObsevaciones();
	}
	
}
