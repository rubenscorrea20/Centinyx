$('#someSwitchOptionPrimary').change(function() {
	document.getElementById("nomeFavorecido").value = document.getElementById("nomeCompleto").value;
	document.getElementById("cpfFavorecido").value = document.getElementById("cpf").value;
});