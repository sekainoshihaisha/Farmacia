<!--
	Autor: Brian Téllez
	Fecha de creación: 8/04/2018
	Ultima modificación: Brian Téllez
 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Reportes</title>
	
	<jsp:include page="../css.html"></jsp:include>
	<link rel="stylesheet" href="../../nifty/v2.6/js/bootstrap-datepicker/css/datepicker.css">
</head>
<body>
	<jsp:include page="../menu.html"></jsp:include>
	
	<div class="container body-content" style="margin-top: 5%">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">Inventario de productos</h3>
			</div>
			<form method="POST" action="../../SLReporteStock">
				<div class="panel-footer text-left">
					<button type="submit" target="__blank" class="btn btn-primary">Generar reporte</button>
				</div>
			</form>
		</div>
		
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">Productos más vendidos</h3>
			</div>
			<form method="POST" action="../../SLProductoVendido">
				<div class="panel-body">
					<div class="form-horizontal">
						<div class="col-md-10">
							<div class="form-group">
								<label class="control-label col-md-3">Fecha inicio</label>
								<div class="col-md-9">
									<div class='input-group date'>
					                    <input id='fecha1'name='fecha1' type='text' class="form-control" />
					                    <span class="input-group-addon">
					                        <span class="glyphicon glyphicon-calendar"></span>
					                    </span>
					                </div>
								</div>
							</div>
						</div>
						<div class="col-md-10">
							<div class="form-group">
								<label class="control-label col-md-3">Fecha fin</label>
								<div class="col-md-9">
									<div class='input-group date'>
					                    <input id='fecha2'name='fecha2' type='text' class="form-control" />
					                    <span class="input-group-addon">
					                        <span class="glyphicon glyphicon-calendar"></span>
					                    </span>
					                </div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="panel-footer text-left">
					<button type="submit" target="__blank" class="btn btn-primary">Generar reporte</button>
				</div>
			</form>
		</div>
	</div>
	
	<jsp:include page="../form.html"></jsp:include>
	
	<jsp:include page="../scripts.html"></jsp:include>
	<script src="../../nifty/v2.6/js/moment.js"></script>
	<script src="../../nifty/v2.6/js/moment-es.js"></script>
	<script src="../../nifty/v2.6/js/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
	<script type="text/javascript">
        $(function () {
            $('#datetimepicker1').datetimepicker();
        });
        $(function () {
            $('#datetimepicker2').datetimepicker();
        });
    </script>
</body>
</html>