$(document).ready(function(){
	$('#deletaFuncionario').on('click', function(){
		var idFuncionario = document.getElementById("idFuncionario").innerHTML;
		location.replace("funcionario/deleta/" + idFuncionario);
		delete window.localStorage["nome"]
	});
})

$(document).ready(function(){
	$('#deletaUsuario').on('click', function(){
		var idUsuario = document.getElementById("idUsuario").innerHTML;
		location.replace("usuario/deleta/" + idUsuario);
		delete window.localStorage["login"]
	});
})

$(document).ready(function(){
	$('#deletaPerfil').on('click', function(){
		var idPerfil = document.getElementById("idPerfil").innerHTML;
		location.replace("perfil/deleta/" + idPerfil);
		delete window.localStorage["tipoAcesso"]
	});
})

$(document).ready(function(){
	$('#deletaContato').on('click', function(){
		var idContatoCliente = document.getElementById("idContatoCliente").innerHTML;
		location.replace("contatocliente/deleta/" + idContatoCliente);
	});
})

$(document).ready(function(){
	$('#deletaCliente').on('click', function(){
		var idCliente = document.getElementById("idCliente").innerHTML;
		location.replace("cliente/deleta/" + idCliente);
	});
})



