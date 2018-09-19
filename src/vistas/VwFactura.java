/**
 * Autor: Brian Téllez
 * Fecha de creación: 6/05/2018
 * Última modificación: Brian Téllez
 */

package vistas;
import java.sql.Date;
import java.util.ArrayList;
import entidades.DetalleFactura;

public class VwFactura
{
	public int IdFactura;
	public String NumeroFactura;
	public int IdClienteFactura;
	public String Cliente;
	public int IdEmpleadoFactura;
	public String Empleado;
	public Date FechaFactura;
	public boolean VentaReceta;
	public boolean EstadoFactura;
	public ArrayList<DetalleFactura> listaDetalle;
	
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
	
	public int getIdClienteFactura()
	{
		return IdClienteFactura;
	}
	
	public void setIdClienteFactura(int idClienteFactura)
	{
		IdClienteFactura = idClienteFactura;
	}
	
	public String getCliente()
	{
		return Cliente;
	}
	
	public void setCliente(String cliente)
	{
		Cliente = cliente;
	}
	
	public int getIdEmpleadoFactura()
	{
		return IdEmpleadoFactura;
	}
	
	public void setIdEmpleadoFactura(int idEmpleadoFactura)
	{
		IdEmpleadoFactura = idEmpleadoFactura;
	}
	
	public String getEmpleado()
	
	{
		return Empleado;
	}
	
	public void setEmpleado(String empleado)
	{
		Empleado = empleado;
	}
	
	public Date getFechaFactura()
	{
		return FechaFactura;
	}
	
	public void setFechaFactura(Date fechaFactura)
	{
		FechaFactura = fechaFactura;
	}
	
	public boolean isVentaReceta()
	{
		return VentaReceta;
	}
	
	public void setVentaReceta(boolean ventaReceta)
	{
		VentaReceta = ventaReceta;
	}
	
	public boolean isEstadoFactura()
	{
		return EstadoFactura;
	}
	
	public void setEstadoFactura(boolean estadoFactura)
	{
		EstadoFactura = estadoFactura;
	}
	
	public ArrayList<DetalleFactura> getListaDetalle()
	{
		return listaDetalle;
	}
	
	public void setListaDetalle(ArrayList<DetalleFactura> listaDetalle)
	{
		this.listaDetalle = listaDetalle;
	}
}
