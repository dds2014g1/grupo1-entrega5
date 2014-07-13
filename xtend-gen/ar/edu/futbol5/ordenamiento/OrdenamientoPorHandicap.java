package ar.edu.futbol5.ordenamiento;

import ar.edu.futbol5.Jugador;
import ar.edu.futbol5.ordenamiento.CriterioOrdenamiento;
import org.eclipse.xtext.xbase.lib.Functions.Function1;

@SuppressWarnings("all")
public class OrdenamientoPorHandicap extends CriterioOrdenamiento {
  public Function1<? super Jugador,? extends Double> calcularValor() {
    final Function1<Jugador,Double> _function = new Function1<Jugador,Double>() {
      public Double apply(final Jugador jugador) {
        return jugador.getCalificacion();
      }
    };
    return _function;
  }
}
