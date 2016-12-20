$(document).ready(function(){
	$('#confirmaDelete').on('click', function(){
		var idFuncionario = document.getElementById("idFuncionario").innerHTML;
		location.replace("funcionario/deleta/" + idFuncionario);
	});
})