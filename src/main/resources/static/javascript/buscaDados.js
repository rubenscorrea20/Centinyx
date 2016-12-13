/*<![CDATA[*/
function criaLocalStorageLogin() {
		var linhas = document.getElementById("tabela").getElementsByTagName("tbody")[0].getElementsByTagName("tr");
		var table = document.getElementById("tabela");
		for (i = 0; i < linhas.length; i++) {
			linhas[i].onclick = function() {
	        	var t = this.rowIndex + 1;
	            //alert(t);
	            var tabela = table.rows[t-1].cells.namedItem("loginUsuario").innerHTML;
	            localStorage.login = tabela;
	    		window.close();
	    		setaUsuario();
	        }
	    }
};

function setaUsuario() {
	if(localStorage.login){
		document.getElementById("login").value = localStorage.login;
	}
}

function criaLocalStorageTipoAcesso() {
	var linhas = document.getElementById("tabela").getElementsByTagName("tbody")[0].getElementsByTagName("tr");
	var table = document.getElementById("tabela");
	for (i = 0; i < linhas.length; i++) {
		linhas[i].onclick = function() {
        	var t = this.rowIndex + 1;
            //alert(t);
            var tabela = table.rows[t-1].cells.namedItem("tipoAcesso").innerHTML;
            localStorage.tipoAcesso = tabela;
    		window.close();
    		setaPerfil();
        }
    }
};

function criaLocalStorageFuncionario() {
	var nome = document.getElementById("nomeCompleto").value;
	localStorage.funcionario = nome;
};

function setaPerfil() {
	if(localStorage.tipoAcesso){
		document.getElementById("tipoAcesso").value = localStorage.tipoAcesso;
	}
}
/* ]]> */