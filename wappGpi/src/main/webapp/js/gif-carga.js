
// prepara gif de carga
function gif_carga() {
	var $loader = $('#loader-cargando');

	$('#form-multipart-upload').on('submit', function() {
		if ($loader.hasClass('ocultar'))
			$loader.toggleClass('ocultar');
	});
	
	
	
	
}


