package daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.TipoSeguroDao;
import entidad.Seguro;
import entidad.TipoSeguro;

public class TipoSeguroDaoImpl implements TipoSeguroDao {
	private static final String readall = "SELECT idTipo, descripcion FROM TipoSeguros";
	
	public List<TipoSeguro> readAll() {
		PreparedStatement statement;
		ResultSet result;
		ArrayList<TipoSeguro> tipoSeguro = new ArrayList<TipoSeguro>();
		Conexion conexion = Conexion.getConexion();
		
		
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			result = statement.executeQuery();
			
			while(result.next()) {
				tipoSeguro.add(getTipoSeguro(result));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return tipoSeguro;
	}
	
	private TipoSeguro getTipoSeguro(ResultSet resultSet) throws SQLException {
		int idTipo = resultSet.getInt("idTipo");
	    String descripcion = resultSet.getString("descripcion");
	    
	    return new TipoSeguro(idTipo, descripcion);
	}
}
