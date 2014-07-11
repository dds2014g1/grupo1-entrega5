package ar.edu.futbol5.ordenamiento;

import ar.edu.futbol5.Jugador;
import ar.edu.futbol5.Partido;
import ar.edu.futbol5.ordenamiento.CriterioOrdenamiento;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.DoubleExtensions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class OrdenamientoCalificacionUltimos2Partidos implements CriterioOrdenamiento {
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
        double _xblockexpression = (double) 0;
        {
          List<Double> _puntajes = jugador.getPuntajes();
          Double[] _clone = ((Double[])Conversions.unwrapArray(_puntajes, Double.class)).clone();
          List<Double> _reverse = ListExtensions.<Double>reverse(((List<Double>)Conversions.doWrapArray(_clone)));
          Iterable<Double> _take = IterableExtensions.<Double>take(_reverse, 2);
          final List<Double> misPuntajes = IterableExtensions.<Double>toList(_take);
          final Function2<Double,Double,Double> _function = new Function2<Double,Double,Double>() {
            public Double apply(final Double acum, final Double puntaje) {
              return Double.valueOf(DoubleExtensions.operator_plus(acum, puntaje));
            }
          };
          Double _fold = IterableExtensions.<Double, Double>fold(misPuntajes, Double.valueOf(0d), _function);
          int _size = misPuntajes.size();
          final double promedio = ((_fold).doubleValue() / _size);
          _xblockexpression = promedio;
        }
        return Double.valueOf(_xblockexpression);
      }
    };
    return _function;
  }
}
