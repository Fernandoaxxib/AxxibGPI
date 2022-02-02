function limpiarVariables(){
	console.log("limpiar");
	$("#btn-indicador").removeClass("btn-drop");
	  $("#btn-indicador").removeClass("g4-back");
	  $("#btn-indicador").removeClass("g3-back");
	  $("#btn-indicador").removeClass("g2-back");
    $("#btn-indicador").removeClass("g1-back");
    $("#btn-indicador").addClass("btn-drop");
}

/***********FUNCION PARA DESPLEGAR EL MENU DE LOS INDICADORES DE COLOR*********/
function myFunction() {
	
  document.getElementById("myDropdown").classList.toggle("show");
}

/***********FUNCION PARA CERRAR EL MENU DE INDICADORES DE COLOR*********/
window.onclick = function(event) {
  if (!event.target.matches('.dropbtn')) {
    var dropdowns = document.getElementsByClassName("dropdown-content");
    var i;
    for (i = 0; i < dropdowns.length; i++) {
      var openDropdown = dropdowns[i];
      if (openDropdown.classList.contains('show')) {
        openDropdown.classList.remove('show');
        
        document.getElementById("btn-indicador").classList.toggle("show");
        
        
      }
    }
  }
}

/***********************************
 * FUNCION PARA DAR COLOR AL BOTON 
 ***********************************/
function indicador(idColor) {
	
	switch (idColor) {
	  case 1:
		  $("#btn-indicador").removeClass("btn-drop");
		  $("#btn-indicador").removeClass("g4-back");
		  $("#btn-indicador").removeClass("g3-back");
		  $("#btn-indicador").removeClass("g2-back");
          $("#btn-indicador").addClass("g1-back");
	    break;
	  case 2:
		  $("#btn-indicador").removeClass("btn-drop");
		  $("#btn-indicador").removeClass("g1-back");
		  $("#btn-indicador").removeClass("g4-back");
		  $("#btn-indicador").removeClass("g3-back");
          $("#btn-indicador").addClass("g2-back");
	    break;
	  case 3:
		  $("#btn-indicador").removeClass("btn-drop");
		  $("#btn-indicador").removeClass("g4-back");
		  $("#btn-indicador").removeClass("g1-back");
		  $("#btn-indicador").removeClass("g2-back");
          $("#btn-indicador").addClass("g3-back");
	    break;
	  case 4:
		  $("#btn-indicador").removeClass("btn-drop");
		  $("#btn-indicador").removeClass("g1-back");
		  $("#btn-indicador").removeClass("g2-back");
		  $("#btn-indicador").removeClass("g3-back");
          $("#btn-indicador").addClass("g4-back");
	    break;	  
	  default:
	    break;
	}
	
	
}

/*********************************************************
 * FUNCION PARA MOSTRAR LA MODAL DE REGISTRO DE AVANCES 
 **/
$( document ).ready(function() {
	if(document.getElementById("btn-registro-avance")){
		
		
		var modal1 = document.getElementById("modal-registrar-avances");
		var btn1 = document.getElementById("btn-registro-avance");
		var span1 = document.getElementsByClassName("cerrar-RegistroAvance")[0];
		var cerrar1 = document.getElementsByClassName("cerrar-btn-cancelar")[0];
		

		btn1.onclick = function() {
			modal1.style.display = "block";	
			body.style.position = "static";
			body.style.height = "100%";
			body.style.overflow = "hidden";
			
		}

		span1.onclick = function() {
			modal1.style.display = "none";	
			body.style.position = "inherit";
			body.style.height = "auto";
			body.style.overflow = "visible";
			
			
		}

		cerrar1.onclick = function() {
			modal1.style.display = "none";	
			body.style.position = "inherit";
			body.style.height = "auto";
			body.style.overflow = "visible";
			
		}

		
	}
});


/*****************************************************************
 *  FUNCION PARA FILTRAR TABLA
 *  -> LOGICA: IDPORTAFOLIO, CLAVEPORTAFOLIO, DESCRIPCION
 *     LOS PARAMETROS DE ENTRADA SIRVEN PARA:
 *     ID: EL ID FILTRA LA TABLA Y SI EXISTE MUESTRA LOS DATOS      
 */
function filtraTablaPortafolio(idPortafolio, clavePortafolio) {     
       BuscarDatos(idPortafolio, clavePortafolio);     
}

function BuscarDatos(idPortafolio, clavePortafolio) {  
	 
	var valor = false;
	 	
        $('#tbl-planes tbody tr:has(td)').each(function () {               
            var rowmodulo = $.trim($(this).find('td:eq(0)').text());             
                if (rowmodulo == idPortafolio) {
                    $(this).show();
                    $("#body-proyectos").removeClass("ocultar-tabla");
                    $("#portafolioSelect").removeClass("ocultar");
                    $('#nombrePortafolio').removeClass("ocultar");
                    $('#nombrePortafolio').html(clavePortafolio);
                } else {                	
                    $(this).hide();  
                    $("#body-proyectos").removeClass("ocultar-tabla");
                     $('#nombrePortafolio').removeClass("ocultar");
                    $('#nombrePortafolio').html(clavePortafolio);
                }
                
        });
}


function  filtraTablaProyectos(idPortafolio, claveProyecto) {       
    $('#portafolioSelectProyecto').removeClass("ocultar-Proyecto");
    $('#nombrePortafolioProyecto').removeClass("ocultar-Proyecto");
    $('#nombrePortafolioProyecto').html(claveProyecto);
    
}


