package ar.edu.futbol5.estado

import ar.edu.futbol5.excepciones.BusinessException
import ar.edu.futbol5.Jugador
import ar.edu.futbol5.Partido

class EstadoEquiposGenerados extends Estado {
	
	override void validarInscripcion() {
		throw new BusinessException("Los equipos ya han sido generados")
	}
	
	override void inscribir(Jugador jugador, Partido partido) {
		this.validarInscripcion()
	}
	
}