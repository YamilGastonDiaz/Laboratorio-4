package Ejercicio3;

abstract class Edificio {
	private double superficie;
	
	public Edificio()
	{}

	public Edificio(double superficie) {
		super();
		this.superficie = superficie;
	}

	public double getSuperficie() {
		return superficie;
	}

	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}

	@Override
	public String toString() {
		return "superficie=" + superficie;
	}
	
}
