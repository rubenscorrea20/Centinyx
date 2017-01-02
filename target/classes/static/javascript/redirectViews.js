/*<![CDATA[*/
jQuery(document).ready(function() {
	$('#buscaContato').on('click', function(e) {
		e.preventDefault();
		buscaContato();
	}),

	$('#buscaUsuario').on('click', function(e) {
		e.preventDefault();
		buscaUsuario();
	}),

	$('#buscaPerfil').on('click', function(e) {
		e.preventDefault();
		buscaPerfil();
	});
	
	$('#buscaCliente').on('click', function(e) {
		e.preventDefault();
		buscaCliente();
	});

	function buscaUsuario() {
		window.open("/usuario/lista");
	};

	function buscaPerfil() {
		window.open("/perfil/lista");
	};
	
	function buscaContato() {
		window.open("/contatocliente/lista");
	};
	
	function buscaCliente() {
		window.open("/cliente/lista");
	};
});
/* ]]> */