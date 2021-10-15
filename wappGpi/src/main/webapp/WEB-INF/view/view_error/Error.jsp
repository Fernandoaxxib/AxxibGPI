<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="google" content="notranslate" />
<link rel="stylesheet" href="css/estilo-head-footer.css">
<link rel="stylesheet" href="css/estilos-gnrls.css">
<link rel="shortcut icon" href="<c:url value='/Imagenes/favicon.ico'/>">
<script src="https://kit.fontawesome.com/4fb8bc8279.js"></script>
<title>GPP</title>
</head>

<body>

	<jsp:include page="../layaut/header.jsp" />

	<section>

		<table id="tabla-gnral">
		<tr>
				<td height="40px" align="center">				
				</td>
				
							
				
			</tr>
			<tr>
				<td width="400px" align="center">				
				</td>
				
				<td width="200px" align="center">				
				
				<div  class="estiloImg-centro" >     
                                       <img  class="img-error"  src="<%=request.getContextPath()%>/Imagenes/logo-hex.png" >        
                                 </div>
				</td>
				<td align="center">				
				</td>
			</tr>
			<tr>
				
				
                <td  width="400px" class="tbla-whit-center"></td>
                <td  width="200px" class="tbla-whit-center"> <div  class="est-msg-error" >
                               <h3 >${errorMsg}</h3>
                           </div></td>
                <td class="tbla-whit-center"></td>

			</tr>



		</table>





	</section>
	<jsp:include page="../layaut/footer.jsp" />

</body>

</html>