<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="google" content="notranslate" />
<title>GPP</title>
<link rel="stylesheet" href="css/estilo-head-footer.css">

<link rel="stylesheet" href="css/estilos-gnrls.css">
<link rel="shortcut icon" href="<c:url value='/Imagenes/favicon.ico'/>">
<script src="https://kit.fontawesome.com/4fb8bc8279.js"></script>
<script src="js/jquery-1.12.1.min.js"></script>
<style>

.grey-obscuro {
	color: #6e6e6e;
}

.cargarep-titulo {
	font-size: 14px;
	font-family: sans-serif;
	background: #59ad40;
	height: 34px;
	line-height: 32px;
	text-align: center;
	
	font-weight: 600;
	color: white;
	border: 1px solid #59ad40;
	border-radius: 5px;
}

.boton {
	height: 30px;
	width: 280px
}

.est-etiq {
	font-size: 14px;
	font-family: sans-serif;
	text-align: left;

	font-weight: 500;

}

.est-res {
	font-size: 11px;
	font-family: sans-serif;
	text-align: left;

	font-weight: 500;

}


.est-radio {
	font-size: 14px;
	font-family: sans-serif;
	text-align: left;
	line-height: 28px;
	font-weight: 500;
}

	

.est-titulos {
	font-size: 14px;
	font-family: sans-serif;
	line-height: 25px;
	text-align: left;
	
	font-weight: 600;
	background-color: rgba(0, 0, 0, 0);
	border: 2px solid #6e6e6e;
	border-radius: 14px;
}

.tbl-upload {
	width: 520px;
	height: 320px;
}

.est-ele-archivo {
	font-size: 14px;
	font-family: sans-serif;
	font-weight: bold;
	padding-left: 6px;
}

.est-tam {
	width: 378px;
}

.ocultar {
	display: none
}

::-webkit-file-upload-button {
	font-family: 'Montserrat', sans-serif;
	color: #fff;
	background-color: #00529b;
	border-color: transparent;
	border-radius: .25rem;
}

textarea {
  resize: none;
}

#hide {
    display: none;
}


</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
<script>
       $('#radioContainer > input').each(function() {
    var radioInput = $(this);
    if(radioInput.is(':checked')) {
        $('#radioContainer').animate({
            scrollTop: radioInput.offset().top
        }, 2000);
    }
});
    </script>
</head>
<body>

	<jsp:include page="../layaut/cargando.jsp" flush="true" />
	<jsp:include page="../layaut/header.jsp" />

	<section>
		<form method="POST" action="uploadFile" enctype="multipart/form-data"
			id="form-multipart-upload">

			<table border="0" style="width: 100%;">
				<tr height="50px">
					<td width="20%"></td>
					<td colspan="5" style="text-align: center">
						<div class="cargarep-titulo">CARGA REPORTES DE AVANCES PARA PORTAFOLIOS.</div>
					</td>
					<td width="20%"></td>
				</tr>
				<tr>
					<td width="10%"></td>
					<td width="5%"></td>

					<td width="80px" ><img src="Imagenes/excel.png"
						width="100px" style="margin-left:-18px;"></td>

					<td align="left"  class="est-ele-archivo grey-obscuro">Elegir
						archivo: <input type="file" name="file"
						accept="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet">
					</td>

					<td></td>
					<td width="5%"></td>
					<td width="10%"></td>
				</tr>
				<tr height="10px">
				</tr>

				<tr>
					<td width="10%"></td>
					<td width="5%"></td>

					<td width="30%" colspan="2" align="center">
					<div class="tbl-upload est-titulos">
						<table border="0" style="width: 100%;">
							<tr height="50px">
								<td width="2px"></td>
								<td class="grey-obscuro">Seleccione la opción de carga de su interés:</td>
							</tr>
							<tr>
								<td colspan="2" >
									<input type="radio" id="hide" name="tipos" value="hide" checked="checked">
									<div id="radioContainer" style="display: block; overflow-y: auto; height: 260px;">
										<c:forEach var="i" begin="0" end="${tipos.size() - 1}">
										
											
		       										<input
													type="radio" id="${tipos.get(i).getId()}" name="tipos"
													value="${tipos.get(i).getId()}">
													 <label class="est-radio" for="${tipos.get(i).getId()}">${tipos.get(i).getDescripcion()}</label>
													<br>
											
										
										</c:forEach>
									</div>
								</td>
							</tr>
						</table>
					</div>
					</td>

					<td width="20%" align="left">
						<table border="0"
							style="height: 100%; margin-left: 10px;">
							<tr height="180px">
								<td></td>
							</tr>
							<tr height="50px">
								<td><input type="submit" class="boton btn-gnral"
									 value="CARGAR REPORTE"></td>
							</tr>

							<tr  height="25px">
								<td class="est-ele-archivo grey-obscuro">Resultados del proceso:</td>
							</tr>

							<tr>
								<td><textarea class="est-res grey-obscuro"  rows="3" disabled="disabled" draggable="false" readonly style="width: 97%">${mensaje}${error}</textarea>
								</td>
							</tr>
						</table>


					</td>
					<td width="5%"></td>
					<td width="10%"></td>
				</tr>

			</table>
		</form>
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