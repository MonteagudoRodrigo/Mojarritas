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
		<link href="css/login.css" rel="stylesheet">
	</head>
	<body>
		<div class = "container-md">
			<div id="registrobox" class="login-container mx-auto">
				<%--Definicion de un form asociado a la accion /validar-login por POST. Se indica ademas que el model attribute se--%>
				<%--debe referenciar con el nombre usuario, spring mapea los elementos de la vista con los atributos de dicho objeto--%>
					<%--para eso debe coincidir el valor del elemento path de cada input con el nombre de un atributo del objeto --%>
					<img class = "w-75 my-5 mx-auto d-block"  src="img/logo/logo_dark.png" alt="">
					<form:form action="validar-registro" method="POST" modelAttribute="datosRegistro">
					<div class="d-grid center">
						<h1 class="h3" style="color:white;text-align:center">Creá tu cuenta</h1>
					</div>

					<%--Elementos de entrada de datos, el elemento path debe indicar en que atributo del objeto usuario se guardan los datos ingresados--%>
					<form:input path="email" id="email" type="email" class="form-control" placeholder="Email" />
					<form:input path="password" type="password" id="clave" class="form-control" placeholder="Contraseñia" />   
					<form:input path="nombre" type="text" id="nombre" class="form-control" placeholder="Nombre" /> 		  
					<form:input path="apellido" type="text" id="apellido" class="form-control" placeholder="Apellido" />
					<form:input path="username" type="text" id="username" class="form-control" placeholder="Nombre de Usuario" />
					
					<div class="d-grid center">
						<button class="btn btn-primary" Type="Submit">Registrarme</button>
					</div>
				</form:form>
				<%--Bloque que es visible si el elemento error no esta vacio	--%>
				<c:if test="${not empty error}">
			        <h4><span>${error}</span></h4>
			        <br>
		        </c:if>
				${msg}
			</div>
		</div>
		
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>
