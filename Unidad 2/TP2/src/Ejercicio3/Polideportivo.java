package Ejercicio3;

public class Polideportivo extends Edificio implements IDeportiva {
	private String nombre;
	private int tipoInstalacion;
	
	public Polideportivo()
	{
		
	}

	public Polideportivo(double superficie, String nombre, int tipoInstalacion) {
		super(superficie);
		this.nombre = nombre;
		this.tipoInstalacion = tipoInstalacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return super.toString() + ", nombre=" + nombre + ", tipoInstalacion=" + tipoInstalacion;
	}

	@Override
	public int getTipoDeInstalacion() {
		return tipoInstalacion;
	}
	
}
