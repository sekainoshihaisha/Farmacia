/**
 * Autor: Brian Téllez
 * Fecha de creación: 4/04/2018
 * Última modificación: Brian Téllez
 */

package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.DTEmpleado;
import entidades.Empleado;

/**
 * Servlet implementation class SLeditarEmpleado
 */
@WebServlet("/SLeditarEmpleado")
public class SLeditarEmpleado extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SLeditarEmpleado() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String idEmpleado = "";
		idEmpleado = request.getParameter("identificationEmpleado");
		idEmpleado = idEmpleado==null?"0":idEmpleado;
		String nombreEmpleado = "";
		String apellidoEmpleado = "";
		String cedulaEmpleado = "";
		String telefonoEmpleado = "";
		String direccionEmpleado = "";
		
		try
		{
			DTEmpleado dte = new DTEmpleado();
			Empleado e = new Empleado();
			e.setIdEmpleado(Integer.parseInt(idEmpleado));
			
			nombreEmpleado = request.getParameter("nameEmpleado");
			apellidoEmpleado = request.getParameter("lastNameEmpleado");
			cedulaEmpleado = request.getParameter("idCardEmpleado");
			telefonoEmpleado = request.getParameter("phoneEmpleado");
			direccionEmpleado = request.getParameter("addressEmpleado");
			
			e.setNombreEmpleado(nombreEmpleado);
			e.setApellidoEmpleado(apellidoEmpleado);
			e.setCedulaEmpleado(cedulaEmpleado);
			e.setTelefonoEmpleado(telefonoEmpleado);
			e.setDireccionEmpleado(direccionEmpleado);
			
			if(dte.modificarEmpleado(e))
			{
				response.sendRedirect("/Farmacia/vistas/empleado/index.jsp");
			}
			else
			{
				response.sendRedirect("/Farmacia/vistas/empleado/index.jsp?error");
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			System.err.println("SL ERROR: NO SE MODIFICÓ: " + ex.getMessage());
		}
	}
}
