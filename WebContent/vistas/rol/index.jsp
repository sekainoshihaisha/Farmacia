<!--
	Autor: Brian Téllez
	Fecha de creación: 4/04/2018
	Ultima modificación: Brian Téllez
 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
	import="java.util.ArrayList,entidades.Rol,datos.DTRol"
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
	<title>Listado de roles</title>
	
	<jsp:include page="../css.html"></jsp:include>
</head>
<body>
	<jsp:include page="../menu.html"></jsp:include>
	
	<div class="container body-content" style="margin-top: 5%">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">Listado de roles</h3>
			</div>
			<div class="panel-body">
				<a class="btn btn-info botonCrear" href="crear.jsp">Nuevo</a>
				<table class="table table-striped table-bordered dataTable dtr-inline">
					<thead>
						<tr>
							<th>Id Rol</th>
							<th>Rol</th>
							<th>Descripción</th>
							<th>Acciones</th>
						</tr>
					</thead>
					<tbody>
						<%
							DTRol dtr = new DTRol();
							ArrayList<Rol> roles = new ArrayList<Rol>();
							roles = dtr.ListarRoles();
							
							ArrayList<Rol> listaRol = null;
							listaRol = dtr.ListarRoles();
							session.setAttribute("ListaRoles", listaRol);
							
							for(Rol r : roles)
							{
						%>
						
						<tr>
							<td><%=r.getIdRol()%></td>
							<td><%=r.getNombreRol()%></td>
							<td><%=r.getDescripcionRol()%></td>
							<td class="action-center">
								<a class="btn btn-info btn-icon btn-circle" title="Editar Registro" onclick="editar('<%=r.getIdRol()%>');">
									<span class="glyphicon glyphicon-edit"></span>
								</a>
								<a class="btn btn-danger btn-icon btn-circle eliminar" title="Eliminar Registro" data-id="<%=r.getIdRol()%>" href="#">
									<span class="glyphicon glyphicon-trash"></span>
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
	
	<jsp:include page="../scripts.html"></jsp:include>
	<script src="../../js/rol/index.js"></script>
	
	<script type="text/javascript">		
    	function editar(id)
		{
			location.assign("editar.jsp?id="+id);
		}
	</script>
</body>
</html>