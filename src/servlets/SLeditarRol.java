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

import datos.DTRol;
import entidades.Rol;

/**
 * Servlet implementation class SLeditarRol
 */
@WebServlet("/SLeditarRol")
public class SLeditarRol extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SLeditarRol() {
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
		String idRol = "";
		idRol = request.getParameter("identificationRol");
		idRol = idRol==null?"0":idRol;
		String nombreRol = "";
		String descripcionRol = "";
		
		try
		{
			DTRol dtr = new DTRol();
			Rol r = new Rol();
			r.setIdRol(Integer.parseInt(idRol));
			
			nombreRol = request.getParameter("nameRol");
			descripcionRol = request.getParameter("descriptionRol");
			
			r.setNombreRol(nombreRol);
			r.setDescripcionRol(descripcionRol);
			
			if(dtr.modificarRol(r))
			{
				response.sendRedirect("/Farmacia/vistas/rol/index.jsp");
			}
			else
			{
				response.sendRedirect("/Farmacia/vistas/rol/index.jsp?error");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.err.println("SL ERROR: NO SE MODIFICÓ: " + e.getMessage());
		}
	}

}
