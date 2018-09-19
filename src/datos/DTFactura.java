/**
 * Autor: Leticia Téllez
 * Fecha de creación: 2/04/2018
 * Última modificación: Brian Téllez
 */

package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.mysql.jdbc.Statement;

import entidades.*;
import datos.DTProducto;

public class DTFactura
{
	Conexion c = Conexion.getInstance();
	Connection cn = Conexion.getConnection();
	ResultSet rs = null;
	
	public ArrayList<Factura> ListarFacturas()
	{
		ArrayList<Factura> facturas = new ArrayList<Factura>();
		ArrayList<DetalleFactura> detallefacturas = new ArrayList<DetalleFactura>();
		String sql = ("SELECT * FROM factura");
		
		try 
		{
			PreparedStatement ps = cn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				Factura f = new Factura();
				
				f.setIdFactura(rs.getInt("IdFactura"));
				f.setNumeroFactura(rs.getString("NumeroFactura"));
				f.setIdClienteFactura(rs.getInt("IdClienteFactura"));
				f.setIdEmpleadoFactura(rs.getInt("IdEmpleadoFactura"));
				f.setFechaFactura(rs.getDate("FechaFactura"));
				f.setEstado(rs.getBoolean("EstadoFactura"));
		
				facturas.add(f);
			}
		} 
		catch (Exception e) 
		{
			System.out.println("DATOS: ERROR AL OBTENER LAS FACTURAS "+ e.getMessage());
			e.printStackTrace();
		}
		
		return facturas;
	}
	
	/**LISTAS PARA COMBOBOX**/
	
	public ArrayList<Producto> ListaProductos() 
	{
		ArrayList<Producto> listaProd = new ArrayList<Producto>();
		String sql = ("SELECT IdProducto, NombreProducto  FROM producto WHERE EstadoProducto = true");

		try 
		{
			PreparedStatement ps = cn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				Producto pd = new Producto();
				pd.setIdProducto(rs.getInt("IdProducto"));
				pd.setNombreProducto(rs.getString("NombreProducto"));
				
				listaProd.add(pd);
			}
		} 
		catch (Exception e) 
		{
			System.out.println("DATOS: ERROR AL OBTENER LOS PRODUCTOS "+ e.getMessage());
			e.printStackTrace();
		}
		
		return listaProd;
	}
	
	public ArrayList<Cliente> ListaClientes() 
	{
		ArrayList<Cliente> listaCli = new ArrayList<Cliente>();
		String sql = ("SELECT IdCliente, NombreCliente, ApellidoCliente FROM cliente WHERE EstadoCliente = true");

		try 
		{
			PreparedStatement ps = cn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				Cliente cl = new Cliente();
				cl.setIdCliente(rs.getInt("IdCliente"));
				cl.setNombreCliente(rs.getString("NombreCliente"));
				cl.setApellidoCliente(rs.getString("ApellidoCliente"));
				
				listaCli.add(cl);
			}
		} 
		catch (Exception e) 
		{
			System.out.println("DATOS: ERROR AL OBTENER LOS CLIENTES "+ e.getMessage());
			e.printStackTrace();
		}
		
		return listaCli;
	}
	
	public ArrayList<Empleado> ListaVendedores() 
	{
		ArrayList<Empleado> listaEmp = new ArrayList<Empleado>();
		String sql = ("SELECT IdEmpleado, NombreEmpleado, ApellidoEmpleado FROM empleado WHERE EstadoEmpleado = true");

		try 
		{
			PreparedStatement ps = cn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				Empleado emp = new Empleado();
				emp.setIdEmpleado(rs.getInt("IdEmpleado"));
				emp.setNombreEmpleado(rs.getString("NombreEmpleado"));
				emp.setApellidoEmpleado(rs.getString("ApellidoEmpleado"));
				
				listaEmp.add(emp);
			}
		} 
		catch (Exception e) 
		{
			System.out.println("DATOS: ERROR AL OBTENER LOS VENDEDORES "+ e.getMessage());
			e.printStackTrace();
		}
		
		return listaEmp;
	}
	/**FIN**/
	
	/*****DETALLE FACTURA********/
	public ArrayList<DetalleFactura> ListarDetalleFactura()
	{
		ArrayList<DetalleFactura> detallefactura = new ArrayList<DetalleFactura>();
		String sql = ("SELECT * FROM detallefactura WHERE EstadoDetalleFactura = true");
		
		try 
		{
			PreparedStatement ps = cn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				DetalleFactura df = new DetalleFactura();
				
				df.setIdDetalleFactura(rs.getInt("IdDetalleFactura"));
				df.setIdFactura(rs.getInt("IdFactura"));
				df.setIdProducto(rs.getInt("IdProducto"));
				df.setCantidadProducto(rs.getInt("CantidadProducto"));
				df.setPrecioProducto(rs.getFloat("PrecioProducto"));
				
				detallefactura.add(df);
			}
		} 
		catch (Exception e) 
		{
			System.out.println("DATOS: ERROR AL OBTENER LOS DETALLE FACTURA "+ e.getMessage());
			e.printStackTrace();
		}
		
		return detallefactura;
	}
	/**FIN*****/
	
	public boolean GuardarFactura(Factura f)
	{
		Date fecha = new Date();
		java.sql.Date fDate = new java.sql.Date(fecha.getTime());
				
		try 
		{
			//GUARDAR FACTURA
			String sql = "INSERT INTO factura (NumeroFactura, IdClienteFactura, IdEmpleadoFactura, FechaFactura, VentaReceta, EstadoFactura) VALUES (?,?,?,?,?,?)";
			
			PreparedStatement ps = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); 
			
			ps.setString(1, f.getNumeroFactura());
			ps.setInt(2, f.getIdClienteFactura());
			ps.setInt(3, f.getIdEmpleadoFactura());
			ps.setDate(4, fDate);
			ps.setBoolean(5, f.isVentaReceta());
			ps.setBoolean(6, true);
			 
			ps.executeUpdate();  
			
			//OBTENER EL IDFACTURA RECIÉN INGRESADO
			rs = ps.getGeneratedKeys();    
			rs.next();  
			int IdFact = rs.getInt(1); 
			
			//GUARDAR EL DETALLE FACTURA
			for (DetalleFactura df : f.getListaDetalle()) 
			{
				this.ListarDetalleFactura();
				rs.moveToInsertRow();
				rs.updateInt("IdFactura", IdFact);
				rs.updateInt("IdProducto", df.getIdProducto());
				rs.updateInt("CantidadProducto", df.getCantidadProducto());
				rs.updateDouble("PrecioProducto", df.getPrecioProducto());
				rs.updateBoolean("EstadoDetalleFactura", true);
				
				new DTProducto().ActualizarStock(df.getIdProducto(), df.getCantidadProducto(), 2);
				
				rs.insertRow();
				rs.moveToCurrentRow();
			}
			
			return true;
		} 
		catch (Exception ex) 
		{
			System.err.println("ERROR AL GUARDAR FACTURA "+ ex.getMessage());
			ex.printStackTrace();
			
			return false;
		}
	}
	
	public boolean CancelarFactura(int IdFactura)
	{
		try 
		{
			String sql = ("UPDATE Factura SET EstadoFactura = false WHERE IdFactura = ?");
			PreparedStatement ps = cn.prepareStatement(sql);
			
			ps.setInt(1, IdFactura);
			ps.executeUpdate();
			
			return true;
			
		}
		catch (Exception ex)
		{
			System.err.println("ERROR AL GUARDAR FACTURA "+ ex.getMessage());
			ex.printStackTrace();
			
			return false;
		}
	}
}