/**
 * Autor: Brian Téllez
 * Fecha de creación: 6/05/2018
 * Última modificación: Brian Téllez
 */

package datos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import vistas.VwUsuario;

public class DTVwUsuario
{
	Conexion c = Conexion.getInstance();
	Connection cn = Conexion.getConnection();
	ResultSet rs = null;
	
	public ArrayList<VwUsuario> ListarUsuarios()
	{
		ArrayList<VwUsuario> usuarios = new ArrayList<VwUsuario>();
		String sql = ("SELECT * FROM vwusuario");
		
		try
		{
			PreparedStatement ps = cn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				VwUsuario u = new VwUsuario();
				
				u.setIdUsuario(rs.getInt("IdUsuario"));
				u.setIdEmpleado(rs.getInt("IdEmpleado"));
				u.setEmpleado(rs.getString("Empleado"));
				u.setNombreUsuario(rs.getString("NombreUsuario"));
				u.setClave(rs.getString("Clave"));
				u.setIdRol(rs.getInt("IdRol"));
				u.setNombreRol(rs.getString("NombreRol"));
				u.setEstado(rs.getInt("Estado"));
				u.setCondicion(rs.getString("Condicion"));
				
				usuarios.add(u);
			}
		}
		catch(Exception e)
		{
			System.out.println("DATOS: ERROR AL OBTENER LOS USUARIOS "+ e.getMessage());
			e.printStackTrace();
		}
		
		return usuarios;
	}
}
