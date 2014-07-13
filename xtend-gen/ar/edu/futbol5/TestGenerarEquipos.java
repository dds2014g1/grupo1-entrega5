package ar.edu.futbol5;

import ar.edu.futbol5.Equipo;
import ar.edu.futbol5.Jugador;
import ar.edu.futbol5.Partido;
import ar.edu.futbol5.equipos.GeneradorDeEquipos14589Vs236710;
import ar.edu.futbol5.excepciones.BusinessException;
import ar.edu.futbol5.ordenamiento.CriterioOrdenamiento;
import ar.edu.futbol5.ordenamiento.OrdenamientoCalificacionUltimos2Partidos;
import ar.edu.futbol5.ordenamiento.OrdenamientoMix;
import ar.edu.futbol5.ordenamiento.OrdenamientoPorHandicap;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.DoubleExtensions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("all")
public class TestGenerarEquipos {
  private Partido partidoPocosJugadores;
  
  private Partido partidoOk;
  
  private Partido partido1;
  
  private Jugador sytek;
  
  private Jugador chicho;
  
  private Jugador pato;
  
  private Jugador lechu;
  
  private Jugador rodri;
  
  private Jugador mike;
  
  private Jugador dodi;
  
  private Jugador roly;
  
  private Jugador eric;
  
  private Jugador leo;
  
  private Jugador ferme;
  
  @Before
  public void init() {
    Partido _partido = new Partido();
    this.partidoPocosJugadores = _partido;
    IntegerRange _upTo = new IntegerRange(1, 7);
    final Procedure1<Integer> _function = new Procedure1<Integer>() {
      public void apply(final Integer it) {
        Jugador _jugador = new Jugador();
        TestGenerarEquipos.this.inscribir(TestGenerarEquipos.this.partidoPocosJugadores, _jugador);
      }
    };
    IterableExtensions.<Integer>forEach(_upTo, _function);
    Partido _partido_1 = new Partido();
    this.partidoOk = _partido_1;
    Partido _partido_2 = new Partido();
    this.partido1 = _partido_2;
    ArrayList<Double> _newArrayList = CollectionLiterals.<Double>newArrayList(Double.valueOf(5d), Double.valueOf(8d));
    Jugador _jugador = new Jugador("sytek", 6d, _newArrayList);
    this.sytek = _jugador;
    ArrayList<Double> _newArrayList_1 = CollectionLiterals.<Double>newArrayList(Double.valueOf(6d), Double.valueOf(8d), Double.valueOf(6d));
    Jugador _jugador_1 = new Jugador("chicho", 7d, _newArrayList_1);
    this.chicho = _jugador_1;
    ArrayList<Double> _newArrayList_2 = CollectionLiterals.<Double>newArrayList(Double.valueOf(9d), Double.valueOf(8d));
    Jugador _jugador_2 = new Jugador("pato", 8d, _newArrayList_2);
    this.pato = _jugador_2;
    ArrayList<Double> _newArrayList_3 = CollectionLiterals.<Double>newArrayList(Double.valueOf(7d), Double.valueOf(9d));
    Jugador _jugador_3 = new Jugador("lechu", 7d, _newArrayList_3);
    this.lechu = _jugador_3;
    ArrayList<Double> _newArrayList_4 = CollectionLiterals.<Double>newArrayList(Double.valueOf(5d), Double.valueOf(8d));
    Jugador _jugador_4 = new Jugador("rodri", 6d, _newArrayList_4);
    this.rodri = _jugador_4;
    ArrayList<Double> _newArrayList_5 = CollectionLiterals.<Double>newArrayList(Double.valueOf(4d), Double.valueOf(10d), Double.valueOf(6d), Double.valueOf(8d));
    Jugador _jugador_5 = new Jugador("mike", 5d, _newArrayList_5);
    this.mike = _jugador_5;
    ArrayList<Double> _newArrayList_6 = CollectionLiterals.<Double>newArrayList(Double.valueOf(6d), Double.valueOf(7d));
    Jugador _jugador_6 = new Jugador("dodi", 7d, _newArrayList_6);
    this.dodi = _jugador_6;
    ArrayList<Double> _newArrayList_7 = CollectionLiterals.<Double>newArrayList(Double.valueOf(6d), Double.valueOf(6d), Double.valueOf(9d));
    Jugador _jugador_7 = new Jugador("roly", 8d, _newArrayList_7);
    this.roly = _jugador_7;
    ArrayList<Double> _newArrayList_8 = CollectionLiterals.<Double>newArrayList(Double.valueOf(9d), Double.valueOf(4d), Double.valueOf(3d), Double.valueOf(10d));
    Jugador _jugador_8 = new Jugador("eric", 6d, _newArrayList_8);
    this.eric = _jugador_8;
    this.eric.modoSolidario();
    ArrayList<Double> _newArrayList_9 = CollectionLiterals.<Double>newArrayList(Double.valueOf(6d), Double.valueOf(6d), Double.valueOf(6d));
    Jugador _jugador_9 = new Jugador("leo", 5d, _newArrayList_9);
    this.leo = _jugador_9;
    this.leo.modoSolidario();
    ArrayList<Double> _newArrayList_10 = CollectionLiterals.<Double>newArrayList(Double.valueOf(9d), Double.valueOf(10d), Double.valueOf(7d));
    Jugador _jugador_10 = new Jugador("ferme", 8d, _newArrayList_10);
    this.ferme = _jugador_10;
    this.ferme.modoSolidario();
    this.inscribir(this.partidoOk, this.sytek);
    this.inscribir(this.partidoOk, this.chicho);
    this.inscribir(this.partidoOk, this.pato);
    this.inscribir(this.partidoOk, this.lechu);
    this.inscribir(this.partidoOk, this.rodri);
    this.inscribir(this.partidoOk, this.mike);
    this.inscribir(this.partidoOk, this.dodi);
    this.inscribir(this.partidoOk, this.eric);
    this.inscribir(this.partidoOk, this.leo);
    this.inscribir(this.partidoOk, this.ferme);
    this.inscribir(this.partido1, this.sytek);
    this.inscribir(this.partido1, this.chicho);
    this.inscribir(this.partido1, this.pato);
    this.inscribir(this.partido1, this.lechu);
    this.inscribir(this.partido1, this.rodri);
    this.inscribir(this.partido1, this.mike);
    this.inscribir(this.partido1, this.dodi);
    this.inscribir(this.partido1, this.roly);
    this.inscribir(this.partido1, this.eric);
    this.inscribir(this.partido1, this.leo);
    this.inscribir(this.partido1, this.ferme);
  }
  
  @Test(expected = BusinessException.class)
  public void pocosInscriptosNoGeneranEquipos() {
    this.partidoPocosJugadores.generarEquipos();
  }
  
  @Test(expected = BusinessException.class)
  public void partidoSinIniciarNoPuedeGenerarEquipos() {
    IntegerRange _upTo = new IntegerRange(1, 4);
    final Procedure1<Integer> _function = new Procedure1<Integer>() {
      public void apply(final Integer it) {
        Jugador _jugador = new Jugador();
        TestGenerarEquipos.this.inscribir(TestGenerarEquipos.this.partidoPocosJugadores, _jugador);
      }
    };
    IterableExtensions.<Integer>forEach(_upTo, _function);
    this.partidoPocosJugadores.generarEquipos();
  }
  
  @Test
  public void inscripcionJugadorNuevoDesplazaAPrimerSolidario() {
    this.inscribir(this.partido1, this.roly);
    List<Jugador> _inscriptos = this.partido1.getInscriptos();
    boolean _contains = _inscriptos.contains(this.roly);
    Assert.assertTrue(_contains);
    List<Jugador> _inscriptos_1 = this.partido1.getInscriptos();
    boolean _contains_1 = _inscriptos_1.contains(this.eric);
    Assert.assertFalse(_contains_1);
    List<Jugador> _inscriptos_2 = this.partido1.getInscriptos();
    boolean _contains_2 = _inscriptos_2.contains(this.ferme);
    Assert.assertTrue(_contains_2);
  }
  
  @Test
  public void generarEquiposPorHandicap() {
    final CriterioOrdenamiento criterioOrdenamiento = this.partido1.getCriterioOrdenamiento();
    InputOutput.<String>println("******************************************");
    InputOutput.<String>println("ordenamiento por handicap");
    List<Jugador> _ordenar = criterioOrdenamiento.ordenar(this.partido1);
    final Function1<Jugador,String> _function = new Function1<Jugador,String>() {
      public String apply(final Jugador jugador) {
        Double _calificacion = jugador.getCalificacion();
        String _plus = ((("Jugador: " + jugador) + " - calificacion: ") + _calificacion);
        return InputOutput.<String>println(_plus);
      }
    };
    List<String> _map = ListExtensions.<Jugador, String>map(_ordenar, _function);
    InputOutput.<List<String>>println(_map);
    ArrayList<Object> _newArrayList = CollectionLiterals.<Object>newArrayList(this.ferme, this.roly, this.pato, this.dodi, this.lechu, this.chicho, this.rodri, this.sytek, this.leo, this.mike);
    List<Jugador> _ordenar_1 = criterioOrdenamiento.ordenar(this.partido1);
    Assert.assertArrayEquals(((Object[])Conversions.unwrapArray(_newArrayList, Object.class)), ((Object[])Conversions.unwrapArray(_ordenar_1, Object.class)));
  }
  
  @Test
  public void generarEquiposPorCalificacionUltimos2Partidos() {
    OrdenamientoCalificacionUltimos2Partidos _ordenamientoCalificacionUltimos2Partidos = new OrdenamientoCalificacionUltimos2Partidos();
    this.partido1.setCriterioOrdenamiento(_ordenamientoCalificacionUltimos2Partidos);
    final CriterioOrdenamiento criterioOrdenamiento = this.partido1.getCriterioOrdenamiento();
    InputOutput.<String>println("******************************************");
    InputOutput.<String>println("ordenamiento por ultimas 2 calificaciones");
    List<Jugador> _ordenar = criterioOrdenamiento.ordenar(this.partido1);
    final Function1<Jugador,String> _function = new Function1<Jugador,String>() {
      public String apply(final Jugador jugador) {
        String _xblockexpression = null;
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
          List<Double> _puntajes_1 = jugador.getPuntajes();
          String _plus = ((("Jugador: " + jugador) + " puntajes: ") + _puntajes_1);
          String _plus_1 = (_plus + " ult.puntajes: ");
          String _plus_2 = (_plus_1 + misPuntajes);
          String _plus_3 = (_plus_2 + 
            " promedio: ");
          String _plus_4 = (_plus_3 + Double.valueOf(promedio));
          _xblockexpression = InputOutput.<String>println(_plus_4);
        }
        return _xblockexpression;
      }
    };
    List<String> _map = ListExtensions.<Jugador, String>map(_ordenar, _function);
    InputOutput.<List<String>>println(_map);
    ArrayList<Object> _newArrayList = CollectionLiterals.<Object>newArrayList(this.ferme, this.pato, this.lechu, this.roly, this.mike, this.chicho, this.dodi, this.rodri, this.sytek, this.leo);
    List<Jugador> _ordenar_1 = criterioOrdenamiento.ordenar(this.partido1);
    Assert.assertArrayEquals(((Object[])Conversions.unwrapArray(_newArrayList, Object.class)), ((Object[])Conversions.unwrapArray(_ordenar_1, Object.class)));
  }
  
  @Test
  public void generarEquiposPorMixDeCriterios() {
    final OrdenamientoMix ordenamientoMix = new OrdenamientoMix();
    OrdenamientoCalificacionUltimos2Partidos _ordenamientoCalificacionUltimos2Partidos = new OrdenamientoCalificacionUltimos2Partidos();
    ordenamientoMix.addCriterio(_ordenamientoCalificacionUltimos2Partidos);
    OrdenamientoPorHandicap _ordenamientoPorHandicap = new OrdenamientoPorHandicap();
    ordenamientoMix.addCriterio(_ordenamientoPorHandicap);
    this.partido1.setCriterioOrdenamiento(ordenamientoMix);
    final CriterioOrdenamiento criterioOrdenamiento = this.partido1.getCriterioOrdenamiento();
    InputOutput.<String>println("******************************************");
    InputOutput.<String>println("ordenamiento por mix");
    List<Jugador> _ordenar = criterioOrdenamiento.ordenar(this.partido1);
    InputOutput.<List<Jugador>>println(_ordenar);
    ArrayList<Object> _newArrayList = CollectionLiterals.<Object>newArrayList(this.ferme, this.pato, this.roly, this.lechu, this.chicho, this.dodi, this.rodri, this.sytek, this.mike, this.leo);
    List<Jugador> _ordenar_1 = criterioOrdenamiento.ordenar(this.partido1);
    Assert.assertArrayEquals(((Object[])Conversions.unwrapArray(_newArrayList, Object.class)), ((Object[])Conversions.unwrapArray(_ordenar_1, Object.class)));
  }
  
  @Test
  public void distribuirEquiposParEImpar() {
    this.partido1.cerrar();
    this.partido1.generarEquipos();
    ArrayList<Object> _newArrayList = CollectionLiterals.<Object>newArrayList(this.ferme, this.pato, this.lechu, this.rodri, this.leo);
    Equipo _equipo1 = this.partido1.getEquipo1();
    List<Jugador> _jugadores = _equipo1.getJugadores();
    Assert.assertArrayEquals(((Object[])Conversions.unwrapArray(_newArrayList, Object.class)), ((Object[])Conversions.unwrapArray(_jugadores, Object.class)));
    ArrayList<Object> _newArrayList_1 = CollectionLiterals.<Object>newArrayList(this.roly, this.dodi, this.chicho, this.sytek, this.mike);
    Equipo _equipo2 = this.partido1.getEquipo2();
    List<Jugador> _jugadores_1 = _equipo2.getJugadores();
    Assert.assertArrayEquals(((Object[])Conversions.unwrapArray(_newArrayList_1, Object.class)), ((Object[])Conversions.unwrapArray(_jugadores_1, Object.class)));
  }
  
  @Test
  public void distribuirEquipos14589() {
    GeneradorDeEquipos14589Vs236710 _generadorDeEquipos14589Vs236710 = new GeneradorDeEquipos14589Vs236710();
    this.partido1.setGeneradorDeEquipos(_generadorDeEquipos14589Vs236710);
    this.partido1.cerrar();
    this.partido1.generarEquipos();
    ArrayList<Object> _newArrayList = CollectionLiterals.<Object>newArrayList(this.ferme, this.dodi, this.lechu, this.sytek, this.leo);
    Equipo _equipo1 = this.partido1.getEquipo1();
    List<Jugador> _jugadores = _equipo1.getJugadores();
    Assert.assertArrayEquals(((Object[])Conversions.unwrapArray(_newArrayList, Object.class)), ((Object[])Conversions.unwrapArray(_jugadores, Object.class)));
    ArrayList<Object> _newArrayList_1 = CollectionLiterals.<Object>newArrayList(this.roly, this.pato, this.chicho, this.rodri, this.mike);
    Equipo _equipo2 = this.partido1.getEquipo2();
    List<Jugador> _jugadores_1 = _equipo2.getJugadores();
    Assert.assertArrayEquals(((Object[])Conversions.unwrapArray(_newArrayList_1, Object.class)), ((Object[])Conversions.unwrapArray(_jugadores_1, Object.class)));
  }
  
  @Test(expected = BusinessException.class)
  public void generarEquiposCuandoSeCierra() {
    GeneradorDeEquipos14589Vs236710 _generadorDeEquipos14589Vs236710 = new GeneradorDeEquipos14589Vs236710();
    this.partido1.setGeneradorDeEquipos(_generadorDeEquipos14589Vs236710);
    this.partido1.cerrar();
    this.partido1.generarEquipos();
    this.partido1.generarEquipos();
  }
  
  /**
   * METODOS AUXILIARES DE LOS TESTS
   */
  public void inscribir(final Partido partido, final Jugador jugador) {
    partido.inscribir(jugador);
  }
}
