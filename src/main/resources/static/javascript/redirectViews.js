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

	/*$('#enviar').on('click', function(e) {
		e.preventDefault();
		redirectMotoboy();
	});*/

	function buscaContato() {
		window.open("/cliente/buscacontato");
	};

	function buscaUsuario() {
		window.open("/usuario/lista");
	};

	function buscaPerfil() {
		window.open("/perfil/lista");
	};

	/*function redirectMotoboy() {
		var func = "MOTOBOY";
		var res = $('#funcao').val().toUpperCase();
		if (res == func) {
			window.location.href = "/funcionario/cadastra/motoboy";
		};
	};*/
});
/* ]]> */