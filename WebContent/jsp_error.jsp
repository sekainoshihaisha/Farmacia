<!--
	Autor: Brian Téllez
	Fecha de creación: 25/04/2018
	Ultima modificación: Brian Téllez
 -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Error</title>
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
</body>
</html>