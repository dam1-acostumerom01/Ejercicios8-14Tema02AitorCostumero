package Ejercicio11;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.ListIterator;
import com.thoughtworks.xstream.XStream;

public class Principal {

	public static void deserializar() {
		XStream xstream = new XStream();
		xstream.alias("blog", Blog.class);
		xstream.alias("autor", Autor.class);
		xstream.alias("entrada", Entrada.class);
		xstream.addImplicitCollection(Blog.class, "entradas");
		Blog blog;
		
		try {
			blog = (Blog) xstream.fromXML(new FileInputStream("blog.xml"));
			System.out.println("El número de entradas del blog es: " + blog.getEntradas().size());
			ArrayList<Entrada> entradas = blog.getEntradas();

			ListIterator<Entrada> iterador = entradas.listIterator();
			System.out.println("Autor: "+blog.getAutor().getNombre());
			while (iterador.hasNext()) {
				Entrada entrada = (Entrada) iterador.next();
				System.out.println(entrada);
			}
			System.out.println("Fin del listado.");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}
public static void main(String[] args) {
	deserializar();
}
}
