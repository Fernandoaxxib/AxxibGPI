<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="google" content="notranslate" />
<link rel="stylesheet" href="css/estilo-head-footer.css">
<link rel="stylesheet" href="css/estilos-gnrls.css">
<script src="https://kit.fontawesome.com/4fb8bc8279.js"></script>
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
	top: 0;
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
	border: 1px solid #acbece;
	background: #ffffff !important;
	color: #00529b !important;
	font-weight: 500 !important;
	font-size: 12px !important;
	font-family: 'Montserrat', sans-serif;
	padding: 4px 10px;
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
</style>
</head>
<body>
	<jsp:include page="../layaut/header.jsp" />

	<section>

		<div class="div-buscar">
			<form method="POST" action="tabulador">
				<label class="est-ele-archivo grey-obscuro">GESTIÓN DE
					PORTAFOLIOS: <c:out value="${portafolio}" />
				</label> <input type="hidden" name="portafolio" value="${portafolio}">
				<button type="submit" name="idPortafolio" value="${idPortafolio}"
					style="margin-left: 15px" class="btn-gnral btn-est">CONSULTAR</button>
			</form>
		</div>


		<div class="div-buscar">
			<input id="buscar" type="text" placeholder="Escriba la búsqueda"
				style="width: 300px" onkeyup="filtrar()" />

		</div>

		<div class="table-wrapper">
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
					<c:forEach items="${portafol.listaRegistros}" var="obj">
						<tr>
							<td width="200"><c:out value="${obj.iniciativa}"></c:out></td>
							<td width="200"><c:out value="${obj.objetivo}"></c:out></td>
							<td width="200"><c:out value="${obj.accionEstrategica}"></c:out></td>
							<td width="300"><c:choose>
									<c:when test="${obj.esTituloBloque > 0}">
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
									<c:when test="${obj.idPresupuesto > 0}">
										<div>
											<c:out value="${obj.idPresupuesto}" />
										</div>
									</c:when>
									<c:otherwise>
										<div>
											<c:out value="" />
										</div>
									</c:otherwise>
								</c:choose></td>

							<td width="90" style="text-align: left"><c:choose>
									<c:when test="${obj.esNormativo == 0}">
										<c:out value="SI" />
									</c:when>
									<c:when test="${obj.esNormativo == 1}">
										<c:out value="NO" />
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
									value="${obj.cveBp}"></c:out></td>
							<td width="90" style="text-align: leftr"><c:out
									value="${obj.cvesRecursos}"></c:out></td>
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
								<td width="70"><c:forEach items="${obj.periodoAvance}"
										var="avance">
										<c:choose>
											<c:when test="${avance.periodo eq columna}">
												<c:choose>
													<c:when test="${avance.identificador == 0}">
														<input type="text" value="" style="background: darkgrey;border: 1px solid darkgrey;max-width:70px !important" disabled="disabled" >
													</c:when>
													<c:when test="${avance.identificador == 1}">
														<input type="text" value="" style="background: green;border: 1px solid green;max-width:70px !important" disabled="disabled" >
													</c:when>
													<c:when test="${avance.identificador == 2}">														
														<input type="text" value="" style="background: lightgreen;border: 1px solid lightgreen;max-width:70px !important" disabled="disabled" >
													</c:when>
													<c:when test="${avance.identificador == 3}">
														<input type="text" value="" style="background: yellow;border: 1px solid yellow;max-width:70px !important" disabled="disabled" >														
													</c:when>
													<c:when test="${avance.identificador == 4}">
													    <input type="text" value="" style="background: red;border: 1px solid red;max-width:70px !important" disabled="disabled" />														
													</c:when>
												</c:choose>
											</c:when>
										</c:choose>
									</c:forEach></td>
							</c:forEach>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</section>

	<jsp:include page="../layaut/footer.jsp" />

</body>
</html>