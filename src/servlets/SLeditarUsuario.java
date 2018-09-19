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

import datos.DTUsuario;
import entidades.Usuario;

/**
 * Servlet implementation class SLeditarUsuario
 */
@WebServlet("/SLeditarUsuario")
public class SLeditarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SLeditarUsuario() {
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
		String idUsuario = "";
		idUsuario = request.getParameter("identificationUsuario");
		idUsuario = idUsuario==null?"0":idUsuario;
		int idEmpleado;
		String nombreUsuario = "";
		String contrasena = "";
		int idRol;
		
		try
		{
			DTUsuario dtu = new DTUsuario();
			Usuario u = new Usuario();
			u.setIdUsuario(Integer.parseInt(idUsuario));
			
			idEmpleado = Integer.parseInt(request.getParameter("employee"));
			nombreUsuario = request.getParameter("username");
			contrasena = request.getParameter("password");
			idRol = Integer.parseInt(request.getParameter("rol"));
			
			u.setIdEmpleado(idEmpleado);
			u.setNombreUsuario(nombreUsuario);
			u.setClave(contrasena);
			u.setIdRol(idRol);
			
			if(dtu.modificarUsuario(u))
			{
				response.sendRedirect("/Farmacia/vistas/usuario/index.jsp");
			}
			else
			{
				response.sendRedirect("/Farmacia/vistas/usuario/index.jsp?error");
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			System.err.println("SL ERROR: NO SE MODIFICÓ: " + ex.getMessage());
		}
	}
}
