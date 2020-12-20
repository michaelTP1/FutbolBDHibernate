package mjtp.java.hibernate;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import mjtp.java.hibernate.tablas.Contratos;
import mjtp.java.hibernate.tablas.Equipos;
import mjtp.java.hibernate.tablas.EquiposObservaciones;
import mjtp.java.hibernate.tablas.Futbolistas;
import mjtp.java.hibernate.tablas.Ligas;

public class Funciones {

	public static List<Contratos> getContratos() {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();

		Query query = session.createQuery("from Contratos");

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
	
	public static List<Futbolistas> getFutbolistas() {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();

		Query query = session.createQuery("from Futbolistas");

		List<Futbolistas> futbolistas = null;
		futbolistas = query.getResultList();

		transaction.commit();
		session.close();

		return futbolistas;
	}
	
	public static List<Ligas> getLigas() {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();

		Query query = session.createQuery("from Ligas");

		List<Ligas> ligas = null;
		ligas = query.getResultList();

		transaction.commit();
		session.close();

		return ligas;
	}
	


	public static void insertarEquipo(Equipos equipo) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();

		session.save(equipo);

		transaction.commit();
		session.close();
	}
	
	public static void insertarObservacion(EquiposObservaciones observacion) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();

		session.save(observacion);

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

	public static void updateEquipo(Equipos equipo) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();

		session.update(equipo);

		transaction.commit();
		session.close();
	}
	
	public static void updateContrato(Contratos contrato) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();

		session.update(contrato);

		transaction.commit();
		session.close();
	}
	

	public static void verEquipoObservaciones() {
		Session sesion = HibernateUtil.getSessionFactory().openSession();
		sesion.beginTransaction();

//		List<Object[]> resultList = sesion.createQuery("from Equipos e join e.equiposobservaciones").getResultList();
//		List<Object[]> results = resultList;
//		
//		for(Object[] result:results) {
//			System.out.println(((Equipos)result[0]).getDatos()+" "+((EquiposObservaciones)result[1]).getObsevaciones());
//		}
//		
		org.hibernate.Query cons = sesion.createQuery("from Equipos e inner join e.equiposobservaciones ");
		Iterator q = ( cons).iterate();
		while (q.hasNext()) {
		Object[] par =(Object[]) q.next();
		Equipos eq = (Equipos) par[0];
		EquiposObservaciones ob = (EquiposObservaciones) par[1];
		System. out. println (eq.getDatos()+" "+ob.getObsevaciones()); 
		}
		sesion.getTransaction().commit();
		sesion.close();
	}
	

	public static void verEquipoContratos() {
		Session sesion = HibernateUtil.getSessionFactory().openSession();
		sesion.beginTransaction();
		org.hibernate.Query cons = sesion.createQuery("from Equipos e inner join e.contratos ");
		Iterator q = ( cons).iterate();
		System.out.println();
		System.out.println();
		while (q.hasNext()) {
		Object[] par =(Object[]) q.next();
		Equipos eq = (Equipos) par[0];
		Contratos con = (Contratos) par[1];
		
		System.out.println("-------------------------------------------------------------------------");
		System. out. println (eq.getDatos()+" "+con.getDatos()); 
		}
		
		sesion.getTransaction().commit();
		sesion.close();
	
	}
	
}
