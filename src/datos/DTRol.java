/**
 * Autor: Brian Téllez
 * Fecha de creación: 4/04/2018
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

public class DTRol
{
	Conexion c = Conexion.getInstance();
	Connection cn = Conexion.getConnection();
	ResultSet rs = null;
	
	public ArrayList<Rol> ListarRoles()
	{
		ArrayList<Rol> roles = new ArrayList<Rol>();
		String sql = ("SELECT * FROM rol WHERE EstadoRol = true");
		
		try
		{
			PreparedStatement ps = cn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				Rol r = new Rol();
				
				r.setIdRol(rs.getInt("IdRol"));
				r.setNombreRol(rs.getString("NombreRol"));
				r.setDescripcionRol(rs.getString("DescripcionRol"));
				r.setEstadoRol(rs.getBoolean("EstadoRol"));
				
				roles.add(r);
			}
		}
		catch(Exception e)
		{
			System.out.println("DATOS: ERROR AL OBTENER LOS ROLES "+ e.getMessage());
			e.printStackTrace();
		}
		
		return roles;
	}
	
	public boolean crearRol(Rol r)
	{
		boolean creado = false;
		
		try
		{
			this.ListarRoles();
			rs.moveToInsertRow();
			rs.updateString("NombreRol", r.getNombreRol());
			rs.updateString("DescripcionRol", r.getDescripcionRol());
			rs.updateBoolean("EstadoRol", r.isEstadoRol());
			
			rs.insertRow();
			rs.moveToCurrentRow();
			creado = true;
		}
		catch(Exception e)
		{
			System.err.println("ERROR AL CREAR EMPLEADO: " + e.getMessage());
			e.printStackTrace();
		}
		
		return creado;
	}
	
	public boolean modificarRol(Rol r)
	{
		boolean modificado = false;
		PreparedStatement ps;
		String sql = ("UPDATE farmacia.rol SET NombreRol = ?, DescripcionRol = ? WHERE IdRol = ?");
		
		try
		{
			ps = cn.prepareStatement(sql);
			ps.setString(1, r.getNombreRol());
			ps.setString(2, r.getDescripcionRol());
			ps.setInt(3, r.getIdRol());
			
			ps.executeUpdate();
			
			modificado = true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.err.println("ERROR AL MODIFICAR: " + e.getMessage());
		}
		
		return modificado;
	}
	
	public boolean eliminarRol(Rol r)
	{
		boolean eliminado = false;
		PreparedStatement ps;
		String sql = ("UPDATE farmacia.rol SET EstadoRol = false WHERE IdRol = ?");
		
		try
		{
			ps = cn.prepareStatement(sql);
			ps.setInt(1, r.getIdRol());
			
			ps.executeUpdate();
			
			eliminado = true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.err.println("ERROR AL ELIMINAR: " + e.getMessage());
		}
		
		return eliminado;
	}
}
