package mjtp.java.hibernate;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import mjtp.java.hibernate.tablas.Contratos;
import mjtp.java.hibernate.tablas.Equipos;
import mjtp.java.hibernate.tablas.EquiposObservaciones;
import mjtp.java.hibernate.tablas.Futbolistas;
import mjtp.java.hibernate.tablas.Ligas;



public class Main {

	public static void main(String[] args) {
		

		Ligas liga1 = new Ligas();
		liga1.setCodLiga("LL1");
		liga1.setNomLiga("LaLiga1");
	

		Ligas liga2 = new Ligas();
		liga2.setCodLiga("LL2");
		liga2.setNomLiga("LaLiga2");
	

		Equipos equipo1 = new Equipos();
		equipo1.getCodEquipo();
		equipo1.setNomEquipo("Real Madrid");
		equipo1.setLiga(liga1);
		equipo1.setLocalidad("Madrid");
		equipo1.setInternacional(true);
		

		Equipos equipo2 = new Equipos();
		equipo2.getCodEquipo();
		equipo2.setNomEquipo("FC Tenerife");
		equipo2.setLiga(liga2);
		equipo2.setLocalidad("Tenerife");
		equipo2.setInternacional(true);
		

		Futbolistas futbolista1 = new Futbolistas();
		futbolista1.setCoddnionie("12345678W");
		futbolista1.setNombre("Cristiano Ronaldo");
		futbolista1.setNacionalidad("Portuguesa");
		

		Futbolistas futbolista2 = new Futbolistas();
		futbolista2.setCoddnionie("11111111W");
		futbolista2.setNombre("Leo Messi");
		futbolista2.setNacionalidad("Argentino");
	

		Contratos contrato1 = new Contratos();
		contrato1.getCodContrato();
		contrato1.setEquipo(equipo1);
		contrato1.setFechaInicio(new Date(2002 - 02 - 10));
		contrato1.setFechaFin(new Date(2005 - 02 - 02));
		contrato1.setPrecioanual(425478);
		contrato1.setPreciorecision(12344);


		Funciones.insertarLiga(liga1);
		Funciones.insertarLiga(liga2);
		Funciones.insertarFutbolista(futbolista1);
		Funciones.insertarFutbolista(futbolista2);
		Funciones.insertarEquipo(equipo1);
		Funciones.insertarEquipo(equipo2);
		Funciones.insertarContratos(contrato1);
		 
		//
		
		Funciones.borrarContrato(1);
		Funciones.borrarEquipo(1);
		Funciones.getEquipos();
		Funciones.verEquipoObservaciones();
	}

}
