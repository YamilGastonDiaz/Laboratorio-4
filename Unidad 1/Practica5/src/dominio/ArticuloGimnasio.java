package dominio;

public class ArticuloGimnasio extends Articulo {
	
	private int peso;
	private static final int gramo = 1000;// una variable de tipo constante FINAL se le asigna ese valor ya no se puede modificar
	
	//metodo
	public int devuelvePesoEnGramo() 
	{
		return peso * gramo;
	}
	
	//constructores
	public ArticuloGimnasio()
	{
		super();
	}
	
	//getters y setters
	public ArticuloGimnasio(String nombre, int peso)
	{
		super(nombre);
		this.peso = peso;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		return super.toString() + ", PESO=" + peso;
	}

}
