package ar.edu.futbol5.equipos

import java.util.List
import ar.edu.futbol5.Jugador

class GeneradorDeEquiposParesContraImpares extends GeneradorDeEquipos {
	
	override boolean cumpleParaEquipo1(Jugador j, List<Jugador> jugadores) {
		(jugadores.indexOf(j)) % 2 == 0
	}

}