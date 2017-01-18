$(document).ready(function() {
	var date = new Date();
    var d = date.getDate();
    var m = date.getMonth();
    var y = date.getFullYear();
    var calendar = $('#calendar').fullCalendar({
        header: {
            left: 'prev,next today',
            center: 'title',
        },
        selectable: true,
        editable: true,
        eventLimit: true,
        displayEventTime: false,
        select: function(start, allDay, jsEvent, view) {
            document.getElementById("numeroPedidoAlocacao").value = document.getElementById("numeroPedido").value;
            var start = moment(start).format('DD/MM/YYYY');
            var title = document.getElementById("tipoPeriodo").value;
            $("#modalCalendar").modal("show");
            $("#modalCalendar #dataAlocacao").val(start);
            var eventData;
			$("#confirmaAlocacao").on('click', function(){
				eventData = {
						title: title,
						start: start
					},
					$('#calendar').fullCalendar('renderEvent', eventData, true); // stick? = true
			});
			$('#calendar').fullCalendar('unselect');
        },
        eventClick: function(){
        	$("#modalDetalhes").modal('show');
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
});