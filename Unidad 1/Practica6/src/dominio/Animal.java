package dominio;

public class Animal {
	private String nombre;
	
	//constructor
	public Animal()
	{
		this.nombre = "Sin Nombre";
	}
	
	public Animal(String nombre)
	{
		this.nombre = nombre;
	}
	
	
	//getters y setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	//metodo toString
	@Override
	public String toString() {
		return "ES UN ANIMAL, SU NOMBRE: " + nombre;
	}
	
}
