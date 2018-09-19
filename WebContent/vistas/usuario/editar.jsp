<!--
	Autor: Brian Téllez
	Fecha de creación: 4/04/2018
	Ultima modificación: Brian Téllez
 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="entidades.*,datos.*,java.util.ArrayList,vistas.VwUsuario"
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
	<title>Editar usuario</title>
	
	<jsp:include page="../css.html"></jsp:include>
</head>
<body>
	<jsp:include page="../menu.html"></jsp:include>
	
	<div class="container body-content" style="margin-top: 5%">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">Editar usuario</h3>
			</div>
			<form method="POST" action="../../SLeditarUsuario">
				<%
					ArrayList<VwUsuario> listaUsuarios = (ArrayList<VwUsuario>)session.getAttribute("ListaUsuarios");
					String idUsuario = request.getParameter("id");
					VwUsuario u = null;
					int idUser = 0;
					
					try
					{
						idUser = Integer.parseInt(idUsuario);
					}
					catch(Exception ex)
					{
						idUser = 0;
						ex.printStackTrace();
						ex.getMessage();
					}
					
					for(VwUsuario user : listaUsuarios)
					{
						if(user.getIdUsuario() == Integer.parseInt(idUsuario))
						{
							u = user;
						}
					}
					
					int employee = u.getIdEmpleado();
					String username = u.getNombreUsuario();
					String password = u.getClave();
					//int rol = u.getIdRol();
					
					
					ArrayList<Rol> listaRol = new ArrayList<Rol>();
					ArrayList<Empleado> listaEmp = new ArrayList<Empleado>();
					
					DTFactura fact = new DTFactura();
					DTUsuario user = new DTUsuario();
					
					listaRol = user.ListaRoles();
					listaEmp = fact.ListaVendedores();
				%>
				
				<div class="panel-body">
					<div class="form-horizontal">
						<div class="col-md-10">
							<div class="form-group" hidden="true">
								<input type="text" name="identificationUsuario" id="identificationUsuario" class="form-control"/>
							</div>
							<div class="form-group">
								<label class="control-label col-md-3">Empleado</label>
								<div class="col-md-9">
									<select id="employee" name="employee" class="form-control employee">
										<% for(Empleado emp : listaEmp) { %>
											<option value="<%=emp.getIdEmpleado()%>">
												<%=emp.getNombreEmpleado() + " " + emp.getApellidoEmpleado() %>
											</option>
										<% } %>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-3">Usuario</label>
								<div class="col-md-9">
									<input type="text" name="username" id="username" required="true" class="form-control"/>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-3">Contraseña</label>
								<div class="col-md-9">
									<input type="password" name="password" id="password" required="true" class="form-control"/>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-3">Rol</label>
								<div class="col-md-9">
									<select id="rol" name="rol" class="form-control rol">
										<% for(Rol r : listaRol) { %>
											<option value="<%=r.getIdRol()%>">
												<%=r.getNombreRol() %>
											</option>
										<% } %>
									</select>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="panel-footer text-left">
					<a class="btn btn-default" href="../../vistas/usuario/index.jsp">Cancelar</a>
					<button class="btn btn-primary" type="submit">Guardar</button>
				</div>
			</form>
		</div>
	</div>
	
	<jsp:include page="../form.html"></jsp:include>
	<script type="text/javascript">
	$(document).ready(function()
	{
		$('#identificationUsuario').val('<%=u.getIdUsuario()%>');
		$('#employee').val('<%=u.getIdEmpleado()%>');
		$('#username').val('<%=u.getNombreUsuario()%>');
		$('#password').val('<%=u.getClave()%>');
		$('#rol').val('<%=u.getIdRol()%>')
	});
	</script>
</body>
</html>