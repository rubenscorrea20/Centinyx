$('#someSwitchOptionPrimary').change(function() {
	document.getElementById("nomeFavorecido").value = document.getElementById("nome").value;
	document.getElementById("cpfFavorecido").value = document.getElementById("cpf").value;
});