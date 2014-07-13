package ar.edu.futbol5;

import ar.edu.futbol5.Equipo;
import ar.edu.futbol5.Jugador;
import ar.edu.futbol5.equipos.GeneradorDeEquipos;
import ar.edu.futbol5.equipos.GeneradorDeEquiposParesContraImpares;
import ar.edu.futbol5.equipos.ParDeEquipos;
import ar.edu.futbol5.estado.Estado;
import ar.edu.futbol5.estado.EstadoAbierto;
import ar.edu.futbol5.estado.EstadoCerrado;
import ar.edu.futbol5.estado.EstadoEquiposGenerados;
import ar.edu.futbol5.inscripcion.CriterioInscripcion;
import ar.edu.futbol5.ordenamiento.CriterioOrdenamiento;
import ar.edu.futbol5.ordenamiento.OrdenamientoPorHandicap;
import java.util.ArrayList;
import java.util.List;
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
  
  private GeneradorDeEquipos _generadorDeEquipos;
  
  public GeneradorDeEquipos getGeneradorDeEquipos() {
    return this._generadorDeEquipos;
  }
  
  public void setGeneradorDeEquipos(final GeneradorDeEquipos generadorDeEquipos) {
    this._generadorDeEquipos = generadorDeEquipos;
  }
  
  public Partido() {
    ArrayList<Jugador> _arrayList = new ArrayList<Jugador>();
    this.setInscriptos(_arrayList);
    EstadoAbierto _estadoAbierto = new EstadoAbierto();
    this.setEstado(_estadoAbierto);
    GeneradorDeEquiposParesContraImpares _generadorDeEquiposParesContraImpares = new GeneradorDeEquiposParesContraImpares();
    this.setGeneradorDeEquipos(_generadorDeEquiposParesContraImpares);
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
    GeneradorDeEquipos _generadorDeEquipos = this.getGeneradorDeEquipos();
    final ParDeEquipos parDeEquipos = _generadorDeEquipos.generar(jugadores);
    Equipo _equipo1 = parDeEquipos.getEquipo1();
    this.setEquipo1(_equipo1);
    Equipo _equipo2 = parDeEquipos.getEquipo2();
    this.setEquipo2(_equipo2);
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
