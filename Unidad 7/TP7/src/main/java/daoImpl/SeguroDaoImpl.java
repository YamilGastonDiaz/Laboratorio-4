package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.SeguroDao;
import entidad.Seguro;
import entidad.TipoSeguro;

public class SeguroDaoImpl implements SeguroDao {
	private static final String insert = "INSERT INTO seguros (descripcion,idTipo,costoContratacion,costoAsegurado) VALUES(?, ?, ?, ?)";
	private static final String readall = "select idSeguro, s.descripcion as descripcionSeguro, s.idTipo as idTipoSeguro, ts.descripcion as descripcionTipo, costoContratacion, costoAsegurado from seguros s inner join tiposeguros ts ON s.idTipo = ts.idTipo order by idSeguro";
	private static final String readAlltipo = "select idSeguro, s.descripcion as descripcionSeguro, s.idTipo as idTipoSeguro, ts.descripcion as descripcionTipo, costoContratacion, costoAsegurado from seguros s inner join tiposeguros ts ON s.idTipo = ts.idTipo where s.idTipo = ?";
	private static final String ultimoId = "SELECT MAX(idSeguro) FROM seguros";
	
	public int obtenerProximoIdSimulado() {
	    int maxId = 0;
	    PreparedStatement statement;
	    Connection conexion = Conexion.getConexion().getSQLConexion();
	    
	    try {
	        statement = conexion.prepareStatement(ultimoId);
	        ResultSet resultado = statement.executeQuery();
	        
	        if (resultado.next()) {
	            maxId = resultado.getInt(1); 
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return maxId + 1;
	}
		
	public boolean insert(Seguro seguro) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean insertExitoso = false;
		
		try {
			statement = conexion.prepareStatement(insert);
			statement.setString(1, seguro.getDescripcion());
			statement.setInt(2, seguro.getTipo().getId());
			statement.setFloat(3, seguro.getCostoContratacion());
			statement.setFloat(4, seguro.getCostoAsegurado());
			
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
	
	public List<Seguro> readAll() {
		PreparedStatement statement;
		ResultSet result;
		ArrayList<Seguro> seguro = new ArrayList<Seguro>();
		Conexion conexion = Conexion.getConexion();
		
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			result = statement.executeQuery();
			
			while(result.next()) {
				seguro.add(getSeguro(result));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return seguro;
	}
	
	public List<Seguro> readAlltipo(int idTipoSeguro) {
		PreparedStatement statement;
		ResultSet result;
		ArrayList<Seguro> seguro = new ArrayList<Seguro>();
		Conexion conexion = Conexion.getConexion();
		
		try {
			statement = conexion.getSQLConexion().prepareStatement(readAlltipo);
			statement.setInt(1, idTipoSeguro);
			result = statement.executeQuery();
			
			while(result.next()) {
				seguro.add(getSeguro(result));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return seguro;
	}
	
	private Seguro getSeguro(ResultSet resultSet) throws SQLException {
		int idSeguro = resultSet.getInt("idSeguro");
	    String descripcion = resultSet.getString("descripcionSeguro");
	    
	    int idTipo = resultSet.getInt("idTipoSeguro");
	    String descripcionTipo = resultSet.getString("descripcionTipo");
	    TipoSeguro tipo = new TipoSeguro(idTipo, descripcionTipo);
	    
	    float costoContratacion = resultSet.getFloat("costoContratacion");
	    float costoAsegurado = resultSet.getFloat("costoAsegurado");
	    
	    return new Seguro(idSeguro, descripcion, tipo, costoContratacion, costoAsegurado);
	    
	}
	
}