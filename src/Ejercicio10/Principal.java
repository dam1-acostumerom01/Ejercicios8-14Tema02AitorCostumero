package Ejercicio10;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.ListIterator;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import Ejercicio08.Libro;

public class Principal {

	public static void leerFicheroYSerializar(File fichero) {
		ListaLibros lista= null;
		try {
		FileInputStream fis = new FileInputStream(fichero);
		ObjectInputStream ois = new ObjectInputStream(fis);
		System.out.println("Comenzamos a crear el fichero:");
		
		//Creamos un objeto Listalibros para tener la lista de los libros.
		lista = new ListaLibros();
		try {
		while(true) {
		 Libro aux = (Libro) ois.readObject();
		 lista.add(aux);
		}
		}catch(EOFException ex) {
			ois.close();
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//instanciamos el xstream
		XStream xstream = new XStream(new DomDriver("UTF-8"));
		//Le damos un alias a la clase libro
		xstream.alias("DatosLibro", Libro.class);
		//Hacemos que no salga el atributo lista de la clase listalibros
		xstream.addImplicitCollection(ListaLibros.class, "lista");
		//Generamos el fichero xml
		xstream.toXML(lista,new FileOutputStream("libros10.xml"));
		System.out.println("Generando fichero XML...");
		System.out.println("Fichero XML generado con éxito.");

	} catch (FileNotFoundException e) {	
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			
		}
	}
	
	public static void leerXml() {
		try {
		XStream xstream = new XStream();
		xstream.alias("DatosLibro", Libro.class);
		xstream.addImplicitCollection(ListaLibros.class, "lista");
		
		//Creamos un objeto listalibros que contenga el fichero xml para deserializar.
		ListaLibros libros;
		libros = (ListaLibros)xstream.fromXML(new FileInputStream("libros10.xml"));
		System.out.println("Número de libros: "+ libros.getLista().size());
		//Creamos un array de libros que contiene la lista de libros del objeto anterior.
		ArrayList <Libro> totalLibros = libros.getLista();
		
		ListIterator<Libro> iterador = totalLibros.listIterator();
		while (iterador.hasNext()) {
			Libro libro = (Libro) iterador.next(); //Obtengo el libro
			System.out.println(libro);
			
		}
		System.out.println("Fin del listado.");
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		File fichero = new File("libros10.dat");
		leerFicheroYSerializar(fichero);
		leerXml();
	}
	
}
