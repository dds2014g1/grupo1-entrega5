package ar.edu.futbol5;

import ar.edu.futbol5.Equipo;
import ar.edu.futbol5.Jugador;
import ar.edu.futbol5.estado.Estado;
import ar.edu.futbol5.estado.EstadoAbierto;
import ar.edu.futbol5.estado.EstadoCerrado;
import ar.edu.futbol5.estado.EstadoEquiposGenerados;
import ar.edu.futbol5.inscripcion.CriterioInscripcion;
import ar.edu.futbol5.ordenamiento.CriterioOrdenamiento;
import ar.edu.futbol5.ordenamiento.OrdenamientoPorHandicap;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class Partido {
  private List<Jugador> _inscriptos;
  
  public List<Jugador> getInscriptos() {
    return this._inscriptos;
  }
  
  public void setInscriptos(final List<Jugador> inscriptos) {
    this._inscriptos = inscriptos;
  }
  
  private Equipo _equipo1;
  
  public Equipo getEquipo1() {
    return this._equipo1;
  }
  
  public void setEquipo1(final Equipo equipo1) {
    this._equipo1 = equipo1;
  }
  
  private Equipo _equipo2;
  
  public Equipo getEquipo2() {
    return this._equipo2;
  }
  
  public void setEquipo2(final Equipo equipo2) {
    this._equipo2 = equipo2;
  }
  
  private Estado _estado;
  
  public Estado getEstado() {
    return this._estado;
  }
  
  public void setEstado(final Estado estado) {
    this._estado = estado;
  }
  
  private CriterioOrdenamiento _criterioOrdenamiento;
  
  public CriterioOrdenamiento getCriterioOrdenamiento() {
    return this._criterioOrdenamiento;
  }
  
  public void setCriterioOrdenamiento(final CriterioOrdenamiento criterioOrdenamiento) {
    this._criterioOrdenamiento = criterioOrdenamiento;
  }
  
  private int _distribucionEquipos;
  
  public int getDistribucionEquipos() {
    return this._distribucionEquipos;
  }
  
  public void setDistribucionEquipos(final int distribucionEquipos) {
    this._distribucionEquipos = distribucionEquipos;
  }
  
  public Partido() {
    ArrayList<Jugador> _arrayList = new ArrayList<Jugador>();
    this.setInscriptos(_arrayList);
    EstadoAbierto _estadoAbierto = new EstadoAbierto();
    this.setEstado(_estadoAbierto);
    this.setDistribucionEquipos(5);
    OrdenamientoPorHandicap _ordenamientoPorHandicap = new OrdenamientoPorHandicap();
    this.setCriterioOrdenamiento(_ordenamientoPorHandicap);
  }
  
  public void generarEquipos() {
    Estado _estado = this.getEstado();
    _estado.validarInscripcion();
    CriterioOrdenamiento _criterioOrdenamiento = this.getCriterioOrdenamiento();
    List<Jugador> _ordenar = _criterioOrdenamiento.ordenar(this);
    this.distribuirEquipos(_ordenar);
    EstadoEquiposGenerados _estadoEquiposGenerados = new EstadoEquiposGenerados();
    this.setEstado(_estadoEquiposGenerados);
  }
  
  /**
   * def validarInscripcion() {
   * if (inscriptos.size < 10) {
   * return -1
   * }
   * if (estado.equalsIgnoreCase("A")) {
   * return -1
   * }
   * if (estado.equalsIgnoreCase("G")) {
   * return -1
   * }
   * return 0
   * }
   */
  public void distribuirEquipos(final List<Jugador> jugadores) {
    Equipo _equipo = new Equipo();
    this.setEquipo1(_equipo);
    Equipo _equipo_1 = new Equipo();
    this.setEquipo2(_equipo_1);
    int _distribucionEquipos = this.getDistribucionEquipos();
    boolean _equals = (_distribucionEquipos == 5);
    if (_equals) {
      Equipo _equipo1 = this.getEquipo1();
      Jugador _get = jugadores.get(0);
      Jugador _get_1 = jugadores.get(2);
      Jugador _get_2 = jugadores.get(4);
      Jugador _get_3 = jugadores.get(6);
      Jugador _get_4 = jugadores.get(8);
      ArrayList<Jugador> _newArrayList = CollectionLiterals.<Jugador>newArrayList(_get, _get_1, _get_2, _get_3, _get_4);
      _equipo1.setJugadores(_newArrayList);
      Equipo _equipo2 = this.getEquipo2();
      Jugador _get_5 = jugadores.get(1);
      Jugador _get_6 = jugadores.get(3);
      Jugador _get_7 = jugadores.get(5);
      Jugador _get_8 = jugadores.get(7);
      Jugador _get_9 = jugadores.get(9);
      ArrayList<Jugador> _newArrayList_1 = CollectionLiterals.<Jugador>newArrayList(_get_5, _get_6, _get_7, _get_8, _get_9);
      _equipo2.setJugadores(_newArrayList_1);
    } else {
      Equipo _equipo1_1 = this.getEquipo1();
      Jugador _get_10 = jugadores.get(0);
      Jugador _get_11 = jugadores.get(3);
      Jugador _get_12 = jugadores.get(4);
      Jugador _get_13 = jugadores.get(7);
      Jugador _get_14 = jugadores.get(8);
      ArrayList<Jugador> _newArrayList_2 = CollectionLiterals.<Jugador>newArrayList(_get_10, _get_11, _get_12, _get_13, _get_14);
      _equipo1_1.setJugadores(_newArrayList_2);
      Equipo _equipo2_1 = this.getEquipo2();
      Jugador _get_15 = jugadores.get(1);
      Jugador _get_16 = jugadores.get(2);
      Jugador _get_17 = jugadores.get(5);
      Jugador _get_18 = jugadores.get(6);
      Jugador _get_19 = jugadores.get(9);
      ArrayList<Jugador> _newArrayList_3 = CollectionLiterals.<Jugador>newArrayList(_get_15, _get_16, _get_17, _get_18, _get_19);
      _equipo2_1.setJugadores(_newArrayList_3);
    }
  }
  
  /**
   * def List<Jugador> ordenarEquipos() {
   * criterioOrdenamiento.ordenar(this)
   * }
   */
  public void inscribir(final Jugador jugador) {
    Estado _estado = this.getEstado();
    _estado.inscribir(jugador, this);
    List<Jugador> _inscriptos = this.getInscriptos();
    int _size = _inscriptos.size();
    boolean _equals = (_size == 10);
    if (_equals) {
      this.cerrar();
    }
  }
  
  public boolean hayAlgunJugadorQueCedaLugar() {
    List<Jugador> _inscriptos = this.getInscriptos();
    final Function1<Jugador,Boolean> _function = new Function1<Jugador,Boolean>() {
      public Boolean apply(final Jugador jugador) {
        CriterioInscripcion _criterioInscripcion = jugador.getCriterioInscripcion();
        return Boolean.valueOf(_criterioInscripcion.dejaLugarAOtro());
      }
    };
    return IterableExtensions.<Jugador>exists(_inscriptos, _function);
  }
  
  public Jugador jugadorQueCedeLugar() {
    boolean _hayAlgunJugadorQueCedaLugar = this.hayAlgunJugadorQueCedaLugar();
    boolean _not = (!_hayAlgunJugadorQueCedaLugar);
    if (_not) {
      return null;
    }
    List<Jugador> _inscriptos = this.getInscriptos();
    final Function1<Jugador,Boolean> _function = new Function1<Jugador,Boolean>() {
      public Boolean apply(final Jugador jugador) {
        CriterioInscripcion _criterioInscripcion = jugador.getCriterioInscripcion();
        return Boolean.valueOf(_criterioInscripcion.dejaLugarAOtro());
      }
    };
    Iterable<Jugador> _filter = IterableExtensions.<Jugador>filter(_inscriptos, _function);
    return ((Jugador[])Conversions.unwrapArray(_filter, Jugador.class))[0];
  }
  
  public void cerrar() {
    EstadoCerrado _estadoCerrado = new EstadoCerrado();
    this.setEstado(_estadoCerrado);
  }
}
