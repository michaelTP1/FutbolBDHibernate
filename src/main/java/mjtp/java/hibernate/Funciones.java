package mjtp.java.hibernate;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import mjtp.java.hibernate.tablas.Contratos;
import mjtp.java.hibernate.tablas.Equipos;
import mjtp.java.hibernate.tablas.Futbolistas;
import mjtp.java.hibernate.tablas.Ligas;

public class Funciones {

	public static List<Contratos> getContratos() {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();

		Query query = session.createQuery("from contratos");

		List<Contratos> contratos = null;
		contratos = query.getResultList();

		transaction.commit();
		session.close();

		return contratos;
	}
	public static List<Equipos> getEquipos() {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();

		Query query = session.createQuery("from Equipos");

		List<Equipos> equipos = null;
		equipos = query.getResultList();

		transaction.commit();
		session.close();

		return equipos;
	}
	

	public static void insertarEquipo(Equipos equipo) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();

		session.save(equipo);

		transaction.commit();
		session.close();
	}
	public static void insertarLiga(Ligas liga) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();

		session.save(liga);

		transaction.commit();
		session.close();
	}
	public static void insertarFutbolista(Futbolistas futbolista) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();

		session.save(futbolista);

		transaction.commit();
		session.close();
	}

	public static void insertarContratos(Contratos contrato) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();

		session.save(contrato);

		transaction.commit();
		session.close();
	}
	public static void borrarEquipo(int id) {
		Session sesion = HibernateUtil.getSessionFactory().openSession();
		sesion.beginTransaction();
		Equipos equipo= sesion.find(Equipos.class, id);
		equipo.getContratos().clear();
	
		sesion.close();
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction transasction = session.beginTransaction();
		
		session.delete(equipo);
	
		
		transasction.commit();
		session.close();
	}
		
	public static void borrarContrato(int id) {
		Session sesion = HibernateUtil.getSessionFactory().openSession();
		sesion.beginTransaction();
		Contratos contrato= sesion.find(Contratos.class, id);
		sesion.close();
	
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction transasction = session.beginTransaction();
		
		session.remove(contrato);
		
		transasction.commit();
		session.close();
	}


	public static void verEquipoObservaciones() {
		Session sesion = HibernateUtil.getSessionFactory().openSession();
		sesion.beginTransaction();
		String sel = "SELECT e.codEquipo, e.nomEquipo, e.internacional, e.localidad, eo.obsevaciones from Equipos as e  LEFT JOIN EquiposObservaciones as eo ON e.codEquipo= eo.codEquipo";
		List<Object[]> results = sesion.createQuery(sel).getResultList();
			System.out.println();
		for (Object[] result : results) {
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println(result[0]+" "+result[1]+" "+result[2]+" "+result[3]+" "+result[4]+"\n");
			System.out.println("--------------------------------------------------------------------------------");
		}
		sesion.getTransaction().commit();
		sesion.close();
	
	}
	

	public static void verEquipoContratos() {
		Session sesion = HibernateUtil.getSessionFactory().openSession();
		sesion.beginTransaction();
		String sel = "SELECT e.codEquipo, e.nomEquipo, e.internacional, e.localidad, c.obsevaciones from Equipos as e   JOIN Contratos as c ON e.codEquipo= eo.codEquipo";
		List<Object[]> results = sesion.createQuery(sel).getResultList();
			System.out.println();
		for (Object[] result : results) {
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println(result[0]+" "+result[1]+" "+result[2]+" "+result[3]+" "+result[4]+"\n");
			System.out.println("--------------------------------------------------------------------------------");
		}
		sesion.getTransaction().commit();
		sesion.close();
	
	}
	
}
