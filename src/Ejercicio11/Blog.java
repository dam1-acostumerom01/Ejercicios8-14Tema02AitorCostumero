package Ejercicio11;

import java.util.ArrayList;

public class Blog {
	
	public Autor autor;
	public ArrayList<Entrada> entradas = new ArrayList<>();

	public Blog() {
autor = new Autor();
	}

	

	public ArrayList<Entrada> getEntradas() {
		return entradas;
	}

	public void setEntradas(ArrayList<Entrada> entradas) {
		this.entradas = entradas;
	}

	public String mostrarEntradas() {
		String cadena="";
		for (int i = 0; i < entradas.size(); i++) {
			cadena+="Título: " + entradas.get(i).titulo+"\n"+
			"Descripción: " + entradas.get(i).descripcion;
		}
		return cadena;
	}

	@Override
	public String toString() {

		return "*** DATOS DEL BLOG ***" + "\n" 
		+ "Autor: " + autor.getNombre() + "\n" +
				"Entradas: \n"+
		mostrarEntradas()+"\n"+
		"*************************";

	}



	public Autor getAutor() {
		return autor;
	}



	public void setAutor(Autor autor) {
		this.autor = autor;
	}

}
