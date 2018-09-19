/**
 * Autor: Leticia Téllez
 * Fecha de creación: 4/05/2018
 * Última modificación: Leticia Téllez
 */

$(document).ready(function () {
	$('#btnIngresarMov').click(function() {
		$('#Movimiento').removeClass('hidden');
	})
	
	$('#btnGuardarMov').on('click', function (event) {
        event.preventDefault();
        fnGuardarMovimiento();
    });
})

function fnGuardarMovimiento() {
	var Movimiento = {
			IdTipoMovimiento: $('#IdTipoMovimiento').val(),
			IdProductoMovimiento: $('#IdProducto').val(),
			CantidadProductoDM: $('#CantidadProductoDM').val(),
			IdLoteDM: $('#IdLoteDM').val(),
			DescripcionMovimiento: $('#DescripcionMovimiento').val()
	}
	
	if($('#CantidadProductoDM').val().length > 0 && $('#DescripcionMovimiento').val().length > 0) {
		$.post("../../SLInventario",{ Movimiento: JSON.stringify(Movimiento) }, function(dato) {
			if (dato.status) {
	        	notif({
	                type: "success",
	                msg: dato.message,
	                position: "center",
	                timeout: 5000,
	                callback: function () {
	                	 window.location.href = location.protocol + '//' + location.host +  '/Farmacia/vistas/inventario/index.jsp';
	                }
	            });
	           
	        } else {
	            notif({
	                type: "error",
	                msg: dato.message,
	                position: "center",
	                clickable: true,
	                autohide: true
	            });
	        }
		})
	} else {
        notif({
            type: "error",
            msg: "Todos los campos son requeridos",
            position: "center",
            clickable: true,
            autohide: true
        });
    }
}