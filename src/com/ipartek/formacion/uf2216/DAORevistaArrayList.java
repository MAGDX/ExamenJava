package com.ipartek.formacion.uf2216;

import java.util.ArrayList;
import java.util.List;

public class DAORevistaArrayList {

	// Parametros
	private static DAORevistaArrayList INSTANCE;
	private ArrayList<Revista> lista;

	/**
	 * Encargado de devolver solo 1 objeto, patron Singleton
	 * 
	 * @return Devuelve la instancia de la clase, en caso de que sea null, la crea.
	 */
	public static synchronized DAORevistaArrayList getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new DAORevistaArrayList();
		}
		return INSTANCE;
	}

	// Constructores
	private DAORevistaArrayList() {
		this.lista = new ArrayList<Revista>();
	}

	// Metodos
	/**
	 * Metodo que devuelve la lista.
	 * 
	 * @return lista, List<Revista>
	 */
	public List<Revista> getAll() {
		return lista;
	}

	/**
	 * Metodo que inserta una Revista en la lista.
	 * 
	 * @param r Revista, Revista a insertar.
	 * @return boolean, devuelve true en caso de que r no sea null y la añade, falso
	 *         en caso contrario.
	 */
	public boolean insert(Revista r) {
		boolean exito;
		if (r == null) {
			exito = false;
		} else {
			lista.add(r);
			exito = true;
		}
		return exito;
	}
}