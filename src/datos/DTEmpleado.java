/**
 * Autor: Brian Téllez
 * Fecha de creación: 3/04/2018
 * Última modificación: Brian Téllez
 */

package datos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.mysql.jdbc.Statement;
import entidades.*;

public class DTEmpleado
{
	Conexion c = Conexion.getInstance();
	Connection cn = Conexion.getConnection();
	ResultSet rs = null;
	
	public ArrayList<Empleado> ListarEmpleados()
	{
		ArrayList<Empleado> empleados = new ArrayList<Empleado>();
		String sql = ("SELECT * FROM empleado WHERE EstadoEmpleado = true");
		
		try
		{
			PreparedStatement ps = cn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				Empleado e = new Empleado();
				
				e.setIdEmpleado(rs.getInt("IdEmpleado"));
				e.setNombreEmpleado(rs.getString("NombreEmpleado"));
				e.setApellidoEmpleado(rs.getString("ApellidoEmpleado"));
				e.setCedulaEmpleado(rs.getString("CedulaEmpleado"));
				e.setTelefonoEmpleado(rs.getString("TelefonoEmpleado"));
				e.setDireccionEmpleado(rs.getString("DireccionEmpleado"));
				e.setEstadoEmpleado(rs.getBoolean("EstadoEmpleado"));
				
				empleados.add(e);
			}
		}
		catch(Exception e)
		{
			System.out.println("DATOS: ERROR AL OBTENER LOS EMPLEADOS "+ e.getMessage());
			e.printStackTrace();
		}
		
		return empleados;
	}
	
	public boolean crearEmpleado(Empleado e)
	{
		boolean creado = false;
		
		try
		{
			this.ListarEmpleados();
			rs.moveToInsertRow();
			rs.updateString("NombreEmpleado", e.getNombreEmpleado());
			rs.updateString("ApellidoEmpleado", e.getApellidoEmpleado());
			rs.updateString("CedulaEmpleado", e.getCedulaEmpleado());
			rs.updateString("TelefonoEmpleado", e.getTelefonoEmpleado());
			rs.updateString("DireccionEmpleado", e.getDireccionEmpleado());
			rs.updateBoolean("EstadoEmpleado", e.isEstadoEmpleado());
			
			rs.insertRow();
			rs.moveToCurrentRow();
			creado = true;
		}
		catch(Exception ex)
		{
			System.err.println("ERROR AL CREAR EMPLEADO: " + ex.getMessage());
			ex.printStackTrace();
		}
		
		return creado;
	}
	
	public boolean modificarEmpleado(Empleado e)
	{
		boolean modificado = false;
		PreparedStatement ps;
		String sql = ("UPDATE farmacia.empleado SET NombreEmpleado = ?, ApellidoEmpleado = ?, CedulaEmpleado = ?, TelefonoEmpleado = ?, DireccionEmpleado = ? WHERE IdEmpleado = ?");
		
		try
		{
			ps = cn.prepareStatement(sql);
			ps.setString(1, e.getNombreEmpleado());
			ps.setString(2, e.getApellidoEmpleado());
			ps.setString(3, e.getCedulaEmpleado());
			ps.setString(4, e.getTelefonoEmpleado());
			ps.setString(5, e.getDireccionEmpleado());
			ps.setInt(6, e.getIdEmpleado());
			
			ps.executeUpdate();
			
			modificado = true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			System.err.println("ERROR AL MODIFICAR: " + ex.getMessage());
		}
		
		return modificado;
	}
	
	public boolean eliminarEmpleado(Empleado e)
	{
		boolean eliminado = false;
		PreparedStatement ps;
		String sql = ("UPDATE farmacia.empleado SET EstadoEmpleado = false WHERE IdEmpleado = ?");
		
		try
		{
			ps = cn.prepareStatement(sql);
			ps.setInt(1, e.getIdEmpleado());
			
			ps.executeUpdate();
			
			eliminado = true;
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
			System.err.println("ERROR AL ELIMINAR: " + ex.getMessage());
		}
		
		return eliminado;
	}
}
