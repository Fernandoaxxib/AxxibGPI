<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="google" content="notranslate" />
<title>GPP</title>
<link rel="stylesheet" href="css/estilo-head-footer.css">
<link rel="shortcut icon" href="<c:url value='/Imagenes/favicon.ico'/>">
<link rel="stylesheet" href="css/estilo-home.css">
<link rel="stylesheet" href="css/estilos-gnrls.css">
<script src="https://kit.fontawesome.com/4fb8bc8279.js"></script>
</head>

<body>


	<jsp:include page="../layaut/header.jsp" />



	 <section id="home">

        <table id="tabla-home">          
            
					<tr>
					 <td width="300" ></td>
					  <td  >
						<div>

                            <div >
                                <img src="Imagenes/inicio-h.jpg" class=" img-home ">

                            </div>

                        </div>	
					 </td>
                     
                     <td   width="600" align="center">
						   
                            <a href="<c:url value="/portafolio"/>" >
                                <img src="Imagenes/btn1.png"  class="botones-hover img-hex" alt="">
                            </a>
                            
                            <a  href="<c:url value="/registroAvance"/>">
                                <img src="Imagenes/btn2.png" class="botones-hover img-hex" alt="">
                            </a>
                           
                            <a  href="#">
                                <img src="Imagenes/btn3.png" class="botones-hover img-hex" alt="">
                            </a>
                           

                        

					 </td>
					 <td width="100" ></td>
			</tr>
        </table>
    
        </section>




	<jsp:include page="../layaut/footer.jsp" />


</body>

</html>