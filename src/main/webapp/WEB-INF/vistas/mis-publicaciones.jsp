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
		 
		<!-- MENU PUBLICACION -->
		 <%@ include file="partials/menu-publicacion.jsp" %> 
        
        <div class="main-content px-3 pt-3 pb-0 mb-0">
            <!--AQUI TODO EL CONTENIDO-->
            <c:forEach  items="${publicaciones}" var="publicacion">
            	
            	  <!-- TARGETA PUBLICACION -->
           <div class="mt-card px-3 bg-light mx-5 pb-2 mb-3 shadow fadeIn">
            <div> 
                
                 <div class="mt-card-header d-flex  px-3">
                    <div class="profile-box text-center bg-gray-secondary shadow">
                        <img class="profile medium mx-3 mb-1 mt-3 bd-red-meet" src="${pageContext.request.contextPath}/profiles/${publicacion.usuario.imagen}" alt="">
                        <h5 class="fs-7 text-center text-light">${publicacion.usuario.nombre}</h5>
                      
                    </div>
                    <div class="w-100 d-flex flex-column pt-3 ps-3">
                         <h4>${publicacion.titulo}</h4>
                         <div class="fecha d-flex justify-content-between align-items-baseline align-middle mt-auto text-gray">
                            <div class="d-flex">
                            	<p class="mb-0 fs-6"><strong class="fs-7">Participantes:</strong>10/<strong>10</strong></p>
                            </div>
                            <div class="d-flex">
	                            <p class="italic px-2 my-0 py-0 fs-6 ">${publicacion.fecha}</p>
	                            <p class="italic px-2 my-0 py-0fs-6 ">hora</p>
                            </div>
                            
                         </div>
                       
                    </div>
                      
                       
                   </div>
                    <div class="mt-card-actions mt-3 ">
                    <div class="actions d-flex text-center align-items-center">
                        <div class="mt-card-like me-3 ">
                            <a href=""><i class="fa-regular fa-heart"></i></a>
                            <p>124</p>
                        </div>
                        <div class="mt-card-view me-3">
                            <a href=""><i class="fa-regular fa-eye"></i></a>
                            <p>1256</p>
                        </div>
                         <div class="mt-card-add">
                            <a href="">  <i class="fa-regular fa-bookmark"></i></a>
                          <p>100</p>
                        </div>
                    </div>

                
                </div>
            
            </div>
           

          

       </div>
        
            
 				
 			</c:forEach>
           
        </div>
    </main>

 <script src="js/menu.js" type="text/javascript"></script>    
</body>

</html>
