package dominio;

//palabra para llamar a la herencia extends
public class ArticuloGimnasio extends Articulo {
	
	private int peso;
	
	//constructores
	public ArticuloGimnasio()
	{
		super();//palabra para llamar al constructor padre super()
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
