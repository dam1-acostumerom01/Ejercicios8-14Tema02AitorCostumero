package Ejercicio09;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamConstants;

public class Principal {

	public static void leerXML() {

		ArrayList<Empleado> plantilla = new ArrayList<>();
		
		Empleado empleado = null;
		Direccion direccion = null;
		try {
			XMLInputFactory factory = XMLInputFactory.newInstance();
			XMLStreamReader reader = factory.createXMLStreamReader(new FileReader("empleados9.xml"));

			while (reader.hasNext()) {
				int event = reader.next();
				if (event == XMLStreamConstants.START_ELEMENT) {
					
					String nodo = reader.getLocalName();
					switch (nodo) {
					case "empleado":
						empleado = new Empleado();
						empleado.setId(reader.getAttributeValue(0));
						break;
					case "nombre":
						empleado.setNombre(reader.getElementText());
						break;
					case "apellido":
						empleado.setApellido(reader.getElementText());
						break;
					case "salario":
						empleado.setSalario(Float.parseFloat(reader.getElementText()));
						break;
					case "cargo":
						empleado.setCargo(reader.getElementText());
						break;
					case "direccion":
						direccion = new Direccion();
						break;
					case "ciudad":
						direccion.setCiudad(reader.getElementText());
						break;
					case "provincia":
						direccion.setProvincia(reader.getElementText());
						break;
					case "cp":
						direccion.setCp(reader.getElementText());
						break;
					case "calle":
						direccion.setCalle(reader.getElementText());
						break;
					}
				}
				
				//Si el evento es fin de elemento y es de tipo empleado:
				if ((event == XMLStreamConstants.END_ELEMENT) && (reader.getLocalName() == "empleado")) {
					empleado.setDireccion(direccion);  //Asignamos la dirección a ese empleado.
					plantilla.add(empleado); //Añadimos el empleado a la lista.
					
				}
			}
			
			//Ordenamos los empleados de forma ascendente según su sueldo.
			Collections.sort(plantilla); 
			
			//Mostramos aquellos que tengan un sueldo igual o superior a 30.000
			for (int i = 0; i < plantilla.size(); i++) {
				if (plantilla.get(i).getSalario()>= 30000) {
					System.out.println(plantilla.get(i));
				}
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
