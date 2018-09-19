/**
 * Autor: Brian Téllez
 * Fecha de creación: 6/05/2018
 * Última modificación: Brian Téllez
 */

package vistas;

public class VwUsuario
{
	public int IdUsuario;
	public int IdEmpleado;
	public String Empleado;
	public String NombreUsuario;
	public String Clave;
	public int IdRol;
	public String NombreRol;
	public int Estado;
	public String Condicion;
	
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
	
	public String getEmpleado()
	{
		return Empleado;
	}
	
	public void setEmpleado(String empleado)
	{
		Empleado = empleado;
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
	
	public String getNombreRol()
	{
		return NombreRol;
	}
	
	public void setNombreRol(String nombreRol)
	{
		NombreRol = nombreRol;
	}
	
	public int getEstado()
	{
		return Estado;
	}
	
	public void setEstado(int estado)
	{
		Estado = estado;
	}
	
	public String getCondicion()
	{
		return Condicion;
	}
	
	public void setCondicion(String condicion)
	{
		Condicion = condicion;
	}
}
