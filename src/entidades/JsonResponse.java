/**
 * Autor: Leticia T�llez
 * Fecha de creaci�n: 4/04/2018
 * �ltima modificaci�n: Leticia T�llez
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
