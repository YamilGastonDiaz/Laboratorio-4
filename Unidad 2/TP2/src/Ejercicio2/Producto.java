package Ejercicio2;

import java.time.LocalDate;

public class Producto {
	private LocalDate fechaCaducidad;
	private int numLote;
	
	public Producto()
	{
		
	}

	public Producto(LocalDate fechaCaducidad, int numLote)
	{
		this.fechaCaducidad = fechaCaducidad;
		this.numLote = numLote;
	}

	public LocalDate getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(LocalDate fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	public int getNumLote() {
		return numLote;
	}

	public void setNumLote(int numLote) {
		this.numLote = numLote;
	}

	@Override
	public String toString() {
		return "Producto fechaCaducidad=" + fechaCaducidad + ", numLote=" + numLote;
	}
}
