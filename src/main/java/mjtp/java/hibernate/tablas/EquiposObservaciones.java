package mjtp.java.hibernate.tablas;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@SuppressWarnings("serial")

@Entity
@Table(name = "equiposobservaciones")
public class EquiposObservaciones implements Serializable{
	

	@Id
	@GeneratedValue(generator = "myForeign")
	@GenericGenerator( name = "myForeign", strategy = "foreign",
	parameters = {@org.hibernate.annotations.Parameter(name = "property", value = "equipo")})
	private int codEquipo;
	
	@OneToOne (cascade={CascadeType.PERSIST,CascadeType.REMOVE}) 
	@PrimaryKeyJoinColumn
	private Equipos equipo;
	
	
	@Column(length=200)
	private String obsevaciones;

	public int getCodEquipo() {
		return codEquipo;
	}

	public void setCodEquipo(int codEquipo) {
		this.codEquipo = codEquipo;
	}

	public String getObsevaciones() {
		return obsevaciones;
	}

	public void setObsevaciones(String obsevaciones) {
		this.obsevaciones = obsevaciones;
	}
	
	
}
