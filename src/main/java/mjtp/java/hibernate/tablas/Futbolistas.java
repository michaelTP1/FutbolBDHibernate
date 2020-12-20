package mjtp.java.hibernate.tablas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.CascadeType;

@SuppressWarnings("serial")
@Entity

@Table(name = "futbolistas")
public class Futbolistas implements Serializable {
	
	@Id
	@Column(columnDefinition = "char(9)")
	private String coddnionie;

	@Column(length=50)
	private String nombre;
	
	@Column(length=40)
	private String nacionalidad;

	public List<Contratos> getContratos() {
		return contratos;
	}

	public void setContratos(List<Contratos> contratos) {
		this.contratos = contratos;
	}

	@OneToMany(cascade=CascadeType.ALL,	fetch=FetchType.EAGER, mappedBy="futbolista")
			private List<Contratos> contratos = new ArrayList<Contratos>();
	
	public String getCoddnionie() {
		return coddnionie;
	}

	public void setCoddnionie(String coddnionie) {
		this.coddnionie = coddnionie;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

}
