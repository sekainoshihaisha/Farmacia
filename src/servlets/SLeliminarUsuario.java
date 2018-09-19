/**
 * Autor: Brian Téllez
 * Fecha de creación: 5/04/2018
 * Última modificación: Brian Téllez
 */

package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import datos.DTUsuario;
import entidades.JsonResponse;
import entidades.Usuario;

/**
 * Servlet implementation class SLeliminarUsuario
 */
@WebServlet("/SLeliminarUsuario")
public class SLeliminarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SLeliminarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String idUsuario = "";
		idUsuario = request.getParameter("id");
		idUsuario = idUsuario==null?"0":idUsuario;
		
		 response.setContentType("application/json;charset=UTF-8");
	     ServletOutputStream out = response.getOutputStream();
	     
	     JsonResponse respuesta = new JsonResponse();
		 
	     Gson gson = new Gson();
	     String json;
		try
		{
			DTUsuario dtu = new DTUsuario();
			Usuario u = new Usuario();
			u.setIdUsuario(Integer.parseInt(idUsuario));
			
			if(dtu.eliminarUsuario(u))
			{
				respuesta.setStatus(true);
				respuesta.setMessage("Registro Eliminado Correctamente");
				
				json = gson.toJson(respuesta);
				out.print(json);
			}
			else
			{
				respuesta.setStatus(false);
				respuesta.setMessage("Problemas al Eliminar Registro");
				
				json = gson.toJson(respuesta);
				out.print(json);
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			System.err.println("SL ERROR: NO SE ELIMINÓ: " +e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
