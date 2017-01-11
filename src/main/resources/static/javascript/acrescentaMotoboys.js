function acrescentaMotoboy(){
		var qtdeMotoboy = document.getElementById("qtdeMotoboy").value;
		var container = document.getElementById("container");
		// Limpa contextos anteriroes do container
		while(container.hasChildNodes()){
			container.removeChild(container.lastChild);
		}
		for (i = 0; i <qtdeMotoboy;i++) {
			var p = document.createElement("P");
			var input = document.createElement("input");
			var button = document.createElement("button");
			var texto = document.createTextNode("Buscar Motoboy");
			
			container.appendChild(p);
			
			input.type = "text";
			input.setAttribute("placeholder", "Adicione o " +(i+1)+ "º motoboy");
			input.setAttribute("readonly", "readonly");
			input.className= "form-control";
			input.style = "width : 350px";
			input.setAttribute("id", "motoboy");
			input.setAttribute("name", '"'+i+'"');
			container.appendChild(input);
			
			button.className= "btn btn-default";
			button.type = "button";
			button.appendChild(texto);
			button.setAttribute("name", "Buscar motoboy");
			container.appendChild(button);
				
			button.onclick = function(){
				window.open("/funcionario/motoboy/lista");
			}
		}
};