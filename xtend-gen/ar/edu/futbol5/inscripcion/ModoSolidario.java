package ar.edu.futbol5.inscripcion;

import ar.edu.futbol5.inscripcion.CriterioInscripcion;

@SuppressWarnings("all")
public class ModoSolidario implements CriterioInscripcion {
  public boolean dejaLugarAOtro() {
    return true;
  }
}
