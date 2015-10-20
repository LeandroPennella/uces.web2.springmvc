package ar.edu.uces.progweb2.springmvc.model;

public class Persona {
private String nombre;
private int edad;

public int getEdad() {
	return edad;
}
public void setEdad(int edad) {
	this.edad = edad;
}
public String getNombre(){return this.nombre;}

public void  setNombre(String nombre){this.nombre=nombre;}
public Persona (String nombre){this.nombre=nombre;}
public Persona (String nombre, int edad){this.nombre=nombre; this.edad=edad;}

public Persona(){}

}
