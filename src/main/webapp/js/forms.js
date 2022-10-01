var btn = document.getElementById("link_submit");
var frm = document.getElementById("form");
btn.addEventListener("click", function(){
	console.log("click");
	frm.setAttribute("action","validar-usuario");
	frm.submit();
});