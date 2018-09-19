/**
 * Autor: Brian Téllez
 * Fecha de creación: 24/04/2018
 * Última modificación: Brian Téllez
 */

package datos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import vistas.VwEmpleadoVsUsuario;

public class DTVwEmpleadoVsUsuario
{
	Conexion c = Conexion.getInstance();
	Connection cn = Conexion.getConnection();
	ResultSet rs = null;
	
	public ArrayList<VwEmpleadoVsUsuario> listarUsuariosVW()
	{
		ArrayList<VwEmpleadoVsUsuario> usuarios = new ArrayList<VwEmpleadoVsUsuario>();
		String sql = ("SELECT * FROM farmacia.vwempleadovsusuario");
		
		try
		{
			PreparedStatement ps = cn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				VwEmpleadoVsUsuario u = new VwEmpleadoVsUsuario();
				u.setIdUsuario(rs.getInt("IdUsuario"));
				u.setNombreEmpleado(rs.getString("NombreEmpleado"));
				u.setApellidoEmpleado(rs.getString("ApellidoEmpleado"));
				u.setNombreUsuario(rs.getString("NombreUsuario"));
				
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