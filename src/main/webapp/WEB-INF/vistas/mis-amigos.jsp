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
        
        <!-- DETALLES PERFIL -->
        
        <%@ include file="partials/resumen-usuario.jsp" %>
		
		<!-- MENU PRINCIPAL -->
		 <%@ include file="partials/menu-principal.jsp" %>
		 
		<!-- MENU AMIGO -->
		 <%@ include file="partials/menu-amigos.jsp" %> 
        
        <div class="main-content px-3 pt-3 pb-0 mb-0">
            <!--AQUI TODO EL CONTENIDO-->
          
            
            	<c:forEach  items="${amigos}" var="amigo">
            	
            	  <!-- TARGETA PUBLICACION -->
				<div class="mt-card d-flex align-items-center px-3 bg-light mx-3 pb-2 mb-2 shadow fadeIn">



					<div class="col-2">
						<img class="profile medium mx-3 mb-1 mt-3 bd-red-meet"
							src="${pageContext.request.contextPath}/profiles/${amigo.amigo.imagen}"
							alt="">
					</div>

					<div
						class="col-10 d-flex align-items-center justify-content-between  pt-3">
						<h5 class="fs-7 ">${amigo.amigo.nombre}
							${amigo.amigo.apellido}</h5>

						
						<div class="dropdown">
									<a class="btn btn-meet dropdown-toggle" data-bs-toggle="dropdown"
										role="button" aria-expanded="false" btn-friend> Opciones </a>
		
									<ul class="dropdown-menu">
										<li><a class="dropdown-item" href="#">Eliminar de amigos</a></li>
									</ul>
						</div>


					</div>



				</div>




			</c:forEach>
          
 			
 		
           
        </div>
    </main>

<script src="${pageContext.request.contextPath}/js/bootstrap.bundle.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
 <script src="js/menu.js" type="text/javascript"></script>    
 
</body>

</html>
