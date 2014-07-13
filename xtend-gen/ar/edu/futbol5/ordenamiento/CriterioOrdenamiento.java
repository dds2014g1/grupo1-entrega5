package ar.edu.futbol5.ordenamiento;

import ar.edu.futbol5.Jugador;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public abstract class CriterioOrdenamiento {
  public List<Jugador> ordenar(final List<Jugador> jugadores) {
    Function1<? super Jugador,? extends Double> _calcularValor = this.calcularValor();
    List<Jugador> _sortBy = IterableExtensions.sortBy(jugadores, _calcularValor);
    Jugador[] _clone = ((Jugador[])Conversions.unwrapArray(_sortBy, Jugador.class)).clone();
    return ListExtensions.<Jugador>reverse(((List<Jugador>)Conversions.doWrapArray(_clone)));
  }
  
  public abstract Function1<? super Jugador,? extends Double> calcularValor();
}
