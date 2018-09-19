/**
 * Autor: Brian T�llez
 * Fecha de creaci�n: 25/04/2018
 * �ltima modificaci�n: Brian T�llez
 */

package entidades;

public class RolOpcion
{
	private int IdRolOpcion;
	private int IdRol;
	private int IdOpcion;
	private boolean EstadoRolOpcion;
	
	public int getIdRolOpcion()
	{
		return IdRolOpcion;
	}
	
	public void setIdRolOpcion(int idRolOpcion)
	{
		IdRolOpcion = idRolOpcion;
	}
	
	public int getIdRol()
	{
		return IdRol;
	}
	
	public void setIdRol(int idRol)
	{
		IdRol = idRol;
	}
	
	public int getIdOpcion()
	{
		return IdOpcion;
	}
	
	public void setIdOpcion(int idOpcion)
	{
		IdOpcion = idOpcion;
	}
	
	public boolean isEstadoRolOpcion()
	{
		return EstadoRolOpcion;
	}
	
	public void setEstadoRolOpcion(boolean estadoRolOpcion)
	{
		EstadoRolOpcion = estadoRolOpcion;
	}
}
