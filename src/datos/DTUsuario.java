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
import entidades.*;
import vistas.VwUsuarioVsRol;

public class DTUsuario
{
	Conexion c = Conexion.getInstance();
	Connection cn = Conexion.getConnection();
	ResultSet rs = null;
	
	public ArrayList<Usuario> ListarUsuarios()
	{
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		String sql = ("SELECT * FROM usuario WHERE EstadoUsuario = true");
		
		try
		{
			PreparedStatement ps = cn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				Usuario u = new Usuario();
				
				u.setIdUsuario(rs.getInt("IdUsuario"));
				u.setIdEmpleado(rs.getInt("IdEmpleado"));
				u.setNombreUsuario(rs.getString("NombreUsuario"));
				u.setClave(rs.getString("Clave"));
				u.setIdRol(rs.getInt("IdRol"));
				u.setEstado(rs.getInt("Estado"));
				u.setEstadoUsuario(rs.getBoolean("EstadoUsuario"));
				
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
	
	public ArrayList<Rol> ListaRoles() 
	{
		ArrayList<Rol> listaRol = new ArrayList<Rol>();
		String sql = ("SELECT IdRol, NombreRol FROM rol WHERE EstadoRol = true");

		try 
		{
			PreparedStatement ps = cn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				Rol r = new Rol();
				r.setIdRol(rs.getInt("IdRol"));
				r.setNombreRol(rs.getString("NombreRol"));
				
				listaRol.add(r);
			}
		} 
		catch (Exception e) 
		{
			System.out.println("DATOS: ERROR AL OBTENER LOS CLIENTES "+ e.getMessage());
			e.printStackTrace();
		}
		
		return listaRol;
	}
	
	public boolean crearUsuario(Usuario u)
	{
		boolean creado = false;
		
		try
		{
			this.ListarUsuarios();
			rs.moveToInsertRow();
			rs.updateInt("IdEmpleado", u.getIdEmpleado());
			rs.updateString("NombreUsuario", u.getNombreUsuario());
			rs.updateString("Clave", u.getClave());
			rs.updateInt("IdRol", u.getIdRol());
			rs.updateInt("Estado", u.getEstado());
			rs.updateBoolean("EstadoUsuario", u.isEstadoUsuario());
			
			rs.insertRow();
			rs.moveToCurrentRow();
			creado = true;
		}
		catch(Exception ex)
		{
			System.err.println("ERROR AL CREAR USUARIO: " + ex.getMessage());
			ex.printStackTrace();
		}
		
		return creado;
	}
	
	public boolean modificarUsuario(Usuario u)
	{
		boolean modificado = false;
		PreparedStatement ps;
		String sql = ("UPDATE farmacia.usuario SET IdEmpleado = ?, NombreUsuario = ?, Clave = ?, IdRol = ?, Estado = ? WHERE IdUsuario = ?");
		
		try
		{
			ps = cn.prepareStatement(sql);
			ps.setInt(1, u.getIdEmpleado());
			ps.setString(2, u.getNombreUsuario());
			ps.setString(3, u.getClave());
			ps.setInt(4, u.getIdRol());
			ps.setInt(5, 2);
			ps.setInt(6, u.getIdUsuario());
			
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
	
	public boolean eliminarUsuario(Usuario u)
	{
		boolean eliminado = false;
		PreparedStatement ps;
		String sql = ("UPDATE farmacia.usuario SET Estado = 3, EstadoUsuario = false WHERE IdUsuario = ?");
		
		try
		{
			ps = cn.prepareStatement(sql);
			ps.setInt(1, u.getIdUsuario());
			
			ps.executeUpdate();
			
			return true;
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
			System.err.println("ERROR AL ELIMINAR: " + ex.getMessage());
		}
		
		return eliminado;
	}
	
	public boolean verificarLogin(Usuario u)
	{
		boolean existe = false;
		
		try
		{
			PreparedStatement ps = cn.prepareStatement("SELECT * FROM farmacia.usuario WHERE NombreUsuario = ? AND Clave = ? AND Estado <> 3 AND EstadoUsuario = true");
			System.out.println("Nombre de usuario: " + u.getNombreUsuario());
			System.out.println("Contraseña de usuario: " + u.getClave());
			ps.setString(1, u.getNombreUsuario());
			ps.setString(2, u.getClave());
			ResultSet rsu = null;
			rsu = ps.executeQuery();
			
			if(rsu.next())
			{
				existe = true;
			}
		}
		catch(Exception e)
		{
			System.out.println("DATOS: ERROR AL VERIFICAR EL LOGIN " + e.getMessage());
			e.printStackTrace();
		}
		
		return existe;
	}
	
	public ArrayList<VwUsuarioVsRol> listaRol(String loginUser)
	{
		ArrayList<VwUsuarioVsRol> rolU = new ArrayList<VwUsuarioVsRol>();
		
		try
		{
			PreparedStatement ps = cn.prepareStatement("SELECT * FROM farmacia.vwusuariovsrol WHERE NombreUsuario = ?");
			ps.setString(1, loginUser);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				VwUsuarioVsRol vus = new VwUsuarioVsRol();
				vus.setIdEmpleado(rs.getInt("IdEmpleado"));
				vus.setIdUsuario(rs.getInt("IdUsuario"));
				vus.setIdRol(rs.getInt("IdRol"));
				vus.setNombreUsuario(rs.getString("NombreUsuario"));
				vus.setNombreEmpleado(rs.getString("NombreEmpleado"));
				vus.setApellidoEmpleado(rs.getString("ApellidoEmpleado"));
				vus.setURL(rs.getString("URL"));
				
				rolU.add(vus);
			}
		}
		catch(Exception e)
		{
			System.out.println("DATOS: ERROR AL VERIFICAR EL ROL " + e.getMessage());
			e.printStackTrace();
		}
		
		return rolU;
	}
	
	public ArrayList<VwUsuarioVsRol> obtenerOpciones(int rol)
	{
		ArrayList<VwUsuarioVsRol> lvro = new ArrayList<VwUsuarioVsRol>();
		
		String sql = ("SELECT URL FROM farmacia.vwusuariovsrol WHERE IdRol = ?");
		
		try
		{
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setInt(1, rol);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				VwUsuarioVsRol vus = new VwUsuarioVsRol();
				vus.setURL(rs.getString("URL"));
				
				lvro.add(vus);
			}
			
			ps.close();
			cn.close();
		}
		catch(Exception e)
		{
			System.out.println("DATOS: ERROR AL OBTENER EL Opciones " + e.getMessage());
			e.printStackTrace();
		}
		
		return lvro;
	}
}
