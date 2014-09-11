package ar.edu.itba.it.paw.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Hotel implements Serializable{
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
	@Override
	public boolean equals(Object obj) {
		if(obj.getClass() != Hotel.class){
			return false;
		}		
		return ((Hotel)obj).code == this.code;
	}
	@Override
	public int hashCode() {
		return code;//TODO: check
	}
}