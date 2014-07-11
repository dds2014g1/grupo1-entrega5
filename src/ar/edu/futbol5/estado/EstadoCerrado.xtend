package ar.edu.futbol5.estado

import ar.edu.futbol5.Jugador
import ar.edu.futbol5.Partido
import ar.edu.futbol5.excepciones.BusinessException

class EstadoCerrado extends Estado {
	
	override void validarInscripcion() {}
	
	override void inscribir(Jugador jugador, Partido partido) {
		if (partido.hayAlgunJugadorQueCedaLugar()) {
				partido.inscriptos.remove(partido.jugadorQueCedeLugar())
				super.inscribir(jugador, partido)
			} else {
				throw new BusinessException("No hay más lugar")
			}
		}
	
}
