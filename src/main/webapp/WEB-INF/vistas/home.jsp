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
    <nav class="navbar position-fixed w-100" style="background-color: var(--mt-light)">
        <div class="container">
            <a class="navbar-brand" href="#">
                <img src="img/logo/Logo.png" class="mt-brand"  alt="meeting">
            </a>
             <ul class="nav d-flex fs-5 ">
                <li class="nav-item">
                    <a class="nav-link text-dark-gray" href="" title="Notificaciones">
                        <i class="fa-solid fa-comment-dots "></i>
                        
                    </a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle text-dark-gray" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false" title="Opciones">
                        <i class="fa-solid fa-gear"></i> 
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="#">Editar Perfil</a></li>
                        <li><a class="dropdown-item" href="#">Configuración</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="#">Cerrar Sesión</a></li>
                    </ul>
                </li>
               
            </ul>
             
        </div>
       
    </nav>
    
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