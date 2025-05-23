package Ejercicio1;

public class Empleado {
	private final int id;
	private String nombre;
	private int edad;
	private static int cont = 999;
	
	//CONSTRUCTORES
	public Empleado()
	{
		cont++;
		this.id = cont;
		this.nombre = "Sin Nombre";
		this.edad = 99;
	}
	
	public Empleado(String nombre, int edad) 
	{
		cont++;
		this.id = cont;
		this.nombre = nombre;
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public static int devuelveProximoID()
	{
		return cont + 1;
	}

	@Override
	public String toString() {
		return "Empleado ID=" + id + ", NOMBRE=" + nombre + ", EDAD=" + edad;
	}
	
	
}
