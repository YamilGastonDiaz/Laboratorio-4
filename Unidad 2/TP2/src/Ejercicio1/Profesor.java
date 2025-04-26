package Ejercicio1;

import java.util.Objects;

public class Profesor extends Empleado implements Comparable<Profesor> {
	
	private String cargo;
	private int antiguedadDocente;
	
	public Profesor()
	{}

	public Profesor(String nombre, int edad, String cargo, int antiguedadDocente)
	{
		super(nombre, edad);
		this.cargo = cargo;
		this.antiguedadDocente = antiguedadDocente;
	}
	
	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public int getAntiguedadDocente() {
		return antiguedadDocente;
	}

	public void setAntiguedadDocente(int antiguedadDocente) {
		this.antiguedadDocente = antiguedadDocente;
	}

	@Override
	public String toString() {
		return super.toString() + ", cargo=" + cargo + ", antiguedadDocente=" + antiguedadDocente;
	}

	@Override
	public int compareTo(Profesor o) {
		if(o.antiguedadDocente == this.antiguedadDocente)
			return 0;
		
		if (o.antiguedadDocente < this.antiguedadDocente)
		{
			return 1;
		}		
		return -1;
	}

	@Override
	public int hashCode() {
		return Objects.hash(antiguedadDocente, cargo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profesor other = (Profesor) obj;
		return antiguedadDocente == other.antiguedadDocente && Objects.equals(cargo, other.cargo);
	}
}
