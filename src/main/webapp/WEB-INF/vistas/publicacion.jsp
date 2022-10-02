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
				<h1 class="h3" style="color:white;text-align:center">${publicacion}</h1>
				<table class="table table-borderless">
					<tbody>
						<tr>
							<th scope="row">Detalle</th>
							<td>${descripcion}</td>
						</tr>
							<th scope="row">Fecha</th>
							<td>${fecha}</td>
						<tr>
						</tr>
						<tr>
							<th scope="row">Cantidad de participantes</th>
							<td>${cantParticipantes} de ${cupo}</td>
						</tr>
						<tr>
							<th scope="row">Anfitrión</th>
							<td>${nombreUsuario}</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>
