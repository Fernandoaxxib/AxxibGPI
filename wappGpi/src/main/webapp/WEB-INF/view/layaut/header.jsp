
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>


<header id="header">


	<table style="width: 100%" id="tbl-header" >
	   <tr height="0px">
		  <td>
		  
		  <table style="width: 100%" class="estilo-tbl-header">
							<tr >
								<td width="100">
								<div class="header">
                                     <img src="Imagenes/logo-ban.png" >
                                   </div>
                                  </td>
								<td width="400"><div class="afore blue "><a class="blue" href="<c:url value="/home"/>"> GESTOR PORTAFOLIOS PARA PROYECTOS</a></div></td>
								<td width="100"></td>
								<td width="100"></td>
								<td width="100"></td>
								<td width="100"></td>
								<td width="400"><div class="afore blue usuario-header">
					                             <div ><span class="icono-usuario "><i class="fas fa-user"></i> </span> <sec:authentication property="principal.username" /> </div>
				                                </div></td>
								<td width="100"><div class="afore  salir-header  red">	 
	 <button id="btn-modal-cerrar-sesion" class="btn-cerrar-sesion"><span class="icono-cerrar "><i class="fas fa-power-off "></i></span></button> 
	 
	</div></td>
								
							</tr>


						</table>
		  	</td>
		
		</tr>
	
		<tr>
		  <td>
		  <div class="linea-header">	</div>
		  </td>
		
		</tr>
		
	</table>
	




</header>

<div id="modal-cerrar-sesion" class="modalContainer">
	<div class="modal-content">
		<span class="close">×</span>

		<div class="cerrar-sesion-contenido">

			<div class="grupo-botones">
				<span class="icono-alerta alerta-icono "><i
					class="far fa-question-circle"></i></span>
				<h4 class="txt-alerta">¿Realmente desea cerrar la sesión?</h4>
			</div>



			<div class="grupo-botones">
				<form method="POST" action="logout">
					<button class="btn-gnral botones-cerrar-sesion ">SI</button>
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
