package control;

/**
 * Excepciones relacionadas con el registro de barcos en el puerto,
 * expecialmente por no cumplir alguna regla del negocio
 * @version 1.0
 * @author Cristian David Guerrero  - Andres Felipe Castrillon - Juan Jose Paz
*/
 

@SuppressWarnings("serial")
public class EmpleadoException extends Exception {
	
	public EmpleadoException(String mensaje) {
		super(mensaje);
	}
}
