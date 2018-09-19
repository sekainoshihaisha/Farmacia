/**
 * Autor: Leticia Téllez
 * Fecha de creación: 20/04/2018
 * Última modificación: Leticia Téllez
 */

package entidades;

public class DetalleMovimiento
{
	public int IdDetalleMovimiento;
	public int IdMovimientoDM;
	public int IdLoteDM;
	public int CantidadProductoDM;
	public boolean EstadoDetalleMovimiento;
	
	public int getIdDetalleMovimiento()
	{
		return IdDetalleMovimiento;
	}
	
	public void setIdDetalleMovimiento(int idDetalleMovimiento)
	{
		IdDetalleMovimiento = idDetalleMovimiento;
	}
	
	public int getIdMovimientoDM()
	{
		return IdMovimientoDM;
	}
	
	public void setIdMovimientoDM(int idMovimientoDM)
	{
		IdMovimientoDM = idMovimientoDM;
	}
	
	public int getIdLoteDM()
	{
		return IdLoteDM;
	}
	
	public void setIdLoteDM(int idLoteDM)
	{
		IdLoteDM = idLoteDM;
	}
	
	public int getCantidadProductoDM()
	{
		return CantidadProductoDM;
	}
	
	public void setCantidadProductoDM(int cantidadProductoDM)
	{
		CantidadProductoDM = cantidadProductoDM;
	}
	
	public boolean isEstadoDetalleMovimiento()
	{
		return EstadoDetalleMovimiento;
	}
	
	public void setEstadoDetalleMovimiento(boolean estadoDetalleMovimiento)
	{
		EstadoDetalleMovimiento = estadoDetalleMovimiento;
	}
}
