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
	//String estado
	@Property CriterioOrdenamiento criterioOrdenamiento
	@Property GeneradorDeEquipos generadorDeEquipos

	new() {
		inscriptos = new ArrayList<Jugador>
		estado = new EstadoAbierto
		//estado = "A"
		generadorDeEquipos = new GeneradorDeEquiposParesContraImpares
		criterioOrdenamiento = new OrdenamientoPorHandicap
	}

	def generarEquipos() {
		this.estado.validarInscripcion()
		/*if (this.validarInscripcion == -1) {
			throw new BusinessException("Hubo un error")
		}*/
		this.distribuirEquipos(criterioOrdenamiento.ordenar(this))
		estado = new EstadoEquiposGenerados
		//estado = "G"
	}

	/*def validarInscripcion() {
		if (inscriptos.size < 10) {
			return -1
		}
		if (estado.equalsIgnoreCase("A")) {
			return -1
		}
		if (estado.equalsIgnoreCase("G")) {
			return -1
		}
		return 0
	}*/

	def distribuirEquipos(List<Jugador> jugadores) {
		val ParDeEquipos parDeEquipos = generadorDeEquipos.generar(jugadores)
		equipo1 = parDeEquipos.equipo1
		equipo2 = parDeEquipos.equipo2
	}

	/*def List<Jugador> ordenarEquipos() {
		criterioOrdenamiento.ordenar(this)
	}*/

	def void inscribir(Jugador jugador) {
		estado.inscribir(jugador, this)
		if (inscriptos.size == 10) {
			this.cerrar()
		}
		/*if (inscriptos.size < 10) {
			this.inscriptos.add(jugador)
		} else {
			if (this.hayAlgunJugadorQueCedaLugar()) {
				this.inscriptos.remove(this.jugadorQueCedeLugar())
				this.inscriptos.add(jugador)
			} else {
				throw new BusinessException("No hay más lugar")
			}
		}*/
	}

	def boolean hayAlgunJugadorQueCedaLugar() {
		return inscriptos.exists[jugador|jugador.criterioInscripcion.dejaLugarAOtro]
	}

	def Jugador jugadorQueCedeLugar() {
		if (!hayAlgunJugadorQueCedaLugar()) {
			return null
		}
		return inscriptos.filter[jugador|jugador.criterioInscripcion.dejaLugarAOtro].get(0)
	}

	def void cerrar() {
		estado = new EstadoCerrado
		//estado = "C"
	}
}
