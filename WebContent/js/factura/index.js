/**
 * Autor: Leticia Téllez
 * Fecha de creación: 2/04/2018
 * Última modificación: Leticia Téllez
 */

$(document).ready(function () {
    $(".table tbody").on('click', '.cancelar', function () {
    	var id = $(this).data('id');
    	
        var myCallback = function(choice) {
        	if(choice) {
        		$.post("../../SLFactura", { id: id, opc: 2 }, function (result) {
                    if (result.status) {
                    	notif({
                            type: "success",
                            msg: result.message,
                            position: "center",
                            timeout: 5000,
                            callback: function () {
                            	location.reload();
                            }
                        });
                    }
                    else {
                    	notif({
                            type: "error",
                            msg: result.message,
                            position: "center",
                            clickable: true,
                            autohide: true
                        });
                    }
                });
        	}
        }

        notif_confirm({
        	'message':'¿Cancelar Factura?',
        	'textaccept': 'Sí',
        	'textcancel': 'No',
        	'fullscreen': true,
        	'callback': myCallback
        });
    });
});