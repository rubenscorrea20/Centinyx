$(document).ready(function() {
    var date = new Date();
    var d = date.getDate();
    var m = date.getMonth();
    var y = date.getFullYear();
    var calendar = $('#calendar').fullCalendar({
        header: {
            left: 'prev,next today',
            center: 'title',
            //right: 'month,agendaWeek,agendaDay'
        },
        selectable: true,
        selectHelper: true,
        /*select: function(start, end, allDay) {
        	var title = prompt('Event Title:');
        	if (title) {
        		calendar.fullCalendar('renderEvent',
        			{
        				title: title,
        				start: start,
        				end: end,
        				allDay: allDay
        			},
        			true // make the event "stick"
        		);
        	}
        	calendar.fullCalendar('unselect');
        },*/
        editable: true,
        select: function(start, allDay, jsEvent, view) {
            //start = $.fullCalendar.formatDate(date,'dd-MM-yyyy');
            //$('#calendar').fullCalendar('renderEvent', eventData, true);
            start = moment(start).format('DD/MM/YYYY');
            $("#modalCalendar").modal("show");
            $("#modalCalendar #dataAlocacao").val(start);
            var title = document.getElementById("periodo").value;
            var eventData;
			if (title) {
				eventData = {
					title: title,
					start: start,
					end: end
				};
				$('#calendar').fullCalendar('renderEvent', eventData, true); // stick? = true
			}
			$('#calendar').fullCalendar('unselect');
            var eventData = {
                    
            };
            //$('#calendar').fullCalendar('renderEvent', eventData, true); // stick? = true
            //$('#calendar').fullCalendar('unselect');
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