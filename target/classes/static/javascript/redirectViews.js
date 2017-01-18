/*<![CDATA[*/
jQuery(document).ready(function() {
	$('#buscaContato').on('click', function(e) {
		e.preventDefault();
		buscaContato();
	});
	function buscaContato() {
		window.open("/contatocliente/lista");
	};

	$('#buscaUsuario').on('click', function(e) {
		e.preventDefault();
		buscaUsuario();
	});
	function buscaUsuario() {
		window.open("/usuario/lista");
	};

	$('#buscaPerfil').on('click', function(e) {
		e.preventDefault();
		buscaPerfil();
	});
	function buscaPerfil() {
		window.open("/perfil/lista");
	};
	
	$('#buscaCliente').on('click', function(e) {
		e.preventDefault();
		buscaCliente();
	});
	function buscaCliente() {
		window.open("/cliente/lista");
	};
	
	$('#cancelaPedido').on('click', function(e) {
		e.preventDefault();
		listaMotoboy();
	});
	function listaMotoboy(){
		window.location.href="/funcionario/motoboy/lista";
	}

});
/* ]]> */