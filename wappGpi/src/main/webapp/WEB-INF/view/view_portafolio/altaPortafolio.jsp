<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>

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
<link rel="stylesheet" href="css/alta-portafolio.css">
<link rel="stylesheet" href="css/estilos-gnrls.css">
<script src="https://kit.fontawesome.com/4fb8bc8279.js"></script>
<script src="js/jquery-1.12.1.min.js"></script>
<script src="js/jquery-2.2.4.min.js"></script>
</head>

<body>


	<jsp:include page="../layaut/header.jsp" />
	<jsp:include page="../layaut/cargando.jsp" flush="true" />



	<section id="portafolio">
	
	<form 	class="form-horizontal" id="altaPortafolio">

		<table style="width: 95%" align="center">
			<tr>
				<td>


					<table style="width: 100%" class="estilo-tabla-principal">
						<tr>
							<td>
								<div id="tituloPortafolio">AGREGAR PORTAFOLIO</div>
							</td>

						</tr>

						<tr>
							<td>
								<div id="ttl-datosportafolio">DATOS PORTAFOLIO</div>
								<div class="linea"></div>
							</td>

						</tr>

						<tr>
							<td>
								<table style="width: 100%">
									<tr>
										<td>
											<table style="width: 100%">
												<tr height="30px">
													<td width="800">CLAVE PORTAFOLIO:</td>
													<td width="800">ESTATUS:</td>
												</tr>

												<tr >
													<td><input type="text"  id="portClave" value="${clavePortafolio}"	class="est-caja-txt largo-caja-txt" disabled> 
													<div class="popup  " ><span class="popuptext posicion-pop" id="1-portClave"></span> </div>
													</td>
													<td>													
													<input type="text"	 value="INICIATIVA" class="est-caja-txt largo-caja-txt" disabled >													
												    <input id="portestatus" type="hidden" value="1" />
												    </td>

												</tr>
												<tr height="30px">
													<td width="800">BP INTERVENTOR:</td>
													<td width="800"></td>
												</tr>

												<tr >
													<td colspan="2">
													
													<input type="text" value ="<sec:authentication property="principal.username" />" id="portClaveBP" class="est-caja-txt largo-caja-txt" disabled>
													<div class="popup  " ><span class="popuptext posicion-pop" id="2-portClaveBP"></span> </div>
													</td>
													

												</tr>


											</table>


										</td>
										<td>
											<table style="width: 100%">
												<tr>
													<td>DESCRIPCI&Oacute;N:</td>
													<td></td>
												</tr>
												<tr height="60px">
													<td><textarea onkeypress="return textoMayusculas(event,this,'3-portDescripcion')" class="largo-txt" rows="4" cols="50" id="portDescripcion"></textarea>
													<div class="popup " ><span class="popuptext posicion-pop2" id="3-portDescripcion"></span> </div>
													</td>

												</tr>
											</table>
										</td>
									</tr>
								</table>


							</td>
						</tr>
						
						<tr height="0px">
							<td>
								<div id="ttl-datosportafolio">DATOS PLAN INVERSI&Oacute;N</div>
								<div class="linea"></div>
							</td>

						</tr>
						<tr>
							<td>
								<table style="width: 100%">
									<tr>
										<td>
											<table style="width: 100%">
												<tr height="30px">
													<td width="200">CLAVE PROYECTO:</td>
													<td width="500"><input type="text"	id="portClaveProy" value="${claveProyecto}" class="est-caja-txt largo-caja-txt" disabled>
													 <div class="popup " ><span class="popuptext posicion-pop" id="0-portClaveProy"></span> </div>
													</td>
													<td width="150">BP. PROYECTO:</td>
													<td width="800"><select	class="est-caja-txt largo-caja-txt alto-select" id="portBPProy" name="portBPProy">
															<c:forEach var="bp" items="${LBP}">
											                <option value="${bp.id}">${bp.nombre}</option>
										                   </c:forEach>
													</select></td>
													<td width="80">ESTATUS:</td>
													<td width="300"><input type="text"	 value="INICIATIVA" class="est-caja-txt largo-caja-txt" disabled>													
												    <input id="portEstatusProy" type="hidden" value="1" />
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
									<tr height="30px">
										
										<td width="800">COSTO PROYECTO:</td>
										<td width="800">PERIODO REQUERIDO:</td>
										<td width="800">PERIODO MAX. REQUERIDO:</td>										
										<td width="800">PRESUPUESTO:</td>
									</tr>

									<tr height="0px">										
										<td><input type="text" 	id="portCostoProy" onkeyup="format(this)" onchange="format(this)" onkeypress="return textoMayusculas(event,this,'1-portCostoProy')" class="est-caja-txt largo-caja-txt" >
										<div class="popup " ><span class="popuptext posicion-pop" id="1-portCostoProy"></span> </div>
										</td>
										<td><input type="text" 	id="portPeriodoProy" onkeyup="formatPeriodo(this)" onchange="formatPeriodo(this)"   class="est-caja-txt largo-caja-txt" maxlength="4" size="4" >
										<div class="popup " ><span class="popuptext posicion-pop" id="2-portPeriodoProy"></span> </div>
										</td>
										<td><input type="text"   id="portPeriodoMaxProy" onkeyup="formatPeriodoMax(this)" onchange="formatPeriodoMax(this)"  class="est-caja-txt largo-caja-txt" maxlength="4" size="4"  >
										<div class="popup " ><span class="popuptext posicion-pop" id="3-portPeriodoMaxProy"></span> </div>
										</td>
										<td><select	class="est-caja-txt largo-caja-txt alto-select" id="portPresupuesto" name="proypresupuesto">
															<c:forEach var="presupuestos" items="${lpresupuestos}">
											                <option value="${presupuestos.id}">${presupuestos.presupuesto}</option>
										                   </c:forEach>
													</select></td>

									</tr>
								</table>
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
										<td><textarea onkeypress="return textoMayusculas(event,this,'4-portDescripProy')" class="largo-txt" id="portDescripProy" rows="4" cols="50"></textarea>
										<div class="popup " ><span class="popuptext posicion-pop2" id="4-portDescripProy"></span> </div>
										</td>
										<td><textarea onkeypress="return textoMayusculas(event,this, '5-portRecProy')" class="largo-txt" id="portRecProy" rows="4" cols="50"></textarea>
										<div class="popup " ><span class="popuptext posicion-pop2" id="5-portRecProy"></span> </div>
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
													<td width="150">TIPO DE GASTO:</td>
													<td width="800"><select	class="est-caja-txt largo-caja-txt alto-select" id="portGasto" name="proygasto">
															<c:forEach var="tipoGastos" items="${ltipoGastos}">
											                <option value="${tipoGastos.id}">${tipoGastos.descripcion}</option>
										                   </c:forEach>
													</select></td>
													<td width="80">CIRCUITO:</td>
													<td width="800"><select	class="est-caja-txt largo-caja-txt alto-select" name="portCircuito" id="portCircuito">
															<c:forEach var="circuitos" items="${lcircuitos}">
											                <option value="${circuitos.id}">${circuitos.circuito}</option>
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
													<td>INICIATIVA:</td>
												</tr>

												<tr>

													<td><select	class="est-caja-txt largo-caja-txt alto-select" id="portIniciativa" name="portIniciativa">
															<c:forEach var="iniciativas" items="${liniciativas}">
											                <option value="${iniciativas.id}">${iniciativas.iniciativa}</option>
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
													<td>OBJETIVO:</td>
												</tr>

												<tr>

													<td><select	class=" largo-select alto-select" id="portObjetivo"  name="portObjetivo">
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
													<td>ACCI&Oacute;N:</td>
												</tr>

												<tr>

													<td><select	class="est-caja-txt largo-select alto-select" id="portAccion" name="portAccion">
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
													<td>COSTO:</td>
												</tr>

												<tr>

													<td><select	class="est-caja-txt largo-select alto-select" id="portCostosProy" name="portCostosProy">
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
													<td>META:</td>
												</tr>

												<tr>

													<td><select	class="est-caja-txt largo-select alto-select" id="portMeta" name="portMeta">
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
						<div id="msg-gneral" class="est-msg-general" ></div>
						</td>
						</tr>
						</table></td>
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
										<td width="300"></td>
										<td width="600">
										<button type="submit"
												class="btn-gnral btn-prt">GUARDAR</button>
												
												
												<input id="csrf-altaPortafolio" type="hidden"
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
	<script src="js/altaPortafolio.js"></script>
	<script>
		$(function() {
			altaPortafolio();
					
		});
	</script>


</body>

</html>