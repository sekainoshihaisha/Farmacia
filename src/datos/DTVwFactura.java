/**
 * Autor: Brian Téllez
 * Fecha de creación: 6/05/2018
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
import vistas.*;
import datos.DTProducto;

public class DTVwFactura
{
	Conexion c = Conexion.getInstance();
	Connection cn = Conexion.getConnection();
	ResultSet rs = null;
	
	public ArrayList<VwFactura> ListarFacturas()
	{
		ArrayList<VwFactura> facturas = new ArrayList<VwFactura>();
		ArrayList<DetalleFactura> detallefacturas = new ArrayList<DetalleFactura>();
		String sql = ("SELECT * FROM vwfactura");
		
		try
		{
			PreparedStatement ps = cn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				VwFactura f = new VwFactura();
				
				f.setIdFactura(rs.getInt("IdFactura"));
				f.setNumeroFactura(rs.getString("NumeroFactura"));
				f.setIdClienteFactura(rs.getInt("IdClienteFactura"));
				f.setCliente(rs.getString("Cliente"));
				f.setIdEmpleadoFactura(rs.getInt("IdEmpleadoFactura"));
				f.setEmpleado(rs.getString("Empleado"));
				f.setFechaFactura(rs.getDate("FechaFactura"));
				f.setEstadoFactura(rs.getBoolean("EstadoFactura"));
				
				facturas.add(f);
			}
		}
		catch(Exception e)
		{
			System.out.println("DATOS: ERROR AL OBTENER LAS FACTURAS "+ e.getMessage());
			e.printStackTrace();
		}
		
		return facturas;
	}
}
