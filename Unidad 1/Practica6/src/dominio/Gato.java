package dominio;

public class Gato extends Animal {
	
	//constructor
	public Gato()
	{
		super();
	}
	
	public Gato(String nombre)
	{
		super(nombre);
	}

	//metodo toString
	@Override
	public String toString() {
		return "ES UN GATO, SE LLAMA: " + getNombre();
	}
	
	
}
