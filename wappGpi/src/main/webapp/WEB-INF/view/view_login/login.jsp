<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="google" content="notranslate" />
<title>Afore digital</title>
<link rel="stylesheet" href="css/estilo-login.css">

</head>

<body>
	<div id="login-header">
		<div class="wrapper ">
			<div>
				<img src="Imagenes/logo-ban.png" class="logo-nav">
			</div>
			<div>
				<div class="afore left-gpp">GESTOR PORTAFOLIOS PARA PROYECTOS</div>
			</div>
			
			
		</div>
	</div>


	<section id="sesion-login">
		<div class="titulo-login">
			<div class="card-header-titulo">GESTOR PORTAFOLIOS PARA PROYECTOS (GPP)</div>
		</div>
		<div class="imagen-login">
			<img src="Imagenes/logo-hex.png" class="img-fluid" alt="">
		</div>

		<div id="noticias" class="noticias-right">
			<nav class="fixed">
				<ul>
					<li>
						<button class=" btn tooltip" >
							<img src="Imagenes/noticias.png" class="image-fluid " alt="">
							<span class="tooltiptext">
													 <h4 class="green">Afore XXI Banorte invertirá en bonos verdes</h4>
													 <p>Afore XXI Banorte está dispuesta a destinar toda su inversión en 
													 infraestructura y energía en bonos verdes, alrededor de 50,000 
													 millones de pesos, como parte de su compromiso para combatir el cambio
													  climático frente al riesgo que representa para las inversiones.</p>
						   </span>
						</button>
					</li>
					<li>
						<button class=" btn " >
							<img src="Imagenes/videos.png" class="image-fluid " alt="">                                    
							
						</button>
					</li>
				</ul>
			</nav>
		</div>


		<div class="form-login h-back">
						
			<c:url var="loginUrl" value="/login" />
			<form action="${loginUrl}" method="POST" class="form-horizontal">
			<div  class="card-login-head"> 
			CONTROL DE ACCESO
		     </div >
			<div class="formcontainer">
			<hr/>
			<c:if test="${not empty errorMessge}">
										<div class="msg-gen-error">${errorMessge}</div>
									</c:if>	
			<div class="container">
			  <label for="uname"><strong>Cuenta Usuario:</strong></label>
			  <input type="text" placeholder="Usuario" name="usuario"
											id="validationTooltip01" required>
			  <label for="psw"><strong>Contraseña:</strong></label>
			  <input type="password" placeholder="Contraseña" id="validationTooltip03"
											name="password" required>
			</div>
			
			<button type="submit" class=" btn-iniciarSesion">Iniciar Sesión</button>
			</div>
		  </form>
		  <div class=" text-right">[Versión 11.01.00]</div>
		</div>


		

	</section>

	<footer>
		<div class="fixed-bottom">
			<div class="float-left">
				<span>© 2019. Afore XXI Banorte S.A. de C.V. Derechos
					Reservados</span>
			</div>
			<div class="float-right">
				<a href="https://twitter.com/XXIBanorte" target="_blank"
					rel="noopener"> <img src="Imagenes/icn_tw.svg" width="24"
					height="24" title="Ir a https://twitter.com/XXIBanorte"
					class="h-back" alt="Ícono_Twitter">
				</a> <a href="https://www.facebook.com/xxibanorte" target="_blank"
					rel="noopener"> <img src="Imagenes/icn_fb.svg" width="24"
					height="24" title="Ir a https://www.facebook.com/xxibanorte"
					class="h-back" alt="Ícono_Facebook">
				</a> <a href="https://www.youtube.com/user/AforeXXIBanorte"
					target="_blank" rel="noopener"> <img
					src="Imagenes/icn_youtube_circle_.svg" width="24" height="24"
					title="Ir a https://www.youtube.com/user/AforeXXIBanorte"
					class="h-back" alt="Ícono_Youtube">
				</a> <a href="https://mx.linkedin.com/company/afore-xxi-banorte"
					target="_blank" rel="noopener"> <img
					src="Imagenes/icn_linkedin_circle_.svg" width="24" height="24"
					title="Ir a https://mx.linkedin.com/company/afore-xxi-banorte"
					class="h-back" alt="Ícono_Linkedin">
				</a>
			</div>


		</div>
	</footer>

</body>

</html>