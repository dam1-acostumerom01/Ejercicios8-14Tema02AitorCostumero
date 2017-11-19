package Ejercicio13;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class Principal {

	public static void leerFichero(File fichero) {
		try {
			FileInputStream fis = new FileInputStream(fichero);
			JsonReader reader = new JsonReader(new InputStreamReader(fis,"UTF-8"));
			Gson gson = new Gson();
			//Leemos el fichero en stream
			reader.beginArray();
			while (reader.hasNext()){
				//Leemos la información del archivo utilizando el modelo producto
				Producto aux = gson.fromJson(reader, Producto.class);
			System.out.println(aux.toString());
			}
			reader.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
		
		}
		
	}
	public static void main(String[] args) {
		File fichero = new File("productos.json.txt");
		leerFichero(fichero);
	}
	
}
