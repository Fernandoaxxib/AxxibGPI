/*********************************************************
 * FUNCION  PARA DAR ANCHO AL DESPLEGAR LOS SELECT
 *********************************************************/
$(document).ready(function() {
	var maxLength = 200;

	var maxLength1 = 100;

	$('#portGasto > option').text(function(i, text) {
		if (text.length > maxLength) {
			return text.substr(0, maxLength) + '...';
		}
	});

	$('#portAccion > option').text(function(i, text) {
		if (text.length > maxLength) {
			return text.substr(0, maxLength) + '...';
		}
	});

	$('#portCircuito > option').text(function(i, text) {
		if (text.length > maxLength1) {
			return text.substr(0, maxLength1) + '...';
		}
	});

	$('#portIniciativa > option').text(function(i, text) {
		if (text.length > maxLength) {
			return text.substr(0, maxLength) + '...';
		}
	});

	$('#portObjetivo > option').text(function(i, text) {
		if (text.length > maxLength) {
			return text.substr(0, maxLength) + '...';
		}
	});

	$('#portCostosProy > option').text(function(i, text) {
		if (text.length > maxLength) {
			return text.substr(0, maxLength) + '...';
		}
	});

	$('#portMeta > option').text(function(i, text) {
		if (text.length > maxLength) {
			return text.substr(0, maxLength) + '...';
		}
	});

});

/*********************************************************
 * FUNCION PARA PASAR EL TEXTO A MAYUSCULAS
 * OCULTA LOS MSG DE ALERTA QUE SE MUESTRAN EN LA JSP,
 * ASI COMO EL BORDE.
 *********************************************************/
function textoMayusculas(event, obj, idmsgAlerta) {

	charValue = (document.all) ? event.keyCode : event.which;

	if (charValue != "8" && charValue != "0" && charValue != "27") {
		obj.value += String.fromCharCode(charValue).toUpperCase();

		$('#portClave').removeClass('alerta-txt');
		$('#1-portClave').removeClass('show');

		$('#portClaveProy').removeClass('alerta-txt');
		$('#0-portClaveProy').removeClass('show');

		switch (idmsgAlerta) {
		case '2-portClaveBP':
			$('#portClaveBP').removeClass('alerta-txt');
			$('#2-portClaveBP').removeClass('show');
			break;
		case '3-portDescripcion':
			$('#portDescripcion').removeClass('alerta-txt');
			$('#3-portDescripcion').removeClass('show');
			break;
		case '1-portCostoProy':
			$('#portCostoProy').removeClass('alerta-txt');
			$('#1-portCostoProy').removeClass('show');
			break;
		case '2-portPeriodoProy':
			$('#portPeriodoProy').removeClass('alerta-txt');
			$('#2-portPeriodoProy').removeClass('show');
			break;
		case '3-portPeriodoMaxProy':
			$('#portPeriodoMaxProy').removeClass('alerta-txt');
			$('#3-portPeriodoMaxProy').removeClass('show');
			break;
		case '4-portDescripProy':
			$('#portDescripProy').removeClass('alerta-txt');
			$('#4-portDescripProy').removeClass('show');
			break;
		case '5-portRecProy':
			$('#portRecProy').removeClass('alerta-txt');
			$('#5-portRecProy').removeClass('show');
			break;
		default:
			null;

		}

		return false;
	} else {
		return true;
	}
}

/*********************************************************
 * FUNCIONES PARA  MOSTRAR ALERTAS CUANDO EL TEXTO
 * NO ES  NUMERICO
 *********************************************************/
function format(input) {
	var num = input.value.replace(/\./g, '');
	if (!isNaN(num)) {
		num = num.toString().split('').reverse().join('').replace(
				/(?=\d*\.?)(\d{3})/g, '$1.');
		num = num.split('').reverse().join('').replace(/^[\.]/, '');
		input.value = num;
					
	}

	else {
		
		$('#1-portCostoProy').addClass('show');
		$("#1-portCostoProy" ).html("Solo se permiten numeros");
		input.value = input.value.replace(/[^\d\.]*/g, '');
	}
	
	
}

function formatPeriodo(input) {
	var num = input.value.replace(/\./g, '');
	if (!isNaN(num)) {		
		input.value = num;	
		$('#portPeriodoProy').removeClass('alerta-txt');
		$('#2-portPeriodoProy').removeClass('show');
	}
	else {
		
		$('#2-portPeriodoProy').addClass('show');
		$("#2-portPeriodoProy" ).html("Solo se permiten numeros");
		input.value = input.value.replace(/[^\d\.]*/g, '');
		}	
}

function formatPeriodoMax(input) {
	var num = input.value.replace(/\./g, '');
	if (!isNaN(num)) {		
		input.value = num;
		$('#portPeriodoMaxProy').removeClass('alerta-txt');
		$('#3-portPeriodoMaxProy').removeClass('show');
	}
	else {
		
		$('#3-portPeriodoMaxProy').addClass('show');
		$("#3-portPeriodoMaxProy" ).html("Solo se permiten numeros");
		input.value = input.value.replace(/[^\d\.]*/g, '');
		}	
}

/*******************************************************************
 * FUNCION PARA AGREGAR PORTAFOLIO
 * SE ENCARGA DE LLAMAR A LA FUNCION QUE HARA EL ENVIO DE INFORMACION
 * DEL FORMULARIO.
 *****************************************************************/
function altaPortafolio() {
	var $submit = $('#altaPortafolio button[type=submit]');
	$('#msg-gneral').html("");
	$submit.on('click', function(event) {
		event.preventDefault();
		envia_formulario_alta_portafolio();
		var $loader = $('#loader-cargando');
        if ($loader.hasClass('ocultar'));
		    $loader.toggleClass('ocultar');

	});
}

/*******************************************************************
 * FUNCION PARA AGREGAR PORTAFOLIO
 * PARAMETROS: SE CREA EL OBJETO: altaPortafolioForm
 * EN EL CUAL SE ENVIARAN LOS ATRIBUTOS 
 * RETORNA:
 *  ---> LISTA DE STRING (lerrorAdicional)
 *  ---> MSG (msg)
 *  ---> BOOLEAN (errorAdicional) QUE VALIDA SI HAY ALGUN ERROR.
 *  LA LISTA CONTIENE EL NOMBRE DE LOS COMPONENTES Y MENSAJES PARA LA JSP 
 *   - CON LOS ID´S SE PUEDE MOSTRAR LA ALERTA Y MSG DE ERROR
 *****************************************************************/
function envia_formulario_alta_portafolio() {
	var dataArrayError = [];

	var altaPortafolioForm = new Object();
	altaPortafolioForm.clavePortafolio = $("#portClave").val();
	altaPortafolioForm.claveBPPortafolio = $("#portClaveBP").val();
	altaPortafolioForm.descripcionPortafolio = $("#portDescripcion").val();
	altaPortafolioForm.estatusPortafolio = $("#portestatus").val();

	altaPortafolioForm.proyDescripcion = $("#portDescripProy").val();
	altaPortafolioForm.proyRecursos = $("#portRecProy").val();
	altaPortafolioForm.proyclaveProyecto = $("#portClaveProy").val();
	altaPortafolioForm.proyBP = $("#portBPProy").val();
	altaPortafolioForm.proycosto = $("#portCostoProy").val();
	altaPortafolioForm.proyfecha = $("#portPeriodoProy").val();
	altaPortafolioForm.proyfechaMaxima = $("#portPeriodoMaxProy").val();
	altaPortafolioForm.proyestatus = $("#portEstatusProy").val();
	altaPortafolioForm.proycircuito = $("#portCircuito").val();
	altaPortafolioForm.proyiniciativa = $("#portIniciativa").val();
	altaPortafolioForm.proyobjetivo = $("#portObjetivo").val();
	altaPortafolioForm.proyaccion = $("#portAccion").val();
	altaPortafolioForm.proymeta = $("#portMeta").val();
	altaPortafolioForm.proycostos = $("#portCostosProy").val();
	altaPortafolioForm.proygasto = $("#portGasto").val();
	altaPortafolioForm.proypresupuesto = $("#portPresupuesto").val();

	var xhr = new XMLHttpRequest();
	xhr.onload = function() {
		var $loader = $('#loader-cargando');
		if (xhr.status == 200) {
			var form = JSON.parse(xhr.responseText);

			if (form.errorAdicional) {
				$('#msg-gneral').removeClass('green');
				$('#msg-gneral').addClass('red');

				dataArrayError = form.lerrorAdicional;
				marcaAlerta(dataArrayError);
				$loader.toggleClass('ocultar');

			} else {
				
				
				$('#msg-gneral').removeClass('red');
				$('#msg-gneral').addClass('green');
				$loader.toggleClass('ocultar');
				
				
				$("#portClave").val(form.idPortafolio);
				$("#portDescripcion").val("");
				$("#portClaveProy").val(form.idProyecto);
				$("#portDescripProy").val("");
				$("#portRecProy").val("");
				$("#portCostoProy").val("");
				$("#portPeriodoProy").val("");
				$("#portPeriodoMaxProy").val("");
			}
			$('#msg-gneral').html(form.msg);

		}
	};

	xhr.open('POST', '/wappGpi/altaPortafolio', true);
	xhr.setRequestHeader("Content-type", "application/json");
	xhr.setRequestHeader('X-CSRF-Token', $('#csrf-altaPortafolio').val());
	xhr.send(JSON.stringify(altaPortafolioForm));
}

/*******************************************************************
 * FUNCION PARA MOSTRAR ALERTAS
 * PARAMETROS ENTRADA:  LISTA
 * LOGICA: LISTA OBTENIDA TRAE UNA CADENA CON UN VALOR
 * POR EJEMPLO: 'portClave-1-Agregar Clave Portafolio' --> la cadena viene del back (clase: AltaPortafolioForm ) 
 *         SEPARAMOS LA CADENA Y CON ESO GENERAMOS
 *         EL NOMBRE DEL COMPONENTE AL QUE SE LE VA A PRENDER LA ALERTA
 *         ASI COMO EL MENSAJE QUE SE VA A MOSTRAR.
 *         PE: (1-portClave)
 *****************************************************************/

function marcaAlerta(dataArrayError) {
	var arr = dataArrayError;
	var indexDato;
	var nombreComponente;

	for (var i = 0, l = arr.length; i < l; i++) {

		nombreComponente = arr[i];

		indexDato = nombreComponente.split("-");
		$("#" + indexDato[0]).addClass('alerta-txt');

		$("#" + indexDato[1] + "-" + indexDato[0]).addClass('show');
		$("#" + indexDato[1] + "-" + indexDato[0]).html(indexDato[2]);

	}

}
