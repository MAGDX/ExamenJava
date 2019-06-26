package com.ipartek.formacion.uf2216;

/**
 * 
 * @author Arkaitz Marcos
 *
 *         Excepcion personalizada para el POJO Revista
 *
 */

@SuppressWarnings("serial")
public class RevistaException extends Exception {
	
	public static final String ERROR_TITULO = "La longitud del titulo debe ser minimo 3 y maximo 150.";
	public static final String ERROR_ISBN = "La longitud del ISBN debe ser 10";
	public static final String ERROR_NPAGINAS = "El numero de paginas debe ser minimo 1.";
	public static final String ERROR_FORMATO = "El formato debe de ser digital (d) o en papel (p).";

	public RevistaException(String error) {
		super(error);
	}
}