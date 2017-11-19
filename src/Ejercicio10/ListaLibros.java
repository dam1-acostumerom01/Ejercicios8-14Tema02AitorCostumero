package Ejercicio10;

import Ejercicio08.Libro;
import java.util.ArrayList;

public class ListaLibros{

	public ArrayList<Libro> lista = new ArrayList<>();

	public ListaLibros() {
		
	}
	
	public void add(Libro libro) {
		lista.add(libro);
	}
	
	public ArrayList<Libro> getLista(){
		return lista;
	} 
	
	
}
