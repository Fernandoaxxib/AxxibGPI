<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="google" content="notranslate" />
<title>GPP</title>
<link rel="stylesheet" href="css/estilo-head-footer.css">
<link rel="stylesheet" href="css/estilo-home.css">
<link rel="stylesheet" href="css/estilos-gnrls.css">
<script src="https://kit.fontawesome.com/4fb8bc8279.js"></script>
</head>

<body>


	<jsp:include page="../layaut/header.jsp" />



	<section id="home">

		<table id="tabla-gnral">
			<tr height="100px">
				<td colspan="3">
					<div id="nav">
						<div class="cargarep-est-btn">
							<a class="grey" href="<c:url value="/carga"/>"> CARGA DE
								REPORTES DE AVANCE </a> <span class=" grey reporte-icon"><i
								class="far fa-file-alt"></i></span>
						</div>
					</div>
				</td>
			</tr>
			<tr>
				<td ></td>
				<td class="tbla-whit-center">
					<div class="tbl-btn-gnral est-titulos">
						<table id="tbl-gnral-btones">
							<tr>
								<td width="200px" align="center" rowspan="6">
									<div class="img-left">
										<div class="cargarep-est-btn txt-estilo">
											<span class=" grey portafolio-icon"><i
												class="fas fa-chart-line"></i></span><br> GESTIÓN DE
											PORTAFOLIOS
										</div>
									</div>
								</td>
							</tr>							
							<tr >
								<td align="left"><button type="button"
										class="btn-gnral btn-est">BP OPERACIONES</button></td>
							</tr>
							<tr >
								<td align="left"><button type="button"
										class="btn-gnral btn-est">BP INVERSIONES</button></td>
							</tr>
							<tr >
								<td align="left"><button type="button"
										class="btn-gnral btn-est">BP COMERCIAL</button></td>
							</tr>
							<tr >
								<td align="left"><button type="button"
										class="btn-gnral btn-est">BP ADMINISTRACIÓN Y
										FINANZAS</button></td>
							</tr>
							<tr >
								<td></td>
							</tr>
						</table>

					</div>
				</td>
				<td ></td>
			</tr>
			

		</table>

	</section>




	<jsp:include page="../layaut/footer.jsp" />


</body>

</html>