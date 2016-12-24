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
        }
    }
};

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
        localStorage.nome = nome;
    } else {
        delete window.localStorage["nome"];
    }
};

function setaFuncionarioMotoboy() {
    if (localStorage.nome) {
        document.getElementById("nome").value = localStorage.nome;
        document.getElementById("cpfMotoboy").value = localStorage.cpf;
    }
};

function setaPerfil() {
    $.ajax({
        url: "/usuario/cadastra",
        type: 'POST',
        data: localStorage.tipoAcesso,
        success: function() {
            document.getElementById("tipoAcesso").value = localStorage.tipoAcesso;
        },
        error: function() {
            alert("Deu erro!");
        }
    });
};

function setaUsuario() {
    $.ajax({
        url: "/cliente/cadastra",
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

function setaContatoCliente() {
    $.ajax({
        url: "/cliente/cadastra",
        type: 'POST',
        data: localStorage.login,
        success: function() {
            document.getElementById("nomeContato").value = localStorage.contato;
        },
        error: function() {
            alert("Deu erro!");
        }
    });
};

function limpaLocalStorageUsuario() {
    delete window.localStorage["tipoAcesso"];
    delete window.localStorage["login"];
}

function limpaLocalStorageMotoboy() {
    delete window.localStorage["nome"];
    delete window.localStorage["cpf"];
}

function limpaLocalStorageContato() {
    delete window.localStorage["contato"]
}

$(document).ready(function() {
    $("#cpf").blur(function() {
        var cpf = document.getElementById("cpf").value;
        cpf = cpf.replace(/[^a-zA-Z0-9 ]/g, "");
        localStorage.cpf = cpf;
    });
});
/* ]]> */