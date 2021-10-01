
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>


<header id="header">

	<div id="login-header">
	
	<div class="grid-container">
	       <div class="item1 left">			
				<div>
				<img src="Imagenes/logo-ban.png" class="logo-nav">
			</div>
			</div>
			<div class="item1 left">			
				<div class="afore ">
				<a class="blue" href="<c:url value="/home"/>"> GESTOR PORTAFOLIOS PARA PROYECTOS</a>
				</div>
			</div>
			
			<div class="right">
			<div class="item1 left ">
				<div class="afore grey usuario-header">
					<div >Usuario: <sec:authentication property="principal.username" /> </div>
				</div>
				
			</div>
			<div class="item1 left ">				
				<div class="afore  salir-header  red">
					<a	href="<c:url value="/logout"/>" ><span class="icono-cerrar "><i class="fas fa-power-off "></i></span>  </a>
				</div>
			</div>
			</div>
			

		</div>
		
		
	</div>
	
</header>

