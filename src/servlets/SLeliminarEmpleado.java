/**
 * Autor: Brian Téllez
 * Fecha de creación: 4/04/2018
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

import datos.DTEmpleado;
import entidades.Empleado;
import entidades.JsonResponse;

/**
 * Servlet implementation class SLeliminarEmpleado
 */
@WebServlet("/SLeliminarEmpleado")
public class SLeliminarEmpleado extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SLeliminarEmpleado() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String idEmpleado = "";
		idEmpleado = request.getParameter("id");
		idEmpleado = idEmpleado==null?"0":idEmpleado;
		
		 response.setContentType("application/json;charset=UTF-8");
	     ServletOutputStream out = response.getOutputStream();
	     
	     JsonResponse respuesta = new JsonResponse();
		 
	     Gson gson = new Gson();
	     String json;
		
		try
		{
			DTEmpleado dte = new DTEmpleado();
			Empleado e = new Empleado();
			e.setIdEmpleado(Integer.parseInt(idEmpleado));
			
			if(dte.eliminarEmpleado(e))
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
	}
}
