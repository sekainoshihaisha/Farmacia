<!--
	Autor: Brian Téllez
	Fecha de creación: 23/04/2018
	Ultima modificación: Brian Téllez
 -->

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
	<%
		String error = request.getParameter("msj");
		error = error==null?"":error;
		
		HttpSession hts = request.getSession(false);
		hts.removeAttribute("user");
		hts.invalidate();
	%>
	
	<link rel="stylesheet" href="nifty/v2.6/css/bootstrap.min.css">
	<link rel="stylesheet" href="nifty/v2.6/css/jquery.dataTables.css">
	<link rel="stylesheet" href="nifty/v2.6/plugins/notifIt/notifIt.min.css">

	<title>Farmacia | Inicio de Sesión</title>
</head>
<body>
	<div class="container body-content" style="margin-top: 5%">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">Inicio de Sesión</h3>
			</div>
			<form method="POST" action="./login.do">
				<div class="panel-body">
					<div class="form-horizontal">
						<div class="col-md-10">
							<div class="form-group">
								<label class="control-label col-md-3">Usuario</label>
								<div class="col-md-9">
									<input type="text" name="user" class="form-control" placeholder="Usuario" required />
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-md-3">Contraseña</label>
								<div class="col-md-9">
									<input type="password" name="password" class="form-control" placeholder="Contraseña" required/>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="panel-footer text-left">
					<button class="btn btn-primary" type="submit">Ingresar</button>
				</div>
			</form>
		</div>
	</div>
	
	<script src="nifty/v2.6/js/jquery.min.js"></script>
	<script src="nifty/v2.6/js/bootstrap.min.js"></script></body>
	<script src="nifty/v2.6/plugins/notifIt/notifIt.min.js"></script>
	
	<script type="text/javascript">
		$(document).ready(function() 
		{
			var msj = "<%=error%>";
			if(msj=="503")
			{
				errorAlert('SUS DATOS DE ACCESO SON INCORRECTOS O SU USUARIO HA SIDO BLOQUEADO, SI EL ERROR PERSISTE CONTACTE AL ADMINISTRADOR DE SISTEMA');
			}
		});
	</script>
</body>
</html>