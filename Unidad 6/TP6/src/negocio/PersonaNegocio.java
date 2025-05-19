package negocio;

import java.util.List;

import entidad.Persona;

public interface PersonaNegocio {
	public boolean insert(Persona persona);
	public boolean delete(Persona persona_a_eliminar);
	public boolean modificar(Persona perosna_a_mod);
	public List<Persona> readAll();
	public boolean existeDni(String dni);
}
