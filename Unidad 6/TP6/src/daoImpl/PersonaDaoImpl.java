package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.PersonaDao;
import entidad.Persona;

public class PersonaDaoImpl implements PersonaDao {
	private static final String insert = "INSERT INTO Personas(dni, nombre, apellido) VALUES(?, ?, ?)";
	private static final String delete = "DELETE FROM Personas WHERE dni = ?";
	private static final String update = "UPDATE Personas SET nombre = ?, apellido = ? WHERE dni = ?";
	private static final String readall = "SELECT * FROM Personas";
	private static final String dniEncontrado = "SELECT 1 FROM Personas WHERE dni = ?";
	
	@Override
	public boolean insert(Persona persona) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean insertExitoso = false;
		
		try {
			statement = conexion.prepareStatement(insert);
			statement.setString(1, persona.getDni());
			statement.setString(2, persona.getNombre());
			statement.setString(3, persona.getApellido());
			
			if (statement.executeUpdate() > 0) {
				conexion.commit();
				insertExitoso = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
			try {
				conexion.rollback();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		
		return insertExitoso;
	}
	
	@Override
	public boolean delete(Persona persona_a_eliminar) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean deleteExitoso = false;
		
		try {
			statement = conexion.prepareStatement(delete);
			statement.setString(1, persona_a_eliminar.getDni());
			
			if (statement.executeUpdate() > 0) {
				conexion.commit();
				deleteExitoso = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return deleteExitoso;
	}
	
	@Override
	public boolean modificar(Persona persona_a_mod) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean updateExitoso = false;
		
		try {
			statement = conexion.prepareStatement(update);
			statement.setString(1, persona_a_mod.getNombre());
			statement.setString(2, persona_a_mod.getApellido());
			statement.setString(3, persona_a_mod.getDni());
			
			if (statement.executeUpdate() > 0) {
				conexion.commit();
				updateExitoso = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return updateExitoso;
	}
	
	@Override
	public List<Persona> readAll() {
		PreparedStatement statement;
		ResultSet result;
		ArrayList<Persona> persona = new ArrayList<Persona>();
		Conexion conexion = Conexion.getConexion();
		
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			result = statement.executeQuery();
			
			while(result.next()) {
				persona.add(getPersona(result));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return persona;
	}
	
	public boolean existeDni(String dni) {
	    PreparedStatement statement;
	    ResultSet resultado;
	    Connection conexion = Conexion.getConexion().getSQLConexion();
	    boolean existe = false;

	    try {
	        statement = conexion.prepareStatement(dniEncontrado);
	        statement.setString(1, dni);
	        resultado = statement.executeQuery();

	        if (resultado.next()) {
	            existe = true;
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return existe;
	}
	
	private Persona getPersona(ResultSet resultSet) throws SQLException
	{
		String dni = resultSet.getString("Dni");
		String nombre = resultSet.getString("Nombre");
		String apellido = resultSet.getString("Apellido");
		return new Persona(dni, nombre, apellido);
	}
}
