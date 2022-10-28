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
           
 			
 			<!-- SOLO PARA BUSQUEDA  -->
 			
 			
	 			<c:forEach  items="${usuarios}" var="usuario">
	            	
	            	  <!-- TARGETA PUBLICACION -->
			           <div class="mt-card px-3 bg-light mx-5 pb-2 mb-3 shadow fadeIn">
			            
			                
			                 
			                    <div class="profile-box text-center bg-gray-secondary shadow">
			                        <img class="profile medium mx-3 mb-1 mt-3 bd-red-meet" src="${pageContext.request.contextPath}/profiles/${usuario.imagen}" alt="">   
			                    </div>
			                    <div class="w-100 d-flex flex-column pt-3 ps-3">
			                         <h5 class="fs-7 text-center text-light">${usuario.nombre} ${usuario.apellido}</h5>
			                         <div class="fecha d-flex justify-content-between align-items-baseline align-middle mt-auto text-gray">
			                           
			                           <a h="/proyecto-limpio-spring/amigos/solicitud?idUserTo=${usuario.id}&idUserFrom=${user.id}" class="btn btn-meet" btn-friend>
			                           	
			                           		Enviar solicitud
			                           
			                           </a>
			                            
			                         </div>
			                       
			                    </div>
			                      
			             
			
			       		</div>
	        
	            
	 				
	 			</c:forEach>
	 		
           
        </div>
    </main>
<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
 <script src="${pageContext.request.contextPath}/js/ajax.js" type="text/javascript"></script>    
</body>

</html>
