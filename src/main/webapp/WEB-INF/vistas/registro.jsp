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
	</head>
	<body class="bg-dark">
		<nav class="navbar bg-dark position-fixed w-100" style="background-color: var(--mt-light)">
	        <div class="container">
	           <div class="pt-2">
		            <a href="login" class="btn btn-primary me-4">
		            	<i class="fa-solid fa-circle-chevron-left"></i>
		            	Volver
		            </a>
		            <img src="img/logo/logo_dark.png" class="mt-brand"  alt="meeting">    
	           </div>
	          	 
	           
	           
	             
	        </div>
	       
	    </nav>
		
		<div class = "container-md">
			<div id="registrobox" class="container mx-auto pt-5">
				<%--Definicion de un form asociado a la accion /validar-login por POST. Se indica ademas que el model attribute se--%>
				<%--debe referenciar con el nombre usuario, spring mapea los elementos de la vista con los atributos de dicho objeto--%>
					<%--para eso debe coincidir el valor del elemento path de cada input con el nombre de un atributo del objeto --%>
					
					<form:form  action="validar-registro" id="form"  method="POST" modelAttribute="datosRegistro" enctype="multipart/form-data">
					<div class="d-grid center">
						<h1 class="h3 mt-5" style="color:white;text-align:center">Creá tu cuenta</h1>
					</div>
					
					<div class="d-grid center mb-5 mt-3">
						<div class="d-grid center profile mx-auto large bd-red-meet">
							<img class = "  mx-auto d-block large"  src="profiles/default.png" id="preview" alt="">
							<div class="btn bg-dark file mx-auto w-100 text-center">
								<form:input path="imagen" name="archivoImagen" id="file" type="file" class="form-control opacity-0"/>
								<i class="fa-solid fa-camera text-light fs-3"></i>
							</div>
						</div>
						
					</div>
					
					<%--Elementos de entrada de datos, el elemento path debe indicar en que atributo del objeto usuario se guardan los datos ingresados--%>
					<div class="d-flex my-3">
						<form:input path="nombre" type="text" id="nombre" class="form-control  me-3" placeholder="Nombre" required="true"/> 		  
						<form:input path="apellido" type="text" id="apellido" class="form-control" placeholder="Apellido" required="true"/>
					</div>
					
					<div class="d-flex my-3">
						<div class="input-group me-3" style="max-width: 38%;">
			  					<span class="input-group-text" id="basic-addon1">@</span>
								<form:input path="username" type="text" id="username" class="form-control" placeholder="Nombre de Usuario" aria-label="username" aria-describedby="basic-addon1" required="true"/>
						</div>
						<div class="d-grid me-3">
							<a  id="link_submit" class="btn btn-secondary d-block">Verificar</a>
						</div>
						
						
						<!-- //VERIFICACION DE USUARIO -MENSAJES -->
						<c:if test="${not empty user_ok}">
							<div class="alert alert-success py-1 my-0 d-block w-100" role="alert">
	 							 ${user_ok}
							</div>
						</c:if>
						
						<c:if test="${not empty user_found}">
							<div class="alert alert-danger py-1 my-0 d-block w-100" role="alert">
	 							 ${user_found}
							</div>
						</c:if>
						
						
					</div>
					
					<form:input path="email" id="email" type="email" class="form-control my-3" placeholder="Email" required="true"/>
					
					<div class="d-flex my-3">
						<form:input path="password" type="password" id="password" class="form-control me-3" placeholder="Contraseña" required="true"/>   
						<input  type="password" id="password-repeat" class="form-control" placeholder="Repite la Contraseña" required="true"/> 
					</div>
					
					
					<div class="d-grid center mx-auto mt-5">
						<button class="btn btn-primary" Type="Submit">Registrarme</button>
					</div>
				</form:form>
				<%--Bloque que es visible si el elemento error no esta vacio	--%>
				<c:if test="${not empty error}">
						<div class="alert alert-danger w-100 mt-4" role="alert">
 							 ${error}
						</div>
		        </c:if>
		        <c:if test="${not empty msg}">
		        		<div class="alert alert-success w-100 mt-4" role="alert">
 							 ${msg}
						</div>
		        
		        </c:if>
				
			</div>
		</div>
		
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
		<script src="js/bootstrap.bundle.js" type="text/javascript"></script>
		<script src="js/preview.js" type="text/javascript"></script>
		<script src="js/forms.js" type="text/javascript"></script>
	</body>
</html>


