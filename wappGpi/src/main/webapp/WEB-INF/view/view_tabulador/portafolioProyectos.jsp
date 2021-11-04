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

#portafolio-proyecto {
	font-size: 14px;
	font-family: sans-serif;
	background: #e9e9e9;
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

.btn-prt {
	height: 30px;
}

.est-titulos {
	font-size: 14px;
    font-family: sans-serif;
    font-weight: 600;
    color: #6a6a6a;
    text-align: left;
}

.tbl-botones-radio {
	width: 410px;
}

.est-titulos-radio {
	font-size: 13px;
	font-family: sans-serif;
	line-height: 32px;
	text-align: left;
	font-weight: 500;
	color: #0c0c0c;
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
	padding: 0px 3px;
}
</style>


    

</head>

<body>


	<jsp:include page="../layaut/header.jsp" />



	<section id="home">
		<table style="width: 100%">
			<tr height="50px">
				<td width="20%"></td>
				<td colspan="3" style="text-align: center">
					<div id="portafolio-proyecto">GESTIÓN DE PORTAFOLIOS DE
						PROYECTOS</div>
				</td>
				<td width="20%"></td>
			</tr>

		</table>

		<form method="POST" action="tab" id="form-gestion-portafolios">
			<table id="tabla-gnral">
				<tr height="30px">
					<td></td>
				</tr>
				<tr>
					<td width="400"></td>

				</tr>
				
				


				<tr>
					<td width="25%"></td>
					<td colspan="3">
						<div class="tbl-botones-radio est-titulos-radio grey-obscuro">
							<div id="tabla-contendio" >
								<table id="tbl-gnral-btones">
									<tr height="50px">
										<td width="10"  ></td>
										<td class="est-titulos">SELECCIONA EL PORTAFOLIO:</td>
										<td width="10"> </td>
									</tr>
									
									
										<tr>
										 
											
									<td colspan="2" >
									
									<div id="lista-radio" style="display: block; overflow-y: auto; height: 350px;">
										<c:forEach var="i" begin="0" end="${listaReportes.size() - 1}">
										
											
		       										<input
													type="radio" id="${listaReportes.get(i).getId()}" name="idPortafolio"
													value="${listaReportes.get(i).getId()}" required="required" >
													 <label class="est-radio" for="${listaReportes.get(i).getId()}">${listaReportes.get(i).getDescripcion()}</label>
													<br>
											
										
										</c:forEach>
									</div>
								</td>

										</tr>
								</table>
							</div>

						</div>
					</td>

					<td width="5"></td>

					<td>

						<button type="submit" class="btn-gnral btn-prt">VER
							PORTAFOLIO SELECCIONADO</button>

					</td>

					<td width="100"></td>
					<td width="100"></td>
					<td width="100"></td>

				</tr>

			</table>
		</form>

	</section>




	<jsp:include page="../layaut/footer.jsp" />

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
<script>
       $('#lista-radio > input').each(function() {
    var radioInput = $(this);
    if(radioInput.is(':checked')) {
        $('#lista-radio').animate({
            scrollTop: radioInput.offset().top
        }, 2000);
    }
});
       </script>
</body>

</html>