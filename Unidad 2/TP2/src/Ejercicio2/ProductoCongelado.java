package Ejercicio2;

import java.time.LocalDate;

public class ProductoCongelado extends Producto {
	private int temperatura;
	
	public ProductoCongelado()
	{
		
	}

	public ProductoCongelado(LocalDate fechaCaducidad, int numLote, int temperatura) {
		super(fechaCaducidad, numLote);
		this.temperatura = temperatura;
	}

	public int getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(int temperatura) {
		this.temperatura = temperatura;
	}

	@Override
	public String toString() {
		return super.toString() + ", temperatura=" + temperatura;
	}
	
}
