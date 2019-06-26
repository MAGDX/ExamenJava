package com.ipartek.formacion.uf2216;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class AppRevistas {
	// Parametros
	private static final int OPCION_CREAR = 1;
	private static final int OPCION_LISTAR = 2;
	private static final int OPCION_EXPORTAR = 3;
	private static final int OPCION_SALIR = 4;
	private static Scanner sc;
	private static DAORevistaArrayList dao = DAORevistaArrayList.getInstance();

	// Main
	public static void main(String[] args) throws RevistaException {
		sc = new Scanner(System.in);
		int op = 0;
		while (op != 4) {
			op = pintarMenu();

			switch (op) {
			case OPCION_CREAR:
				crearRevista();
				break;
			case OPCION_LISTAR:
				mostrarRevistasOrdenadas((ArrayList<Revista>) dao.getAll());
				break;
			case OPCION_EXPORTAR:
				exportarRevistas((ArrayList<Revista>) dao.getAll());
				break;
			case OPCION_SALIR:
				break;
			default:
				System.out.println("Entrada no valida. Vuelva a intentarlo... Rango 1-4");
				break;
			}
		}
		System.out.println("Adios!");
		sc.close();
	} // End Main

	// Funciones

	/**
	 * Metodo que imprime por consola el menu de la aplicación.
	 * 
	 * @return op Opcion escogida por el usuario. Rango 1-4. En caso de que error
	 *         vuelve a pedir opcion.
	 */
	public static int pintarMenu() {
		int op;

		System.out.println("\nMENU:");
		System.out.println("1) Crear revista");
		System.out.println("2) Listar revistas");
		System.out.println("3) Exportar revistas a txt");
		System.out.println("4) Salir");
		try {
			op = Integer.parseInt(sc.nextLine());
		} catch (Exception e) {
			System.out.println("Valor incorrecto. Rango 1-4.");
			op = pintarMenu();
		}
		return op;
	}

	/**
	 * Metodo que crea la revista e inicializa todos sus atributos.
	 */
	public static void crearRevista() {
		Revista revista = new Revista();
		pedirTitulo(revista);
		pedirISBN(revista);
		pedirNPaginas(revista);
		pedirFormato(revista);
		try {
			System.out.println(revista);
			System.out.println("¿Desea guardar esta revista? S/N");
			switch (sc.nextLine().toLowerCase().charAt(0)) {
			case 's':
				dao.insert(revista);
				System.out.println("Revista guardada con exito!");
				break;
			case 'n':
				System.out.println("Revista no guardada.");
				break;
			default:
				throw new Exception();
			}

		} catch (Exception e) {
			System.out.println("Dato no valido. Intentelo de nuevo...");
			crearRevista();
		}
	}

	/**
	 * Metodo que solicita el titulo de la revista por teclado.
	 * 
	 * @param r Revista, Revista a la que se le va a settear el titulo.
	 */
	public static void pedirTitulo(Revista r) {
		System.out.println("Inserte el titulo de la revista: ");
		try {
			r.setTitulo(sc.nextLine());
		} catch (RevistaException e) {
			System.out.println(e.getMessage());
			pedirTitulo(r);
		}
	}

	/**
	 * Metodo que solicita el ISBN de la revista por teclado.
	 * 
	 * @param r Revista, Revista a la que se le va a setter el ISBN.
	 */
	public static void pedirISBN(Revista r) {
		System.out.println("Inserte el ISBN de la revista: ");
		try {
			r.setIsbn(sc.nextLine());
		} catch (RevistaException e) {
			System.out.println(e.getMessage());
			pedirISBN(r);
		}
	}

	/**
	 * Metodo que solicita el número de paginas de la revista por teclado.
	 * 
	 * @param r Revista, Revista a la que se le va a setter el número de paginas.
	 */
	public static void pedirNPaginas(Revista r) {
		System.out.println("Inserte el numero de paginas de la revista: ");
		try {
			r.setnPaginas(Integer.parseInt(sc.nextLine()));
		} catch (NumberFormatException e) {
			System.out.println("Valor no numerico. Intentelo de nuevo...");
			pedirNPaginas(r);
		} catch (RevistaException e) {
			System.out.println(e.getMessage());
			pedirNPaginas(r);
		}
	}

	/**
	 * Metodo que solicita el formato de la revista por teclado.
	 * 
	 * @param r Revista, Revista a la que se le va a setter el formato.
	 */
	public static void pedirFormato(Revista r) {
		System.out.println("Inserte el formato de la revista: (D=Digital/P=Papel)");
		try {
			r.setFormato(sc.nextLine().toLowerCase().charAt(0));
		} catch (RevistaException e) {
			System.out.println(e.getMessage());
			pedirFormato(r);
		}
	}

	/**
	 * Metodo que lista las revistas ordenadas de mayor a menor según su número de
	 * paginas.
	 * 
	 * @param lista ArrayList<Revista>, ArrayList que contiene todas las revistas
	 *              creadas hasta el momento.
	 */
	public static void mostrarRevistasOrdenadas(ArrayList<Revista> lista) {
		Collections.sort(lista);

		System.out.println("Lista de revistas ordenadas por numero de paginas de mayor a menor:");
		for (int i = 0; i < lista.size(); i++) {
			System.out
					.println(i + 1 + ": " + lista.get(i).getTitulo() + " " + lista.get(i).getnPaginas() + " paginas.");
		}
	}

	/**
	 * Metodo que exporta todas las revistas creadas hasta el momento (contenidas en
	 * el arraylist) a un fichero txt.
	 * 
	 * @param lista ArrayList<Revista>, ArrayList que contiene todas las revistas
	 *              creadas hasta el momento.
	 */
	public static void exportarRevistas(ArrayList<Revista> lista) {
		String ficheroRevistas = "C:\\1713\\eclipse-workspace\\ArkaitzMarcosGuerrero\\revistas.txt";
		FileWriter fw;
		BufferedWriter bf;
		try {
			fw = new FileWriter(ficheroRevistas);
			bf = new BufferedWriter(fw);
			for (Revista revista : lista) {
				bf.write(revista.toString());
				;
				bf.newLine();
			}
			bf.close();
			System.out.println("Exportado completado!");
		} catch (IOException e) {
			System.out.println("Error al exportar!");
		}
	}
}