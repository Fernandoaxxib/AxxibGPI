<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="google" content="notranslate" />
<title>GPP</title>
<link rel="stylesheet" href="css/estilo-head-footer.css">
<link rel="stylesheet" href="css/estilos-gnrls.css">
<script src="https://kit.fontawesome.com/4fb8bc8279.js"></script>
<script src="js/jquery-1.12.1.min.js"></script>
<style>

/*table {
	/*border: gray 1px solid;
	border-radius: 10px;
	background-color: #f2f2f2;
}
*/
.grey-obscuro{
	color: #6e6e6e;
}

 .cargarep-titulo {
    font-size: 14px;
    font-family: sans-serif;
    background: #e9e9e9;
    width: 293px;
    height: 34px;
    line-height: 32px;
    text-align: center;
    margin-left: 48px;
    font-weight: 600;
    color: #00529b ;    
    background-color: rgba(0, 0, 0, 0);
    border: 1px solid #00529b;
}

.boton {
	height: 30px;
	width: 280px
}

.est-titulos {
	 font-size: 14px;
    font-family: sans-serif;
    line-height: 32px;
    text-align: center;
    margin-left: 48px;
    font-weight: 600;  
    background-color: rgba(0, 0, 0, 0);
    border: 2px solid #6e6e6e;
    border-radius: 14px;
}

.tbl-upload {
	width: 520px;
	height: 258px;
}

.est-ele-archivo {
	font-size: 14px;
	font-family: sans-serif;
}

.est-tam {
	width: 378px;
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
		<table width="100%">
			<tr height="100px">
				<td colspan="3">
					<div class="cargarep-titulo est-tam">CARGA REPORTES DE AVANCE
						PARA PORTAFOLIOS.</div>
				</td>
			</tr>
			<tr height="20px">
				<td >
					
				</td>
			</tr>
			<tr>
				<td width="30%"></td>
				<td width="40%">
					<div class="tbl-upload est-titulos">
						<form method="POST" action="uploadFile"
							enctype="multipart/form-data" id="form-multipart-upload">
							<table width="100%">
								<tr height="50px">
									<td align="center" colspan="2" class="est-ele-archivo grey-obscuro">
										Elegir archivo: <input type="file" name="file">
									</td>
								</tr>
								<tr>
									<td width="200px" align="center" rowspan="6"><img
										src="Imagenes/excel.png" width="150px"></td>
								</tr>
								<tr height="10px">
									<td></td>
								</tr>
								<tr height="45px">
									<td align="left"><input type="submit"
										class="boton btn-gnral" name="action"
										value="REPORTE BP OPERACIONES"></td>
								</tr>
								<tr height="45px">
									<td align="left"><input type="submit"
										class="boton btn-gnral" name="action"
										value="REPORTE BP INVERSIONES"></td>
								</tr>
								<tr height="45px">
									<td align="left"><input type="submit"
										class="boton btn-gnral" name="action"
										value="REPORTE BP COMERCIAL"></td>
								</tr>
								<tr height="45px">
									<td align="left"><input type="submit"
										class="boton btn-gnral" name="action"
										value="REPORTE BP ADMON. Y FINANZAS"></td>
								</tr>
								<tr height="20px">
									<td></td>
								</tr>
							</table>

						</form>
					</div>
				</td>
				<td width="30%"></td>
			</tr>
			<tr height="100px">
				<td colspan="3" align="center">
					<div style="margin-left: 48px">
						<p style="color: green">${mensaje}</p>
						<p style="color: red">${error}</p>
					</div>
				</td>
			</tr>
		</table>

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