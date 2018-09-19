/**
 * Autor: Amara López
 * Fecha de creación: 2/04/2018
 * Última modificación: Amara López
 */

package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;
import javax.swing.JOptionPane;

import org.apache.commons.dbcp.BasicDataSource;

public class Conexion 
{
	private static Conexion INSTANCE = null;
	private static Connection cn = null;
	private static DataSource dataSource;
	private static String db = "farmacia";
	private static String url = "jdbc:mysql://localhost:3306/"+db;
	private static String user = "root";
	private static String pwd = "1234";
	private static String DRIVER_CLASS = "com.mysql.jdbc.Driver";
	
	public Conexion() 
	{
		inicializaDataSource();
	}
	
	private synchronized static void createInstance()
	{
		if(INSTANCE == null)
		{
			INSTANCE = new Conexion();
		}
	}
	
	public static Conexion getInstance()
	{
		if(INSTANCE == null)
		{
			createInstance();
		}
		return INSTANCE;
	}
	
	public final void inicializaDataSource()
	{
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName(DRIVER_CLASS);
		basicDataSource.setUsername(user);
		basicDataSource.setPassword(pwd);
		basicDataSource.setUrl(url);
		basicDataSource.setMaxActive(50);
		dataSource = basicDataSource;
	}
	
	public static boolean EstaConectado()
	{
		boolean resp = false;
		try 
		{
			cn = Conexion.dataSource.getConnection();
			if(cn == null || cn.isClosed())
			{
				resp = false;
			}
			else
			{
				resp = true;
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println("CONEXION: " + e.getMessage());
		}
		
		return resp;
	}
	
	public static Connection getConnection()
	{
		if(EstaConectado() == false)
		{
			try 
			{
				cn = Conexion.dataSource.getConnection();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
				System.out.println("CONEXION: "+ e.getMessage());
			}
		}
		
		return cn;
	}
	
	public static void CrearConexion()
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection(url,user, pwd);
			System.out.println("SE CONECTÓ A LA BASE DE DATOS");
		} 
		catch (ClassNotFoundException e) 
		{
			cn = null;
			System.out.println("ERROR NO SE PUEDE CARGAR EL DRIVER");
		}
		catch (SQLException e) 
		{
			cn = null;
			System.out.println("ERROR AL ESTABLECER LA CONEXIÓN: "+e.getMessage());
		}
	}

	public static void main(String[] args) 
	{
		Conexion.getInstance();
		Connection cn = null;
		
		try 
		{
			cn = Conexion.getConnection();
			if (cn != null)
			{
				JOptionPane.showMessageDialog(null, "Conectado a " + db);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Error al Conectar a " + db);
				System.out.println("Error al Conectar a " + db);
			}
			
		}
		finally 
		{
			try 
			{
				cn.close();
				System.out.println("Se desconectó de " + db);
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
				System.out.println("CONEXIÓN: " + e.getMessage());
			}
		}
		
	}

}
