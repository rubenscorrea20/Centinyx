$(document).ready(function geraNumeroAleatorio() {
    var x = document.getElementById("numeroPedido");
    x.innerHTML = Math.floor((Math.random() * 10000) + 99999);
    document.getElementById("numeroPedido").value = x.innerHTML;
});

$(function() {
    $('#criaEscala').click(function() {
        $('#calendar').toggle(function() {
        	//$('#calendar').hide('slow');
        	$('#calendar').show('fast');
        }, function() {
        	
        });
    });
    $('#calendar').hide('fast', 'linear');
});