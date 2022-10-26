

const btn_menu = document.querySelectorAll("a[btn-menu]");

btn_menu.forEach(function(btn){

	btn.addEventListener('click', function(){
		btn_menu.forEach(function(nbtn){
			nbtn.classList.add('text-light-gray');
		});
		btn.classList.add('text-light');
		
	});
});

