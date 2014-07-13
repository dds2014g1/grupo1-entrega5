package ar.edu.futbol5

import java.util.List

class Equipo {
	
	@Property List<Jugador> jugadores
	
	new(List<Jugador> jugadores) {
		this.jugadores = jugadores
	}
}