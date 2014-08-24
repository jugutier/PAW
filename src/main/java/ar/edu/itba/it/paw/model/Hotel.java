package ar.edu.itba.it.paw.model;

public class Hotel {
	private int code;
	private String name, description;

	public Hotel(final int code, final String name, final String description) {
		this.code = code;
		this.name = name;
		this.description = description;
	}

	public int getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	public String getName() {
		return name;
	}
}

/*
 * Cada hotel tiene un código, nombre y descripción. No es necesario almacenar
 * esta información en un archivo, basta con mantenerla en memoria durante la
 * ejecución de la aplicación.
 */
