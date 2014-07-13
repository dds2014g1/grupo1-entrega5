package ar.edu.futbol5.equipos

import java.util.List
import ar.edu.futbol5.Jugador
import ar.edu.futbol5.Equipo

abstract class GeneradorDeEquipos {
	
	def generar(List<Jugador> jugadoresOrdenados) {
		val equipo1 = new Equipo(jugadoresOrdenados.filter[ j | j.cumpleParaEquipo1(jugadoresOrdenados)].toList)
		val equipo2 = new Equipo(jugadoresOrdenados.filter[ j | !j.cumpleParaEquipo1(jugadoresOrdenados)].toList)
		
		new ParDeEquipos(equipo1, equipo2)
	}
	
	def boolean cumpleParaEquipo1(Jugador j, List<Jugador> jugadores)

}