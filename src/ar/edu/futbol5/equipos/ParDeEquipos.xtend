package ar.edu.futbol5.equipos

import ar.edu.futbol5.Equipo

class ParDeEquipos {
	
	@Property
	Equipo equipo1
	
	@Property
	Equipo equipo2
	
	new(Equipo equipo1, Equipo equipo2) {
		this.equipo1 = equipo1
		this.equipo2 = equipo2
	}
	
}