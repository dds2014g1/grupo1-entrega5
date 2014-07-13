package ar.edu.futbol5.estado;

import ar.edu.futbol5.Jugador;
import ar.edu.futbol5.Partido;
import java.util.List;

@SuppressWarnings("all")
public abstract class Estado {
  public abstract void validarInscripcion();
  
  public void inscribir(final Jugador jugador, final Partido partido) {
    List<Jugador> _inscriptos = partido.getInscriptos();
    _inscriptos.add(jugador);
  }
}
