package Ejercicio2;

import java.time.LocalDate;

public class ProductoFresco extends Producto {
	private LocalDate fechaEnvasado;
	private String paisOrigen;
	
	public ProductoFresco()
	{
		
	}

	public ProductoFresco(LocalDate fechaCaducidad, int numLote, LocalDate fechaEnvasado, String paisOrigen) {
		super(fechaCaducidad, numLote);
		this.fechaEnvasado = fechaEnvasado;
		this.paisOrigen = paisOrigen;
	}

	public LocalDate getFechaEnvasado() {
		return fechaEnvasado;
	}

	public void setFechaEnvasado(LocalDate fechaEnvasado) {
		this.fechaEnvasado = fechaEnvasado;
	}

	public String getPaisOrigen() {
		return paisOrigen;
	}

	public void setPaisOrigen(String paisOrigen) {
		this.paisOrigen = paisOrigen;
	}

	@Override
	public String toString() {
		return super.toString() + ", fechaEnvasado=" + fechaEnvasado + ", paisOrigen=" + paisOrigen;
	}
		
}
