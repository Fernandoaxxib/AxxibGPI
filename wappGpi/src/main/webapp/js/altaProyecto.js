/*********************************************************
 * FUNCION  PARA DAR ANCHO AL DESPLEGAR LOS SELECT
 *********************************************************/
$(document).ready(function() {
    var maxLength = 200;
    
    var maxLength1 = 100;
    
    $('#proygasto > option').text(function(i, text) {
        if (text.length > maxLength1) {
            return text.substr(0, maxLength1) + '...';
        }
    });
    
    
    $('#proyaccion > option').text(function(i, text) {
        if (text.length > maxLength) {
            return text.substr(0, maxLength) + '...';
        }
    });
    
    $('#proycircuito > option').text(function(i, text) {
        if (text.length > maxLength1) {
            return text.substr(0, maxLength1) + '...';
        }
    });
    
    $('#proyiniciativa > option').text(function(i, text) {
        if (text.length > maxLength) {
            return text.substr(0, maxLength) + '...';
        }
    });
    
    $('#proyobjetivo > option').text(function(i, text) {
        if (text.length > maxLength) {
            return text.substr(0, maxLength) + '...';
        }
    });
    
    $('#proycostos > option').text(function(i, text) {
        if (text.length > maxLength) {
            return text.substr(0, maxLength) + '...';
        }
    });
    
    $('#proymeta > option').text(function(i, text) {
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
function textoMayusculas(event,obj, idmsgAlerta) {
	
        charValue = (document.all) ? event.keyCode : event.which;
        
        if (charValue!="8" && charValue!="0" && charValue != "27"){
            obj.value += String.fromCharCode(charValue).toUpperCase();
           
            
            $('#proyclaveProyecto').removeClass('alerta-txt');
            $('#3-proyclaveProyecto').removeClass('show');
            
            
            switch (idmsgAlerta) { 
        	case '1-proydescripcion': 
        		$('#proydescripcion').removeClass('alerta-txt');
                $('#1-proydescripcion').removeClass('show');
        		break;
        	case '2-proyRecursos': 
        		 $('#proyRecursos').removeClass('alerta-txt');
                 $('#2-proyRecursos').removeClass('show');
        		break;
        	case '4-proycosto': 
        		$('#proycosto').removeClass('alerta-txt');
                $('#4-proycosto').removeClass('show');
        		break;		
        	case '5-proyfecha': 
        		 $('#proyfecha').removeClass('alerta-txt');
                 $('#5-proyfecha').removeClass('show');
        		break;
        	case '6-proyfechaMaxima': 
        		$('#proyfechaMaxima').removeClass('alerta-txt');
                $('#6-proyfechaMaxima').removeClass('show');
       		break;
        	
        	default:
        		
        		null;
        		
        }
                     
            return false;
        }else{
            return true;
        }
    }


/*********************************************************
 * FUNCION PARA AGREGAR PROYECTO
 *********************************************************/
function altaProyecto() { 
    var $submit = $('#altaProyecto button[type=submit]');
    $submit.on('click', function (event) { 
        event.preventDefault();     
        envia_formulario_alta_proyecto();
               
        	  
    });
}
	

function envia_formulario_alta_proyecto () {
	var dataArrayError =[];
	var altaProyectoForm = new Object();
	
	altaProyectoForm.proyDescripcion = $("#proy-descripcion").val();	
	altaProyectoForm.proyRecursos = $("#proyRecursos").val();	
	altaProyectoForm.proyclaveProyecto = $("#proyclaveProyecto").val();
	altaProyectoForm.proyBP =  $("#proyBP").val();
	altaProyectoForm.proycosto = $("#proycosto").val();
	altaProyectoForm.proyfecha = $("#proyfecha").val();
	altaProyectoForm.proyfechaMaxima =  $("#proyfechaMaxima").val(); 
	altaProyectoForm.proyestatus = $("#proyestatus").val(); 
	altaProyectoForm.proyportafolio = $("#proyportafolio").val(); 
	altaProyectoForm.proycircuito = $("#proycircuito").val(); 
	altaProyectoForm.proyiniciativa = $("#proyiniciativa").val();
	altaProyectoForm.proyobjetivo = $("#proyobjetivo").val();
	altaProyectoForm.proyaccion = $("#proyaccion").val(); 
	altaProyectoForm.proymeta = $("#proymeta").val(); 
	altaProyectoForm.proycostos = $("#proycostos").val();  
	altaProyectoForm.proygasto = $("#proygasto").val(); 
	altaProyectoForm.proypresupuesto = $("#proypresupuesto").val(); 
	
	
	
	
	var xhr = new XMLHttpRequest();
	xhr.onload = function() {		 
		if (xhr.status == 200) {
			var form = JSON.parse(xhr.responseText);
			
			
			if (form.errorAdicional) {
				$('#msg-gneral').removeClass('green');
				$('#msg-gneral').addClass('red');
				console.log("errror");
				dataArrayError = form.lerrorAdicional;
				marcaAlerta(dataArrayError);
			} 
			else {
				$('#msg-gneral').removeClass('red');
				$('#msg-gneral').addClass('green');
				
			}
			$('#msg-gneral').html(form.msg);
			
			
		}
	};
		
	xhr.open('POST', '/wappGpi/altaPlanInversion', true);
	xhr.setRequestHeader("Content-type", "application/json");
	xhr.setRequestHeader('X-CSRF-Token', $('#csrf-altaProyecto').val());
	xhr.send(JSON.stringify(altaProyectoForm));
}

/*******************************************************************
 * FUNCION PARA MOSTRAR ALERTAS
 * PARAMETROS ENTRADA:  LISTA
 * LOGICA: LISTA OBTENIDA TRAE UNA CADENA CON UN VALOR
 * POR EJEMPLO: 'portClave-1-Agregar Clave Portafolio' --> la cadena viene del back (clase: AltaPortafolioForm ) 
 *         SEPARAMOS LA CADENA Y CON ESO GENERAMOS
 *         EL NOMBRE DEL COMPONENTE AL QUE SE LE VA A PRENDER LA ALERTA
 *         ASI COMO EL MENSAJE QUE SE VA A MOSTRAR.
 *         PE: (1-proydescripcion)
 *****************************************************************/

function marcaAlerta(dataArrayError){
	var arr = dataArrayError;
	var indexDato ; 
	var nombreComponente;
	
	for ( var i = 0, l = arr.length; i < l; i++ ) {
		
		nombreComponente = arr[ i ]; 
		
		indexDato = nombreComponente.split("-");
		$("#"+indexDato[0]).addClass('alerta-txt'); 
		 
		$("#"+indexDato[1]+"-"+indexDato[0]).addClass('show');
		$("#"+indexDato[1]+"-"+indexDato[0]).html(indexDato[2]);
			    
	}
	 
	
}