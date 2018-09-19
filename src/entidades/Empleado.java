/**
 * Autor: Brian Téllez
 * Fecha de creación: 3/04/2018
 * Última modificación: Brian Téllez
 */

package entidades;

public class Empleado
{
	public int IdEmpleado;
	public String NombreEmpleado;
	public String ApellidoEmpleado;
	public String CedulaEmpleado;
	public String TelefonoEmpleado;
	public String DireccionEmpleado;
	public boolean EstadoEmpleado;
	
	public int getIdEmpleado()
	{
		return IdEmpleado;
	}
	
	public void setIdEmpleado(int idEmpleado)
	{
		IdEmpleado = idEmpleado;
	}
	
	public String getNombreEmpleado()
	{
		return NombreEmpleado;
	}
	
	public void setNombreEmpleado(String nombreEmpleado)
	{
		NombreEmpleado = nombreEmpleado;
	}
	
	public String getApellidoEmpleado()
	{
		return ApellidoEmpleado;
	}
	
	public void setApellidoEmpleado(String apellidoEmpleado)
	{
		ApellidoEmpleado = apellidoEmpleado;
	}
	
	public String getCedulaEmpleado()
	{
		return CedulaEmpleado;
	}
	
	public void setCedulaEmpleado(String cedulaEmpleado)
	{
		CedulaEmpleado = cedulaEmpleado;
	}
	
	public String getTelefonoEmpleado()
	{
		return TelefonoEmpleado;
	}
	
	public void setTelefonoEmpleado(String telefonoEmpleado)
	{
		TelefonoEmpleado = telefonoEmpleado;
	}
	
	public String getDireccionEmpleado()
	{
		return DireccionEmpleado;
	}
	
	public void setDireccionEmpleado(String direccionEmpleado)
	{
		DireccionEmpleado = direccionEmpleado;
	}
	
	public boolean isEstadoEmpleado()
	{
		return EstadoEmpleado;
	}
	
	public void setEstadoEmpleado(boolean estadoEmpleado)
	{
		EstadoEmpleado = estadoEmpleado;
	}
}
