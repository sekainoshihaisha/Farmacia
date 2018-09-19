/**
 * Autor: Leticia Téllez
 * Fecha de creación: 2/04/2018
 * Última modificación: Leticia Téllez
 */

package entidades;

public class Producto {
	
	public int IdProducto;
	public String NombreProducto;
	public String DescripcionProducto;
	public boolean ProductoControlado;
	public int IdPresentacionProducto;
	public int IdTipoConsumidoProducto;
	public int StockProducto;
	public double PrecioProducto;
	public boolean EstadoProducto;
	
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
	
	public String getDescripcionProducto()
	{
		return DescripcionProducto;
	}
	
	public void setDescripcionProducto(String descripcionProducto)
	{
		DescripcionProducto = descripcionProducto;
	}
	
	public boolean isProductoControlado()
	{
		return ProductoControlado;
	}
	
	public void setProductoControlado(boolean productoControlado)
	{
		ProductoControlado = productoControlado;
	}
	
	public int getIdPresentacionProducto()
	{
		return IdPresentacionProducto;
	}
	
	public void setIdPresentacionProducto(int idPresentacionProducto)
	{
		IdPresentacionProducto = idPresentacionProducto;
	}
	
	public int getIdTipoConsumidoProducto()
	{
		return IdTipoConsumidoProducto;
	}
	
	public void setIdTipoConsumidoProducto(int idTipoConsumidoProducto)
	{
		IdTipoConsumidoProducto = idTipoConsumidoProducto;
	}
	
	public int getStockProducto()
	{
		return StockProducto;
	}
	
	public void setStockProducto(int stockProducto)
	{
		StockProducto = stockProducto;
	}
	
	public double getPrecioProducto()
	{
		return PrecioProducto;
	}
	
	public void setPrecioProducto(double precioProducto)
	{
		PrecioProducto = precioProducto;
	}
	
	public boolean isEstadoProducto()
	{
		return EstadoProducto;
	}
	
	public void setEstadoProducto(boolean estadoProducto)
	{
		EstadoProducto = estadoProducto;
	}
}
