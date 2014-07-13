package ar.edu.futbol5.ordenamiento;

import ar.edu.futbol5.Jugador;
import ar.edu.futbol5.Partido;
import ar.edu.futbol5.ordenamiento.CriterioOrdenamiento;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class OrdenamientoPorHandicap implements CriterioOrdenamiento {
  public List<Jugador> ordenar(final Partido partido) {
    List<Jugador> _inscriptos = partido.getInscriptos();
    Function1<? super Jugador,? extends Double> _calcularValor = this.calcularValor();
    List<Jugador> _sortBy = IterableExtensions.sortBy(_inscriptos, _calcularValor);
    Jugador[] _clone = ((Jugador[])Conversions.unwrapArray(_sortBy, Jugador.class)).clone();
    return ListExtensions.<Jugador>reverse(((List<Jugador>)Conversions.doWrapArray(_clone)));
  }
  
  public Function1<? super Jugador,? extends Double> calcularValor() {
    final Function1<Jugador,Double> _function = new Function1<Jugador,Double>() {
      public Double apply(final Jugador jugador) {
        return jugador.getCalificacion();
      }
    };
    return _function;
  }
}
