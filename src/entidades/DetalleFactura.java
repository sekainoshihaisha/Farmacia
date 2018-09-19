/**
 * Autor: Leticia Téllez
 * Fecha de creación: 2/04/2018
 * Última modificación: Leticia Téllez
 */

package entidades;

public class DetalleFactura
{
	public int IdDetalleFactura;
	public int IdFactura;
	public int IdProducto;
	public int CantidadProducto;
	public float PrecioProducto;
	public boolean EstadoDetalleFactura;
	
	public int getIdDetalleFactura()
	{
		return IdDetalleFactura;
	}
	
	public void setIdDetalleFactura(int idDetalleFactura)
	{
		IdDetalleFactura = idDetalleFactura;
	}
	
	public int getIdFactura()
	{
		return IdFactura;
	}
	
	public void setIdFactura(int idFactura)
	{
		IdFactura = idFactura;
	}
	
	public int getIdProducto()
	{
		return IdProducto;
	}
	
	public void setIdProducto(int idProducto)
	{
		IdProducto = idProducto;
	}
	
	public int getCantidadProducto()
	{
		return CantidadProducto;
	}
	
	public void setCantidadProducto(int cantidadProducto)
	{
		CantidadProducto = cantidadProducto;
	}
	
	public float getPrecioProducto()
	{
		return PrecioProducto;
	}
	
	public void setPrecioProducto(float precioProducto)
	{
		PrecioProducto = precioProducto;
	}
	
	public boolean isEstadoDetalleFactura()
	{
		return EstadoDetalleFactura;
	}
	
	public void setEstadoDetalleFactura(boolean estadoDetalleFactura)
	{
		EstadoDetalleFactura = estadoDetalleFactura;
	}
}