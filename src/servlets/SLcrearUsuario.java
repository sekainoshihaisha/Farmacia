/**
 * Autor: Brian Téllez
 * Fecha de creación: 5/04/2018
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
 * Servlet implementation class SLcrearUsuario
 */
@WebServlet("/SLcrearUsuario")
public class SLcrearUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SLcrearUsuario() {
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
			DTUsuario dtu = new DTUsuario();
			Usuario u = new Usuario();
			
			int idEmpleado;
			String nombreUsuario = "";
			String clave = "";
			int idRol;
			int estado = 1;
			boolean estadoUsuario = true;
			
			idEmpleado = Integer.parseInt(request.getParameter("employee"));
			nombreUsuario = request.getParameter("username");
			clave = request.getParameter("password");
			idRol = Integer.parseInt(request.getParameter("rol"));
			
			
			u.setIdEmpleado(idEmpleado);
			u.setNombreUsuario(nombreUsuario);
			u.setClave(clave);
			u.setIdRol(idRol);
			u.setEstado(estado);
			u.setEstadoUsuario(estadoUsuario);
			
			if(dtu.crearUsuario(u))
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
			System.out.println("SL: ERROR AL CREAR USUARIO: " + ex.getMessage());
		}
	}
}
