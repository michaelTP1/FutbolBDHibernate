package mjtp.java.hibernate.tablas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.CascadeType;

@SuppressWarnings("serial")
@Entity
@Table(name = "ligas")
public class Ligas implements Serializable {

	@Id
	@Column(columnDefinition = "char(5)")
	private String codLiga;
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER, mappedBy="liga")
			private List<Equipos> libros = new ArrayList<Equipos>();

	@Column(columnDefinition = "char(50)")
	private String nomLiga;

	public String getCodLiga() {
		return codLiga;
	}

	public void setCodLiga(String codLiga) {
		this.codLiga = codLiga;
	}

	public String getNomLiga() {
		return nomLiga;
	}

	public void setNomLiga(String nomLiga) {
		this.nomLiga = nomLiga;
	}
}
