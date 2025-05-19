package negocioImpl;

import java.util.List;

import dao.PersonaDao;
import daoImpl.PersonaDaoImpl;
import entidad.Persona;
import negocio.PersonaNegocio;

public class PersonaNegocioImpl implements PersonaNegocio {
	
	PersonaDao pdao = new PersonaDaoImpl();
	
	@Override
	public boolean insert(Persona persona) {
		boolean estado=false;
		
		boolean nombreValido = persona.getNombre() != null && persona.getNombre().trim().length() > 0;
	    boolean apellidoValido = persona.getApellido() != null && persona.getApellido().trim().length() > 0;
	    boolean dniValido = validarDni(persona.getDni());;
		
		if(nombreValido && apellidoValido && dniValido)
		{
			estado=pdao.insert(persona);
		}
		return estado;
	}

	@Override
	public boolean delete(Persona persona_a_eliminar) {
		boolean estado=false;
		
		boolean dniValido = validarDni(persona_a_eliminar.getDni());
		
		if(dniValido && pdao.existeDni(persona_a_eliminar.getDni()))
		{
			estado=pdao.delete(persona_a_eliminar);
		}
		return estado;
	}

	@Override
	public boolean modificar(Persona persona_a_mod) {
		 boolean modificar = false;

		    boolean nombreValido = persona_a_mod.getNombre() != null && persona_a_mod.getNombre().trim().length() > 0;
		    boolean apellidoValido = persona_a_mod.getApellido() != null && persona_a_mod.getApellido().trim().length() > 0;
		    boolean dniValido = validarDni(persona_a_mod.getDni());

		    if (nombreValido && apellidoValido && dniValido && pdao.existeDni(persona_a_mod.getDni())) {
		        modificar = pdao.modificar(persona_a_mod);
		    }

		    return modificar;
	}

	@Override
	public List<Persona> readAll() {
		return pdao.readAll();
	}

	@Override
	public boolean existeDni(String dni) {
		return pdao.existeDni(dni);
	}
	
	private boolean validarDni(String dniStr) {
		try {
            int dni = Integer.parseInt(dniStr);
            return dni > 1000000;
        } catch (NumberFormatException e) {
            return false;
        }
	}

}
