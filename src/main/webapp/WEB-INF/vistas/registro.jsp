<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
	</head>
	<body>
		<div class = "container">
			<div id="registrobox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
				<%--Definicion de un form asociado a la accion /validar-login por POST. Se indica ademas que el model attribute se--%>
				<%--debe referenciar con el nombre usuario, spring mapea los elementos de la vista con los atributos de dicho objeto--%>
					<%--para eso debe coincidir el valor del elemento path de cada input con el nombre de un atributo del objeto --%>
				<form:form action="validar-registro" method="POST" modelAttribute="datosRegistro" enctype="multipart/form-data">
			    	<h3 class="form-signin-heading">Registro</h3>
					<hr class="colorgraph"><br>
					
					<input name="archivoImagen" id="imagen" type="file" class="form-control"/>

					<%--Elementos de entrada de datos, el elemento path debe indicar en que atributo del objeto usuario se guardan los datos ingresados--%>
					<form:input path="email" id="email" type="email" class="form-control" placeholder="Email" />
					<form:input path="password" type="password" id="clave" class="form-control" placeholder="Contraseña" />   
					<form:input path="nombre" type="text" id="nombre" class="form-control" placeholder="Nombre" /> 		  
					<form:input path="apellido" type="text" id="apellido" class="form-control" placeholder="Apellido" />
					
					<button class="btn btn-lg btn-primary btn-block" Type="Submit"/>Registrarme</button>
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
