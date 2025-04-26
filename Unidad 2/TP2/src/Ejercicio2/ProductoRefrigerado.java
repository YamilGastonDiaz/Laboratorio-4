package Ejercicio2;

import java.time.LocalDate;

public class ProductoRefrigerado extends Producto {
	private int codigoOrganizmoSa;
	
	public ProductoRefrigerado()
	{
		
	}

	public ProductoRefrigerado(LocalDate fechaCaducidad, int numLote, int codigoOrganizmoSa) {
		super(fechaCaducidad, numLote);
		this.codigoOrganizmoSa = codigoOrganizmoSa;
	}

	public int getCodigoOrganizmoSa() {
		return codigoOrganizmoSa;
	}

	public void setCodigoOrganizmoSa(int codigoOrganizmoSa) {
		this.codigoOrganizmoSa = codigoOrganizmoSa;
	}

	@Override
	public String toString() {
		return super.toString() + ", codigoOrganizmoSa=" + codigoOrganizmoSa;
	}
	
	
}
