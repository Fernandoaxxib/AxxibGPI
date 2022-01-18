<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="google" content="notranslate" />
<title>GPP</title>
<link rel="stylesheet" href="css/estilo-head-footer.css">
<link rel="shortcut icon" href="<c:url value='/Imagenes/favicon.ico'/>">
<link rel="stylesheet" href="css/estilo-portafolio.css">
<link rel="stylesheet" href="css/estilos-gnrls.css">

<script src="https://kit.fontawesome.com/4fb8bc8279.js"></script>
<script src="js/jquery-3.5.1.min.js"></script>
<script src="js/jquery-2.2.4.min.js"></script>
<script src="js/jquery-1.12.1.min.js"></script>
<script>
               
        history.pushState(null, null, location.href);
        window.onpopstate = function () {
            history.go(0);
        };
    </script>

</head>

<body>


	<jsp:include page="../layaut/header.jsp" />



	<section>

		<table style="width: 93%" align="center">
			<tr height="260px">
				<td>
					<table style="width: 100%" class="estilo-tabla-principal">
						<tr>
							<td>
								<div id="tituloPortafolio">PORTAFOLIOS</div>
							</td>


						</tr>

						<tr height="40px">
							<td>
								<table style="width: 100%" >

									<tr>
										<td width="700"></td>
										<td width="900"></td>
										<td width="900"></td>
										<td width="700"></td>
										<td width="700"></td>
										<td width="800"></td>
										<td width="800"></td>
										<td width="800" align="right">											
											<a class=" btn-gnral btn-gnera-href " href="<c:url value="portafolios"/>">
											<span> <i class="fas fa-plus-square"></i>
											</span>AGREGAR PLAN INVERSIÓN</a> 
												
										</td>
									</tr>


								</table>

							</td>

						</tr>


						<tr>
							<td>
								<div id="lista-portafolios"	class="tableFixHead" >
									<table id="tbl-registro-portafolio" style="width: 100%"
										class="table  est-tabla-1 ">
										<thead>
											<tr>
												<th width="150">CLAVE:</th>
												<th width="450">DESCRIPCIÓN:</th>
												<th width="150">ESTATUS:</th>
												<th width="250">BP INTERVENTOR:</th>
												<th width="75"></th>
												<th width="75"></th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="portafolios" items="${lportafolios}" varStatus="porIndx">	
											
											<tr>
												<td > <button onclick="filtraTablaProyectos(${portafolios.id},'${portafolios.clavePortafolio}','${portafolios.descripcion}');" class="button button-tabla blue letra-btn">
												    ${portafolios.clavePortafolio}</button> </td>
												<td >${portafolios.descripcion}</td>
												<td >${portafolios.estatus.descripcion}</td>
												<td >${portafolios.claveBP}</td>
												<td align="center" ><button type="button"
														class="button btn-gnral-icono btn-prt">
														<span> <i class="fas fa-eye"></i>
														</span>
													</button></td>
												<td align="center"><button type="button"
														class="button btn-gnral-icono btn-prt">
														<span> <i class="fas fa-minus-circle"></i>
														</span>
													</button></td>
											</tr>
											
											</c:forEach>
											
										</tbody>

									</table>
								</div>

							</td>

						</tr>


					</table>
				</td>
			</tr>


		</table>

		<table style="width: 93%" align="center">
			<tr height="250px">
				<td>
					<table style="width: 100%" class="estilo-tabla-principal">
						<tr>
							<td>
								<div id="tituloPortafolio">PLANES DE INVERSIÓN</div>
							</td>


						</tr>

						<tr height="40px">
							<td width="900">
								<table style="width: 100%">
									<tr height="20px">
										<td width="200" align="right"><div id="portafolioSelect" class="letra-btn blue ocultar-componentes" >PORTAFOLIO:</div></td>
										<td width="900" align="left"><div id="nombrePortafolio" class="letra-btn blue ocultar-componentes" ></div></td>
										<td width="900"></td>										
										<td width="900"></td>
										<td width="900"></td>
										<td width="300"></td>
										<td width="300"></td>
										<td width="900" align="center">
										<form action="altaproyectos" method="post"
												class="form-horizontal">
										<input type="hidden" name="proyDescripcion" id="proyDescripcion"> 
										<input type="hidden" name="proyId" id="proyId"> 
										<button type="submit" id="btn-agregar-proyecto"
												class="button btn-gnral btn-prt" disabled>
												<span> <i class="fas fa-plus-square"></i>
												</span> AGREGAR PROYECTO
											</button>
											</form>
											</td>
										<td width="300" align="center"><button type="button"
												class="button btn-gnral btn-prt">
												<span> <i class="fas fa-check"></i> PROBAR
												</span>
											</button></td>
										<td width="300" align="center"><button type="button"
												class="button btn-gnral btn-prt">
												<span> <i class="fas fa-times"></i>
												</span> CANCELAR
											</button></td>
									</tr>
								</table>
							</td>
						 </tr>
						<tr>
							<td>
							 <div id="lista-planes"	class="tableFixHead">

								<table id="tbl-planes" style="width: 100%" class="est-tabla-1  ">
									<thead>
										<tr>
											<th width="30"></th>
											<th width="30" class="ocultar"></th>
											<th width="120">CLAVE PROYECTO:</th>
											<th width="300">DESCRIPCIÓN PROYECTO:</th>
											<th width="150">PERIODO REQUERIDO:</th>
											<th width="200">PERIODO MAX. REQUERIDO:</th>
											<th width="110">COSTO PROYECTO:</th>
											<th width="50"></th>
										</tr>
									</thead>
									<tbody id="body-proyectos" class="ocultar-tabla">
									<c:forEach var="planes" items="${lplanes}" varStatus="porIndx">	
										<tr>
											<td align="center" ><input type="checkbox" id="vehicle1" name="vehicle1"
												value="Bike"></td>
											<td class="ocultar">${planes.portafolio.id}</td>
											<td >${planes.claveProyecto}</td>
											<td >${planes.descripcion}</td>
											<td >${planes.fechaRequerida}</td>
											<td >${planes.fechaMaxTermino}</td>
											<td  align="right" >$ ${ planes.costoProyecto}.00</td>
											<td align="center" ><button type="button"
													class="button btn-gnral-icono btn-prt">
													<span> <i class="fas fa-pen"></i>
													</span>
												</button></td>
										</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</section>
	
	<jsp:include page="../layaut/footer.jsp" />
	<script src="js/portafolios.js"></script>
	

</body>

</html>