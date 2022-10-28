/**
 * 
 */
 
 var botones = document.querySelectorAll("a[btn-friend]");

 botones.forEach(function(btn){
	
	btn.addEventListener('click', function(e){
		e.preventDefault();
		enviarPeticion("http://localhost:8080/" + btn.getAttribute('h'), this)
			
		
		
	});
	
});


function enviarPeticion(url, btn){
	
	$.ajax({
		url: url,
		type: 'GET',
		success: function(response){
			if(response == true){
				
				btn.innerHTML = "Solicitud pendiente"
				btn.classList.remove('btn-meet');
				btn.classList.add('btn-secondary');
			}
			
		}
	});
	
	
}