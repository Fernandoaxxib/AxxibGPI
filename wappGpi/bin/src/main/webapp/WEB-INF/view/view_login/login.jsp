<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
        <div><img src="Imagenes/logo-ban.png" class="logo-nav"></div>
        <div><div class="afore" > PLATAFORMA
            AFORE DIGITAL</div></div>
        <div><div class="HACD">
            <div class="est-acd"
                >ACERCA DE</div>
        </div></div>
        <div><div class="HACD">
            <div class="est-acd"
                >PRIVACIDAD</div>
        </div></div>
     </div>
    </div>
    

    <section id="sesion-login">        
            <div class="grid-container">
                <div class="item2">
                 <div class="card-header-titulo">GESTOR PORTAFOLIOS DE INVERSION (GPI) </div>
                  </div>
                  <div class="item3">
                    <img src="Imagenes/logo-hex.png" class="img-fluid" alt="">
                 </div>
                
              </div>

              <div class="grid-container  ">  
                            
                <div class="item3 ">
                   
                    <div  class="card-login-head">
                        <div class="card-header text-center">CONTROL DE ACCESO</div>
                    </div>
                    <div class="card-login-body"> 
                    <div class="alertaSession">${ejemploMsg}</div>

                    
                                      
                </div>
                        
                    
                </div>
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