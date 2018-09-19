/**
 * Autor: Leticia Téllez
 * Fecha de creación: 20/04/2018
 * Última modificación: Leticia Téllez
 */

package entidades;
import java.sql.Date;

public class Movimiento extends DetalleMovimiento
{
	public int IdMovimiento;
	public String DescripcionMovimiento;
	public Date FechaMovimiento;
	public int IdTipoMovimiento;
	public int IdProductoMovimiento;
	public boolean EstadoMovimiento;
	public String NombreTipoMovimiento;
	public String NombreProducto;
	public int StockProducto;
	public int StockTotal;
	
	public int getStockTotal()
	{
		return StockTotal;
	}
	
	public void setStockTotal(int stockTotal)
	{
		StockTotal = stockTotal;
	}
	
	public int getStockProducto()
	{
		return StockProducto;
	}
	
	public void setStockProducto(int stockProducto)
	{
		StockProducto = stockProducto;
	}
	
	public String getNombreTipoMovimiento()
	{
		return NombreTipoMovimiento;
	}
	
	public void setNombreTipoMovimiento(String nombreTipoMovimiento)
	{
		NombreTipoMovimiento = nombreTipoMovimiento;
	}
	
	public String getNombreProducto()
	{
		return NombreProducto;
	}
	
	public void setNombreProducto(String nombreProducto)
	{
		NombreProducto = nombreProducto;
	}
	
	public int getIdMovimiento()
	{
		return IdMovimiento;
	}
	
	public void setIdMovimiento(int idMovimiento)
	{
		IdMovimiento = idMovimiento;
	}
	
	public String getDescripcionMovimiento()
	{
		return DescripcionMovimiento;
	}
	
	public void setDescripcionMovimiento(String descripcionMovimiento)
	{
		DescripcionMovimiento = descripcionMovimiento;
	}
	
	public Date getFechaMovimiento()
	{
		return FechaMovimiento;
	}
	
	public void setFechaMovimiento(Date fechaMovimiento)
	{
		FechaMovimiento = fechaMovimiento;
	}
	
	public int getIdTipoMovimiento()
	{
		return IdTipoMovimiento;
	}
	
	public void setIdTipoMovimiento(int idTipoMovimiento)
	{
		IdTipoMovimiento = idTipoMovimiento;
	}
	
	public int getIdProductoMovimiento()
	{
		return IdProductoMovimiento;
	}
	
	public void setIdProductoMovimiento(int idProductoMovimiento)
	{
		IdProductoMovimiento = idProductoMovimiento;
	}
	
	public boolean isEstadoMovimiento()
	{
		return EstadoMovimiento;
	}
	
	public void setEstadoMovimiento(boolean estadoMovimiento)
	{
		EstadoMovimiento = estadoMovimiento;
	}
}
