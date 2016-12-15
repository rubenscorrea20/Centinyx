/*<![CDATA[*/
function criaLocalStorageLogin() {
	var linhas = document.getElementById("tabela")
			.getElementsByTagName("tbody")[0].getElementsByTagName("tr");
	var table = document.getElementById("tabela");
	for (i = 0; i < linhas.length; i++) {
		linhas[i].onclick = function() {
			var t = this.rowIndex + 1;
			var tabela = table.rows[t - 1].cells.namedItem("loginUsuario").innerHTML;
			localStorage.login = tabela;
			window.close();
			setaUsuario();
		}
	}
};

function setaUsuario() {
	if (localStorage.login) {
		document.getElementById("login").value = localStorage.login;
	}
}

function criaLocalStorageTipoAcesso() {
	var linhas = document.getElementById("tabela")
			.getElementsByTagName("tbody")[0].getElementsByTagName("tr");
	var table = document.getElementById("tabela");
	for (i = 0; i < linhas.length; i++) {
		linhas[i].onclick = function() {
			var t = this.rowIndex + 1;
			var tabela = table.rows[t - 1].cells.namedItem("tipoAcesso").innerHTML;
			localStorage.tipoAcesso = tabela;
			window.close();
			setaPerfil();
		}
	}
};

function criaLocalStorageFuncionario() {
	if (document.getElementById("funcao").value == "Motoboy") {
		var nome = document.getElementById("nomeCompleto").value;
		localStorage.nomeFuncionario = nome;
		setaFuncionarioMotoboy();
	}
};

function setaFuncionarioMotoboy() {
	document.getElementById("nomeFuncionario").value = localStorage.nomeFuncionario;
	document.getElementById("cpfMotoboy").value = localStorage.cpf;
};

function setaPerfil() {
	if (localStorage.tipoAcesso) {
		document.getElementById("tipoAcesso").value = localStorage.tipoAcesso;
	}
};

function limpaLocalStorageUsuario() {
	delete window.localStorage["tipoAcesso"]
}

function limpaLocalStorageFuncionario() {
	delete window.localStorage["nomeFuncionario"]
}

$(document).ready(function() {
	$("#cpf").blur(function() {
		var cpf = document.getElementById("cpf").value;
		cpf = cpf.replace(/[^a-zA-Z0-9 ]/g, "");
		localStorage.cpf = cpf;
	});
});
/* ]]> */