package mjtp.java.hibernate.tablas;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name ="empleado")
public class Empleado implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codEmpleado;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="empresa_empleado",
			joinColumns = {@JoinColumn( name="codEmpleado")},
			inverseJoinColumns = {@JoinColumn(name="codEmpresa")}
			)
	private List<Empresa> empresas;

}
