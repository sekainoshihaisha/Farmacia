<!--
	Autor: Brian Téllez
	Fecha de creación: 3/04/2018
	Ultima modificación: Brian Téllez
 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>

<%@page import="vistas.VwUsuarioVsRol"%>
<%@page import="java.util.ArrayList"%>

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
	<title>Crear empleado</title>
	
	<jsp:include page="../css.html"></jsp:include>
</head>
<body>
	<jsp:include page="../menu.html"></jsp:include>
		
	<div class="container body-content" style="margin-top: 5%">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">Registro empleado</h3>
			</div>
			<form method="POST" action="../../SLcrearEmpleado">
				<div class="panel-body">
					<div class="form-horizontal">
						<div class="col-md-10">
							<div class="form-group">
								<label class="control-label col-md-3">Nombre</label>
								<div class="col-md-9">
									<input type="text" name="nameEmpleado" id="nameEmpleado" required="true" class="form-control"/>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-3">Apellido</label>
								<div class="col-md-9">
									<input type="text" name="lastNameEmpleado" id="lastNameEmpleado" required="true" class="form-control"/>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-3">Cédula</label>
								<div class="col-md-9">
									<input type="text" name="idCardEmpleado" id="idCardEmpleado" required="true" class="form-control"/>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-3">Teléfono</label>
								<div class="col-md-9">
									<input type="text" name="phoneEmpleado" id="phoneEmpleado" required="true" class="form-control"/>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-3">Dirección</label>
								<div class="col-md-9">
									<textarea type="text" name="addressEmpleado" id="addressEmpleado" required="true" class="form-control"></textarea>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="panel-footer text-left">
					<a class="btn btn-default" href="../../vistas/empleado/index.jsp">Cancelar</a>
					<button class="btn btn-primary" type="submit">Guardar</button>
				</div>
			</form>
		</div>
	</div>
	
	<jsp:include page="../form.html"></jsp:include>
</body>
</html>