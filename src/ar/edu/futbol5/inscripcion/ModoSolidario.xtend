package ar.edu.futbol5.inscripcion

import ar.edu.futbol5.inscripcion.CriterioInscripcion

class ModoSolidario extends CriterioInscripcion {

	override boolean dejaLugarAOtro() {
		return true
	}
	
	override toString() {
		"Solidario"
	}
	
}
