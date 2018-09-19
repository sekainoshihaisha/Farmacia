/**
 * Autor: Leticia Téllez
 * Fecha de creación: 4/05/2018
 * Última modificación: Leticia Téllez
 */

package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import com.mysql.jdbc.Statement;

import entidades.*;

public class DTProducto
{
	Conexion c = Conexion.getInstance();
	Connection cn = Conexion.getConnection();
	ResultSet rs = null;
	
	public ArrayList<Producto> ListaProductos() 
	{
		ArrayList<Producto> listaProd = new ArrayList<Producto>();
		String sql = ("SELECT *  FROM producto WHERE EstadoProducto = true");

		try 
		{
			PreparedStatement ps = cn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				Producto pd = new Producto();
				pd.setIdProducto(rs.getInt("IdProducto"));
				pd.setNombreProducto(rs.getString("NombreProducto"));
				pd.setDescripcionProducto(rs.getString("DescripcionProducto"));
				pd.setPrecioProducto(rs.getDouble("PrecioProducto"));
				pd.setStockProducto(rs.getInt("StockProducto"));
				
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
	
	//DROPDOWN_LIST
	
	public ArrayList<Lote> ListaLote() 
	{
		ArrayList<Lote> listaLote = new ArrayList<Lote>();
		String sql = ("SELECT IdLote, NumeroLote FROM lote WHERE EstadoLote = true");

		try 
		{
			PreparedStatement ps = cn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				Lote l = new Lote();
				l.setIdLote(rs.getInt("IdLote"));
				l.setNumeroLote(rs.getString("NumeroLote"));
				
				listaLote.add(l);
			}
		} 
		catch (Exception e) 
		{
			System.out.println("DATOS: ERROR AL OBTENER LOS LOTES "+ e.getMessage());
			e.printStackTrace();
		}
		
		return listaLote;
	}
	
	public ArrayList<TipoMovimiento> ListaTipoMovimiento() 
	{
		ArrayList<TipoMovimiento> listaTipMov = new ArrayList<TipoMovimiento>();
		String sql = ("SELECT IdTipoMovimiento, NombreTipoMovimiento  FROM tipomovimiento WHERE EstadoTipoMovimiento = true");

		try 
		{
			PreparedStatement ps = cn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				TipoMovimiento tm = new TipoMovimiento();
				tm.setIdTipoMovimiento(rs.getInt("IdTipoMovimiento"));
				tm.setNombreTipoMovimiento(rs.getString("NombreTipoMovimiento"));
				
				listaTipMov.add(tm);
			}
		} 
		catch (Exception e) 
		{
			System.out.println("DATOS: ERROR AL OBTENER LOS LOTES "+ e.getMessage());
			e.printStackTrace();
		}
		
		return listaTipMov;
	}
	
	//END
	
	public ArrayList<Movimiento> DetallarMovimientos(int id) 
	{
		ArrayList<Movimiento> listMov = new ArrayList<Movimiento>();

		try 
		{	
			String sql = ("SELECT m.DescripcionMovimiento, m.FechaMovimiento, tm.NombreTipoMovimiento, dm.CantidadProductoDM, p.StockProducto FROM movimiento m " + 
							"INNER JOIN producto p ON p.IdProducto = m.IdProductoMovimiento "+
							"INNER JOIN detallemovimiento dm ON m.IdMovimiento = dm.IdMovimientoDM " + 
							"INNER JOIN tipomovimiento tm ON m.IdTipoMovimiento = tm.IdTipoMovimiento " + 
							"WHERE dm.EstadoDetalleMovimiento = true AND m.EstadoMovimiento = true AND m.IdProductoMovimiento = ?");
			
			PreparedStatement ps = cn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			int suma = 0;
			while(rs.next())
			{
				Movimiento m = new Movimiento();
				
				m.setDescripcionMovimiento(rs.getString("DescripcionMovimiento"));
				m.setFechaMovimiento(rs.getDate("FechaMovimiento"));
				m.setNombreTipoMovimiento(rs.getString("NombreTipoMovimiento"));
				m.setCantidadProductoDM(rs.getInt("CantidadProductoDM"));
				m.setStockProducto(rs.getInt("StockProducto"));
				
				/*suma += rs.getInt("CantidadProductoDM");
				m.setStockTotal(suma);*/
				
				listMov.add(m);
			}
		} 
		catch (Exception ex) 
		{
			System.err.println("ERROR AL OBTENER MOVIMIENTOS "+ ex.getMessage());
			ex.printStackTrace();
		}
		
		return listMov;
	}
	
	public boolean GuardarMovimientos(Movimiento m) 
	{
		try 
		{
			Date fecha = new Date();
			java.sql.Date fDate = new java.sql.Date(fecha.getTime());
			
			//GUARDAR MOVIMIENTO
			String sql = "INSERT INTO movimiento (DescripcionMovimiento, FechaMovimiento, IdTipoMovimiento, IdProductoMovimiento, EstadoMovimiento) VALUES (?,?,?,?,?)";
			
			PreparedStatement ps = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); 
			
			ps.setString(1, m.getDescripcionMovimiento());
			ps.setDate(2, fDate);
			ps.setInt(3, m.getIdTipoMovimiento());
			ps.setInt(4, m.getIdProductoMovimiento());
			ps.setBoolean(5, true);
			 
			ps.executeUpdate();  
			
			//GUARDAR DETALLE MOVIMIENTO
			rs = ps.getGeneratedKeys();    
			rs.next();  
			int IdMov = rs.getInt(1); 
			
			String query = "INSERT INTO detallemovimiento (IdMovimientoDM, IdLoteDM, CantidadProductoDM, EstadoDetalleMovimiento) VALUES (?,?,?,?)";
			ps = cn.prepareStatement(query);
			
			ps.setInt(1, IdMov);
			ps.setInt(2, m.getIdLoteDM());
			ps.setDouble(3, m.getCantidadProductoDM());
			ps.setBoolean(4, true);
			
			ps.executeUpdate();
			 
			ActualizarStock(m.getIdProductoMovimiento(), m.getCantidadProductoDM(), m.getIdTipoMovimiento());
			return true;
		} 
		catch (Exception ex) 
		{
			System.err.println("ERROR AL GUARDAR MOVIMIENTO "+ ex.getMessage());
			return false;
		}
	}
	
	public boolean ActualizarStock (int id, int cantidad, int tipo) 
	{
		try 
		{
			//OBTENER EL STOCK ACTUAL
			PreparedStatement psd = cn.prepareStatement("SELECT StockProducto FROM producto WHERE IdProducto = ?");
			psd.setInt(1, id);
			rs = psd.executeQuery();
			rs.next();
			int total, stock;
			
			stock = rs.getInt("StockProducto");
			
			//INGRESOS
			if (tipo == 1) 
			{
				total = (stock + cantidad);
			}
			else 
			{ //EGRESOS
				total = (stock - cantidad);
			}
			//ACTUALIZAR EL STOCK DEL PRODUCTO
			psd = cn.prepareStatement("UPDATE producto SET StockProducto = ? WHERE IdProducto = " + id);
			
			psd.setInt(1, total);
			psd.executeUpdate(); 
			
			return true;
		} 
		catch (Exception ex) 
		{
			System.err.println("ERROR AL ACTUALIZAR STOCK "+ ex.getMessage());
			return false;
		}
	}
}
