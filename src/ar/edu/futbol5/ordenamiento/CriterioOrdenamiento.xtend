package ar.edu.futbol5.ordenamiento

import ar.edu.futbol5.Jugador
import java.util.List

abstract class CriterioOrdenamiento {
	
	def ordenar(List<Jugador> jugadores) {
		jugadores.sortBy(calcularValor).clone.reverse
	}

	def (Jugador) => Double calcularValor()
		 
}