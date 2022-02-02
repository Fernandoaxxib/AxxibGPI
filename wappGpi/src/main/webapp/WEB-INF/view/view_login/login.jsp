<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="google" content="notranslate" />
<title>GPP</title>
<link rel="stylesheet" href="css/estilo-login.css">
<link rel="shortcut icon" href="<c:url value='/Imagenes/favicon.ico'/>">

</head>

<body>

	<table style="width: 100%" class="tabla-header">
		<tr height="50px">
			<td width="200" align="left"><img src="Imagenes/logo-ban.png" class="logo-img">
			</td>
			<td align="left">
				<div class="afore ">GESTOR PORTAFOLIOS PARA PROYECTOS</div>
			</td>
		</tr>
	</table>
	
	<table style="width: 100%">
	<tr height="200px">
	 <td width="600" align="left">
			<div class="card-header-titulo">GESTOR PORTAFOLIOS PARA PROYECTOS (GPP)</div>		
	 </td>
	 <td width="300" align="left">					
	 </td>
	 <td width="500" align="center" ><img src="Imagenes/logo-hex.png" class="img-fluid" alt=""></td>
	 <td width="300" align="center" > </td>	
	</tr>
	
	<tr height="200px">
	 <td width="600" align="left">
				
	 </td>
	 <td width="300" align="left">					
	 </td>
	 <td width="500" align="center" >
	 <div class="form-login h-back">
						
			
			<form action="login" method="POST" class="form-horizontal">
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
											name="password"  required>
			</div>
			
			<button type="submit" class=" btn-iniciarSesion">Iniciar Sesión</button>
			</div>
		  </form>
		  <div class=" text-right">[Versión 01.00.01]</div>
		</div>
	 
	 </td>
	 <td width="300" align="right" >
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
						<button class=" btn tooltip-video " >
							<img src="Imagenes/videos.png" class="image-fluid " alt="">                                    
							<span class="tooltipvideo">
								
	                        </span>
						</button>
					</li>
				</ul>
			</nav>
		</div>
	 
	 
	  </td>	
	</tr>
	
	</table>
	
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