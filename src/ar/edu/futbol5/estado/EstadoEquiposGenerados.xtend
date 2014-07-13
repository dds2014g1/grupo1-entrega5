package ar.edu.futbol5.estado

import ar.edu.futbol5.excepciones.BusinessException

class EstadoEquiposGenerados extends Estado {
	
	override void validarInscripcion() {
		throw new BusinessException("Los equipos ya han sido generados")
	}

}