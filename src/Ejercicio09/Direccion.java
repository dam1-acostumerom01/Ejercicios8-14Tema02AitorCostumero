package Ejercicio09;

import java.io.Serializable;

public class Direccion implements Serializable{

	public String ciudad;
	public String provincia;
	public String cp;
	public String calle;
	
	public Direccion(String ciudad, String provincia, String cp, String calle) {
	
		this.ciudad = ciudad;
		this.provincia = provincia;
		this.cp = cp;
		this.calle = calle;
	}
	
	public Direccion() {}
	
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	
	
	
	
}
