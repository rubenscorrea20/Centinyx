/*<![CDATA[*/
function criaLocalStorageLogin() {
    var linhas = document.getElementById("tabelaUsuario")
        .getElementsByTagName("tbody")[0].getElementsByTagName("tr");
    var table = document.getElementById("tabelaUsuario");
    for (i = 0; i < linhas.length; i++) {
        linhas[i].onclick = function() {
            var t = this.rowIndex + 1;
            var tabela = table.rows[t - 1].cells.namedItem("loginUsuario").innerHTML;
            localStorage.login = tabela;
            window.close();
        }
    }
};

function criaLocalStorageMotoboy() {
    var linhas = document.getElementById("tabelaMotoboy")
        .getElementsByTagName("tbody")[0].getElementsByTagName("tr");
    var table = document.getElementById("tabelaMotoboy");
    for (i = 0; i < linhas.length; i++) {
        linhas[i].onclick = function() {
            var t = this.rowIndex + 1;
            var tabela = table.rows[t - 1].cells.namedItem("nomeMotoboy").innerHTML;
            localStorage.motoboy = tabela;
            window.close();
        }
    }
};

function criaLocalStoragePerfil() {
    var linhas = document.getElementById("tabela")
        .getElementsByTagName("tbody")[0].getElementsByTagName("tr");
    var table = document.getElementById("tabela");
    for (i = 0; i < linhas.length; i++) {
        linhas[i].onclick = function() {
            var t = this.rowIndex + 1;
            var tabela = table.rows[t - 1].cells.namedItem("tipoAcesso").innerHTML;
            localStorage.perfil = tabela;
            window.close();
        }
    }
};

function criaLocalStorageContatoCliente() {
    var linhas = document.getElementById("tabelaContato")
        .getElementsByTagName("tbody")[0].getElementsByTagName("tr");
    var table = document.getElementById("tabelaContato");
    for (i = 0; i < linhas.length; i++) {
        linhas[i].onclick = function() {
            var t = this.rowIndex + 1;
            var tabela = table.rows[t - 1].cells.namedItem("nomeContato").innerHTML;
            localStorage.contato = tabela;
            window.close();
        }
    }
};

function criaLocalStorageFuncionario() {
    if (document.getElementById("funcao").value == "Motoboy") {
        var nome = document.getElementById("nome").value;
        localStorage.funcionario = nome;
    } else {
        delete window.localStorage["funcionario"];
    }
};

function setaFuncionarioMotoboy() {
    if (localStorage.funcionario) {
        document.getElementById("nome").value = localStorage.funcionario;
        document.getElementById("cpfMotoboy").value = localStorage.cpf;
    }
};

function setaPerfil() {
	document.getElementById("tipoAcesso").value = "";
	if (localStorage.perfil) {
		$.ajax({
	        url: "/usuario/cadastra",
	        type: 'POST',
	        data: localStorage.perfil,
	        success: function() {
	            document.getElementById("tipoAcesso").value = localStorage.perfil;
	        },
	        error: function() {
	            alert("Deu erro!");
	        }
	    });
	};
};

function setaUsuario() {
	document.getElementById("login").value = "";
	if(localStorage.login){
		$.ajax({
		    url: "/funcionario/cadastra",
		    type: 'POST',
		    data: localStorage.login,
		    success: function() {
		       document.getElementById("login").value = localStorage.login;
		    },
		    error: function() {
		       alert("Deu erro!");
		    }
		});
	};
};

function setaMotoboy() {
		var indice = document.getElementById("motoboy").name;
		$.ajax({
		    url: "/pedido/cadastra",
		    type: 'POST',
		    data: localStorage.motoboy,
		    success: function() {
		    	document.getElementById("motoboy").id = indice;
		    	document.getElementById(indice).value = localStorage.motoboy;
		    	//alert(document.getElementById(indice).id);
		    },
		    error: function() {
		       alert("Deu erro!");
		    }
		});
		document.getElementById("motoboy").setAttribute("name", "motoboy");
		alert(document.getElementById("motoboy").name);
};

function setaContatoCliente() {
	document.getElementById("nomeContato").value = "";
	if(localStorage.contato){
		$.ajax({
			url: "/cliente/cadastra",
			type: 'POST',
			data: localStorage.contato,
			success: function() {
				document.getElementById("nomeContato").value = localStorage.contato;
			},
			error: function() {
				alert("Deu erro!");
			}
		});
	};
};

function limpaLocalStorageFuncionarioMotoboy() {
    delete window.localStorage["funcionario"];
    delete window.localStorage["cpf"];
}

function limpaLocalStorageContato() {
    delete window.localStorage["contato"]
}

function limpaLocalStoragePerfil(){
	delete window.localStorage["perfil"];
}

$(document).ready(function() {
    $("#cpf").blur(function() {
        var cpf = document.getElementById("cpf").value;
        cpf = cpf.replace(/[^a-zA-Z0-9 ]/g, "");
        localStorage.cpf = cpf;
    });
});
/* ]]> */