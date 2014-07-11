package ar.edu.futbol5.inscripcion;

import ar.edu.futbol5.inscripcion.CriterioInscripcion;

@SuppressWarnings("all")
public class ModoSolidario extends CriterioInscripcion {
  public boolean dejaLugarAOtro() {
    return true;
  }
  
  public String toString() {
    return "Solidario";
  }
}
