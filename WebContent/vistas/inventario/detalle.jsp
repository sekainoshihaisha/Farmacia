<%
	/**
	 * Autor: Leticia Téllez
	 * Fecha de creación: 4/05/2018
	 * Última modificación: Brian Téllez
	 */
%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
   import = "java.util.ArrayList, entidades.*, datos.DTProducto"
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
	<title>Movimientos</title>
	<jsp:include page="../css.html"></jsp:include>

<%
	ArrayList<TipoMovimiento> listaTipMov = new ArrayList<TipoMovimiento>();
	ArrayList<Lote> listaLote = new ArrayList<Lote>();
	ArrayList<Movimiento> listMov = new ArrayList<Movimiento>();
	
	DTProducto prod = new DTProducto();
	
	listaTipMov = prod.ListaTipoMovimiento();
	listaLote = prod.ListaLote();
	
	int IdProducto = Integer.parseInt(request.getParameter("id"));
	listMov = prod.DetallarMovimientos(IdProducto);

%>

</head>
<body>
	<jsp:include page="../menu.html"></jsp:include>
    
    <%//CONTENIDO %>
    <div class="container body-content" style="margin-top: 5%">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">Movimientos</h3>
			</div>
			<form>
			<div class="panel-body">
			<input type="hidden" value="<%=IdProducto%>" id="IdProducto">
			<table class="table table-striped table-bordered dataTable dtr-inline">
					<thead>
						<tr>
							<th>Tipo Movimiento</th>
							<th>Descripción</th>
							<th>Cantidad Productos</th>
							<th>Fecha</th>
						</tr>
					</thead>
					<tbody>
					<%
							//Guardamos esa lista en una Sesión
							session.setAttribute("ListaProducto",prod);
					
							for(Movimiento m: listMov)
							{
						%>
							<tr>
								<td><%= m.getNombreTipoMovimiento() %></td>
								<td><%= m.getDescripcionMovimiento() %></td>
								<td><%= m.getCantidadProductoDM() %></td>
								<td><%= m.getFechaMovimiento() %></td>
							</tr>
						<%
							}
						%>
					</tbody>
				</table>
				<br />
				<%//if(true) { %>
					<div class="text-right">
				    	<div class="btn btn-success btn-outline" id="btnIngresarMov">
				    		<span class="glyphicon glyphicon-plus-sign"></span> Agregar
				    	</div>
					</div>
				<% //} %>
				<br />
				<div id="Movimiento" class="hidden">
					<div class="form-horizontal">
						<div class="col-md-10">
							<h4>Agregar Movimiento</h4>
							<hr>
							<div class="form-group">
								<label class="control-label col-md-3">Cantidad</label>
								<div class="col-md-9">
									<input type="text" id="CantidadProductoDM" name="CantidadProductoDM" class="CantidadProductoDM form-control"/>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-3">Lote</label>
								<div class="col-md-9">
									<select id="IdLoteDM" class="form-control IdLoteDM">
										<% for(Lote lote : listaLote) { %>
											<option value="<%= lote.getIdLote() %>">
												<%= lote.getNumeroLote() %>
											</option>
										<% } %>
									
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-3">Tipo Movimiento</label>
								<div class="col-md-9">
									<select id="IdTipoMovimiento" class="form-control IdTipoMovimiento">
										<% for(TipoMovimiento tp : listaTipMov) { %>
											<option value="<%=tp.getIdTipoMovimiento()%>">
												<%= tp.getNombreTipoMovimiento() %>
											</option>
										<% } %>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-3">Descripción</label>
								<div class="col-md-9">
									<textarea rows="3" class="form-control" id="DescripcionMovimiento"></textarea>
								</div>
							</div>
							<div class="col-md-12 text-left">
		                		<button class="btn btn-primary" id="btnGuardarMov" type="submit">Guardar</button>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="panel-footer">
				<a class="btn btn-default" href="../../vistas/inventario/index.jsp">Cancelar</a>
			</div>
            </form>
		</div>
	</div>
	
	<% // REFERENCIAS DE SCRIPTS  %>
	<jsp:include page="../form.html"></jsp:include>
	<script src="../../js/inventario/detalle.js"></script>
</body>
</html>
