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

	<table id="tabla-gnral">
		<tr height="50px" >
				<td >					
				</td>
			</tr>
			<tr >
				<td>
					<table>
					<tr>
					  <td  >
							<div id="nav-carga-reporte">						
							<a class="grey " href="<c:url value="/carga"/>">							
							 <div class="cargarep-est-btn " id="carga-avance-tit" >
							 IR A CARGA DE REPORTE DE AVANCE 
							  <span class="reporte-icon">
							    <i class="fas fa-file-upload"></i>
							  </span>
						     </div>
							 </a> 
						
					  </div>		
					 </td>
					</tr>
					<tr height="50px">
					  <td >
							
					 </td>
					</tr>
					<tr>
			      <td colspan="3">
					<div id="nav-carga-reporte">						
							<a class="grey" href="<c:url value="/tab"/>">							
							 <div class="cargarep-est-btn" id="carga-avance-tit" >
							IR A PORTAFOLIO DE PROYECTOS
							  <span class="reporte-icon">
							   <i class="fas fa-file-contract "></i>
							  </span>
						     </div>
							 </a> 
						
					</div>
				</td>
				
				</tr>
					
				</table>
				</td>
				
				<td >
					<div class="tbl-btn-gnral est-titulos grey-obscuro">
					
					 <img src="Imagenes/portafolio.jpg" class=" est-img">

					</div>
				</td>
			</tr>
			
			
			
			
			
			

		</table>

	</section>




	<jsp:include page="../layaut/footer.jsp" />


</body>

</html>