/**
 * Autor: Brian Téllez
 * Fecha de creación: 25/04/2018
 * Última modificación: Brian Téllez
 */

package datos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import vistas.VwRolVsOpc;

public class DTVwRolVsOpc
{
	Conexion c = Conexion.getInstance();
	Connection cn = Conexion.getConnection();
	ResultSet rs = null;
	
	public ArrayList<VwRolVsOpc> listarRolOpciones(int rol)
	{
		ArrayList<VwRolVsOpc> rolOpciones = new ArrayList<VwRolVsOpc>();
		String sql = ("SELECT * FROM farmacia.vwrolvsopc WHERE IdRol = ?");
		
		try
		{
			VwRolVsOpc vropc = new VwRolVsOpc();
			vropc.setIdRolOpcion(rs.getInt("IdRolOpcion"));
			vropc.setIdOpcion(rs.getInt("IdOpcion"));
			vropc.setIdRol(rs.getInt("IdRol"));
			vropc.setNombreRol(rs.getString("NombreRol"));
			vropc.setURL(rs.getString("URL"));
			vropc.setNombreOpcion(rs.getString("NombreOpcion"));
			
			rolOpciones.add(vropc);
		}
		catch(Exception e)
		{
			System.out.println("DATOS: ERROR AL OBTENER LOS ROLES Y OPCIONES "+ e.getMessage());
			e.printStackTrace();
		}
		
		return rolOpciones;
	}
}
