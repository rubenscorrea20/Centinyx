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
	}),

	function buscaContato() {
		window.open("/cliente/buscacontato");
	};

	function buscaUsuario() {
		window.open("/usuario/lista");
	};

	function buscaPerfil() {
		window.open("/perfil/lista");
	};	
});
/* ]]> */