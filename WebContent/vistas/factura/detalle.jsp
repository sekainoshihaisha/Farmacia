<!--
	Autor: Brian Téllez
	Fecha de creación: 7/04/2018
	Ultima modificación: Brian Téllez
-->

<%@page import="datos.DTVwDetalleFactura"%>
<%@page import="vistas.VwDetalleFactura"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "java.util.ArrayList"
%>

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
	<title>Detalle factura</title>
	<jsp:include page="../css.html"></jsp:include>
	
	<%
		ArrayList<VwDetalleFactura> listaDetalleFactura = new ArrayList<VwDetalleFactura>();
		
		DTVwDetalleFactura dtdf = new DTVwDetalleFactura();
		
		int IdFactura = Integer.parseInt(request.getParameter("id"));
		
		listaDetalleFactura = dtdf.ListarDetalleFacturas(IdFactura);
	%>
	
</head>
<body>
	<jsp:include page="../menu.html"></jsp:include>
	
	<div class="container body-content" style="margin-top: 5%">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">Detalle factura</h3>
			</div>
			
			<form>
				<div class="panel-body">
					<input type="hidden" value="<%=IdFactura%>" id="IdFactura">
					<table class="table table-striped table-bordered dataTable dtr-inline">
						<thead>
							<tr>
								<th>Producto</th>
								<th>Cantidad</th>
								<th>Precio</th>
								<th>Total producto</th>
							</tr>
						</thead>
						<tbody>
							<%
								session.setAttribute("ListaDetalleFactura", dtdf);
							
								for(VwDetalleFactura vwdf : listaDetalleFactura)
								{
							%>
							<tr>
								<td><%=vwdf.getNombreProducto()%></td>
								<td><%=vwdf.getCantidadProducto()%></td>
								<td><%=vwdf.getPrecioProducto()%></td>
								<td><%=vwdf.getTotalProducto()%></td>
							</tr>
							<%
								}
							%>
						</tbody>
					</table>
				</div>
				<div class="panel-footer">
					<a class="btn btn-default" href="../../vistas/factura/index.jsp">Regresar</a>
				</div>
			</form>
		</div>
	</div>
	
	<jsp:include page="../form.html"></jsp:include>
</body>
</html>