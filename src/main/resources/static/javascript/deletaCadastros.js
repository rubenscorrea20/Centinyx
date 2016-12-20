$(document).ready(function(){
	$('#deletaFuncionario').on('click', function(){
		var idFuncionario = document.getElementById("idFuncionario").innerHTML;
		location.replace("funcionario/deleta/" + idFuncionario);
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
	});
})



