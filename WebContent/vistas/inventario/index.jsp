<%
	/**
	 * Autor: Leticia Téllez
	 * Fecha de creación: 4/05/2018
	 * Última modificación: Brian Téllez
	 */
%>

<%@page import="entidades.Producto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="datos.DTProducto"%>

<%@page import="vistas.VwUsuarioVsRol"%>

<%
	ArrayList<VwUsuarioVsRol> lvOpciones = new ArrayList<VwUsuarioVsRol>();
	lvOpciones = (ArrayList<VwUsuarioVsRol>)session.getAttribute("listOpciones");
	
	Integer rol = 0;
	rol = (Integer)session.getAttribute("idRol");
	
	String miPagina = request.getRequestURL().toString();
	miPagina = miPagina.substring(31);
	boolean permiso = false;
	String opcionActual = "";
	
	for(VwUsuarioVsRol vwr : lvOpciones)
	{
		opcionActual = vwr.getURL().trim();
		
		if(opcionActual.equals(miPagina.trim()))
		{
			permiso = true;
			break;
		}
		else
		{
			permiso = false;
		}
	}
	
	if(!permiso)
	{
		response.sendRedirect("../../jsp_error.jsp");
	}
%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Productos</title>
	
	<jsp:include page="../css.html"></jsp:include>
</head>
<body>
	<jsp:include page="../menu.html"></jsp:include>

	<div class="container body-content" style="margin-top: 5%">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">Listado Productos</h3>
			</div>
			<div class="panel-body">
				<table class="table table-striped table-bordered dataTable dtr-inline">
					<thead>
						<tr>
							<th>Nombre</th>
							<th>Precio</th>
							<th>Existencias</th>
							<th>Descripción</th>
							<th>Acciones</th>
						</tr>
					</thead>
					<tbody>
					<%
							DTProducto dtp = new DTProducto();
							ArrayList<Producto> prod = new ArrayList<Producto>();
							prod = dtp.ListaProductos();
							
							//Guardamos esa lista en una Sesión
							session.setAttribute("ListaProducto",prod);
							
							for(Producto p: prod)
							{
						%>
							<tr>
								<td><%=p.getNombreProducto() %></td>
								<td><%=p.getPrecioProducto()%></td>
								<td><%=p.getStockProducto()%></td>
								<td><%=p.getDescripcionProducto()%></td>
								<td class="action-center">
									<%if (p.getStockProducto() > 0) { %>
			                            <a class="btn btn-success btn-icon btn-circle detalle" title="Movimientos" onclick="detalle('<%=p.getIdProducto()%>');" href="#">
			                                <span class="glyphicon glyphicon-info-sign"></span>
			                            </a>
		                            <%} %>
								</td>
							</tr>
						<%
							}
						%>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	
	
	<% // REFERENCIAS DE SCRIPTS  %>
	<jsp:include page="../scripts.html"></jsp:include>
	<script>
	function detalle(id)
	{
		location.assign("detalle.jsp?id="+id);
	}
	</script>
</body>
</html>