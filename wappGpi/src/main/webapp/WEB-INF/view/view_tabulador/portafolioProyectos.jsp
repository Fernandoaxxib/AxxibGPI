<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="google" content="notranslate" />
<title>GPP</title>
<link rel="stylesheet" href="css/estilo-head-footer.css">
<link rel="stylesheet" href="css/estilos-gnrls.css">
<link rel="shortcut icon" href="<c:url value='/Imagenes/favicon.ico'/>">
<script src="https://kit.fontawesome.com/4fb8bc8279.js"></script>

<style>
table {
	width: 100%;
}

#portafolio-proyecto .titl-proyecto {
	font-size: 14px;
	font-family: sans-serif;
	background: #e9e9e9;
	width: 969px;
	height: 34px;
	line-height: 32px;
	text-align: center;
	font-weight: 600;
	border-radius: 7px;
	color: #fff;
	background-color: #59ad40;
	border-color: transparent;
}

.tbl-btn-gnral {
	height: 400px;
}

.btn-prt{
 height: 30px;
}

.est-titulos {
	font-size: 15px;
	font-family: sans-serif;
	font-weight: 600;
	color: #00529b;
}

.tbl-botones-radio {	
	height: 350px;
}

.est-titulos-radio {
	font-size: 13px;
	font-family: sans-serif;
	line-height: 32px;
	text-align: center;
	font-weight: 600;
	color: #00529b;
	border: 2px solid #6e6e6e;
	border-radius: 14px;
}

.titulo-radio {
	text-align: left;
	font-size: 12px;
	font-family: sans-serif;
	font-weight: 800;
	padding: 0px 7px 0px 9px;
	color: #00529b;
}

#tabla-contendio table td {
    padding: 0px 3px ;
}

#tabla-contendio {
	overflow: scroll;
	height: 370px;
	width: 100%;
}

#tabla-contendio::-webkit-scrollbar {
	width: 14px;
}

#tabla-contendio::-webkit-scrollbar-track:vertical {
	background-color: #d6d6d6;
}

::-webkit-scrollbar-button {
	background-color: #007bff00;
}

#tabla-contendio::-webkit-scrollbar-thumb {
	background-color: #00529b;
	height: 80px;
}

::-webkit-scrollbar-corner {
	background-color: #007bff00;
}
</style>
</head>

<body>


	<jsp:include page="../layaut/header.jsp" />



	<section id="home">
		<table>
			<tr height="30px">
				<td></td>
			</tr>
			<tr>
				<td width="200"></td>
				<td>
					<div id="portafolio-proyecto">

						<div class="titl-proyecto">GESTIÓN DE PORTAFOLIOS DE
							PROYECTOS</div>

					</div>

				</td>
			</tr>

		</table>

<form method="POST" action="tab"  id="form-gestion-portafolios">
		<table id="tabla-gnral">
			<tr height="10px">
				<td></td>
			</tr>
			<tr>
				<td width="200"></td>
			</tr>

			<tr height="20px">
				<td></td>
				
				 <td>
			<h5 class="titulo-radio">SELECCIONA EL PORTAFOLIO: </h5>	
			</td>

			</tr>


			<tr>
				<td></td>

				<td>

					<div class="tbl-botones-radio est-titulos-radio grey-obscuro">
						<div id="tabla-contendio">

							<table id="tbl-gnral-btones">
								<c:forEach var="lista"
									items="${listaReportes}"
															varStatus="indexLista">

								<tr>
									<td align="center"><input type="radio" 
										name="idPortafolio" value="${lista.getId()}" checked></td>
									<td align="left">${lista.getDescripcion()}</td>

								</tr>
								</c:forEach>



							</table>

						</div>

					</div>

				</td>
				<td width="20"></td>

				<td>
				
				
					<button type="submit" 
						class="btn-gnral btn-prt">VER PORTAFOLIO SELECCIONADO</button>
						
				</td>

				<td width="100"></td>
				<td width="100"></td>


			</tr>

		</table>
		</form>

	</section>




	<jsp:include page="../layaut/footer.jsp" />

<script>
function obtieneOperacion(val){

	document.getElementById("operacion-radio").value=val;
	console.log("operacion " + val );
	
}

</script>

</body>

</html>