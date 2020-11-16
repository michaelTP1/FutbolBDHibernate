package mjtp.java.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;


public class Main {

	public static void main(String[] args) {
		Session sesion = HibernateUtil.getSessionFactory().openSession();
		
		sesion.beginTransaction();
		
		
		
		sesion.close();
	}

}
