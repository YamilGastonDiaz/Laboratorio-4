package ejemplo4;

public class Libro {
	
	private String nombre;
	private int capitulos;
    
   
	public Libro()
	{
		nombre="";
		capitulos=0;
	}
	
	public Libro(String nombre, int capitulos)
	{
		this.nombre = nombre;
		this.capitulos = capitulos;
	}

	@Override
	public String toString() {
		return "Libro: "+nombre + ", Capitulos: " + capitulos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCapitulos() {
		return capitulos;
	}

	public void setCapitulos(int capitulos) {
		this.capitulos = capitulos;
	}
	
}
