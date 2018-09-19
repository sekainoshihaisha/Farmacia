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
 * Servlet implementation class SLcrearEmpleado
 */
@WebServlet("/SLcrearEmpleado")
public class SLcrearEmpleado extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SLcrearEmpleado() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
			DTEmpleado dte = new DTEmpleado();
			Empleado e = new Empleado();
			
			String nombreEmpleado = "";
			String apellidoEmpleado = "";
			String cedulaEmpleado = "";
			String telefonoEmpleado = "";
			String direccionEmpleado = "";
			boolean estadoEmpleado = true;
			
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
			e.setEstadoEmpleado(estadoEmpleado);
			
			if(dte.crearEmpleado(e))
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
			System.out.println("SL: ERROR AL CREAR EMPLEADO: " + ex.getMessage());
		}
	}
}
