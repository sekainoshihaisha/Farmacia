/**
 * Autor: Brian Téllez
 * Fecha de creación: 7/05/2018
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
import vistas.VwDetalleFactura;

public class DTVwDetalleFactura
{
	Conexion c = Conexion.getInstance();
	Connection cn = Conexion.getConnection();
	ResultSet rs = null;
	
	public ArrayList<VwDetalleFactura> ListarDetalleFacturas(int id)
	{
		ArrayList<VwDetalleFactura> detallefactura = new ArrayList<VwDetalleFactura>();
		
		try
		{
			String sql = ("SELECT * FROM vwdetallefactura WHERE IdFactura = ?");
			PreparedStatement ps = cn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				VwDetalleFactura df = new VwDetalleFactura();
				
				df.setIdDetalleFactura(rs.getInt("IdDetalleFactura"));
				df.setIdFactura(rs.getInt("IdFactura"));
				df.setNumeroFactura(rs.getString("NumeroFactura"));
				df.setIdProducto(rs.getInt("IdProducto"));
				df.setNombreProducto(rs.getString("NombreProducto"));
				df.setCantidadProducto(rs.getInt("CantidadProducto"));
				df.setPrecioProducto(rs.getFloat("PrecioProducto"));
				df.setTotalProducto(rs.getFloat("TotalProducto"));
				df.setEstadoDetalleFactura(rs.getBoolean("EstadoDetalleFactura"));
				
				detallefactura.add(df);
			}
		}
		catch(Exception e)
		{
			System.out.println("DATOS: ERROR AL OBTENER DETALLE DE LA FACTURA: "+ e.getMessage());
			e.printStackTrace();
		}
		
		return detallefactura;
	}
}
