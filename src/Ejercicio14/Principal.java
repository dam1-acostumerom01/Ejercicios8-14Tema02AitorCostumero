package Ejercicio14;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonWriter;

import Ejercicio08.Libro;

public class Principal {
	
	public static ArrayList<Libro> leerXML() {
		ArrayList<Libro> libros = null;
		try {
			libros = new ArrayList<>();
			Libro aux = null;

			XMLInputFactory factory = XMLInputFactory.newInstance();
			XMLStreamReader reader = factory.createXMLStreamReader(new FileReader("librosejercicio8.xml"));

			while (reader.hasNext()) {
				int event = reader.next();
				if (event == XMLStreamConstants.START_ELEMENT) {
					String nodo = reader.getLocalName();
					switch (nodo) {
					case "libro":
						aux = new Libro();
						aux.setISBN(reader.getAttributeValue(0));
						break;
					case "titulo":
						aux.setTitulo(reader.getElementText());
						break;
					case "autor":
						aux.getAutor().add(reader.getElementText());
						break;
					case "editorial":
						aux.setEditorial(reader.getElementText());
						break;
					}
				}
				if ((event == XMLStreamConstants.END_ELEMENT) && (reader.getLocalName() == "libro")) {
					libros.add(aux);
					
				}

			}
			
			

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return libros;
	}
	
	public static void escribirJson(ArrayList<Libro> libros) {
		
		JsonWriter writer;
		
		try {
			writer = new JsonWriter(new FileWriter("productossalida.json"));
		Iterator<Libro> iterador =  libros.iterator();
		writer.beginArray();
		while (iterador.hasNext()) {
			Libro aux = iterador.next();
			writer.beginObject(); //Objeto libro
			writer.name("ISBN").value(aux.getISBN());
			writer.name("titulo").value(aux.getTitulo());
			writer.name("autores");
			writer.beginArray(); //array de autores
			ArrayList<String> autores = aux.getAutor();
			for (int i = 0; i < autores.size(); i++) {
				writer.value(autores.get(i));
			}
			writer.endArray();//fin array de autores
			writer.name("editorial").value(aux.getEditorial());
			writer.endObject();
		}
		writer.endArray(); //Fin de la lista
		writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args) {
		ArrayList<Libro> libros = leerXML();
		escribirJson(libros);
	}
}
