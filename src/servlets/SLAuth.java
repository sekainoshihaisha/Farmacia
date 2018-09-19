/**
 * Autor: Brian Téllez
 * Fecha de creación: 25/04/2018
 * Última modificación: Brian Téllez
 */

package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datos.DTUsuario;
import entidades.Usuario;

/**
 * Servlet implementation class SLAuth
 */
@WebServlet("/login.do")
public class SLAuth extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SLAuth() {
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
		Usuario u = new Usuario();
		DTUsuario dtu = new DTUsuario();
		
		boolean existe = false;
		
		u.setNombreUsuario(request.getParameter("user"));
		u.setClave(request.getParameter("password"));
		
		try
		{
			existe = dtu.verificarLogin(u);
			
			if(existe)
			{
				HttpSession hts = request.getSession(true);
				request.setAttribute("user", u);
				hts.setAttribute("user", u.getNombreUsuario());
				response.sendRedirect("index.jsp");
			}
			else
			{
				response.sendRedirect("login.jsp?error");
			}
		}
		catch(Exception e)
		{
			System.out.println("SL_Seguridad: El error es: "+e.getMessage());
			e.printStackTrace();
			response.sendRedirect("login.jsp?msj=503");
		}
	}
}
