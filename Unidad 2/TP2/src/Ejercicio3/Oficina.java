package Ejercicio3;

public class Oficina extends Edificio {
	private int cantOficina;
	
	public Oficina()
	{
		
	}

	public Oficina(double superficie, int cantOficina) {
		super(superficie);
		this.cantOficina = cantOficina;
	}

	public int getCantOficina() {
		return cantOficina;
	}

	public void setCantOficina(int cantOficina) {
		this.cantOficina = cantOficina;
	}

	@Override
	public String toString() {
		return super.toString() + ", cantOficina=" + cantOficina;
	}
	
	
}
