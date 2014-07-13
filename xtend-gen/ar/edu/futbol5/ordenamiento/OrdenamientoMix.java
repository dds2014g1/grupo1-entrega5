package ar.edu.futbol5.ordenamiento;

import ar.edu.futbol5.Jugador;
import ar.edu.futbol5.ordenamiento.CriterioOrdenamiento;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtext.xbase.lib.DoubleExtensions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class OrdenamientoMix extends CriterioOrdenamiento {
  private List<CriterioOrdenamiento> criterios;
  
  public OrdenamientoMix() {
    ArrayList<CriterioOrdenamiento> _arrayList = new ArrayList<CriterioOrdenamiento>();
    this.criterios = _arrayList;
  }
  
  public boolean addCriterio(final CriterioOrdenamiento criterio) {
    return this.criterios.add(criterio);
  }
  
  public Function1<? super Jugador,? extends Double> calcularValor() {
    final Function1<Jugador,Double> _function = new Function1<Jugador,Double>() {
      public Double apply(final Jugador jugador) {
        final Function2<Double,CriterioOrdenamiento,Double> _function = new Function2<Double,CriterioOrdenamiento,Double>() {
          public Double apply(final Double acum, final CriterioOrdenamiento criterio) {
            Function1<? super Jugador,? extends Double> _calcularValor = criterio.calcularValor();
            Double _apply = _calcularValor.apply(jugador);
            return Double.valueOf(DoubleExtensions.operator_plus(acum, _apply));
          }
        };
        Double _fold = IterableExtensions.<CriterioOrdenamiento, Double>fold(OrdenamientoMix.this.criterios, Double.valueOf(0d), _function);
        int _size = OrdenamientoMix.this.criterios.size();
        return Double.valueOf(((_fold).doubleValue() / _size));
      }
    };
    return _function;
  }
}
