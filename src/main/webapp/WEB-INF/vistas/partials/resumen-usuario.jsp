<!--DETALLE PERFIL-->
        <div class="d-flex bg-gray px-2 px-md-5 py-3">
            <img src="${pageContext.request.contextPath}/profiles/${user.imagen}" alt="profile" class="profile medium bd-red-meet me-4">
            <div class="my-auto">
              <h5 class="text-light mb-0 fs-7">@${user.username}</h5> 
              <small class="text-light-gray italic fs-8">${user.email}</small> 
            </div>
            <div class="d-flex flex-col mx-auto text-light my-auto text-center">
                <div class="px-2 px-md-5">
                  <h6 class="fs-7">Mis eventos</h6>
                  <h5>0</h5>  
                </div>
                <div class="px-2 px-md-5">
                    <h6 class="fs-7">Mis amigos</h6>
                    <h5>0</h5>
                </div>
                
            </div>
            
        </div>