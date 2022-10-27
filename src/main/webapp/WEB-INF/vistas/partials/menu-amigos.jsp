  <nav class="navbar navbar-expand-sm nav-pills bg-light-gray-nav " role="navigation">
            <div class="container-fluid">
                <ul class="navbar-nav px-3">
                    <li class="navbar-brand fs-5 me-5">
                        Amigos
                    </li>
                    <li class="nav-item me-3">
                        <a href="/proyecto-limpio-spring/publicacion/create" class="nav-link "><i class="fa-solid fa-user-group"></i>Mis amigos</a>
                    </li>
                     <li class="nav-item me-3">
                        <a href="/proyecto-limpio-spring/publicacion/create" class="nav-link "><i class="fa-solid fa-user-clock"></i>Solicitudes</a>
                    </li>
                  
                </ul>
                
                 <form class="mx-2 w-50" action="search" method= "GET" >
                    <div class="input-group input-group-sm">
                        <input type="text" name="value" class="form-control" path="titulo" placeholder="Buscar Amigos" />
                        <button class="btn btn-meet" type="submit" id="button-addon1" title="Buscar Publicación"><i class="fa-solid fa-magnifying-glass"></i></button>
                    </div>
                </form>
            
               
            </div>
            
            
            

        </nav>