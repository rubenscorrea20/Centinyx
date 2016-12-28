function editaLocalStorageContatoCliente() {
    var linhas = document.getElementById("tabelaCliente")
        .getElementsByTagName("tbody")[0].getElementsByTagName("tr");
    var table = document.getElementById("tabelaCliente");
    for (i = 0; i < linhas.length; i++) {
        linhas[i].onclick = function() {
            var t = this.rowIndex + 1;
            var tabela = table.rows[t - 1].cells.namedItem("nomeContato").innerHTML;
            localStorage.contato = tabela;
        }
    }
};

function editaLocalStorageUsuario() {
    var linhas = document.getElementById("tabelaFuncionario")
        .getElementsByTagName("tbody")[0].getElementsByTagName("tr");
    var table = document.getElementById("tabelaFuncionario");
    for (i = 0; i < linhas.length; i++) {
        linhas[i].onclick = function() {
            var t = this.rowIndex + 1;
            var tabela = table.rows[t - 1].cells.namedItem("login").innerHTML;
            localStorage.login = tabela;
        }
    }
};

function editaLocalStoragePerfil() {
    var linhas = document.getElementById("tabelaUsuario")
        .getElementsByTagName("tbody")[0].getElementsByTagName("tr");
    var table = document.getElementById("tabelaUsuario");
    for (i = 0; i < linhas.length; i++) {
        linhas[i].onclick = function() {
            var t = this.rowIndex + 1;
            var tabela = table.rows[t - 1].cells.namedItem("tipoAcesso").innerHTML;
            localStorage.perfil = tabela;
        }
    }
};