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

.table-wrapper {
	width: 100%;
	height: 419px; /* Altura de ejemplo */
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
	position: -webkit-sticky; /* Safari... */
	position: sticky;
	top: -1;
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
}

.table-wrapper table thead th {
	border: 2px solid #acbece;
	background: #ffffff !important;
	color: #00529b !important;
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

.div-buscar {
	padding-top: 15px;
	margin-left: 15px;
	margin-bottom: 15px;
}

/***********SCROLL****************/
#info-tabulador {
	overflow: scroll;
	height: 406px;
	width: 100%;
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

.overlay {
	position: fixed;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	opacity: 0;
	transition: .3s ease;
	z-index: -1;
	background: #000;
}

.overlay.active {
	opacity: 0.5;
	z-index: 2;
}

.modal {
	background: #fff;
	max-height: calc(100% - 100px);
	position: fixed;
	top: 50%;
	left: 50%;
	width: 500px;
	transform: translate(-50%, -50%);
	visibility: hidden;
	opacity: 0;
	transition: .3s ease;
	color: #00529b !important;
	font-weight: 700 !important;
	font-size: 12px !important;
	font-family: 'Montserrat', sans-serif;
	text-align: center;
	border-radius: 5px;
}

.modal.active {
	visibility: visible;
	z-index: 2;
	opacity: 1;
}

.close {
	position: absolute;
	top: -10;
	right: -12;
	text-align: center;
	width: 24px;
	text-decoration: none;
	font-weight: bold;
	border-radius: 12px;
}
</style>
</head>
<body>

	<jsp:include page="../layaut/cargando.jsp" flush="true" />
	<jsp:include page="../layaut/header.jsp" />

	<section>

		<div class="div-buscar">
			<form method="POST" action="tabulador" id="form-tabulador">
				<label class="est-ele-archivo grey-obscuro">GESTIÓN DE
					PORTAFOLIOS: <c:out value="${portafolio}" />
				</label> <input type="hidden" name="portafolio" value="${portafolio}">
				<button type="submit" name="idPortafolio" value="${idPortafolio}"
					style="margin-left: 15px" class="btn-gnral btn-est">CONSULTAR</button>
				<input type="text" value="${msj}"
					Style="font-size: 10px; font-family: sans-serif; color: red; border: 0px; width: 500px; margin-left: 150px;"
					disabled="disabled" />

				<button type="button" class="open btn-gnral"
					style="margin-left: 30px">Indicadores de avance</button>
			</form>
		</div>

		<div class="overlay"></div>
		<div class="modal">
			<div class="modal-header">
				<button type="button" class="close btn-gnral" aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
				<h2>Indicadores de Avance</h2>
			</div>
			<table style="margin-bottom: 20px">
				<tr>
					<td><input type="text" value=""
						style="width: 50px; background: gray; border: 1px solid gray; margin-bottom: 10px"
						disabled="disabled" /></td>
					<td><input type="text"
						value="Existe intervención en el proyecto pero sin notificación de avance"
						style="border: 0px; width: 430px; background: white; margin-bottom: 10px"
						disabled="disabled" /></td>
				</tr>
				<tr>
					<td><input type="text" value=""
						style="width: 50px; background: green; border: 1px solid green; margin-bottom: 10px"
						disabled="disabled" /></td>
					<td><input type="text"
						value="Declara que se tiene avance terminado"
						style="border: 0px; width: 430px; background: white; margin-bottom: 10px"
						disabled="disabled" /></td>
				</tr>
				<tr>
					<td><input type="text" value=""
						style="width: 50px; background: lightgreen; border: 1px solid lightgreen; margin-bottom: 10px"
						disabled="disabled" /></td>
					<td><input type="text"
						value="Declara que se tiene avance satisfactorio"
						style="border: 0px; width: 430px; background: white; margin-bottom: 10px"
						disabled="disabled" /></td>
				</tr>
				<tr>
					<td><input type="text" value=""
						style="width: 50px; background: yellow; border: 1px solid yellow; margin-bottom: 10px"
						disabled="disabled" /></td>
					<td><input type="text"
						value="Declara que se tiene avance con retraso"
						style="border: 0px; width: 430px; background: white; margin-bottom: 10px"
						disabled="disabled" /></td>
				</tr>
				<tr>
					<td><input type="text" value=""
						style="width: 50px; background: red; border: 1px solid red; margin-bottom: 10px"
						disabled="disabled" /></td>
					<td><input type="text"
						value="Declara que se tiene avance con riesgo"
						style="border: 0px; width: 430px; background: white; margin-bottom: 10px"
						disabled="disabled" /></td>
				</tr>
			</table>

		</div>


		<div class="table-wrapper" id="info-tabulador">
			<table id="tabla" class="table1" style="width: 100%">
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
							<c:forEach items="${iniciativa.objetivos}" var="objetivo">
								<tr>
									<td width="200" rowspan="${objetivo.RS_OBJETIVO}"><c:out
											value="${objetivo.objetivo}"></c:out></td>
								</tr>

								<c:forEach items="${objetivo.accionesEstrategicas}" var="accion">
									<tr>
										<td width="200" rowspan="${accion.RS_ACCION}"><c:out
												value="${accion.accionEstrategica}"></c:out></td>
									</tr>
									<tr>
										<c:forEach items="${accion.proyectos}" var="proyecto">
											<tr>
												<td width="300"><c:choose>
														<c:when test="${proyecto.tituloBloque == true}">
															<div style="font-weight: bold; font-size: 12px">
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
												<!-- ------------------------------------ -->
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


												<!-- --------------------------------------- -->
											</tr>
										</c:forEach>
									</tr>
								</c:forEach>

								<%-- 								<c:forEach items="${obj.objetivos}" var="objetivos"> --%>
								<%-- <c:forEach items="${objetivo.accionesEstrategicas}"
										var="acciones">
										
									</c:forEach> --%>
								<%-- 								</c:forEach> --%>
							</c:forEach>



















							<%-- <tr>
								<td width="200"><c:out value="${obj.iniciativa.iniciativa}"></c:out></td>
								<td width="200"><c:out value="${obj.objetivo.objetivo}"></c:out></td>
								<td width="200"><c:out
										value="${obj.accionEstrategica.accionEstrategica}"></c:out></td>
								<td width="300"><c:choose>
										<c:when test="${obj.tituloBloque == true}">
											<div style="font-weight: bold;">
												<c:out value="${obj.proyecto}" />
											</div>
										</c:when>
										<c:otherwise>
											<div>
												<c:out value="${obj.proyecto}" />
											</div>
										</c:otherwise>
									</c:choose></td>
								<td width="90" style="text-align: right"><c:choose>
										<c:when test="${obj.presupuesto.id > 0}">
											<div>
												<c:out value="${obj.presupuesto.id}" />
											</div>
										</c:when>
										<c:otherwise>
											<div>
												<c:out value="" />
											</div>
										</c:otherwise>
									</c:choose></td>

								<td width="90" style="text-align: left"><c:choose>
										<c:when test="${obj.normativo == true}">
											<c:if test="${obj.tituloBloque == false}">
												<c:out value="SI" />
											</c:if>
										</c:when>
										<c:when test="${obj.normativo == false}">
											<c:if test="${obj.tituloBloque == false}">
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
										value="${obj.fechaRequerida}"></c:out></td>
								<td width="50" style="text-align: left"><c:out
										value="${obj.bp.cve}"></c:out></td>
								<td width="90" style="text-align: leftr"><c:out
										value="${obj.interventor.cve}"></c:out></td>
								<td width="90" style="text-align: right"><c:choose>
										<c:when test="${obj.costoPpto > 0}">
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
									<td width="70"><c:forEach items="${obj.periodos}"
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
							</tr> --%>
						</c:if>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</section>

	<jsp:include page="../layaut/footer.jsp" />

	<script src="js/gif-carga.js"></script>
	<script>
		$(function() {
			gif_carga();
		});

		$(".open").on("click", function() {
			$(".overlay, .modal").addClass("active");
		});

		$(".close, .overlay").on("click", function() {
			$(".overlay, .modal").removeClass("active");
		});
	</script>

</body>
</html>