package Ejercicio11;

public class Entrada {
public String titulo;
public String descripcion;
public Entrada() {
}
public String getTitulo() {
	return titulo;
}
public void setTitulo(String titulo) {
	this.titulo = titulo;
}
public String getDescripcion() {
	return descripcion;
}
public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}

@Override
	public String toString() {
	return "-----------"+"\n"+
	"Título: " + titulo+"\n"+
		"Descripción: " + descripcion+"\n"+
		"-----------";
	}
	



}
