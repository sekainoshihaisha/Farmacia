<%
	/**
	 * Autor: Leticia Téllez
	 * Fecha de creación: 6/04/2018
	 * Última modificación: Brian Téllez
	 */
%>

<%@page import="entidades.Factura"%>
<%@page import="vistas.VwFactura"%>
<%@page import="java.util.ArrayList"%>
<%@page import="datos.DTFactura"%>
<%@page import="datos.DTVwFactura"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Listado Facturas</title>
	
	<jsp:include page="../css.html"></jsp:include>
</head>
<body>
	<jsp:include page="../menu.html"></jsp:include>

	<div class="container body-content" style="margin-top: 5%">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">Listado Facturas</h3>
			</div>
			<div class="panel-body">
				<a class="btn btn-info botonCrear" href="../../vistas/factura/crear.jsp">Nuevo</a>
				<table class="table table-striped table-bordered dataTable dtr-inline">
					<thead>
						<tr>
							<th>Número</th>
							<th hidden="true">Id Cliente</th>
							<th>Cliente</th>
							<th hidden="true">Id Empleado</th>
							<th>Vendedor</th>
							<th>Fecha</th>
							<th>Estado</th>
							<th>Acciones</th>
						</tr>
					</thead>
					<tbody>
					<%
							DTVwFactura dtf = new DTVwFactura();
							ArrayList<VwFactura> fact = new ArrayList<VwFactura>();
							fact = dtf.ListarFacturas();
							
							//Guardamos esa lista en una Sesión
							
							ArrayList<VwFactura> factura = null;
							factura = dtf.ListarFacturas();
							session.setAttribute("ListaFact",factura);
							
							for(VwFactura f: fact)
							{
						%>
							<tr>
								<td><%=f.getNumeroFactura() %></td>
								<td hidden="true"><%=f.getIdClienteFactura()%></td>
								<td><%=f.getCliente()%></td>
								<td hidden="true"><%=f.getIdEmpleadoFactura()%></td>
								<td><%=f.getEmpleado()%></td>
								<td><%=f.getFechaFactura()%></td>
								<td><%if (f.isEstadoFactura()) { %>
									<span class="text-success">Activo</span>
									<%} else {%>
										<span class="text-danger">Cancelado</span>
									<%} %>
								</td>
								<td class="action-center">
									<%if (f.isEstadoFactura()) { %>
			                            <a class="btn btn-danger btn-icon btn-circle cancelar" title="Cancelar Factura" data-id="<%=f.getIdFactura() %>" href="#">
			                                <span class="glyphicon glyphicon-ban-circle"></span>
			                            </a>
		                            <%} %>
		                            <a class="btn btn-success btn-icon btn-circle detalle" title="Detalle" onclick="detalle('<%=f.getIdFactura()%>');" href="#">
	                                	<span class="glyphicon glyphicon-info-sign"></span>
			                        </a>
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
	<script src="../../js/factura/index.js"></script>
	<script>
	function detalle(id)
	{
		location.assign("detalle.jsp?id="+id);
	}
	</script>
</body>
</html>