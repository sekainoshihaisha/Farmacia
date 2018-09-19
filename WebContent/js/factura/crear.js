/**
 * Autor: Leticia Téllez
 * Fecha de creación: 2/04/2018
 * Última modificación: Leticia Téllez
 */

$(document).ready(function (){

    /***CREACIÓN DE TBODY***/
    var secuencial = 0; // Numero unico de fila
    var tablaProducto = $("#tblProductos");

    $("#btn_agregarProduct").click(function () {
        secuencial = parseInt(secuencial) + 1;
        var fila = $('<tr>');
		fila.append()
            .append($('<td>')
                .append($('<input type="number" id="CantidadProducto_' + secuencial + '" class="form-control">'))
            )
            .append($('<td>')
                .append($("#IdProducto").clone().attr("id", "IdProducto_" + secuencial))
            )
            .append($('<td>')
               .append($('<input type="number"  step="1" id="PrecioProducto_' + secuencial + '" class="form-control">'))
            )
            .append($('<td class="text-center">')
               .append($('<span class="glyphicon glyphicon-remove borrar" style="color: #ff7676;"></span>'))
            );
		
		$(tablaProducto).find('tbody').append(fila);
		fila.data('secuencial', secuencial);
    });

    /**ELIMINAR FILA**/
    $("#tblProductos").on('click', '.borrar', function (event) {
        event.preventDefault();
        $(this).closest('tr').remove();

        var total = $("#tblProductos tbody> tr").length;
        var i = 1;

        $("#tblProductos tbody> tr").each(function () {
            $(this).find('td:first-child').find('span').text(i);
            i = parseInt(i) + 1;
        });

        total >= 0 ? 1 : $("#tblProductos tbody> tr").length
    })

    /**CALCULAR TOTAL DÍAS**/
    $("#btnCalcularTotal").click(function () {
		var filas = $("#tblProductos tbody> tr");
        if (filas.length > 0) {
            var ListPrecio = [];

            for (var i = 0; i < filas.length; i++) {
				var id = $(filas[i]).data('secuencial');
				
                if ($("#PrecioProducto_" + id).val() != undefined) {
                	ListPrecio.push({
                        Cantidad: $("#PrecioProducto_" + id).val()
                    })
                }
            }

            if (ListPrecio.length > 0) {
                $.post(url + "/CalcularTotal", { ListPrecio: ListPrecio }, function (data) {
                    $('#Total').val(data);
                })
            }
            else { $('#Total').val(0); }
        }
    });

    /**GUARDAR DATOS**/
    $('#btnGuardarFact').on('click', function (event) {
        event.preventDefault();
        fnGuardarFactura(secuencial);
    });
});

function fnGuardarFactura(secuencial)
{
    var ListDetalleFactura = [];
    var filas = $("#tblProductos tbody> tr");
    
    for (var cont = 0; cont < filas.length; cont++) {
		var i = $(filas[cont]).data('secuencial');
		
		ListDetalleFactura.push({
            CantidadProducto: $("#CantidadProducto_" + i).val(),
            IdProducto: $("#IdProducto_" + i).val(),
            PrecioProducto: $("#PrecioProducto_" + i).val(),
            
        });
    }

    var Factura = {
    		NumeroFactura: $("#NumeroFactura").val(),
    		IdClienteFactura: $("#IdClienteFactura").val(),
    		IdEmpleadoFactura: $("#IdEmpleadoFactura").val(),
    		VentaReceta: $("#VentaReceta").prop('checked'),
    		listaDetalle: ListDetalleFactura
    }

    
    if ($('#NumeroFactura').val().length > 0 && $('#IdClienteFactura').val().length > 0 && $('#IdEmpleadoFactura').val().length > 0 && ListDetalleFactura.length > 0) {
        $.post("../../SLFactura",{ Factura : JSON.stringify(Factura), opc : "1" }, function (dato) {
        	//$.parseJSON(dato);
            if (dato.status) {
            	notif({
                    type: "success",
                    msg: dato.message,
                    position: "center",
                    timeout: 5000,
                    callback: function () {
                    	 window.location.href = location.protocol + '//' + location.host +  '/Farmacia/vistas/factura/index.jsp';
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