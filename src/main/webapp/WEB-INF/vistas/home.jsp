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
    <%@ include file="cabecera.jsp" %>
    
    <div class="container content px-0">
        <div class="d-flex bg-dark-gray px-5 py-3">
            <img src="profiles/default.png" alt="profile" class="profile bd-red-meet me-4">
            <div>
              <h5 class="text-light mb-0">@Mi usuario</h5> 
              <small class="text-light">test@test</small> 
            </div>
            <div class="d-flex flex-col mx-auto text-light my-auto text-center">
                <div class="px-5">
                  <h6>Mis eventos</h6>
                  <h5>0</h5>  
                </div>
                <div class="px-5">
                    <h6>Mis amigos</h6>
                    <h5>0</h5>
                </div>
                
            </div>
            
        </div>
        <div>

        </div>
        <div class="main-content bg-light-gray">
            Aqui menu y contenido
        </div>
    </div>
    <main>

    </main>
</body>
<script src="js/bootstrap.bundle.js"  type="text/javascript"></script>
</html>