/**
 * Autor: Leticia Téllez
 * Fecha de creación: 2/04/2018
 * Última modificación: Leticia Téllez
 */

package entidades;
import java.sql.Date;
import java.util.ArrayList;
//import org.eclipse.persistence.jpa.jpql.parser.DateTime;

public class Factura {
	
	public int IdFactura;
	public String NumeroFactura;
	public int IdClienteFactura;
	public int IdEmpleadoFactura;
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
	
	public int getIdEmpleadoFactura()
	{
		return IdEmpleadoFactura;
	}
	
	public void setIdEmpleadoFactura(int idEmpleadoFactura)
	{
		IdEmpleadoFactura = idEmpleadoFactura;
	}
	
	public Date getFechaFactura()
	{
		return FechaFactura;
	}
	
	public void setFechaFactura(Date date)
	{
		FechaFactura = date;
	}
	
	public boolean isVentaReceta()
	{
		return VentaReceta;
	}
	
	public void setVentaReceta(boolean ventaReceta)
	{
		VentaReceta = ventaReceta;
	}
	
	public boolean isEstado()
	{
		return EstadoFactura;
	}
	
	public void setEstado(boolean estado)
	{
		EstadoFactura = estado;
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
