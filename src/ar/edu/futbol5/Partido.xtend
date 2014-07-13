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
import ar.edu.futbol5.excepciones.BusinessException

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
		if (inscriptos.size < 10) {
			this.inscriptos.add(jugador)
		} else {
			this.reemplazarPorOtroJugadro(jugador)
		}
	}

	def void reemplazarPorOtroJugadro(Jugador jugador) {

		if (this.hayAlgunJugadorQueCedaLugar()) {

			this.inscriptos.remove(this.jugadorQueCedeLugar())
			this.inscriptos.add(jugador)

		} else {
			throw new BusinessException("No hay más lugar en el partido")
		}
	}

	def boolean hayAlgunJugadorQueCedaLugar() {
		return inscriptos.exists[jugador|jugador.dejaLugarAOtro]
	}

	def Jugador jugadorQueCedeLugar() {
		return inscriptos.findFirst[jugador|jugador.dejaLugarAOtro]
	}

	def void cerrar() {
		estado = new EstadoCerrado
	}

}
