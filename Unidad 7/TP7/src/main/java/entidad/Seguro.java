package entidad;

public class Seguro {
	private int idSeguro;
	private String descripcion;
	private TipoSeguro tipo;
	private float costoContratacion;
	private float costoAsegurado;
	
	
	public Seguro() {}

	public Seguro(int idSeguro, String descripcion, TipoSeguro tipo, float costoContratacion, float costoAsegurado) {
		this.idSeguro = idSeguro;
		this.descripcion = descripcion;
		this.tipo = tipo;
		this.costoContratacion = costoContratacion;
		this.costoAsegurado = costoAsegurado;
	}

	public int getIdSeguro() {
		return idSeguro;
	}

	public void setIdSeguro(int idSeguro) {
		this.idSeguro = idSeguro;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public TipoSeguro getTipo() {
		return tipo;
	}

	public void setTipo(TipoSeguro tipo) {
		this.tipo = tipo;
	}

	public float getCostoContratacion() {
		return costoContratacion;
	}

	public void setCostoContratacion(float costoContratacion) {
		this.costoContratacion = costoContratacion;
	}

	public float getCostoAsegurado() {
		return costoAsegurado;
	}

	public void setCostoAsegurado(float costoAsegurado) {
		this.costoAsegurado = costoAsegurado;
	}

	@Override
	public String toString() {
		return "Id Seguro= " + idSeguro + ", Descripcion= " + descripcion + ", Tipo= " + tipo
				+ ", Costo Contratacion= " + costoContratacion + ", Costo Asegurado=" + costoAsegurado;
	}
	
}
