package persistencia;

import java.util.List;

import entidades.Empleado;


/**
 * Se crea una interface repositorio empleados la cual tendra los metodos necesario para el 
 * funcionamiento adecuado de la clase empleados, creando los metodos necesarios para el funcionamiento
 * de estos.
 * @author Cristian David Guerrero - Andres Felipe Castrillon - Juan Jose Paz
 * @version 1.0
 */
public interface RepositorioEmpleados {
	
	/**
	 * Consulta toda la lista de los barcos que hay registrados
	 * @return	la lista (List) con los empleado.
	 * 			En caso de no existir empleados registrados retorna una lista vacía.
	 */
	public List<Empleado> consultarEmpleados();
	
	/**
	 * Adiciona un barco al repositorio para hacerlo persistente
	 * @param empleado el objeto empleado que se desea guardar,
	 * 			debe ser diferente de null
	 * @return un valor booleano indicando si se pudo guardar en el repositorio o no
	 * 		(por alguna restricción en el repositorio, no por reglas del negocio)
	 */
	public abstract boolean adicionarEmpleado(Empleado empleado);
	
	/**
	 * Busca un empleado en la base de datos a partir de su identificador
	 * @param matricula	el identificador del empleado que se desea buscar,
	 * 			debe ser diferente de null
	 * @return	el objeto empleado con el identificador, o null si no se encuentra.
	 */
	public abstract Empleado buscarEmpleado(String identificador);


	
}
