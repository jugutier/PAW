package ar.edu.itba.it.paw.model;

public class Comment {
	private final String text;
	public Comment(String comment){
		this.text = comment;
	}
	@Override
	public String toString() {
		return text;
	}
}
