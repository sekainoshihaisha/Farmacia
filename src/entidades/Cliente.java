/**
 * Autor: Leticia T�llez
 * Fecha de creaci�n: 2/04/2018
 * �ltima modificaci�n: Leticia T�llez
 */

package entidades;

public class Cliente
{
	
	public int IdCliente;
	public String NombreCliente;
	public String ApellidoCliente;
	
	public int getIdCliente()
	{
		return IdCliente;
	}
	
	public void setIdCliente(int idCliente)
	{
		IdCliente = idCliente;
	}
	
	public String getNombreCliente()
	{
		return NombreCliente;
	}
	
	public void setNombreCliente(String nombreCliente)
	{
		NombreCliente = nombreCliente;
	}
	
	public String getApellidoCliente()
	{
		return ApellidoCliente;
	}
	
	public void setApellidoCliente(String apellidoCliente)
	{
		ApellidoCliente = apellidoCliente;
	}
}
