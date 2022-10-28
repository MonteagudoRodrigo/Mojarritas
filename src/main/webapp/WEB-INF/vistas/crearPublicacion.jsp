<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>meeting</title>
    <!-- Bootstrap Core-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
    <!-- Fonawesome-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/all.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/global.css">
     <!--CARDS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/card.css">
</head>
<body class="bg-dark">

	<!-- CABECERA -->

    <%@ include file="partials/cabecera.jsp" %>
    
   
   <!--CONTENEDOR PRINCIPAL-->
    <main class="container content px-0 bg-light-gray">
        
        
        <div class="main-content px-3 pt-3 pb-0 mb-0">
            <!--AQUI TODO EL CONTENIDO-->
           <div class="d-grid center">
					<h1 class="h3" style="color:white;text-align:center">Nueva publicación</h1>
				</div>
				<form:form action="validar-publicacion" method="POST" modelAttribute="datosPublicacion">
					<form:input path="lugarId" 				id="lugar"	 			type="text" class="form-control my-3" placeholder="Lugar" />
					<form:input path="titulo" 				id="titulo" 			type="text" class="form-control my-3" placeholder="Título" />
					<form:input path="fecha" 				id="fecha" 				type="text" class="form-control my-3" placeholder="YYYY-MM-DD" />
					<form:input path="descripcion" 			id="descripcion"		type="text" class="form-control my-3" placeholder="Descripción" />
					<form:input path="cupo" 				id="cupo" 				type="number" class="form-control my-3" placeholder="Cupo máximo de participantes" />
					
					<div class="d-grid center">
						<button class="btn btn-primary" Type="Submit">Crear publicación</button>
					</div>
				</form:form>
				<c:if test="${not empty error}">
					<div class="alert alert-danger mt-4" role="alert">
						<i class="fa-solid fa-triangle-exclamation"></i>
						${error}
					</div>
			        
		        </c:if>
				${msg}
           
        </div>
    </main>

 <script src="js/menu.js" type="text/javascript"></script>    
</body>

</html>
