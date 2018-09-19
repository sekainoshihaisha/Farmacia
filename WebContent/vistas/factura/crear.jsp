<%
	/**
	 * Autor: Leticia Téllez
	 * Fecha de creación: 6/04/2018
	 * Última modificación: Brian Téllez
	 */
%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
   import = "java.util.ArrayList, entidades.*, datos.DTFactura"
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
	<title>Crear Factura</title>
	<jsp:include page="../css.html"></jsp:include>

<%
	ArrayList<Cliente> listaCli = new ArrayList<Cliente>();
	ArrayList<Empleado> listaEmp = new ArrayList<Empleado>();
	ArrayList<Producto> listaProd = new ArrayList<Producto>();
	
	DTFactura fact = new DTFactura();
	
	listaCli = fact.ListaClientes();
	listaEmp = fact.ListaVendedores();
	listaProd = fact.ListaProductos();
%>

</head>
<body>
	<jsp:include page="../menu.html"></jsp:include>
    
    <%//CONTENIDO %>
    <div class="container body-content" style="margin-top: 5%">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">Registro Factura</h3>
			</div>
			<form>
			<div class="panel-body">
				<div class="form-horizontal">
					<div class="col-md-10">
						<h4> Cabecera</h4>
						<hr>
						<div class="form-group">
							<label class="control-label col-md-3">Número</label>
							<div class="col-md-9">
								<input type="text" id="NumeroFactura" name="NumeroFactura" class="NumeroFactura form-control"/>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-3">Cliente</label>
							<div class="col-md-9">
								<select id="IdClienteFactura" class="form-control IdClienteFactura">
									<% for(Cliente cli : listaCli) { %>
										<option value="<%=cli.getIdCliente()%>">
											<%=cli.getNombreCliente() + " " + cli.getApellidoCliente() %>
										</option>
									<% } %>
								
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-3">Vendedor</label>
							<div class="col-md-9">
								<select id="IdEmpleadoFactura" class="form-control IdEmpleadoFactura">
									<% for(Empleado emp : listaEmp) { %>
										<option value="<%=emp.getIdEmpleado()%>">
											<%=emp.getNombreEmpleado() + " " + emp.getApellidoEmpleado() %>
										</option>
									<% } %>
								</select>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-9  col-md-offset-2">
								<label class="control-label">¿Receta?</label>
								<input type="checkbox" name="VentaReceta" id="VentaReceta" class="VentaReceta"/>
							</div>
						</div>
					</div>
				
					<div class="col-md-12">
						<h4>Detalle</h4>
						<hr>
						<div class="hide">
							<select id="IdProducto" class="IdProducto form-control">
								<% for(Producto prod : listaProd) { %>
										<option value="<%=prod.getIdProducto()%>">
											<%=prod.getNombreProducto() %>
										</option>
								<% } %>
							</select>
						</div>
						<table class="table table-striped table-bordered" id="tblProductos">
							<thead>
								<tr>
									<th>Cantidad</th>
									<th style="width: 50%">Producto</th>
									<th>Precio</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
							<%//CODIGO JAVASCRIPT %>
							</tbody>
						</table>
						<% //<div class="form-group"> 
							//<label class="control-label col-md-3 col-md-offset-6">Total</label>
							//<div class="col-md-2">
								//<input class="form-control Total" id="Total" />
							//</div>
							//<div class="btn btn-success" id="btnCalcularTotal"><span class="glyphicon glyphicon-plus-sign"></span></div>
						//</div>
						%>
						<div class="text-right">
						    <div class="btn btn-info btn-outline" id="btn_agregarProduct">Agregar</div>
						</div>
					</div>
				</div>
			</div>
			<div class="panel-footer text-left">
                <a class="btn btn-default" href="../../vistas/factura/index.jsp">Cancelar</a>
                <button class="btn btn-primary" id="btnGuardarFact" type="submit">Guardar</button>
            </div>
            </form>
		</div>
	</div>
	
	<% // REFERENCIAS DE SCRIPTS  %>
	<jsp:include page="../form.html"></jsp:include>
	<script src="../../js/factura/crear.js"></script>
</body>
</html>