package ar.edu.futbol5.estado

import ar.edu.futbol5.excepciones.BusinessException

class EstadoAbierto extends Estado {
	
	override void validarInscripcion() {
		throw new BusinessException("El partido no cuenta con 10 jugadores")
	}
	
}