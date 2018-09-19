/**
 * Autor: Leticia Téllez
 * Fecha de creación: 10/04/2018
 * Última modificación: Leticia Téllez
 */

$(document).ready(function () {
    $(".table tbody").on('click', '.eliminar', function () {
    	var id = $(this).data('id');
    	
        var myCallback = function(choice) {
        	if(choice) {
        		$.post("../../SLeliminarEmpleado", { idRol: id}, function (result) {
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
        	'message':'¿Eliminar Registro?',
        	'textaccept': 'Sí',
        	'textcancel': 'No',
        	'fullscreen': true,
        	'callback': myCallback
        });
    });
});