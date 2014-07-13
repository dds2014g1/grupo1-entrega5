package ar.edu.futbol5.equipos

import java.util.List
import java.util.Arrays
import ar.edu.futbol5.Jugador

class GeneradorDeEquipos14589Vs236710 extends GeneradorDeEquipos {

	val posicionesEquipo1 = Arrays.asList(1,4,5,8,9)
	
	override boolean cumpleParaEquipo1(Jugador j, List<Jugador> jugadores) {
		posicionesEquipo1.contains(jugadores.indexOf(j) + 1)
	}
}