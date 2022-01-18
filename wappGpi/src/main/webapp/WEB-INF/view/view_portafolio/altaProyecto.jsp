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
<link rel="stylesheet" href="css/alta-proyecto.css">
<link rel="stylesheet" href="css/estilos-gnrls.css">
<script src="https://kit.fontawesome.com/4fb8bc8279.js"></script>
<script src="js/jquery-1.12.1.min.js"></script>
<script>
        
        history.pushState(null, null, location.href);
        window.onpopstate = function () {
            history.go(1);
        };
    </script>
</head>

<body>


	<jsp:include page="../layaut/header.jsp" />



	<section id="portafolio">

<form 	class="form-horizontal" id="altaProyecto">
		<table style="width: 95%" align="center">
			<tr>
				<td>


					<table style="width: 100%" class="estilo-tabla-principal">
						<tr>
							<td>
								<div id="tituloPortafolio">ALTA PLAN DE INVERSION</div>
							</td>

						</tr>
						
						
						<tr height="0px">
							<td>
								<div id="ttl-datosportafolio">DATOS PROYECTO</div>
								<div class="linea"></div>
							</td>

						</tr>
						
						<tr>
							<td>
								<table style="width: 100%">
									<tr height="30px">
										<td>DESCRIPCI&Oacute;N GENERAL:</td>
										<td>RECURSOS:</td>
									</tr>

									<tr height="0px">
										<td><textarea id="proydescripcion" onkeypress="return textoMayusculas(event,this, '1-proydescripcion')" name="proyDescripcion" class="largo-txt" rows="4" cols="50"></textarea>
										<div class="popup " ><span class="popuptext posicion-pop2" id="1-proydescripcion"></span> </div>
										</td>
										<td><textarea class="largo-txt" id="proyRecursos" onkeypress="return textoMayusculas(event,this, '2-proyRecursos')" name="proyRecursos" rows="4" cols="50"></textarea>
										<div class="popup " ><span class="popuptext posicion-pop2" id="2-proyRecursos"></span> </div></td>
									</tr>
								</table>
							</td>
						</tr>
						
						<tr>
							<td>
								<table style="width: 100%">
									<tr height="30px">
									    <td width="800">CLAVE PROYECTO:</td>
										<td width="800">BP:</td>
										<td width="800">COSTO PROYECTO:</td>
										<td width="800">FECHA REQUERIDA:</td>
										<td width="800">FECHA MAX. TERMINO:</td>
									</tr>

									<tr height="0px">
									<td><input type="text" id="proyclaveProyecto" value="${claveProyecto}" name="proyclaveProyecto" onkeypress="return textoMayusculas(event,this, '3-proyclaveProyecto')"	class="est-caja-txt largo-caja-txt" disabled >
									<div class="popup" ><span class="popuptext posicion-pop1" id="3-proyclaveProyecto"></span> </div>
									</td>
										<td><select	class="est-caja-txt largo-caja-txt alto-select" id="proyBP" name="proyBP">
															<c:forEach var="bp" items="${LBP}">
											                <option value="${bp.id}">${bp.nombre}</option>
										                   </c:forEach>
													</select></td>
										<td><input type="text"  name="proycosto" onkeypress="return textoMayusculas(event,this, '4-proycosto')" id="proycosto" class="est-caja-txt largo-caja-txt" >
										<div class="popup" ><span class="popuptext posicion-pop1" id="4-proycosto"></span> </div>
										</td>
										<td><input type="text"  name="proyfecha" id="proyfecha"	onkeypress="return textoMayusculas(event,this, '5-proyfecha')" class="est-caja-txt largo-caja-txt" >
											<div class="popup" ><span class="popuptext posicion-pop1" id="5-proyfecha"></span> </div>
											</td>
										<td><input type="text"  name="proyfechaMaxima" id="proyfechaMaxima"	onkeypress="return textoMayusculas(event,this, '6-proyfechaMaxima')" class="est-caja-txt largo-caja-txt" >
										 <div class="popup" ><span class="popuptext posicion-pop1" id="6-proyfechaMaxima"></span> </div>
										</td>

									</tr>
								</table>
							</td>
						</tr>
						
						<tr>
							<td>
								<table style="width: 100%">
									<tr height="30px">
										<td width="800">ESTATUS:</td>
										<td width="800">PORTAFOLIO:</td>
										<td width="800">CIRCUITO:</td>
									</tr>

									<tr height="0px">
										<td><select	class="est-caja-txt largo-caja-txt alto-select" id="proyestatus" name="proyestatus">
															<c:forEach var="estatus" items="${lestatus}">
											                <option value="${estatus.id}">${estatus.descripcion}</option>
										                   </c:forEach>
													</select></td>
										<td>
										<input type="text"  class="est-caja-txt largo-caja-txt" value="${descPortafolio}" disabled>
										<input type="hidden" name="proyportafolio" id="proyportafolio"  value="${idPortafolio}"></td>
										<td><select	class="est-caja-txt largo-caja-txt alto-select" name="proycircuito" id="proycircuito">
															<c:forEach var="circuitos" items="${lcircuitos}">
											                <option value="${circuitos.id}">${circuitos.circuito}</option>
										                   </c:forEach>
													</select></td>
										

									</tr>
								</table>
							</td>
						</tr>

						
						

						<tr>
							<td>
								<table style="width: 100%">
									<tr>
										<td>
											<table style="width: 100%">
												<tr height="30px">
													<td>INICIATIVA:</td>
												</tr>

												<tr>

													<td>
													<div class="select-style">
                                                     <select	class="est-caja-txt largo-caja-txt alto-select" id="proyiniciativa" name="proyiniciativa">
															<c:forEach var="iniciativas" items="${liniciativas}">
											                <option value="${iniciativas.id}">${iniciativas.iniciativa}</option>
										                   </c:forEach>
													</select>
                                                   </div>
													
													
													</td>


												</tr>
											</table>


										</td>

									</tr>
								</table>
							</td>
						</tr>

						<tr>
							<td>
								<table style="width: 100%">
									<tr>
										<td>
											<table style="width: 100%">
												<tr height="30px">
													<td>OBJETIVO:</td>
												</tr>

												<tr>

													<td><select	class="est-caja-txt largo-select alto-select" id="proyobjetivo"  name="proyobjetivo">
															<c:forEach var="objetivos" items="${lobjetivos}">
											                <option value="${objetivos.id}">${objetivos.objetivo}</option>
										                   </c:forEach>
													</select></td>


												</tr>
											</table>


										</td>

									</tr>
								</table>
							</td>
						</tr>

						<tr>
							<td>
								<table style="width: 100%">
									<tr>
										<td>
											<table style="width: 100%">
												<tr height="30px">
													<td>ACCIÓN:</td>
												</tr>

												<tr>

													<td><select	class="est-caja-txt largo-select alto-select" id="proyaccion" name="proyaccion">
															<c:forEach var="acciones" items="${lacciones}">
											                <option value="${acciones.id}">${acciones.descripcion}</option>
										                   </c:forEach>
													</select></td>


												</tr>
											</table>


										</td>

									</tr>
								</table>
							</td>
						</tr>

						<tr>
							<td>
								<table style="width: 100%">
									<tr>
										<td>
											<table style="width: 100%">
												<tr height="30px">
													<td>META:</td>
												</tr>

												<tr>

													<td><select	class="est-caja-txt largo-select alto-select" id="proymeta" name="proymeta">
															<c:forEach var="metas" items="${lmetas}">
											                <option value="${metas.id}">${metas.meta}</option>
										                   </c:forEach>
													</select></td>


												</tr>
											</table>


										</td>

									</tr>
								</table>
							</td>
						</tr>
						
						<tr>
							<td>
								<table style="width: 100%">
									<tr>
										<td>
											<table style="width: 100%">
												<tr height="30px">
													<td>COSTO:</td>
												</tr>

												<tr>

													<td><select	class="est-caja-txt largo-select alto-select" id="proycostos" name="proycostos">
															<c:forEach var="costos" items="${lcostos}">
											                <option value="${costos.id}">${costos.descripcion}</option>
										                   </c:forEach>
													</select></td>


												</tr>
											</table>


										</td>

									</tr>
								</table>
							</td>
						</tr>
						
						<tr>
							<td>
								<table style="width: 100%">
									<tr>
										<td>
											<table style="width: 100%">
												<tr height="30px">
													<td>TIPO GASTO:</td>
												</tr>

												<tr>

													<td><select	class="est-caja-txt largo-select alto-select" id="proygasto" name="proygasto">
															<c:forEach var="tipoGastos" items="${ltipoGastos}">
											                <option value="${tipoGastos.id}">${tipoGastos.descripcion}</option>
										                   </c:forEach>
													</select></td>


												</tr>
											</table>


										</td>

									</tr>
								</table>
							</td>
						</tr>
						
						<tr>
							<td>
								<table style="width: 100%">
									<tr>
										<td>
											<table style="width: 100%">
												<tr height="30px">
													<td>PRESUPUESTO:</td>
												</tr>

												<tr>

													<td><select	class="est-caja-txt largo-select alto-select" id="proypresupuesto" name="proypresupuesto">
															<c:forEach var="presupuestos" items="${lpresupuestos}">
											                <option value="${presupuestos.id}">${presupuestos.presupuesto}</option>
										                   </c:forEach>
													</select></td>

												</tr>
											</table>


										</td>

									</tr>
								</table>
							</td>
						</tr>
						<tr>
						<td><div id="msg-gneral" class="est-msg-general" ></div></td>
						</tr>

						<tr>
							<td>

								<table style="width: 100%">
									<tr height="0px">
										<td width="600"></td>
										<td width="600"></td>
										<td width="600"></td>
										<td width="600"></td>
										<td width="600"></td>
										<td width="600"></td>
										<td width="600"></td>
										<td width="50"></td>
										<td width="300"></td>
										<td width="300"></td>
										<td width="300"><button type="submit"
												class="btn-gnral btn-prt">CANCELAR</button></td>
										<td width="600"><button type="submit"
												class="btn-gnral btn-prt">GUARDAR</button>
												<input id="csrf-altaProyecto" type="hidden"
					                                    name="${_csrf.parameterName}" value="${_csrf.token}" />
												</td>
									</tr>
								</table>

							</td>

						</tr>


					</table>
		</table>
		
		</form>


		<table style="width: 95%" align="center">
			<tr height="50px">
				<td></td>
			</tr>
		</table>







	</section>




	<jsp:include page="../layaut/footer.jsp" />
	<script src="js/altaProyecto.js"></script>
	<script>
		$(function() {
			altaProyecto();
					
		});
	</script>
	


</body>

</html>