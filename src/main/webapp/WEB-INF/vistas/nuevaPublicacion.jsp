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
		<link href="css/publicacion.css" rel="stylesheet">
	</head>
	<body>
		<div class = "container-md">
			<div id="loginbox"  class="login-container mx-auto">
				<div class="d-grid center">
					<h1 class="h3" style="color:white;text-align:center">Nueva publicación</h1>
				</div>
				<form:form action="validar-publicacion" method="POST" modelAttribute="datosPublicacion">
					<form:input path="lugar" 				id="lugar"	 			type="text" class="form-control my-3" placeholder="Lugar" />
					<form:input path="titulo" 				id="titulo" 			type="text" class="form-control my-3" placeholder="Título" />
					<form:input path="fecha" 				id="fecha" 				type="text" class="form-control my-3" placeholder="YYYY-MM-DD" />
					<form:input path="descripcion" 			id="descripcion"		type="text" class="form-control my-3" placeholder="Descripción" />
					<form:input path="cupo" 				id="cupo" 				type="number" class="form-control my-3" placeholder="Cupo máximo de participantes" />
					
					<div class="d-grid center">
						<button class="btn btn-primary" Type="Submit">Crear publicación</button>
					</div>
				</form:form>
			</div>
		</div>
		
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>
