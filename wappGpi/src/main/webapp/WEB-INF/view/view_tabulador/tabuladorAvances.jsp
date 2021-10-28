<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="google" content="notranslate" />
<link rel="shortcut icon" href="<c:url value='/Imagenes/favicon.ico'/>">
<link rel="stylesheet" href="css/estilo-head-footer.css">
<link rel="stylesheet" href="css/estilos-gnrls.css">
<script src="https://kit.fontawesome.com/4fb8bc8279.js"></script>
<script src="js/jquery-1.12.1.min.js"></script>


<style>
.boton {
	background-color: white;
	border: gray 2px solid;
	border-radius: 10px;
	height: 30px;
	width: 280px
}

.cabecero {
	border: 1px solid blue;
}

.table-wrapper {
	width: 100%;
	height: 419px;
	overflow: auto;
}

.table-wrapper table {
	border-collapse: separate;
	border-spacing: 0;
	background: #ffffff !important;
	color: #00529b !important;
	font-weight: 500 !important;
	font-size: 11px !important;
	font-family: 'Montserrat', sans-serif;
	border: 1px solid #acbece;
	border-collapse: collapse;
	table-layout: fixed;
}

.table-wrapper table thead {
	position: -webkit-sticky;
	position: sticky;
	top: -1px;
	left: 0;
}

.table-wrapper table td {
	border: 1px solid #acbece;
	font-family: Montserrat, sans-serif !important;
	font-size: 11px;
	font-weight: 500;
	height: 50px;
	text-align: justify;
	padding: 4px 10px;
	color: #000000;
	height: 30px;
}

.table-wrapper table thead th {
	border: 1px solid #acbece;
	background: #00529b !important;
	color: #fff !important;
	font-weight: 700 !important;
	font-size: 12px !important;
	font-family: 'Montserrat', sans-serif;
	padding: 4px 4px;
}

.table-wrapper2 {
	width: 99%;
	height: 160px;
	overflow: auto;
	margin-top: 15px;
	margin-left: 10px;
}

.table-wrapper2 table {
	border-collapse: separate;
	border-spacing: 0;
	background: #ffffff !important;
	color: #00529b !important;
	font-weight: 500 !important;
	font-size: 11px !important;
	font-family: 'Montserrat', sans-serif;
	border: 1px solid #acbece;
	border-collapse: collapse;
	table-layout: fixed;
}

.table-wrapper2 table thead {
	position: -webkit-sticky;
	position: sticky;
	top: -1px;
	left: 0;
}

.table-wrapper2 table td {
	border: 1px solid #acbece;
	font-family: Montserrat, sans-serif !important;
	font-size: 11px;
	font-weight: 500;
	height: 50px;
	text-align: justify;
	padding: 4px 10px;
	color: #000000;
	height: 30px;
}

.table-wrapper2 table thead th {
	border: 1px solid #acbece;
	background: #00529b !important;
	color: #fff !important;
	font-weight: 700 !important;
	font-size: 12px !important;
	font-family: 'Montserrat', sans-serif;
	padding: 4px 4px;
}

.grey-obscuro {
	color: #6e6e6e;
}

.est-ele-archivo {
	font-size: 14px;
	font-family: sans-serif;
	font-weight: bold;
}

.div-header {
	margin-top: 10px;
	align-items: center;
	display: flex;
	height: 35px;
	justify-content: center;
	background: #59ad40;
	color: #fff;
	margin-bottom: 10px;
	margin-left: 10px;
	margin-right: 10px;
	font-size: 14px;
	font-weight: bold;
}

.div-botones {
	margin-bottom: 15px;
}
/***********SCROLL****************/
#info-tabulador {
	overflow: scroll;
	height: 300px;
	width: 99%;
	margin-left: 10px;
}

#info-tabulador::-webkit-scrollbar {
	width: 14px;
}

#info-tabulador::-webkit-scrollbar-track:vertical {
	background-color: #d6d6d6;
}

::-webkit-scrollbar-button {
	background-color: #007bff00;
}

#info-tabulador::-webkit-scrollbar-thumb {
	background-color: #00529b;
	height: 80px;
}

::-webkit-scrollbar-corner {
	background-color: #007bff00;
}

.ocultar {
	display: none
}

.modalIndicadores {
	display: none;
	position: fixed;
	z-index: 1;
	padding-top: 180px;
	left: 0;
	top: 0;
	width: 100%;
	height: 100%;
	overflow: auto;
	background-color: rgb(0, 0, 0);
	background-color: rgba(0, 0, 0, 0.4);
}

.modalIndicadores .modal-content {
	background-color: #fefefe;
	margin: auto;
	padding: 4px 17px;
	border: 1px solid lightgray;
	width: 37%;
}

.modalIndicadores .close-indicadores {
	color: #787878;
	float: right;
	font-size: 37px;
	font-weight: bold;
}

.modalIndicadores .close-indicadores:hover, .modalIndicadores .close-indicadores:focus
	{
	color: #aaaaaa;
	text-decoration: none;
	cursor: pointer;
}
</style>
</head>
<body>

	<jsp:include page="../layaut/cargando.jsp" flush="true" />
	<jsp:include page="../layaut/header.jsp" />

	<section>
		<div class="div-header">
			REPORTE AVANCE PORTAFOLIOS DE PROYECTOS:
			<c:out value="${idPortafolio}" />
		</div>

		<div class="div-botones">
			<form method="POST" action="tabulador" id="form-tabulador">
				<button type="submit" name="idPortafolio" value="${idPortafolio}"
					style="margin-left: 15px" class="btn-gnral btn-est">CONSULTAR</button>
				<input type="text" value="TOTAL DEL PORTAFOLIO: "
					style="border: 0; margin-left: 30px; font-weight: bold; font-size: 15px"
					disabled="disabled" />
				<button id="btn-indicadores-avance" type="button"
					class="open btn-gnral" style="margin-left: 500px">Indicadores
					de avance</button>
			</form>
		</div>
		<div>
			<input type="text" value="${msj}"
				Style="font-size: 10px; font-weight: bold; font-family: sans-serif; color: red; border: 0px; width: 500px; margin-left: 400px;"
				disabled="disabled" />
		</div>

		<div class="table-wrapper" id="info-tabulador">
			<table style="width: 100%">
				<thead>
					<tr>
						<th width="200">INICIATIVA</th>
						<th width="200">OBJETIVO</th>
						<th width="200">ACCIONES ESTRATÉGICAS</th>
						<th width="300">PROYECTOS</th>
						<th width="90">ID PRESUPUESTO</th>
						<th width="90">NORMATIVO</th>
						<th width="90">FECHA REQUERIDA</th>
						<th width="50">BP</th>
						<th width="90">RECURSOS</th>
						<th width="90">COSTOS</th>
						<c:forEach items="${portafol.columnas}" var="columna">
							<th width="70" style="font-size: 10px !important;"><c:out
									value="${columna}"></c:out></th>
						</c:forEach>
					</tr>
				</thead>
				<tbody>

					<c:forEach items="${portafol.iniciativas}" var="iniciativa">
						<c:if test="${iniciativa.id > 0}">
							<tr>
								<td width="200" rowspan="${iniciativa.RS_INICIATIVA}"><c:out
										value="${iniciativa.iniciativa}"></c:out></td>
							</tr>
							<c:forEach items="${iniciativa.objetivos}" var="objetivos">
								<tr>
									<td width="200" rowspan="${objetivos.RS_OBJETIVO}"><c:out
											value="${objetivos.objetivo}"></c:out></td>
								</tr>

								<c:forEach items="${objetivos.accionesEstrategicas}"
									var="accion">
									<tr>
										<td width="200" rowspan="${accion.RS_ACCION}"><c:out
												value="${accion.accionEstrategica}"></c:out></td>
									</tr>

									<c:forEach items="${accion.proyectos}" var="proyecto">
										<tr>
											<td width="300"><c:choose>
													<c:when test="${proyecto.tituloBloque == true}">
														<div style="font-weight: bold;">
															<c:out value="${proyecto.proyecto}" />
														</div>
													</c:when>
													<c:otherwise>
														<div>
															<c:out value="${proyecto.proyecto}" />
														</div>
													</c:otherwise>
												</c:choose></td>



											<td width="90" style="text-align: right"><c:choose>
													<c:when test="${proyecto.presupuesto.id > 0}">
														<div>
															<c:out value="${proyecto.presupuesto.id}" />
														</div>
													</c:when>
													<c:otherwise>
														<div>
															<c:out value="" />
														</div>
													</c:otherwise>
												</c:choose></td>
											<td width="90" style="text-align: left"><c:choose>
													<c:when test="${proyecto.normativo == true}">
														<c:if test="${proyecto.tituloBloque == false}">
															<c:out value="SI" />
														</c:if>
													</c:when>
													<c:when test="${proyecto.normativo == false}">
														<c:if test="${proyecto.tituloBloque == false}">
															<c:out value="NO" />
														</c:if>
													</c:when>
													<c:otherwise>
														<div>
															<c:out value="" />
														</div>
													</c:otherwise>
												</c:choose></td>
											<td width="90" style="text-align: right"><c:out
													value="${proyecto.fechaRequerida}"></c:out></td>
											<td width="50" style="text-align: left"><c:out
													value="${proyecto.bp.cve}"></c:out></td>
											<td width="90" style="text-align: leftr"><c:out
													value="${proyecto.interventor.cve}"></c:out></td>
											<td width="90" style="text-align: right"><c:choose>
													<c:when test="${proyecto.costoPpto > 0}">
														<fmt:formatNumber type="number" value="${obj.costoPpto}"
															pattern="$#,##0.00" />
													</c:when>
													<c:otherwise>
														<div>
															<c:out value="" />
														</div>
													</c:otherwise>
												</c:choose></td>
											<c:forEach items="${portafol.columnas}" var="columna">
												<td width="70"><c:forEach items="${proyecto.periodos}"
														var="avance">
														<c:choose>
															<c:when test="${avance.periodo eq columna}">
																<c:choose>
																	<c:when test="${avance.indicadorAvance eq 0}">
																		<input type="text" value=""
																			style="background: darkgrey; border: 1px solid darkgrey; width: 60px !important; heigth: 30px !important"
																			disabled="disabled">
																	</c:when>
																	<c:when test="${avance.indicadorAvance eq 1}">
																		<input type="text" value=""
																			style="background: green; border: 1px solid green; width: 60px !important; heigth: 30px !important"
																			disabled="disabled">
																	</c:when>
																	<c:when test="${avance.indicadorAvance eq 2}">
																		<input type="text" value=""
																			style="background: lightgreen; border: 1px solid lightgreen; width: 60px !important; heigth: 30px !important"
																			disabled="disabled">
																	</c:when>
																	<c:when test="${avance.indicadorAvance eq 3}">
																		<input type="text" value=""
																			style="background: yellow; border: 1px solid yellow; width: 60px !important; heigth: 30px !important"
																			disabled="disabled">
																	</c:when>
																	<c:when test="${avance.indicadorAvance eq 4}">
																		<input type="text" value=""
																			style="background: red; border: 1px solid red; width: 60px !important; heigth: 30px !important"
																			disabled="disabled" />
																	</c:when>
																</c:choose>
															</c:when>
														</c:choose>
													</c:forEach></td>
											</c:forEach>
										</tr>
									</c:forEach>
								</c:forEach>
							</c:forEach>
						</c:if>
					</c:forEach>
				</tbody>
			</table>
		</div>

		<div class="table-wrapper2">
			<table style="width: 90%">
				<thead>
					<tr>
						<th>ACCIONES ESTRATEGICAS</th>
						<th width="200">TOTAL</th>
					</tr>
				</thead>
				<tbody>

				</tbody>
			</table>
		</div>
	</section>

	<div id="modal-indicadores-avance" class="modalIndicadores">
		<div class="modal-content">
			<span class="close-indicadores">×</span>

			<h2>Indicadores de Avance</h2>

			<div class="contenido-indicadores">

				<table style="margin-bottom: 20px">
					<tr>
						<td><input type="text" value=""
							style="width: 50px; background: gray; border: 1px solid gray; margin-bottom: 10px; margin-left: 15px"
							disabled="disabled" /></td>
						<td><input type="text"
							value="Existe intervención en el proyecto pero sin notificación de avance"
							style="border: 0px; width: 430px; background: white; margin-bottom: 10px;"
							disabled="disabled" /></td>
					</tr>
					<tr>
						<td><input type="text" value=""
							style="width: 50px; background: green; border: 1px solid green; margin-bottom: 10px; margin-left: 15px"
							disabled="disabled" /></td>
						<td><input type="text"
							value="Declara que se tiene avance terminado"
							style="border: 0px; width: 430px; background: white; margin-bottom: 10px"
							disabled="disabled" /></td>
					</tr>
					<tr>
						<td><input type="text" value=""
							style="width: 50px; background: lightgreen; border: 1px solid lightgreen; margin-bottom: 10px; margin-left: 15px"
							disabled="disabled" /></td>
						<td><input type="text"
							value="Declara que se tiene avance satisfactorio"
							style="border: 0px; width: 430px; background: white; margin-bottom: 10px"
							disabled="disabled" /></td>
					</tr>
					<tr>
						<td><input type="text" value=""
							style="width: 50px; background: yellow; border: 1px solid yellow; margin-bottom: 10px; margin-left: 15px"
							disabled="disabled" /></td>
						<td><input type="text"
							value="Declara que se tiene avance con retraso"
							style="border: 0px; width: 430px; background: white; margin-bottom: 10px"
							disabled="disabled" /></td>
					</tr>
					<tr>
						<td><input type="text" value=""
							style="width: 50px; background: red; border: 1px solid red; margin-bottom: 10px; margin-left: 15px"
							disabled="disabled" /></td>
						<td><input type="text"
							value="Declara que se tiene avance con riesgo"
							style="border: 0px; width: 430px; background: white; margin-bottom: 10px"
							disabled="disabled" /></td>
					</tr>
				</table>
			</div>
		</div>
	</div>

	<jsp:include page="../layaut/footer.jsp" />

	<script src="js/gif-carga.js"></script>
	<script>
		if (document.getElementById("btn-indicadores-avance")) {
			var modalIndicadores = document
					.getElementById("modal-indicadores-avance");
			var btnIndicadores = document
					.getElementById("btn-indicadores-avance");
			var spanIndicadores = document
					.getElementsByClassName("close-indicadores")[0];

			btnIndicadores.onclick = function() {
				modalIndicadores.style.display = "block";
				body.style.position = "static";
				body.style.height = "100%";
				body.style.overflow = "hidden";
			}

			spanIndicadores.onclick = function() {
				modalIndicadores.style.display = "none";
				body.style.position = "inherit";
				body.style.height = "auto";
				body.style.overflow = "visible";
			}

		}
		$(function() {
			gif_carga();
		});
	</script>

</body>
</html>