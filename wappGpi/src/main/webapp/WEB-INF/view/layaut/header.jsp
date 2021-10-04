
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
					<a	href="<c:url value="/logout"/>" ><span class="icono-cerrar "><i class="fas fa-power-off "></i></span>  </a>
	</div>
  </div>
</div>
	
</header>

