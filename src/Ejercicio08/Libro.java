package Ejercicio08;

import java.io.Serializable;
import java.util.ArrayList;

public class Libro implements Serializable{

	public String ISBN;
	public String titulo;
	public ArrayList<String> autor = new ArrayList<>();
	public String editorial;
	
	public Libro() {}
	
	public Libro(String iSBN, String titulo, ArrayList<String> autor, String editorial) {
		
		ISBN = iSBN;
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public ArrayList<String> getAutor() {
		return autor;
	}
	public void setAutor(ArrayList<String> autor) {
		this.autor = autor;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	
	@Override
	public String toString() {
		
		return "***** LIBRO ******\n"+
		"ISBN: "+ISBN+"\n"
				+ "Título: "+titulo+"\n"+
				"Autores: "+mostrarAutores()+
				"Editorial: "+editorial+"\n"+
				"******************";
	}

	private String mostrarAutores() {
		String autores="";
		for (int i = 0; i < autor.size(); i++) {
			autores+=autor.get(i)+"\n";
		}
		return autores;
	}
	
	
	
}
