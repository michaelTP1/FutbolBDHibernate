package mjtp.java.hibernate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

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

		Funciones.insertarLiga(liga1);
		Funciones.insertarLiga(liga2);

		Equipos equipo1 = new Equipos();
		equipo1.getCodEquipo();
		equipo1.setNomEquipo("Real Madrid");
		equipo1.setLiga(liga1);
		equipo1.setLocalidad("Madrid");
		equipo1.setInternacional(true);
		EquiposObservaciones observaciones = new EquiposObservaciones();
		observaciones.setCodEquipo(equipo1.getCodEquipo());
		observaciones.setObsevaciones("Observación de ejemplo1111111");
		equipo1.setEquiposobservaciones(observaciones);
		Funciones.insertarEquipo(equipo1);

		Equipos equipo2 = new Equipos();
		equipo2.getCodEquipo();
		equipo2.setNomEquipo("FC Tenerife");
		equipo2.setLiga(liga2);
		equipo2.setLocalidad("Tenerife");
		equipo2.setInternacional(true);
		EquiposObservaciones observaciones2 = new EquiposObservaciones();
		observaciones2.setCodEquipo(equipo2.getCodEquipo());
		observaciones2.setObsevaciones("Observación de ejemplo 12");
		equipo2.setEquiposobservaciones(observaciones2);

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
		contrato1.setFutbolista(futbolista1);
		contrato1.setFechaInicio(new Date(2002 - 02 - 10));
		contrato1.setFechaFin(new Date(2005 - 02 - 02));
		contrato1.setPrecioanual(425478);
		contrato1.setPreciorecision(12344);

		Contratos contrato2 = new Contratos();
		contrato2.getCodContrato();
		contrato2.setEquipo(equipo2);
		contrato2.setFutbolista(futbolista1);
		contrato2.setFechaInicio(new Date(2012 - 02 - 10));
		contrato2.setFechaFin(new Date(2020 - 02 - 02));
		contrato2.setPrecioanual(45478);
		contrato2.setPreciorecision(32423);

		Funciones.insertarFutbolista(futbolista1);
		Funciones.insertarFutbolista(futbolista2);

		Funciones.insertarEquipo(equipo2);
		Funciones.insertarContratos(contrato1);
		Funciones.insertarContratos(contrato2);
		/*

		Scanner entrada = new Scanner(System.in);
		int valor = 0;
		do {
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("Proyecto hibernate Michael Trujillo");
			System.out.println("0- Visualizar");
			System.out.println("1- insertar");
			System.out.println("2- eliminar");
			System.out.println("3- modificar");
			System.out.println("4- salir");

			valor = entrada.nextInt();

			switch (valor) {
			case 0: {

				// System.out.println(Funciones.getEquipos().get(0).getEquiposobservaciones().getObsevaciones());

				System.out.println("0- mostrar contratos");
				System.out.println("1- mostrar equipos");
				System.out.println("2- mostrar equipos y observaciones");
				System.out.println("3- mostrar equipo contratos");

				int valor2 = entrada.nextInt();

				switch (valor2) {
				case 0: {
					for (Contratos contrato : Funciones.getContratos()) {
						System.out.println("------------------------------------------");
						System.out.println(contrato.getDatos());

					}
					break;
				}
				case 1: {
					for (Equipos equipo : Funciones.getEquipos()) {
						System.out.println("------------------------------------------");

						System.out.println(equipo.getDatos());

					}
					break;
				}
				case 2: {
					Funciones.verEquipoObservaciones();
					break;
				}
				case 3: {
					Funciones.verEquipoContratos();
				}

				}
				break;
			}

			case 1: {

				System.out.println();
				System.out.println("0- insertar contrato");
				System.out.println("1- insertar equipo");

				int valor2 = entrada.nextInt();
				switch (valor2) {
				case 0: {
					Contratos contrato = new Contratos();
					List<Futbolistas> futbolistas = Funciones.getFutbolistas();
					List<Equipos> equipos = Funciones.getEquipos();
					int futbolistaIndex = 0;
					int equipoIndex = 0;
					int aux = 0;
					String fechaInicio = "";
					String fechaFin = "";

					System.out.println();
					System.out.println("seleccione un futbolista de la siguiente lista");

					for (Futbolistas futbolista : futbolistas) {

						System.out.println("------------------------------------------");
						System.out.println(aux + "- " + futbolista.getNombre());
						aux++;
					}
					futbolistaIndex = entrada.nextInt();
					contrato.setFutbolista(futbolistas.get(futbolistaIndex));
					System.out.println("seleccione un equipo de la siguiente lista");
					aux = 0;
					for (Equipos equipo : equipos) {
						System.out.println("------------------------------------------");

						System.out.println(aux + "- " + equipo.getDatos());
						aux++;
					}
					equipoIndex = entrada.nextInt();
					entrada.nextLine();
					System.out.println("Fecha de inicio dd/mm/yyyy");
					fechaInicio = entrada.nextLine();
					while (true) {
						try {

							contrato.setFechaInicio(new SimpleDateFormat("dd/mm/yyyy").parse(fechaInicio));
							break;

						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();

						}
					}
					contrato.setEquipo(equipos.get(equipoIndex));
					System.out.println();
					System.out.println("Fecha fin dd/mm/yyyy");
					fechaFin = entrada.nextLine();
					while (true) {
						try {

							contrato.setFechaFin(new SimpleDateFormat("dd/mm/yyyy").parse(fechaFin));
							break;

						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();

						}
					}
					System.out.println();
					System.out.println("precio anual");
					contrato.setPrecioanual(entrada.nextInt());
					System.out.println();
					System.out.println("precio recision");
					contrato.setPreciorecision(entrada.nextInt());

					Funciones.insertarContratos(contrato);
					break;
				}

				case 1: {
					Equipos equipo = new Equipos();
					List<Ligas> ligas = Funciones.getLigas();
					int aux = 0;
					int ligaIndex = 0;
					System.out.println("Seleccione una de las siguientes ligas");
					for (Ligas liga : ligas) {

						System.out.println("------------------------------------------");
						System.out.println(aux + "- " + liga.getNomLiga());
						aux++;
					}
					ligaIndex = entrada.nextInt();
					equipo.setLiga(ligas.get(ligaIndex));
					entrada.nextLine();

					System.out.println("Nombre del equipo:");
					equipo.setNomEquipo(entrada.nextLine());
					System.out.println("localidad:");
					equipo.setLocalidad(entrada.nextLine());
					System.out.println("0 si es internacional");
					boolean internacional = (entrada.nextInt() == 0) ? true : false;
					equipo.setInternacional(internacional);
					entrada.nextLine();

					System.out.println("Pulse 0 para añadir observaciones");

					boolean ob = (entrada.nextInt() == 0) ? true : false;
					entrada.nextLine();
					if (ob) {
						EquiposObservaciones observacion = new EquiposObservaciones();
						observaciones.setCodEquipo(Funciones.getEquipos().size());
						System.out.println("Escriba la observación");
						observacion.setObsevaciones(entrada.nextLine());

						equipo.setEquiposobservaciones(observacion);
					}

					Funciones.insertarEquipo(equipo);

					break;
				}
				}

				break;
			}
			case 2: {
				System.out.println("0- eliminar equipo");
				System.out.println("1- eliminar contrato");
				int valor2 = entrada.nextInt();
				entrada.nextLine();
				switch (valor2) {
				case 0: {
					System.out.println("introduzca el identificador del equipo a borrar");
					try {
						Funciones.borrarEquipo(entrada.nextInt());
					} catch (Exception e) {
						System.err.println("identificador no existente");
					}

					break;
				}
				case 1: {
					System.out.println("introduzca el identificador del contrato a borrar");
					try {
						Funciones.borrarContrato(entrada.nextInt());
					} catch (Exception e) {
						System.err.println("identificador no existente");
					}
					break;

				}

				}

				break;
			}
			case 3: {

				int valor3 = 0;
				System.out.println("0- actualizar equipo");
				System.out.println("1- actualizar contrato");
				valor3 = entrada.nextInt();
				entrada.nextLine();

				switch (valor3) {
				case 0: {
					List<Equipos> equipos = Funciones.getEquipos();
					Equipos equipoIn = new Equipos();
					int aux = 0;
					int equipoIndex = 0;
					System.out.println("seleccione un equipo de la siguiente lista");
					aux = 0;
					for (Equipos equipo : equipos) {
						System.out.println("------------------------------------------");

						System.out.println(aux + "- " + equipo.getDatos());
						aux++;
					}
					equipoIndex = entrada.nextInt();
					entrada.nextLine();

					equipoIn = equipos.get(equipoIndex);
					System.out.println("Introduzca \"9\" para no modificar el campo");
					List<Ligas> ligas = Funciones.getLigas();
					aux = 0;
					int ligaIndex = 0;
					System.out.println("Seleccione una de las siguientes ligas");
					for (Ligas liga : ligas) {

						System.out.println("------------------------------------------");
						System.out.println(aux + "- " + liga.getNomLiga());
						aux++;
					}
					ligaIndex = entrada.nextInt();
					equipoIn.setLiga(ligas.get(ligaIndex));
					entrada.nextLine();

					System.out.println("Nombre del equipo:");
					String auxString = entrada.nextLine();
					if (auxString.compareTo("9") != 0)
						equipoIn.setNomEquipo(auxString);
					System.out.println("localidad:");
					auxString = entrada.nextLine();
					if (auxString.compareTo("9") != 0)
						equipoIn.setLocalidad(auxString);

					System.out.println("0 si es internacional");

					boolean internacional = (entrada.nextInt() == 0) ? true : false;
					equipoIn.setInternacional(internacional);
					entrada.nextLine();

					System.out.println("Pulse 0 para añadir observaciones");

					try {
						boolean ob = (entrada.nextInt() == 0) ? true : false;
						entrada.nextLine();
						if (ob) {
							EquiposObservaciones observacion = new EquiposObservaciones();
							observaciones.setCodEquipo(Funciones.getEquipos().size());
							System.out.println("Escriba la observación");
							observacion.setObsevaciones(entrada.nextLine());

							equipoIn.setEquiposobservaciones(observacion);
						}
					} catch (Exception e) {
						entrada.nextLine();
					}

					Funciones.updateEquipo(equipoIn);

					break;
				}
				case 1: {
					List<Contratos> contratos = Funciones.getContratos();
					Contratos contrato = new Contratos();

					int aux = 0;
					int contratoIndex = 0;
					System.out.println("Seleccione uno de los siguientes contratos");
					for (Contratos contratoIn : contratos) {

						System.out.println("------------------------------------------");
						System.out.println(aux + "- " + contratoIn.getDatos());
						aux++;
					}
					contratoIndex = entrada.nextInt();
					entrada.nextLine();
					contrato = contratos.get(contratoIndex);

					List<Futbolistas> futbolistas = Funciones.getFutbolistas();
					List<Equipos> equipos = Funciones.getEquipos();
					int futbolistaIndex = 0;
					int equipoIndex = 0;
					aux = 0;
					String fechaInicio = "";
					String fechaFin = "";
					String auxString;

					System.out.println("Introduzca \"9\" para no modificar futbolista");
					auxString = entrada.nextLine();
					if (0 != auxString.compareTo("9")) {
						System.out.println("seleccione un futbolista de la siguiente lista");

						for (Futbolistas futbolista : futbolistas) {

							System.out.println("------------------------------------------");
							System.out.println(aux + "- " + futbolista.getNombre());
							aux++;
						}
						futbolistaIndex = entrada.nextInt();
						contrato.setFutbolista(futbolistas.get(futbolistaIndex));
						entrada.nextLine();
					}
					System.out.println("Introduzca \"9\" para no modificar equipo");
					auxString = entrada.nextLine();
					if (0 != auxString.compareTo("9")) {
						System.out.println("seleccione un equipo de la siguiente lista");
						aux = 0;
						for (Equipos equipo : equipos) {
							System.out.println("------------------------------------------");

							System.out.println(aux + "- " + equipo.getDatos());
							aux++;
						}
						equipoIndex = entrada.nextInt();
						entrada.nextLine();
						contrato.setEquipo(equipos.get(equipoIndex));
						entrada.nextLine();
					}
					System.out.println("Introduzca \"9\" para no modificar fecha inicio");
					auxString = entrada.nextLine();
					if (0 != auxString.compareTo("9")) {
						System.out.println("Fecha de inicio dd/mm/yyyy");
						fechaInicio = entrada.nextLine();
						while (true) {
							try {

								contrato.setFechaInicio(new SimpleDateFormat("dd/mm/yyyy").parse(fechaInicio));
								break;

							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();

							}
						}
					}

					System.out.println();
					System.out.println("Introduzca \"9\" para no modificar fecha fin");
					auxString = entrada.nextLine();
					if (0 != auxString.compareTo("9")) {
						System.out.println("Fecha fin dd/mm/yyyy");
						fechaFin = entrada.nextLine();
						while (true) {
							try {

								contrato.setFechaFin(new SimpleDateFormat("dd/mm/yyyy").parse(fechaFin));
								break;

							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();

							}
						}
					}
					System.out.println();
					System.out.println("Introduzca \"9\" para no modificar precio anual");
					auxString = entrada.nextLine();
					if (0 != auxString.compareTo("9")) {
						System.out.println("precio anual");
						contrato.setPrecioanual(entrada.nextInt());
						entrada.nextLine();
					}
					System.out.println();
					System.out.println("Introduzca \"9\" para no modificar precio recicion");
					auxString = entrada.nextLine();
					if (0 != auxString.compareTo("9")) {
						System.out.println("precio recision");
						contrato.setPreciorecision(entrada.nextInt());
						entrada.nextLine();
					}
					Funciones.updateContrato(contrato);
					break;

				}
				}

				break;
			}
			}
		} while (valor != 4);
*/
		
		Funciones.verContratosFutbolistas();
	}
}
