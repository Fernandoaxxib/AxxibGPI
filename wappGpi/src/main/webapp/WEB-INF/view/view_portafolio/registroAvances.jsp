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
<link rel="stylesheet" href="css/registro-avances.css">
<link rel="stylesheet" href="css/estilos-gnrls.css">
<script src="https://kit.fontawesome.com/4fb8bc8279.js"></script>
<script src="js/jquery-1.12.1.min.js"></script>

</head>

<body>


	<jsp:include page="../layaut/header.jsp" />



	<section id="portafolio">

		<table style="width: 95%" align="center">
			<tr>
				<td><table style="width: 100%">
						<tr>
							<td>
								<table style="width: 100%" class="estilo-tabla-principal">
									<tr>
										<td><div id="tituloPortafolio">PORTAFOLIOS</div></td>
									</tr>
									<tr>
										<td>

											<div id="lista-portafolios" class="tableFixHead altoTabla">
												<table id="tbl-registro-portafolio" style="width: 100%"
													class="table  est-tabla-1 ">
													<thead>
														<tr>
															<th width="150">CLAVE:</th>
															<th width="450">DESCRIPCIÓN:</th>
															<th width="250">BP INTERVENTOR:</th>
														</tr>
													</thead>
													<tbody>
														<c:forEach var="portafolios" items="${lportafolios}"
															varStatus="porIndx">

															<tr>
																<td>
																	<button
																		onclick="filtraTablaPortafolio(${portafolios.id}, '${portafolios.clavePortafolio}');"
																		class="button button-tabla blue letra-btn">
																		${portafolios.clavePortafolio}</button>
																</td>
																<td>${portafolios.descripcion}</td>
																<td>${portafolios.claveBP}</td>
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
						<tr>
							<td><table style="width: 100%"
									class="estilo-tabla-principal">
									<tr>
										<td><div id="tituloPortafolio">PLANES INVERSIÓN</div></td>
									</tr>

									<tr>
										<td>
											<table style="width: 100%">
												<tr height="20px">
													<td width="100" align="left"><div
															id="portafolioSelect" class="letra-btn blue ocultar">PORTAFOLIO:</div></td>
													<td width="100" align="left"><div
															id="nombrePortafolio" class="letra-btn blue ocultar"></div></td>
													<td width="100" align="left"></td>
													<td width="100" align="left"></td>
													<td width="100" align="left"></td>
													<td width="100" align="left"></td>


												</tr>
											</table>

										</td>
									</tr>

									<tr>
										<td>

											<div id="lista-planes" class="tableFixHead  altoTabla">

												<table id="tbl-planes" style="width: 100%"
													class="est-tabla-1  ">
													<thead>
														<tr>
															<th width="30" class="ocultar"></th>
															<th width="200">CLAVE PROYECTO:</th>
															<th width="300">DESCRIPCIÓN PROYECTO:</th>
															<th width="200">COSTO PROYECTO:</th>
														</tr>
													</thead>
													<tbody id="body-proyectos" class="ocultar-tabla">
														<c:forEach var="planes" items="${lplanes}"
															varStatus="porIndx">
															<tr>

																<td class="ocultar">${planes.portafolio.id}</td>
																<td><button
																		onclick="filtraTablaProyectos(${planes.id}, '${planes.claveProyecto}');"
																		class="button button-tabla blue letra-btn">
																		${planes.claveProyecto}</button></td>
																<td>${planes.descripcion}</td>
																<td align="right">$ ${ planes.costoProyecto}.00</td>
															</tr>
														</c:forEach>
													</tbody>
												</table>
											</div>
										</td>
									</tr>
								</table></td>
						</tr>
					</table></td>
				<td>
				<td><table style="width: 100%" class="estilo-tabla-principal">
						<tr>
							<td><div id="tituloPortafolio">REGISTRO HISTORICOS</div></td>
						</tr>

						<tr>
							<td>
								<table style="width: 100%">
									<tr height="20px">
										<td width="100" align="left"><div
												id="portafolioSelectProyecto"
												class="letra-btn blue ocultar-Proyecto">PROYECTO:</div></td>
										<td width="100" align="left"><div
												id="nombrePortafolioProyecto"
												class="letra-btn blue ocultar-Proyecto"></div></td>
										<td width="100" align="left"></td>
										<td width="200" align="right">
										<button id="btn-registro-avance" onclick="limpiaVariables();"  class="button btn-gnral btn-prt" >REGISTRAR AVANCE</button>
										</td>
									</tr>
								</table>
							</td>
						</tr>

						<tr>
							<td>

								<div id="lista-historicos"
									class="tableFixHead altoTablaHistorico">
									<table id="tbl-registro-hitoricos" style="width: 100%"
										class=" est-tabla-1 ">
										<thead>
											<tr>
												<th width="100">% AVANCE:</th>
												<th width="200">FECHA REGISTRO:</th>
												<th width="100">INDICADOR:</th>
												<th width="400">OBSERVACIONES:</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td>30%</td>
												<td>28/12/2021</td>
												<td></td>
												<td>ESTAS OBSERVACIONES SON NUEVAS DENTORO DE ESTA
													SOLICITUDKNF DFKASDL</td>
											</tr>
										</tbody>
									</table>
								</div>

							</td>
						</tr>
					</table></td>
			</tr>


		</table>

		<div id="modal-registrar-avances" class="modal-registro-avances">
			<table style="width: 55%" align="center" class="tbl-mod-reg-avance">
				<tr>
					<td>
						<div id="registro-avance">
							<table style="width: 100%">
								<tr height="20px">
									<td width="200" align="left"><div>REGISTRO
											HISTORICOS</div></td>
									<td width="50" align="right"><span
										class="cerrar-RegistroAvance">×</span></td>
								</tr>
							</table>
						</div>
					</td>
				</tr>

				<tr>
					<td>
						<table style="width: 100%" class="tbl-mod-reg-avance-body">
							<tr height="50px">
								<td>FECHA AVANCE:</td>
								<td><input type="text" id="fechaAvance"
									class="est-caja-txt largo-caja-txt" disabled></td>
								<td>INDICADOR:</td>
								<td>
									<div class="dropdown">
                                    <button id="btn-indicador" onclick="myFunction(); " class="dropbtn btn-drop"></button>
                                    <div id="myDropdown" class="dropdown-content">
                                    <a class="g1-back point" onclick=" indicador(1);" ></a>
                                    <a class="g2-back point" onclick=" indicador(2);"></a>
                                    <a class="g3-back point" onclick=" indicador(3);" ></a>
                                    <a class="g4-back point" onclick=" indicador(4);"></a>
                                   </div>
                                   </div>

								</td>
							</tr>
							<tr height="50px">
								<td>AVANCE ANTERIOR:</td>
								<td><input type="text" id="fechaAvance"
									class="est-caja-txt largo-caja-txt" disabled></td>
								<td>AVANCE ACTUAL:</td>
								<td><input type="text" id="indicador"
									class="est-caja-txt largo-caja-txt" disabled></td>
							</tr>
							<tr height="100px">
								<td>OBSERVACIONES:</td>
								<td><textarea
										onkeypress="return textoMayusculas(event,this,'3-portDescripcion')"
										class="largo-txt" rows="4" cols="50" id="portDescripcion"></textarea></td>

								<td colspan="2">
									<table style="width: 100%">
										<tr>
											<td align="center">
												<button
													class="btn-gnral-red btn-cerrar  cerrar-btn-cancelar">CANCELAR</button>
											</td>
											<td align="center">
												<form>
													<button class="btn-gnral  btn-guardar   ">GUARDAR</button>
												</form>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>

					</td>
				</tr>
			</table>
		</div>



	</section>




	<jsp:include page="../layaut/footer.jsp" />
	<script src="js/registroAvances.js"></script>
	<script>
	
	</script>
	
</body>

</html>