/**
 * Autor: Leticia Téllez
 * Fecha de creación: 4/04/2018
 * Última modificación: Leticia Téllez
 */

package entidades;

public class JsonResponse 
{
	public boolean status;
	public String message;
	
	public boolean isStatus()
	{
		return status;
	}
	
	public void setStatus(boolean status)
	{
		this.status = status;
	}
	
	public String getMessage()
	{
		return message;
	}
	
	public void setMessage(String message)
	{
		this.message = message;
	}
}
