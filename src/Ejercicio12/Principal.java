package Ejercicio12;

import Ejercicio08.Libro;

import java.awt.List;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.lang.reflect.Type;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class Principal {

	public static void serializar() {
		ArrayList<Libro> libros = new ArrayList<>();

		try {
			FileInputStream fis = new FileInputStream("libros10.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);

			Libro aux;
			Gson gson = new Gson();
			try {
				while (true) {
					aux = (Libro) ois.readObject();
					libros.add(aux);
					

					

				}
			} catch (EOFException ex) {
				ois.close();
				System.out.println("Procedemos a serializar:");
				Gson pretty = new GsonBuilder().setPrettyPrinting().create();
				System.out.println(pretty.toJson(libros));
				deserializar(pretty.toJson(libros));

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void deserializar(String json) {

		System.out.println("Procedemos a deserializar:");
		Gson gson = new Gson();
		Type tipolibros = new TypeToken<ArrayList<Libro>>() {
		}.getType();
		ArrayList<Libro> listaaux = gson.fromJson(json, tipolibros);
		Iterator<Libro> iterador = listaaux.iterator();
		while (iterador.hasNext()) {
			System.out.println(iterador.next().toString());

		}
	}

	public static void main(String[] args) {
		serializar();

	}
}
