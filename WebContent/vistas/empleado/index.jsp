<!--
	Autor: Brian Téllez
	Fecha de creación: 3/04/2018
	Ultima modificación: Brian Téllez
 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="java.util.ArrayList"%>
<%@page import="entidades.Empleado"%>
<%@page import="datos.DTEmpleado"%>

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
	<title>Listado de empleados</title>
	
	<jsp:include page="../css.html"></jsp:include>
</head>
<body>
	<jsp:include page="../menu.html"></jsp:include>
	
	<div class="container body-content" style="margin-top: 5%">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">Listado de empleados</h3>
			</div>
			<div class="panel-body">
				<a class="btn btn-info botonCrear" href="crear.jsp">Nuevo</a>
				<table class="table table-striped table-bordered dataTable dtr-inline">
					<thead>
						<tr>
							<th>Id Empleado</th>
							<th>Nombre</th>
							<th>Apellido</th>
							<th>Cédula</th>
							<th>Teléfono</th>
							<th>Dirección</th>
							<th>Acciones</th>
						</tr>
					</thead>
					<tbody>
						<%
							DTEmpleado dte = new DTEmpleado();
							ArrayList<Empleado> emp = new ArrayList<Empleado>();
							emp = dte.ListarEmpleados();
							
							ArrayList<Empleado> empleado = null;
							empleado = dte.ListarEmpleados();
							session.setAttribute("ListaEmpleados", empleado);
							
							for(Empleado e : emp)
							{
						%>
						
						<tr>
							<td><%=e.getIdEmpleado()%></td>
							<td><%=e.getNombreEmpleado()%></td>
							<td><%=e.getApellidoEmpleado()%></td>
							<td><%=e.getCedulaEmpleado()%></td>
							<td><%=e.getTelefonoEmpleado()%></td>
							<td><%=e.getDireccionEmpleado()%></td>
							<td class="action-center">
								<a class="btn btn-info btn-icon btn-circle" title="Editar Registro" onclick="editar('<%=e.getIdEmpleado()%>');">
									<span class="glyphicon glyphicon-edit"></span>
								</a>
								<a class="btn btn-danger btn-icon btn-circle eliminar" title="Eliminar Registro" data-id="<%=e.getIdEmpleado()%>">
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
    
    <% // REFERENCIAS DE SCRIPTS  %>
    <jsp:include page="../scripts.html"></jsp:include>
    <script src="../../js/empleado/index.js"></script>
    
    <script type="text/javascript">
    	function editar(id)
		{
			location.assign("editar.jsp?id="+id);
		}
	</script>
</body>
</html>