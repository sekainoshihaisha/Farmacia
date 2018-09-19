/**
 * Autor: Leticia Téllez
 * Fecha de creación: 11/04/2018
 * Última modificación: Leticia Téllez
 */

package servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import datos.DTFactura;
import entidades.Empleado;
import entidades.Factura;
import entidades.JsonResponse;

/**
 * Servlet implementation class SLFactura
 */
@WebServlet("/SLFactura")
public class SLFactura extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SLFactura() {
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
		 response.setContentType("application/json;charset=UTF-8");
	     ServletOutputStream out = response.getOutputStream();
	     
	     JsonResponse respuesta = new JsonResponse();
		 DTFactura fact = new DTFactura();
		 
	     Gson gson = new Gson();
	     String json;
	     
	     int opcion = Integer.parseInt(request.getParameter("opc"));
	     
	     //GUARDAR
		 if(opcion == 1) 
		 {  
			try 
			{
				Factura f = new Factura();
	
			    String arreglo = request.getParameter("Factura");
			    f = gson.fromJson(arreglo, Factura.class);
			        
				
					if(fact.GuardarFactura(f))
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
			
			//CANCELAR
			if(opcion == 2) 
			{
				int IdFactura = Integer.parseInt(request.getParameter("id"));
					 
				if (IdFactura != 0)
				{
					if(fact.CancelarFactura(IdFactura))
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
				else 
				{ 
					respuesta.setStatus(false);
					respuesta.setMessage("Problemas al Ingresar el Registro");
							
					json = gson.toJson(respuesta);
					out.print(json);
				}
			}
	}
}
