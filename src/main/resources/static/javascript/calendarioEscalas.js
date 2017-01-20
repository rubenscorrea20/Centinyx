$(document).ready(function() {
    var date = new Date();
    var d = date.getDate();
    var m = date.getMonth();
    var y = date.getFullYear();
    var periodo = $("#tipoPeriodo").prop('value');
    var calendar = $('#calendar').fullCalendar({
    	header: {
            left: 'prev,next today',
            center: 'title'
        },
        selectable: true,
        editable: false,
        eventLimit: true,
        displayEventTime: false,
        select: function(start, end) {
            document.getElementById("numeroPedidoAlocacao").value = document.getElementById("numeroPedido").value;
            var dataAlocacao = moment(start).format('DD/MM/YYYY');
            $("#modalCalendar").modal("show");
            $("#modalCalendar #dataAlocacao").val(dataAlocacao);
            $("#confirmaAlocacao").on('click', function(){
            	var eventData;
                eventData = {
                		   title: periodo,
                           start: start,
                           end: end
                };
                $('#calendar').fullCalendar('renderEvent', eventData, start, end, true);
            })
            //$("#confirmaAlocacao").on('click', function() {
            //    $('#calendar').fullCalendar('renderEvent', eventData, start, end, true);
            //})
            $('#calendar').fullCalendar('unselect');
        },
        eventClick: function() {
        	var dataAlocacao = $("#modalCalendar #dataAlocacao").prop("value");
        	var periodo = $("#modalCalendar #tipoPeriodo").prop("value");
            $("#modalDetalhes").modal('show');
            $("#modalDetalhes #dataAlocacaolbl").text(dataAlocacao);
            $("#modalDetalhes #periodolbl").text(periodo);    
        }
    });
});

$(document).ready(function() {
    $('#cancelaAlocacao').on('click', function() {
        $("#qtdeMotoboy").val("");
        document.getElementById("container").innerHTML = "";
    });
    $('#fechaAlocacao').on('click', function() {
        $("#qtdeMotoboy").val("");
        document.getElementById("container").innerHTML = "";
    });
    $('#confirmaAlocacao').on('click', function() {
        $("#qtdeMotoboy").val("");
        document.getElementById("container").innerHTML = "";
    });
});