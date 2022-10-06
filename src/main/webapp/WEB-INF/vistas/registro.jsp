<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>meetings</title>
	<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.css" rel="stylesheet" >
	<!-- fontawesome-->	
		<link href="css/all.css" rel="stylesheet">
	<!-- Meeting CSS -->
		<link href="css/global.css" rel="stylesheet">
		 <!-- formulario step -->
        <link href="css/steep-form.css" rel="stylesheet">   
	    <!--CHECKMAARK-->
	    <link href="css/checkmark.css" rel="stylesheet">     
</head>
<body>
    <body class="bg-dark-gray">
		
        <!--CONTAINER GENERAL-->
        <div class="container-fluid text-center">
            <!--todo el contenido de registro-->
        
       
	        <div id="register" class="${register}"> 
   
            
                <img src="img/logo/logo_dark.png" class="mt-brand mb-sm-5"  alt="meeting">  
                
                <!--FORMULARIOS STEP-->
                <div class = "container-md form pb-0 bg-gray mt-1 rounded shadow-md max-w-900">

                    <!-- progressbar circular-->
                    <div>
                        <ul id="progressbar">
                
                            <li class="active" id="account"><strong>Cuenta</strong></li>

                            <li id="personal"><strong>Datos</strong></li>

                            <li id="payment"><strong>Imagen</strong></li>

                            <li id="confirm"><strong>Terminar</strong></li>

                        </ul>
                    </div>
                
                    <!-- progreso barra -->
                    <div class="progress">

                        <div class="progress-bar progress-bar-striped progress-bar-animated" role="progressbar" aria-valuemin="0" aria-valuemax="100"></div>

                    </div>

                    <div id="form-container" class="container mx-auto pt-3 text-light text-center">
                        
                        <form:form action="validar-registro" id="form"  method="POST" modelAttribute="datosRegistro" enctype="multipart/form-data">
                        
	                            <div id="step-parent" class="step-container">
	                                <div class="step fadeIn activate">
	                                    <div class="step-tittle">
	                                        <h4>Empecemos con los datos de tu cuenta</h4>
	                                    </div>
	                                    
	                                   <div class="step-form">
	                                        
	                                        <div class="input-group my-3">
	                                                <span class="input-group-text" id="basic-addon1">@</span>
	                                                <form:input path="username" type="text" id="username" class="form-control" placeholder="Nombre de Usuario" aria-label="username" aria-describedby="basic-addon1" />
		                                            
		                                            
			                                             <span class="input-group-text verify ${user_v_state}" id="verifica-user">
			                                                    <i class="fa-solid fa-${user_v_icon}"></i>
			                                              </span>
			                                        
			                     
		                                               
		                                               
	                                                <button class="btn btn-primary" type="button" id="btn-valida-usuario">Verificar</button>
	                                                
	                                        </div>
	                                        <div class="input-group my-3">
	                                            <span class="input-group-text" id="basic-addon1">@</span>
	                                            <form:input path="email" id="email" type="email" class="form-control" placeholder="Email" />
		                                            
			                                             <span class="input-group-text verify ${email_v_state}" id="verifica-email">
			                                                    <i class="fa-solid fa-${email_v_icon}"></i>
			                                              </span>
			                                     
	                                            <button class="btn btn-primary" type="button" id="btn-valida-email">Verificar</button>
	                                        </div>
	                                        <div class="">
	                                            <form:input path="password" type="password" id="password" class="form-control my-3" placeholder="Contrase�a" required="true"/>   
	                                            <input  type="password" id="password-repeat" class="form-control my-3" placeholder="Repite la Contrase�a" required/> 
	                                        </div>
	
	                                    </div>
	                                </div>

	                                <div class="step fadeIn">
	                                    <div class="step-tittle">
	                                        <h4>Queremos conocerte un poco m�s</h4>
	                                    </div>
	                                    <div class="step-form">
	                                        <form:input path="nombre" type="text" id="nombre" class="form-control  my-3" placeholder="Nombre" required="true"/> 		  
	                                        <form:input path="apellido" type="text" id="apellido" class="form-control my-3" placeholder="Apellido" required="true"/>
	                                        <div class="input-group my-3">
	                                            <label class="input-group-text" for="inputGroupSelect01">Sexo</label>
	                                            <form:select path="sexo" class="form-select" id="select-genero">
		                                            <form:option value="0" selected="true">Seleccione</form:option>
		                                            <form:option value="1">Femenino</form:option>
		                                            <form:option value="2">Masculino</form:option>
	                                            </form:select>
	                                        </div>
	                                        <div class="d-flex">
	                                        	<label for="select-dia">Fecha de nacimiento</label> 
	                                        </div>
	                                        
	                                        <div class="f-nac d-flex mb-3">
	                                            
	                                            <!--DIA-->
	                                            <div class="input-group me-3">
	                                                <label class="input-group-text" for="select-dia">D</label>
		                                                <select class="form-select" id="select-dia">
		                                                	<option value="0" selected hidden disabled>Dia</option>
	                                               		</select>
	                                            </div>
	                                            <!-- MES -->
	                                            <div class="input-group me-3">
	                                                <label class="input-group-text" for="select-dia">M</label>
	                                                <select class="form-select" id="select-mes">
	                                                	<option value="0" selected hidden disabled>Mes</option>
	                                                
	                                                </select>
	                                            </div>
	                                            <!-- A�O -->
	                                            <div class="input-group">
	                                                <label class="input-group-text" for="select-dia">A</label>
	                                                <select class="form-select" id="select-anio">
	                                                	<option value="0" selected hidden disabled>A�o</option>
	                                                
	                                                </select>
	                                            </div>
	                                        </div>
	                                        
	                                        <input path="nacimiento" type="hidden" name="fnac" id="fnac">
	                                        
	                                    </div>
	                                </div>
	
	                                <div class="step fadeIn">
	                                    <div class="step-tittle">
	                                        <h4>Por �ltimo, seleccion� tu foto de perfil</h4>
	                                    </div>
	                                    <div class="step-form">
	                                        <div class="d-grid center profile mx-auto large bd-red-meet mt-3">
	                                          
	                                            <c:if test="${empty datosRegistro.imagen}">
	                                            <img class = "  mx-auto d-block large"  src="profiles/default.png" id="preview" alt="">
	                                            </c:if>  
	                                            <c:if test="${not empty datosRegistro.imagen}">      
	                                            <img class = "  mx-auto d-block large"  src="${upload_folder}datosRegistro.imagen" id="preview" alt="">        
	                                            </c:if>        
	                                            
	                                        </div>
	                                        <div class="btn btn-primary mx-auto  text-center mt-3">
	                                                <form:input path="imagen" name="archivoImagen" id="file" type="file" class="form-control opacity-0"/>
	                                                Seleccionar Imagen
	                                        </div>
	                                    </div>
	                                </div>
	
	                                <div class="step fadeIn">
                                    <div class="step-tittle">
                                        <h4>L�sto, rev�sa tus datos y confirma el registro</h4>
                                    </div>
                                    <div class="step-form">
                                        <div class="profile medium mx-auto bd-red-meet mt-3 mb-2 text-light">
                                                
                                            <img class = " medium "  src="profiles/default.png" id="verify_preview" alt="">        
                                            
                                        </div>
                                        <p><strong id="verify_nombre"></strong> <strong id="verify_apellido"></strong></p>
                                        <p id="verify_username"></p>
                                        <p id="verify_email"></p>
                                    </div>
                                </div>


                            	</div>
                            
                            
                        
                            
                        
                        </form:form>
                        
                    
                        
                    </div> 
                    
                    <!-- MENSAJE DE ERROR -->
                    <c:if test="${not empty error}">
	                    <div class="alert alert-danger d-flex align-items-center p-2 hidden" role="alert" >
	                        <i class="fa-solid fa-triangle-exclamation me-3 ml-2"></i>
	                        <div id="text-alert">
	                        ${error}
	                        </div>
	                    </div>
					</c:if>
                    
                    <!-- BOTONES -->
                     <div id="frm-buttons">
                        <hr>
                        <form:button class="btn btn-primary btn-secondary btn-step" id="prev-btn" type="button">Atras</form:button> 
                        <form:button class="btn btn-primary btn-step" id="next-btn" type="button">Siguiente</form:button> 
                        <form:button class="btn btn-primary btn-meet" id="submit-btn" type="submit">Confirmar Registro</form:button>
                    </div>
                        
                    
                </div>    
                        
            </div>

            <!--SUCCESS-->
            <c:if test="${not empty reg_ok}">
	            <div id="succes" class="container-md form pb-0 pt-4 bg-gray mt-3 s mt-sm-5 rounded shadow-md max-w-900 fadeIn" >
	            
	                <div class="container mx-auto text-center text-light py-5">
	                    <!--checkMark-->
	                    <div class="check_mark w-25 ">
	                        <div class="sa-icon sa-success animate animateOpacity">
	                        <span class="sa-line sa-tip animateSuccessTip"></span>
	                        <span class="sa-line sa-long animateSuccessLong"></span>
	                        <div class="sa-placeholder animateOpacity"></div>
	                        <div class="sa-fix"></div>
	                        </div>
	                    </div>
	
	
	                    <h2>Felicitaciones!</h2>
	                    <h5>${nombre}, ${apellido}</h5>
	                    <h5 class="mt-5">Te damos la bienvenida a Meeting!</h5>
	                    <p class="mt-5">Puedes comenzar iniciando sesi�n</p>
	                    <a href="login" class="btn btn-primary btn-meet mx-auto">Ingresar</a>
	                    <img src="img/logo/logo_dark.png" class="mx-auto d-block mt-5" style="max-width:150px;"  alt="meeting">    
	                </div>
	        
	            </div>
	        </c:if>    
            
            <!--LOADER-->
            <div id="loader" class="text-light hidden">
                <div class="loader-content">
                    <img src="img/logo/Logo-single.png" class="loader animate" alt="logo">
                    <h5>Espere</h5>
                </div>     
            </div>
      
       	</div>
            
      
    
		
	
      
		
		
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
		<script src="js/bootstrap.bundle.js" type="text/javascript"></script>
		<script src="js/preview.js" type="text/javascript"></script>
		<script src="js/forms.js" type="text/javascript"></script>
	</body>
</body>
</html>