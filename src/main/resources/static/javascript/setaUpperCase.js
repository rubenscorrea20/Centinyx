$(document).ready(
function upperUF() {
	$('#ufNascimento').blur(function() {
		var uf = $(this).val().toUpperCase();
		$('#ufNascimento').val(uf);
	}),
	$('#ufEndereco').blur(function() {
		var uf = $(this).val().toUpperCase();
		$('#ufEndereco').val(uf);
	}),
	$('#placaMoto').blur(function() {
		var placa = $(this).val().toUpperCase();
		$('#placaMoto').val(placa);
	});
});