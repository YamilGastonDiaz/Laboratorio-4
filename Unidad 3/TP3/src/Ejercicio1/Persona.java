package Ejercicio1;

public class Persona implements Comparable<Persona> {
	private String nombre;
	private String apellido;
	private String dni;
	
	public Persona(String nombre, String apellido, String dni) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}
	
	public static boolean verificarDniInvalido (String dni) throws DniInvalido {
		if(!dni.matches("\\d{8}")) {
			throw new DniInvalido();
		}
		return true;
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

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	@Override
	public int compareTo(Persona o) {
		int resultado = this.apellido.compareToIgnoreCase(o.apellido);
		
		return resultado;
	}

	@Override
	public String toString() {
		return  nombre + "-" + apellido + "-" + dni;
	}
	
	
	
}
