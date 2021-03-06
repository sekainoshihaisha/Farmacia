<!--
	Autor: Brian Téllez
	Fecha de creación: 4/04/2018
	Ultima modificación: Brian Téllez
 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
	import="entidades.Rol,datos.DTRol,java.util.ArrayList"
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
	<title>Editar rol</title>
	<jsp:include page="../css.html"></jsp:include>
</head>
<body>
	<jsp:include page="../menu.html"></jsp:include>
	
	<div class="container body-content" style="margin-top: 5%">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">Editar rol</h3>
			</div>
			<form method="POST" action="../../SLeditarRol">
				<%
					ArrayList<Rol> listaRoles = (ArrayList<Rol>)session.getAttribute("ListaRoles");
					String idRol = request.getParameter("id");
					Rol r = null;
					int idR = 0;
					
					try
					{
						idR = Integer.parseInt(idRol);
					}
					catch(Exception e)
					{
						idR = 0;
						e.printStackTrace();
						e.getMessage();
					}
					
					for(Rol ro : listaRoles)
					{
						if(ro.getIdRol() == Integer.parseInt(idRol))
						{
							r = ro;
						}
					}
					
					String nombreRol = r.getNombreRol();
					String descripcionRol = r.getDescripcionRol();
				%>
				
				<div class="panel-body">
					<div class="form-horizontal">
						<div class="col-md-10">
							<div class="form-group" hidden="true">
								<input type="text" name="identificationRol" id="identificationRol" class="form-control"/>
							</div>
							<div class="form-group">
								<label class="control-label col-md-3">Nombre</label>
								<div class="col-md-9">
									<input type="text" name="nameRol" id="nameRol" required="true" class="form-control"/>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-3">Descripción</label>
								<div class="col-md-9">
									<textarea name="descriptionRol" id="descriptionRol" required="true" class="form-control"></textarea>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="panel-footer text-left">
					<a class="btn btn-default" href="../../vistas/rol/index.jsp">Cancelar</a>
					<button class="btn btn-primary" type="submit">Guardar</button>
				</div>
			</form>
		</div>
	</div>
	
	<jsp:include page="../form.html"></jsp:include>
	<script type="text/javascript">
		$(document).ready(function()
		{
			$('#identificationRol').val('<%=r.getIdRol()%>');
			$('#nameRol').val('<%=r.getNombreRol()%>');
			$('#descriptionRol').val('<%=r.getDescripcionRol()%>')
		});
	</script>
</body>
</html>