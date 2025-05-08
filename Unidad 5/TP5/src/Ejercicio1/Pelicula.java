package Ejercicio1;

public class Pelicula {
	private int id;
	private String nombre;
	private Categoria categoria;
	
	private static int cont = 1;
	
	
	public Pelicula() {}
	
	public Pelicula(String nombre, Categoria categoria) {
		super();
		this.id = cont++;
		this.nombre = nombre;
		this.categoria = categoria;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	 public static int ProximoId() {
	    return cont;
	 }

	@Override
	public String toString() {
		return "Pelicula: " + id + ", Nombre: " + nombre + ", " + categoria;
	}

}
