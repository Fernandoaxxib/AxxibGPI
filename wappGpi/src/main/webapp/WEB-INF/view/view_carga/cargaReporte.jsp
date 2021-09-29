<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="google" content="notranslate" />
<link rel="stylesheet" href="css/estilo-head-footer.css">
<link rel="stylesheet" href="css/estilos-gnrls.css">
<script src="https://kit.fontawesome.com/4fb8bc8279.js"></script>
<style>


/*table {
	/*border: gray 1px solid;
	border-radius: 10px;
	background-color: #f2f2f2;
}
*/
.boton {	
	height: 30px;
	width: 280px
}

.est-titulos {
    font-size: 14px;
    font-family: sans-serif;
    background: #e9e9e9;
    line-height: 32px;
    text-align: center;
    margin-left: 48px;
    border: 5px solid #d1d1d1;
    font-weight: 600;
    color: grey;
    
}

.tbl-upload{
 width: 520px;
}

.est-ele-archivo{
   font-size: 14px;
    font-family: sans-serif;
}
.est-tam{
  width: 378px;

}

</style>
</head>
<body>

<jsp:include page="../layaut/header.jsp" />

<section >
	<table width="100%">
		<tr height="100px">
			<td colspan="3">
			<div class="est-titulos est-tam">
			   CARGA REPORTES DE AVANCE PARA PORTAFOLIOS.
			</div>
			</td>
		</tr>
		<tr>
			<td width="30%"></td>
			<td width="40%">
			<div  class="tbl-upload est-titulos">
				<form method="POST" action="uploadFile"
					enctype="multipart/form-data">
					<table width="100%">
						<tr height="50px">
							<td align="center" colspan="2" class="est-ele-archivo"> Elegir archivo: <input
								type="file"  name="file">
							</td>
						</tr>
						<tr>
							<td width="200px" align="center" rowspan="6"><img
								src="Imagenes/excel.png" width="150px"></td>
						</tr>
						<tr height="10px">
							<td></td>
						</tr>
						<tr height="50px">
							<td align="left"><input type="submit" class="boton btn-gnral" name="action"
								value="Reporte BP Operaciones"></td>
						</tr>
						<tr height="50px">
							<td align="left"><input type="submit" class="boton btn-gnral" name="action"
								value="Reporte BP Inversiones"></td>
						</tr>
						<tr height="50px">
							<td align="left"><input type="submit" class="boton btn-gnral" name="action"
								value="Reporte BP Comercial"></td>
						</tr>
						<tr height="50px">
							<td align="left"><input type="submit" class="boton btn-gnral" name="action"
								value="Reporte BP Administración y Finanzas"></td>
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
			<td colspan="3" align="center">${mensaje}</td>
		</tr>
	</table>
	</section>
	
	<jsp:include page="../layaut/footer.jsp" />
	
</body>
</html>