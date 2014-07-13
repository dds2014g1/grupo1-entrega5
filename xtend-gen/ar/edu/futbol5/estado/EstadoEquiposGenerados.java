package ar.edu.futbol5.estado;

import ar.edu.futbol5.Jugador;
import ar.edu.futbol5.Partido;
import ar.edu.futbol5.estado.Estado;
import ar.edu.futbol5.excepciones.BusinessException;

@SuppressWarnings("all")
public class EstadoEquiposGenerados extends Estado {
  public void validarInscripcion() {
    throw new BusinessException("Los equipos ya han sido generados");
  }
  
  public void inscribir(final Jugador jugador, final Partido partido) {
    this.validarInscripcion();
  }
}
