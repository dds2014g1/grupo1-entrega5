package ar.edu.futbol5.estado

import ar.edu.futbol5.Jugador
import ar.edu.futbol5.Partido

abstract class Estado {

	def void validarInscripcion()
	
	def void inscribir(Jugador jugador, Partido partido) {
		partido.inscriptos.add(jugador)
	}
	
}