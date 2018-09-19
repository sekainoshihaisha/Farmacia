/**
 * Autor: Brian Téllez
 * Fecha de creación: 4/04/2018
 * Última modificación: Brian Téllez
 */

package entidades;
import java.util.Date;

public class Usuario
{
	public int IdUsuario;
	public int IdEmpleado;
	public String NombreUsuario;
	public String Clave;
	public int IdRol;
	public int IdUsuarioAgrega;
	public int IdUsuarioModifica;
	public int IdUsuarioElimina;
	public Date FechaAgrega;
	public Date FechaElimina;
	public Date FechaModifica;
	public int Estado;
	public boolean EstadoUsuario;
	
	public int getIdUsuario()
	{
		return IdUsuario;
	}
	
	public void setIdUsuario(int idUsuario)
	{
		IdUsuario = idUsuario;
	}
	
	public int getIdEmpleado()
	{
		return IdEmpleado;
	}
	
	public void setIdEmpleado(int idEmpleado)
	{
		IdEmpleado = idEmpleado;
	}
	
	public String getNombreUsuario()
	{
		return NombreUsuario;
	}
	
	public void setNombreUsuario(String nombreUsuario)
	{
		NombreUsuario = nombreUsuario;
	}
	
	public String getClave()
	{
		return Clave;
	}
	
	public void setClave(String clave)
	{
		Clave = clave;
	}
	
	public int getIdRol()
	{
		return IdRol;
	}
	
	public void setIdRol(int idRol)
	{
		IdRol = idRol;
	}
	
	public int getIdUsuarioAgrega()
	{
		return IdUsuarioAgrega;
	}
	
	public void setIdUsuarioAgrega(int idUsuarioAgrega)
	{
		IdUsuarioAgrega = idUsuarioAgrega;
	}
	
	public int getIdUsuarioModifica()
	{
		return IdUsuarioModifica;
	}
	
	public void setIdUsuarioModifica(int idUsuarioModifica)
	{
		IdUsuarioModifica = idUsuarioModifica;
	}
	
	public int getIdUsuarioElimina()
	{
		return IdUsuarioElimina;
	}
	
	public void setIdUsuarioElimina(int idUsuarioElimina)
	{
		IdUsuarioElimina = idUsuarioElimina;
	}
	
	public Date getFechaAgrega()
	{
		return FechaAgrega;
	}
	
	public void setFechaAgrega(Date fechaAgrega)
	{
		FechaAgrega = fechaAgrega;
	}
	
	public Date getFechaElimina()
	{
		return FechaElimina;
	}
	
	public void setFechaElimina(Date fechaElimina)
	{
		FechaElimina = fechaElimina;
	}
	
	public Date getFechaModifica()
	{
		return FechaModifica;
	}
	
	public void setFechaModifica(Date fechaModifica)
	{
		FechaModifica = fechaModifica;
	}
	
	public int getEstado()
	{
		return Estado;
	}
	
	public void setEstado(int estado)
	{
		Estado = estado;
	}
	
	public boolean isEstadoUsuario()
	{
		return EstadoUsuario;
	}
	
	public void setEstadoUsuario(boolean estadoUsuario)
	{
		EstadoUsuario = estadoUsuario;
	}
}
