<html>
<head>
<style>
table {
	border: gray 1px solid;
	border-radius: 10px;
	background-color: #f2f2f2;
}

.boton {
	background-color: white;
	border: gray 2px solid;
	border-radius: 10px;
	height: 30px;
	width: 280px
}
</style>
</head>
<body>
	<table width="100%">
		<tr height="100px">
			<td colspan="3">CARGA REPORTES DE AVANCE PARA PORTAFOLIOS.</td>
		</tr>
		<tr>
			<td width="30%"></td>
			<td width="40%">
				<form method="POST" action="uploadFile"
					enctype="multipart/form-data">
					<table width="100%">
						<tr height="50px">
							<td align="center" colspan="2">Elegir archivo: <input
								type="file" name="file">
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
							<td align="left"><input type="submit" class="boton" 
								value="Reporte BP Operaciones"></td>
						</tr>
						<tr height="50px">
							<td align="left"><input type="submit" class="boton"
								value="Reporte BP Inversiones"></td>
						</tr>
						<tr height="50px">
							<td align="left"><input type="submit" class="boton"
								value="Reporte BP Comercial"></td>
						</tr>
						<tr height="50px">
							<td align="left"><input type="submit" class="boton"
								value="Reporte BP Administración y Finanzas"></td>
						</tr>
						<tr height="20px">
							<td></td>
						</tr>
					</table>
				</form>
			</td>
			<td width="30%"></td>
		</tr>
		<tr height="100px">
			<td colspan="3" align="center">${mensaje}</td>
		</tr>
	</table>
</body>
</html>