package Ejercicio13;

public class Producto {

	public String referencia;
	public String nombre;
	public String precio;
	public String existencias;
	public Producto() {
		
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	public String getExistencias() {
		return existencias;
	}
	public void setExistencias(String existencias) {
		this.existencias = existencias;
	}
	
	@Override
	public String toString() {
		
		return "*** NUEVO PRODUCTO ***"+"\n"+
		"Referencia: "+referencia+"\n"+
				"Nombre: "+nombre+"\n"+
		"Precio: "+precio+"\n"+
				"Existencias: "+existencias+"\n"+
		"***********************";
	}
	
	
}
