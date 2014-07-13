package ar.edu.futbol5

import ar.edu.futbol5.ordenamiento.CriterioOrdenamiento
import ar.edu.futbol5.ordenamiento.OrdenamientoPorHandicap
import java.util.ArrayList
import java.util.List
import ar.edu.futbol5.estado.Estado
import ar.edu.futbol5.estado.EstadoAbierto
import ar.edu.futbol5.estado.EstadoEquiposGenerados
import ar.edu.futbol5.equipos.ParDeEquipos
import ar.edu.futbol5.equipos.GeneradorDeEquipos
import ar.edu.futbol5.equipos.GeneradorDeEquiposParesContraImpares
import ar.edu.futbol5.estado.EstadoCerrado

class Partido {

	@Property List<Jugador> inscriptos
	@Property Equipo equipo1
	@Property Equipo equipo2
	@Property Estado estado
	@Property CriterioOrdenamiento criterioOrdenamiento
	@Property GeneradorDeEquipos generadorDeEquipos

	new() {
		inscriptos = new ArrayList<Jugador>
		estado = new EstadoAbierto
		generadorDeEquipos = new GeneradorDeEquiposParesContraImpares
		criterioOrdenamiento = new OrdenamientoPorHandicap
	}

	def generarEquipos() {
		this.estado.validarInscripcion()
		this.distribuirEquipos(criterioOrdenamiento.ordenar(this.inscriptos))
		estado = new EstadoEquiposGenerados
	}

	def distribuirEquipos(List<Jugador> jugadores) {
		val ParDeEquipos parDeEquipos = generadorDeEquipos.generar(jugadores)
		equipo1 = parDeEquipos.equipo1
		equipo2 = parDeEquipos.equipo2
	}

	def void inscribir(Jugador jugador) {
		estado.inscribir(jugador, this)
		if (inscriptos.size == 10) {
			this.cerrar()
		}
	}

	def boolean hayAlgunJugadorQueCedaLugar() {
		return inscriptos.exists[jugador|jugador.dejaLugarAOtro]
	}

	def Jugador jugadorQueCedeLugar() {
		if (!hayAlgunJugadorQueCedaLugar()) {
			return null
		}
		return inscriptos.filter[jugador|jugador.dejaLugarAOtro].get(0)
	}

	def void cerrar() {
		estado = new EstadoCerrado
	}

}
