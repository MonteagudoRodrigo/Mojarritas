<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>meeting</title>
    <!-- Bootstrap Core-->
    <link rel="stylesheet" href="css/bootstrap.css">
    <!-- Fonawesome-->
    <link rel="stylesheet" href="css/all.css">
    <link rel="stylesheet" href="css/global.css">
</head>
<body class="bg-dark">

	<!-- CABECERA -->

    <%@ include file="partials/cabecera.jsp" %>
    
   
   <!--CONTENEDOR PRINCIPAL-->
    <main class="container content px-0 bg-light-gray">
        
        <!-- DETALLES PERFIL -->
        <%@ include file="partials/resumen-usuario.jsp" %>

        
        <div class="main-content px-3 pt-3">
            <!--AQUI TODO EL CONTENIDO-->
           <input class="form-control" type="text" name="" id="">
        </div>
    </main>

    
</body>
<script src="js/bootstrap.bundle.js"  type="text/javascript"></script>
</html>
