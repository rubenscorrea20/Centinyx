$(function() {
    $('#criaEscala').click(function() {
        $('#calendar').toggle(function() {
        	$('#calendar').show('fast');
        }, function() {
        	
        });
    });
    $('#calendar').hide('fast', 'linear');
});

$(document).ready(function(){
	document.getElementById("numeroPedido").value = document.getElementById("numeroPedidoRandom").innerHTML;
})