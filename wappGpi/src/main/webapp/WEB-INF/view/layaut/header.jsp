
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>


<header id="header">

	<div class="header">
  <img src="Imagenes/logo-ban.png" class=" left">
  <div class="afore blue left"><a class="blue" href="<c:url value="/home"/>"> GESTOR PORTAFOLIOS PARA PROYECTOS</a></div>


  <div class="header-right">
   <div class="afore grey usuario-header">
					<div >Usuario: <sec:authentication property="principal.username" /> </div>
				</div>
    <div class="afore  salir-header  red">	 
	 <button id="btn-modal-cerrar-sesion" class="btn-cerrar-sesion"><span class="icono-cerrar "><i class="fas fa-power-off "></i></span></button> 
	 
	</div>
  </div>
</div>

    
		
	
</header>

<div id="modal-cerrar-sesion" class="modalContainer">
		 <div class="modal-content">
		 <span class="close">×</span>

		    <div class="cerrar-sesion-contenido">
		    
		    <div class="grupo-botones">
		       <span class="icono-alerta alerta-icono "><i class="far fa-question-circle"></i></span> <h4 class="txt-alerta" >  ¿Realmente desea cerrar la sesión?</h4>
		    </div>
		      
				
            
            <div class="grupo-botones">
              <form method="POST" action="logout" >
				 <button class="btn-gnral botones-cerrar-sesion " >SI</button>
			 </form>  
				 
				 <button class="btn-gnral-red  botones-cerrar-sesion cerrar ">NO</button>
				
				</div>
				
				</div>



			
		
		</div>		 
		</div> 
		
		<script>
			if(document.getElementById("btn-modal-cerrar-sesion")){
				var modal = document.getElementById("modal-cerrar-sesion");
				var btn = document.getElementById("btn-modal-cerrar-sesion");
				var span = document.getElementsByClassName("close")[0];
				var cerrar = document.getElementsByClassName("cerrar")[0];
				var body = document.getElementsByTagName("body")[0];
	
				btn.onclick = function() {
					modal.style.display = "block";	
					body.style.position = "static";
					body.style.height = "100%";
					body.style.overflow = "hidden";
				}
	
				span.onclick = function() {
					modal.style.display = "none";	
					body.style.position = "inherit";
					body.style.height = "auto";
					body.style.overflow = "visible";
				}

				cerrar.onclick = function() {
					modal.style.display = "none";	
					body.style.position = "inherit";
					body.style.height = "auto";
					body.style.overflow = "visible";
				}
	
				
			}
		</script>
