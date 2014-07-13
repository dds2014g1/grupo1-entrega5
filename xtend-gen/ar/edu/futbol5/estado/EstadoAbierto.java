package ar.edu.futbol5.estado;

import ar.edu.futbol5.estado.Estado;
import ar.edu.futbol5.excepciones.BusinessException;

@SuppressWarnings("all")
public class EstadoAbierto extends Estado {
  public void validarInscripcion() {
    throw new BusinessException("El partido no cuenta con 10 jugadores");
  }
}
