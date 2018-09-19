<!--
	Autor: Leticia Téllez
	Fecha de creación: 2/04/2018
	Ultima modificación: Brian Téllez
 -->

<%@page import="datos.DTUsuario"%>
<%@page import="vistas.VwUsuarioVsRol"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Cache-Control", "no-store");
	response.setDateHeader("Expires", 0);
	response.setDateHeader("Expires", -1);
%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Farmacia</title>
	<link rel="stylesheet" href="nifty/v2.6/css/bootstrap.min.css">
	
	<%
		int rolId = 0;
		int idUsuario = 0;
		String loginUser = "";
		String url = "";
		loginUser = (String)session.getAttribute("user");
		loginUser = loginUser==null?"":loginUser;
		
		if(loginUser.equals(""))
		{
			response.sendRedirect("login.jsp");
		}
		else
		{
			DTUsuario dtu = new DTUsuario();
			ArrayList<VwUsuarioVsRol> listaUsuario = new ArrayList<VwUsuarioVsRol>();
			listaUsuario = dtu.listaRol(loginUser);
			
			for(VwUsuarioVsRol vtu : listaUsuario)
			{
				rolId = vtu.getIdRol();
				idUsuario = vtu.getIdUsuario();
				url = vtu.getURL();
				break;
			}
			
			ArrayList<VwUsuarioVsRol> lvop = new ArrayList<VwUsuarioVsRol>();
			lvop = dtu.obtenerOpciones(rolId);
			HttpSession hts2 = request.getSession(true);
			hts2.setAttribute("listOpciones", lvop);
			
			HttpSession hts3 = request.getSession(true);
			hts3.setAttribute("idUsuario", idUsuario);
			
			HttpSession hts4 = request.getSession(true);
			hts4.setAttribute("idRol", rolId);
		}
	%>
</head>
<body>
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index.jsp">Farmacia</a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Seguridad<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="vistas/usuario/index.jsp">Usuarios</a></li>
							<li><a href="vistas/rol/index.jsp">Roles</a></li>
							<li><a href="vistas/empleado/index.jsp">Empleados</a></li>
						</ul>
					</li>
					<li><a href="vistas/factura/index.jsp">Factura</a></li>
					<li><a href="vistas/inventario/index.jsp">Inventario</a></li>
					<li><a href="vistas/reporte/index.jsp">Reportes</a></li>
					<li><a href="login.jsp">Cerrar sesión</a></li>
				</ul>
			</div>
		</div>
	</div>
	
    <script src="nifty/v2.6/js/jquery.min.js"></script>
	<script src="nifty/v2.6/js/bootstrap.min.js"></script></body>
</html>