/**
 * 
 */
 
 var botones = document.querySelectorAll("a[btn-friend]");

 botones.forEach(function(btn){
	
	btn.addEventListener('click', function(e){
		e.preventDefault();
		if(!this.classList.contains("dropdown-toggle"))
		{
			console.log("Se envio la solicitud");
			enviarPeticion("http://localhost:8080/" + btn.getAttribute('h'), this, this.parentElement.children[1].children[0].children[0])
			
		}
			
		
		
	});
	
});


function enviarPeticion(url, btn, cancelBtn){
	
	$.ajax({
		url: url,
		type: 'GET',
		success: function(response){
			
			console.log(response);
			
			if(response){
				console.log(response);
				btn.innerHTML = "Pendiente"
				btn.classList.remove('btn-meet');
				btn.classList.add('dropdown-toggle');
				btn.classList.add('btn-secondary');
				btn.setAttribute('data-bs-toggle', 'dropdown');
				
				cancelBtn.setAttribute("h", "http://localhost:8080/proyecto-limpio-spring/amigos/solicitud/cancelar?id=" + response );
				console.log(cancelBtn.getAttribute("h"));
				cancelBtn.addEventListener("click", function(e){
					e.preventDefault();
					cancelarSolicitud( btn, cancelBtn);
				});
				
			}
			
		}
	});
	
	
}

function cancelarSolicitud( btn, cancelBtn){
	
	$.ajax({
		url: cancelBtn.getAttribute("h"),
		type: 'GET',
		success: function(response){
			
			if(response == true){
				
				btn.innerHTML = "Enviar Solicitud";
				btn.classList.remove('btn-secondary');
				btn.classList.add('btn-meet');
				btn.classList.remove('dropdown-toggle');
				
				btn.removeAttribute('data-bs-toggle');
				
				cancelBtn.removeAttribute("h");
				
				
			}
			
		}
	});
	
	
}