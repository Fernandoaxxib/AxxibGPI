<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
<script>
	function filtrar() {
		var busqueda = document.getElementById('buscar');
		var table = document.getElementById("tabla").tBodies[0];

		buscaTabla = function() {
			texto = busqueda.value.toLowerCase();
			var r = 0;
			while (row = table.rows[r++]) {
				if (row.innerText.toLowerCase().indexOf(texto) !== -1)
					row.style.display = null;
				else
					row.style.display = 'none';
			}
		}

		busqueda.addEventListener('keyup', buscaTabla);
	}
</script>
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
					<input type="text" value="${msj}" Style="font-size: 12px;font-family: sans-serif;color: red;border: 0px;width: 600px;margin-left: 150px;" disabled="disabled"/>
			</form>
		</div>


		<div class="div-buscar">
			<input id="buscar" type="text" placeholder="Escriba la búsqueda"
				style="width: 300px" onkeyup="filtrar()" />

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
							<th width="70"><c:out value="${columna}"></c:out></th>
						</c:forEach>
					</tr>
				</thead>
				<tbody>
				
					<c:forEach items="${portafol.listaReportes}" var="obj">
						<c:if test="${obj.iniciativa.id > 0}">
							<tr>
							<td width="200"><c:out value="${obj.iniciativa.iniciativa}"></c:out></td>
								<td width="200"><c:out value="${obj.objetivo.objetivo}"></c:out></td>
								<td width="200"><c:out
										value="${obj.accionEstrategica.accionEstrategica}"></c:out></td>
								<td width="300"><c:choose>
										<c:when test="${obj.tituloBloque == true}">
											<div style="background: yellow">
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
														<input type="text" value="" style="background: darkgrey;border: 1px solid darkgrey;width:60px !important;heigth:30px !important" disabled="disabled" >
													</c:when>
													<c:when test="${avance.indicadorAvance eq 1}">
														<input type="text" value="" style="background: green;border: 1px solid green;width:60px !important;heigth:30px !important" disabled="disabled" >
													</c:when>
													<c:when test="${avance.indicadorAvance eq 2}">														
														<input type="text" value="" style="background: lightgreen;border: 1px solid lightgreen;width:60px !important;heigth:30px !important" disabled="disabled" >
													</c:when>
													<c:when test="${avance.indicadorAvance eq 3}">
														<input type="text" value="" style="background: yellow;border: 1px solid yellow;width:60px !important;heigth:30px !important" disabled="disabled" >														
													</c:when>
													<c:when test="${avance.indicadorAvance eq 4}">
													    <input type="text" value="" style="background: red;border: 1px solid red;width:60px !important;heigth:30px !important" disabled="disabled" />														
													</c:when>
												</c:choose>
											</c:when>
										</c:choose>
									</c:forEach></td>
							</c:forEach>
							</tr>
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
	</script>

</body>
</html>