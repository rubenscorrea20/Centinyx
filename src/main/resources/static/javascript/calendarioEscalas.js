$(document).ready(function() {
    var date = new Date();
    var d = date.getDate();
    var m = date.getMonth();
    var y = date.getFullYear();
    array = [];
    var title = document.getElementById("tipoPeriodo").value;
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
            $("#modalCalendar").modal("show");
            $("#modalCalendar #dataAlocacao").val(start);
            var eventData;
            $("#confirmaAlocacao").on('click', function() {
                eventData = {
                        title: title,
                        start: start,
                        allDay: allDay
                        //color: '#378006',
                    }
                $('#calendar').fullCalendar('renderEvent', eventData, true);
                
                //$('#calendar').fullCalendar( 'addEventSource', eventData );
                //$('#calendar').fullCalendar( 'refetchEvents' );
            })
            if(title = "Noturno"){
            	$("#calendar").fullCalendar({eventColor: '#378006'});
            }
            $('#calendar').fullCalendar( 'refetchEvents' );
        },
        eventClick: function() {
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
    $('#confirmaAlocacao').on('click', function() {
        $("#qtdeMotoboy").val("");
        document.getElementById("container").innerHTML = "";
    });
});