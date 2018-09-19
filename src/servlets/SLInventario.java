/**
 * Autor: Leticia Téllez
 * Fecha de creación: 4/05/2018
 * Última modificación: Leticia Téllez
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

import datos.DTProducto;
import entidades.Factura;
import entidades.JsonResponse;
import entidades.Movimiento;
import entidades.Producto;

/**
 * Servlet implementation class SLInventario
 */
@WebServlet("/SLInventario")
public class SLInventario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SLInventario() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("application/json;charset=UTF-8");
	     ServletOutputStream out = response.getOutputStream();
	     
	     //INSTANCIAS
	     DTProducto prod = new DTProducto();
	     JsonResponse respuesta = new JsonResponse();
	     Gson gson = new Gson();
	     String json;
	     
	     try
	     {
	    	 Movimiento m = new Movimiento();
	
	    	 String arreglo = request.getParameter("Movimiento");
			 m = gson.fromJson(arreglo, Movimiento.class);
			        
			 if(prod.GuardarMovimientos(m))
			 {
				 respuesta.setStatus(true);
				 respuesta.setMessage("Registro Ingresado Correctamente");
						
				 json = gson.toJson(respuesta);
				 out.print(json);
			  } 
			  else 
			  { 
				  respuesta.setStatus(false);
				  respuesta.setMessage("Problemas al Ingresar el Registro");
						
				  json = gson.toJson(respuesta);
				  out.print(json);
			  }
			} 
			catch (Exception e) 
	     	{
				System.out.println(e.getMessage());
				respuesta.setStatus(false);
				respuesta.setMessage(e.getMessage());
					
				json = gson.toJson(respuesta);
				out.print(json);
			}
	 }

}
