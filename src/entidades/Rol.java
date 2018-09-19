/**
 * Autor: Brian T�llez
 * Fecha de creaci�n: 4/04/2018
 * �ltima modificaci�n: Brian T�llez
 */

package entidades;

public class Rol
{
	public int IdRol;
	public String NombreRol;
	public String DescripcionRol;
	public boolean EstadoRol;
	
	public int getIdRol()
	{
		return IdRol;
	}
	
	public void setIdRol(int idRol)
	{
		IdRol = idRol;
	}
	
	public String getNombreRol()
	{
		return NombreRol;
	}
	
	public void setNombreRol(String nombreRol)
	{
		NombreRol = nombreRol;
	}
	
	public String getDescripcionRol()
	{
		return DescripcionRol;
	}
	
	public void setDescripcionRol(String descripcionRol)
	{
		DescripcionRol = descripcionRol;
	}
	
	public boolean isEstadoRol()
	{
		return EstadoRol;
	}
	
	public void setEstadoRol(boolean estadoRol)
	{
		EstadoRol = estadoRol;
	}
}
