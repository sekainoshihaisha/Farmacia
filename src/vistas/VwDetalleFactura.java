/**
 * Autor: Brian Téllez
 * Fecha de creación: 7/05/2018
 * Última modificación: Brian Téllez
 */

package vistas;

public class VwDetalleFactura
{
	public int IdDetalleFactura;
	public int IdFactura;
	public String NumeroFactura;
	public int IdProducto;
	public String NombreProducto;
	public int CantidadProducto;
	public float PrecioProducto;
	public float TotalProducto;
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
	
	public String getNumeroFactura()
	{
		return NumeroFactura;
	}
	
	public void setNumeroFactura(String numeroFactura)
	{
		NumeroFactura = numeroFactura;
	}
	
	public int getIdProducto()
	{
		return IdProducto;
	}
	
	public void setIdProducto(int idProducto)
	{
		IdProducto = idProducto;
	}
	
	public String getNombreProducto()
	{
		return NombreProducto;
	}
	
	public void setNombreProducto(String nombreProducto)
	{
		NombreProducto = nombreProducto;
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
	
	public float getTotalProducto()
	{
		return TotalProducto;
	}
	
	public void setTotalProducto(float totalProducto)
	{
		TotalProducto = totalProducto;
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
