/**
 * Autor: Leticia T�llez
 * Fecha de creaci�n: 20/04/2018
 * �ltima modificaci�n: Leticia T�llez
 */

package entidades;

public class TipoMovimiento
{
	public int IdTipoMovimiento;
	public String NombreTipoMovimiento;
	
	public int getIdTipoMovimiento()
	{
		return IdTipoMovimiento;
	}
	
	public void setIdTipoMovimiento(int idTipoMovimiento)
	{
		IdTipoMovimiento = idTipoMovimiento;
	}
	
	public String getNombreTipoMovimiento()
	{
		return NombreTipoMovimiento;
	}
	
	public void setNombreTipoMovimiento(String nombreTipoMovimiento)
	{
		NombreTipoMovimiento = nombreTipoMovimiento;
	}
}
