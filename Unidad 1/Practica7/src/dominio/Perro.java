package dominio;

public class Perro extends Animal {
	
	private String raza;
	
	//constructores
	public Perro()
	{
		super();
		this.raza = "Sin Raza";
	}
	
	public Perro(String nombre, String raza)
	{
		super(nombre);
		this.raza = raza;
	}
	
	//getters y setters
	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}
	
	
	//metodo toString
	@Override
	public String toString() {
		return "ES UN PERRRO, SU NOMBRE ES: "+ getNombre() + " Y SU RAZA ES:" + raza;
	}
	
	//metodo abstracto desarrollado 
	@Override
	public String habilidades() {
		return "Los perros pueden localizar y separar olores.";
	}
}
