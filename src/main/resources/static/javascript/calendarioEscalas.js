$(document).ready(function() {
	var tipoPeriodo;
    var dataAlocacao;
    var eventData;
    var calendar = $('#calendar').fullCalendar({
    	header: {
            left: 'prev,next today',
            center: 'title'
        },
        selectable: true,
        editable: false,
        eventLimit: true,
        displayEventTime: false,
        dayClick: function(start, end, allDay) {
            document.getElementById("numeroPedidoAlocacao").value = document.getElementById("numeroPedido").value;
            dataAlocacao = moment(start).format('DD/MM/YYYY');
            $("#modalCalendar").modal("show");
            $("#modalCalendar #dataAlocacao").val(dataAlocacao);
            tipoPeriodo = document.getElementById("tipoPeriodo");
            $("#confirmaAlocacao").on('click', function(){
            	var periodo = tipoPeriodo.options[tipoPeriodo.selectedIndex].text;
            	eventData = {
            		title: periodo,
					start: start,
					end: start,
					allDay: allDay
            	},
            	calendar.fullCalendar('renderEvent', eventData, true);
        	    });
        },
        eventAfterRender: function(event, element, view){
        	if(event.title == "Noturno"){
        		element.css('background-color', '#8A1C8E');
        	} else if (event.title == "Matutino"){
        		element.css('background-color', '#B20B16');
        	}else if (event.title == "Vespertino"){
        		element.css('background-color', '#129812');
        	}
        },
        eventClick: function() {
        	dataAlocacao = $("#modalCalendar #dataAlocacao").prop("value");
        	periodo = $("#modalCalendar #tipoPeriodo").prop("value");
            $("#modalDetalhes").modal('show');
            $("#modalDetalhes #dataAlocacaolbl").text(dataAlocacao);
            $("#modalDetalhes #periodolbl").text(periodo);    
        }
    });
})

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