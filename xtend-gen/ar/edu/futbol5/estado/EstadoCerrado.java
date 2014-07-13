package ar.edu.futbol5.estado;

import ar.edu.futbol5.Jugador;
import ar.edu.futbol5.Partido;
import ar.edu.futbol5.estado.Estado;
import ar.edu.futbol5.excepciones.BusinessException;
import java.util.List;

@SuppressWarnings("all")
public class EstadoCerrado extends Estado {
  public void validarInscripcion() {
  }
  
  public void inscribir(final Jugador jugador, final Partido partido) {
    boolean _hayAlgunJugadorQueCedaLugar = partido.hayAlgunJugadorQueCedaLugar();
    if (_hayAlgunJugadorQueCedaLugar) {
      List<Jugador> _inscriptos = partido.getInscriptos();
      Jugador _jugadorQueCedeLugar = partido.jugadorQueCedeLugar();
      _inscriptos.remove(_jugadorQueCedeLugar);
      super.inscribir(jugador, partido);
    } else {
      throw new BusinessException("No hay más lugar");
    }
  }
}
