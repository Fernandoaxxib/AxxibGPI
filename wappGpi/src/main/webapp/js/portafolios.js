/*****************************************************************
 *  FUNCION PARA FILTRAR TABLA
 *  -> LOGICA: IDPORTAFOLIO, CLAVEPORTAFOLIO, DESCRIPCION
 *     LOS PARAMETROS DE ENTRADA SIRVEN PARA:
 *     ID: EL ID FILTRA LA TABLA Y SI EXISTE MUESTRA LOS DATOS *     
 */
function filtraTablaProyectos(idPortafolio, clavePortafolio, descripcion) {
     console.log(idPortafolio);
     console.log(descripcion);
     $("#proyDescripcion").val(descripcion);
     $("#proyId").val(idPortafolio);
       BuscarDatos(idPortafolio, clavePortafolio);
     
}

/*****************************************************************
 *  FUNCION PARA FILTRAR TABLA
 *  EN CASO DE QUE EXISTAN LOS DATOS LOS MUESTRA.
 *     
 */

function BuscarDatos(idPortafolio, clavePortafolio) {  
	 console.log(idPortafolio);
	var valor = false;
	 	
        $('#tbl-planes tbody tr:has(td)').each(function () {               
            var rowmodulo = $.trim($(this).find('td:eq(1)').text());             
                if (rowmodulo == idPortafolio) {
                    $(this).show(); 
                    $("#body-proyectos").removeClass("ocultar-tabla");
                    $("#btn-agregar-proyecto").prop('disabled', false);
                    $("#portafolioSelect").removeClass("ocultar-componentes");
                    $('#nombrePortafolio').removeClass("ocultar-componentes");
                    $('#nombrePortafolio').html(clavePortafolio);
                } else {                	
                    $(this).hide();  
                    $("#body-proyectos").removeClass("ocultar-tabla");
                    $("#btn-agregar-proyecto").prop('disabled', false);
                     $("#portafolioSelect").removeClass("ocultar-componentes");
                    $('#nombrePortafolio').removeClass("ocultar-componentes");
                    $('#nombrePortafolio').html(clavePortafolio);
                }              
                
                
        });
}
