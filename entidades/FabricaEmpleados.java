package entidades;

/**
 * Se crea una clase fabrica la cual se sigue del modelo factory, por medio de
 * la cual podremos crear los distintos empleados dependiendo del tipo que se
 * requiera lo que nos reducira el acoplamiento y aumentara la cohesion siguiendo
 * los principios de diseño.
 * @author Cristian David Guerrero  - Andres Felipe Castrillon - Juan Jose Paz
 * @version 1.0
 */

public class FabricaEmpleados {
	
	/**
	 * 
	 * @param tipo : Nos dice el tipo de empleado que se va a crear
	 * @param nombre : El nombre del empleado que se creara
	 * @param identificador: El identificador del empleado que se creara
	 * @param valorHora: El valor de la hora de trabajo para el empleado por horas-
	 * @param horasTrabajadas : El numero de horas trabajadas para el empleado por horas
	 * @param salarioSemanal : El salario semanal para el empleado asalariado
	 * @param salarioBaseSemanal: El salario base semanal para el empleado por comision.
	 * @param totalVentasRealizadas: El numero total de ventas realizadas por el empleado por comision.
	 * @return: Retorna el empleado creado
	 */
	
	public static Empleado CrearEmpleado(char tipo,String nombre, String identificador, float valorHora, int horasTrabajadas, float salarioSemanal,float salarioBaseSemanal, float totalVentasRealizadas) {
		switch (tipo){
		case 'a':
		case 'A': 	return new EmpleadoAsalariado(nombre,identificador,salarioSemanal);
		case 'c':
		case 'C': 	return new EmpleadoPorComision(nombre,identificador,salarioBaseSemanal,totalVentasRealizadas);
		case 'h':
		case 'H': 	return new EmpleadoPorHoras(nombre,identificador,valorHora,horasTrabajadas);
	}
	return null;
	}
	
}
