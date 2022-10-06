
//formulario
var frm = document.getElementById("form");

//cantidad de step
var cant_steps = document.getElementsByClassName("step").length;
//boton Next
const next = document.getElementById("next-btn");
//boton prev
const prev = document.getElementById("prev-btn");
//boton submit
const submt = document.getElementById("submit-btn");
//progressbar
var progressbar = document.getElementById("progress-bar");
//progress circular
var progress_step = document.getElementById("progressbar");
//todos los steps
var allSteps = document.getElementById("step-parent");
//pass
var pass = document.getElementById("password");
var pass_rpt =document.getElementById("password-repeat");

//alert
var alerta = document.getElementsByClassName("alert");
var alert_msg = document.getElementById("text-alert");

//validaciones
var btn_val_user = document.getElementById("btn-valida-usuario");
var btn_val_email = document.getElementById("btn-valida-email");

var flag_user = document.getElementById("verifica-user");
var flag_email = document.getElementById("verifica-email");

//INPUTS
const input_username = document.getElementById("username");
const input_email = document.getElementById("email");
const input_nombre = document.getElementById("nombre");
const input_apellido = document.getElementById("apellido");
const sel_genero = document.getElementById("select-genero");
const dia = document.getElementById("select-dia");
const mes = document.getElementById("select-mes");
const anio = document.getElementById("select-anio");
const fnac = document.getElementById("fnac");

var curStep = 1;
var nextStep = curStep + 1;
if(curStep == 1) prev.setAttribute("disabled", true);
submt.setAttribute("hidden", true);
setProgress(curStep);

generarCalendario();






//============LISTENERS=======================
next.addEventListener("click", function(){
	if(validaCuenta(curStep) == true){
	curStep = curStep + 1;
	nextStep = curStep + 1;
	if(curStep > 1){
		prev.removeAttribute("disabled");
		prev.classList.remove("btn-secondary");
	} 
	if(curStep == cant_steps) this.setAttribute("hidden", true);
	if(curStep == cant_steps) submt.removeAttribute("hidden");
	setProgress(curStep);
	showStep(curStep);
	verificarDatosUsuario(curStep);
}
});

prev.addEventListener("click", function(){
	curStep = curStep - 1;
	nextStep = curStep + 1;
	if(curStep == 1){
		this.setAttribute("disabled", true);
		this.classList.add("btn-secondary")
	} 
	if(curStep < cant_steps) next.removeAttribute("hidden");
	if(curStep < cant_steps) submt.setAttribute("hidden", true);
	
	setProgress(curStep);
	showStep(curStep);

});

btn_val_email.addEventListener("click", function(){
	console.log("click");
	
	if(input_email.value == ''){
			alerta[0].classList.remove("hidden");
			alert_msg.innerHTML="Debe ingresar un email";
			
			return false;
	}
	alerta[0].classList.add("hidden");
	frm.removeAttribute("action");		
	frm.setAttribute("action","validar-email");
	frm.submit();
});

btn_val_user.addEventListener("click", function(){
	console.log("click");
	

	if(input_username.value == ''){
			alerta[0].classList.remove("hidden");
			alert_msg.innerHTML="Debe ingresar un nombre de usuario";
			
			return false;
	}
	alerta[0].classList.add("hidden");	
	frm.removeAttribute("action");		
	frm.setAttribute("action","validar-usuario");
	frm.submit();
});



//limpiar verificacion al escribir en user y email
input_username.addEventListener("keyup", function(){
	console.log(this.value);
	flag_user.setAttribute("hidden", true);
});

input_email.addEventListener("keyup", function(){
	console.log(this.value);
	flag_email.setAttribute("hidden", true);
});

frm.addEventListener("submit", function(){
	console.log("se envio");
});

submt.addEventListener("click", function(e){
	e.preventDefault();

	var registro = document.getElementById("register");
	var loader = document.getElementById("loader");
	
	registro.classList.add("hidden");
	loader.classList.remove("hidden");
	const timer = ms => new Promise(res => setTimeout(res, ms));
 
    timer(3000)
        .then(() => {
            frm.submit();
		 }).then(() => {
			loader.classList.add("hidden");
		 })

});

//=============FUNCIONES========================
function setProgress(curStep){
	
	var percent = parseFloat(100 / cant_steps) * curStep;
	percent = percent.toFixed();

	//progreso de barra
	document.getElementsByClassName('progress-bar')[0].style.width = percent + "%";
	//progreso de barra step circular
	if (curStep < cant_steps) progress_step.children[curStep].classList.remove("active");
	progress_step.children[--curStep].classList.add("active");
	
}

function showStep(curStep){
	let stepActual = curStep - 1;
	let stepPrev = stepActual - 1;
	let stepPost = stepActual + 1;
	if(stepPrev >= 0) allSteps.children[stepPrev].classList.remove("activate");
	if (curStep < cant_steps) allSteps.children[stepPost].classList.remove("activate");
	allSteps.children[stepActual].classList.add("activate");


}

function validaCuenta(curStep){
	//validaciones para datos de cuenta
	//valida user email
var existe_usuario = flag_user.classList.contains("no");
var existe_email = flag_email.classList.contains("no");
	
	if(curStep == 1){
		if(flag_user.hasAttribute('hidden')){
		alert_msg.innerHTML="Verifique el nombre de usuario para continuar";
		alerta[0].classList.remove("hidden");
		return false;
		}
		if(flag_email.hasAttribute("hidden")){
			alert_msg.innerHTML="Verifique el email para continuar";
			alerta[0].classList.remove("hidden");
			return false;
		}
		if(existe_usuario){
			alert_msg.innerHTML="El nombre de usuario ya se encuentra en uso";
			alerta[0].classList.remove("hidden");
			return false;
		}
		if(existe_email){
			alert_msg.innerHTML="Ya existe una cuenta registrada con este email";
			alerta[0].classList.remove("hidden");
			return false;
		}
		if(pass.value == ''){
			alerta[0].classList.remove("hidden");
			alert_msg.innerHTML="Debe ingresar una contraseña";
			
			return false;
		}
		if(pass_rpt.value == ''){
			alert_msg.innerHTML="Debe repetir la contraseña";
			alerta[0].classList.remove("hidden");
			return false;
		}
		
		if(pass.value != pass_rpt.value){
			alert_msg.innerHTML="Las contraseñas no coinciden";
			alerta[0].classList.remove("hidden");
			return false;
		}
	
	}
	//validaciones para datos personales
	if(curStep == 2){
		if(input_nombre.value == ''){
			alerta[0].classList.remove("hidden");
			alert_msg.innerHTML="Debe ingresar su Nombre";
			
			return false;
		}
		if(input_apellido.value == ''){
			alerta[0].classList.remove("hidden");
			alert_msg.innerHTML="Debe ingresar su Apellido";
			
			return false;
		}
		if(sel_genero.value == '0'){
			alerta[0].classList.remove("hidden");
			alert_msg.innerHTML="Debe Seleccionar Género";
			
			return false;
		}
		if(dia.value == '0' || mes.value == '0' || anio.value == '0'){
			alerta[0].classList.remove("hidden");
			alert_msg.innerHTML="Complete su fecha de nacimiento";
			
			return false;
		}
	}
	
	
	

	alerta[0].classList.add("hidden");
	return true;
}

//generacion de fechas
function generarCalendario(){
	let hoy = new Date();

	let i=1940;
	while(i <= hoy.getFullYear()){
		var option = document.createElement("option");
		option.value = i;
		option.text = i;
		anio.appendChild(option);
		i++;
	}
	anio.value = hoy.getFullYear();

	i=1;
	while(i <= 12){
		var option = document.createElement("option");
		option.value = i;
		option.text = i;
		mes.appendChild(option);
		i++;
	}

	mes.value = hoy.getMonth();

	i=1;
	var d = new Date(Number(anio.value) , Number(mes.value), 0);
	var canDiaMes = d.getDate();
	console.log(canDiaMes);
	while(i <= canDiaMes){
		var option = document.createElement("option");
		option.value = i;
		option.text = i;
		dia.appendChild(option);
		i++;
	}

	dia.value = hoy.getDay();
	fnac.value = new Date(Number(anio.value), Number(mes.value),Number(dia.value)).toLocaleDateString();

}

//cambios de fechas
dia.addEventListener("change", function(){
	fnac.value = new Date(Number(anio.value), Number(mes.value),Number(this.value)).toLocaleDateString();
});

anio.addEventListener("change", function(){
	
	let dsel = dia.value;
	let i=1;
	//obtenemos la cantidad de dias del mes seleccionado
	var d = new Date(Number(this.value) , Number(mes.value), 0);
	var canDiaMes = d.getDate();
	console.log(canDiaMes);
	var cantDiasSelect = dia.childElementCount;

	while(cantDiasSelect > canDiaMes){
		dia.lastChild.remove()
		cantDiasSelect = dia.childElementCount;
	}

	while(cantDiasSelect <= canDiaMes){
		var option = document.createElement("option");
		option.value = cantDiasSelect;
		option.text = cantDiasSelect;
		dia.appendChild(option);
		
		cantDiasSelect = dia.childElementCount;
	}

	dia.value = dsel;
	fnac.value = new Date(Number(this.value), Number(mes.value),Number(dia.value)).toLocaleDateString();

});

mes.addEventListener("change", function(){
	let dsel = dia.value;
	let i=1;
	//obtenemos la cantidad de dias del mes seleccionado
	var d = new Date(Number(anio.value) , Number(this.value), 0);
	var canDiaMes = d.getDate();
	console.log(canDiaMes);
	var cantDiasSelect = dia.childElementCount;

	while(cantDiasSelect > canDiaMes){
		dia.lastChild.remove()
		cantDiasSelect = dia.childElementCount;
	}

	while(cantDiasSelect <= canDiaMes){
		var option = document.createElement("option");
		option.value = cantDiasSelect;
		option.text = cantDiasSelect;
		dia.appendChild(option);
		
		cantDiasSelect = dia.childElementCount;
	}
	
	console.log(this.value);
	dia.value = dsel;
	fnac.value = new Date(Number(anio.value), Number(this.value), Number(dia.value)).toLocaleDateString();
});

function verificarDatosUsuario(curStep){
	console.log(curStep);
	if(curStep == 4){
		document.getElementById("verify_preview").src = document.getElementById("preview").src;
		document.getElementById("verify_nombre").innerHTML = input_nombre.value;
		document.getElementById("verify_apellido").innerHTML = input_apellido.value;
		document.getElementById("verify_username").innerHTML = input_username.value;
		document.getElementById("verify_email").innerHTML = input_email.value;
	}
}

