package Ejercicio09;

import java.io.Serializable;

public class Empleado implements Serializable,Comparable<Empleado>{

	public String id;
	public String nombre;
	public String apellido;
	public float salario;
	public String cargo;
	public Direccion direccion;
	
	public Empleado() {}
	public Empleado(String id, String nombre, String apellido, float salario, String cargo, Direccion direccion) {
		
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.salario = salario;
		this.cargo = cargo;
		this.direccion = direccion;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	
	@Override
	public String toString() {
		
		return "**** DATOS DEL EMPLEADO **** \n"+
		"ID: "+id+"\n"+
				"Nombre: "+nombre+"\n"+
		"Apellido: "+apellido+"\n"+
				"Salario: "+salario+"\n"+
		"Cargo: "+cargo+"\n"+
				"Dirección: "+"\n"+
		"\t Ciudad: "+direccion.ciudad+"\n"+
				"\t Provincia: "+direccion.provincia+"\n"+
		"\t CP: "+direccion.cp+"\n"+
				"\t Calle: "+direccion.calle+"\n"+
		"****************************";
	}
	@Override
	public int compareTo(Empleado e) {
		if (salario<e.salario) {
			return -1;
		}if (salario>e.salario) {
			return 1;
		}
		return 0;
	}
	
}
