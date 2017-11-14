package Ejercicio08;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;

public class Principal {

	public static void leerXML() {
		try {
			ArrayList<Libro> libros = new ArrayList<>();
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

			for (Libro libro : libros) {
				System.out.println(libro);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		leerXML();
	}

}
