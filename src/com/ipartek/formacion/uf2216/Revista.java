package com.ipartek.formacion.uf2216;

public class Revista implements Leible, Comparable<Revista> {
	// Parametros
	private static final int TAMANO_MINIMO_TITULO = 3;
	private static final int TAMANO_MAXIMO_TITULO = 150;
	private static final int TAMANO_ISBN = 10;
	private static final int MINIMO_NUMERO_PAGINAS = 1;
	private static final char FORMATO_DIGITAL = 'd';
	private static final char FORMATO_PAPEL = 'p';
	private String titulo; // Titulo de la revista, caracteres minimos 3 maximos 150
	private String isbn; // ISBN de la revista, caracteres requeridos 10
	private int nPaginas; // Numero de paginas de la revista, minimo 1
	private boolean formato; // Formato de la revista, true digital, false papel

	// Constructores
	public Revista() {

	}

	// Getters y Setters
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Metodo que modifica el titulo de la revista si se cumplen los requisitos
	 * necesarios.
	 * 
	 * @see TAMANO_MINIMO_TITULO
	 * @see TAMANO_MAXIMO_TITULO
	 * @param titulo String
	 * @throws RevistaException en caso de que el titulo sea menos que
	 *                          TAMANO_MINIMO_TITULO o mayor que
	 *                          TAMANO_MAXIMO_TITULO
	 */
	public void setTitulo(String titulo) throws RevistaException {
		if (titulo.length() < TAMANO_MINIMO_TITULO || titulo.length() > TAMANO_MAXIMO_TITULO) {
			throw new RevistaException(RevistaException.ERROR_TITULO);
		} else {
			this.titulo = titulo;
		}
	}

	public String getIsbn() {
		return isbn;
	}

	/**
	 * Metodo que modifica el ISBN de la revista si se cumplen los requisitos
	 * necesarios.
	 * 
	 * @see TAMANO_ISBN
	 * @param isbn String
	 * @throws RevistaException en caso de que el tamaño de ISBN no sea igual que
	 *                          TAMANO_ISBN
	 */
	public void setIsbn(String isbn) throws RevistaException {
		if (isbn.length() == TAMANO_ISBN) {
			this.isbn = isbn;
		} else {
			throw new RevistaException(RevistaException.ERROR_ISBN);
		}
	}

	public int getnPaginas() {
		return nPaginas;
	}

	/**
	 * Metodo que modifica el numero de paginas de la revista si se cumplen los
	 * requisitos necesarios.
	 * 
	 * @see MINIMO_NUMERO_PAGINAS
	 * @param nPaginas int
	 * @throws RevistaException en caso de que nPaginas sea menor que
	 *                          MINIMO_NUMERO_PAGINAS
	 */
	public void setnPaginas(int nPaginas) throws RevistaException {
		if (nPaginas < MINIMO_NUMERO_PAGINAS) {
			throw new RevistaException(RevistaException.ERROR_NPAGINAS);
		} else {
			this.nPaginas = nPaginas;
		}
	}

	public boolean isFormato() {
		return formato;
	}

	/**
	 * Metodo que modifica el formato de la revista si se cumplen los requisitos
	 * necesarios.
	 * 
	 * @see FORMATO_DIGITAL 'd'
	 * @see FORMATO_PAPEL 'p'
	 * @param formato char
	 * @throws RevistaException en caso de que formato no sea igual a
	 *                          FORMATO_DIGITAL O a FORMATO_PAPEL
	 */
	public void setFormato(char formato) throws RevistaException {
		switch (formato) {
		case FORMATO_DIGITAL:
			this.formato = true;
			break;
		case FORMATO_PAPEL:
			this.formato = false;
			break;
		default:
			throw new RevistaException(RevistaException.ERROR_FORMATO);
		}
	}

	/**
	 * Metodo que imprime todos los atributos de la clase Revista
	 */
	@Override
	public String toString() {
		return "Revista [titulo=" + getTitulo() + ", isbn=" + getIsbn() + ", nPaginas=" + getnPaginas() + ", formato="
				+ isFormato() + "]";
	}
	
	/**
	 * Metodo que compara dos revistas segun su número de paginas
	 */
	@Override
	public int compareTo(Revista o) {
		return (o.getnPaginas() - this.getnPaginas());
	}
}