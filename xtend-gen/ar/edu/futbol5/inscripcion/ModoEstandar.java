package ar.edu.futbol5.inscripcion;

import ar.edu.futbol5.inscripcion.CriterioInscripcion;

@SuppressWarnings("all")
public class ModoEstandar implements CriterioInscripcion {
  public boolean leSirveElPartido() {
    return false;
  }
}
