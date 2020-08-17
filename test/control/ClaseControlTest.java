package control;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;

import entidades.Empleado;
/**
 * Se crea una clase pruebas en la cual se hara uso de la herramienta JUnit
 * por medio de la cual se debe mirar que el programa funcione de manera adecuada
 * cumpliendo con cada una de las pruebas propuestas en el enunciado
 * @author Cristian David Guerrero  - Andres Felipe Castrillon - Juan Jose Paz
 * @version 1.0
 */
class ClaseControlTest {

	/**
	 * Test que verifica que el empleado inexistente que se compara en este caso, el que
	 * tiene como identificador el numero 15 sea inexistente y por ende debe lanzar
	 * excepcion
	 * @throws EmpleadoException: la cual indica que el empleado no existe
	 */
	
	@Test
	void calcularSinEmpleado() throws EmpleadoException{
		ClaseControl control = new ClaseControl();
		assertThrows(Exception.class, ()-> control.calcularNomina("15"));
	}
		
	/**
	 * Consulta en la cual se crean los 3 tipos de empleados y se ingresan cada
	 * uno respectivamente en la base de datos, teniendo como objetivo que los 
	 * 3 haya ingresado de la manera adecuada. Se realiza un assertEquals para
	 * verificar que el nombre de los empleados creados anteriormente sea el nombre
	 * obtenido de su respectivo identificador
	 */
	
	@Test
	void consultaTipoEmpleados () {
	ClaseControl control = new ClaseControl();
	Empleado empleadoBuscado1 = control.buscarEmpleado("123456789");
	Empleado empleadoBuscado2 = control.buscarEmpleado("1");
	Empleado empleadoBuscado3 = control.buscarEmpleado("2");
	assertEquals("Juan Paz", empleadoBuscado1.getNombre());
	assertEquals("Cristian Guerrero", empleadoBuscado2.getNombre());
	assertEquals("Andres Castrillon", empleadoBuscado3.getNombre());
	}
	
	/**
	 * Se crea una prueba en la cual se calcula que su metodo de calcularNomina 
	 * retorne el valor correspondiente para cada uno y de esta manera se verifica
	 * el valor adecuado para cada uno de ellos y tambien para el funcionamiento
	 * correcto del programa
	 * @throws EmpleadoException 
	 */
	
	@Test
	void calcularNomina () throws EmpleadoException {
	ClaseControl control = new ClaseControl();
	Empleado empleadoBuscado1 = control.buscarEmpleado("123456789");
	Empleado empleadoBuscado2 = control.buscarEmpleado("1");
	Empleado empleadoBuscado3 = control.buscarEmpleado("2");
	assertEquals(10000000.0, empleadoBuscado1.calcularNomina());
	assertEquals(760000.0, empleadoBuscado2.calcularNomina());
	assertEquals(30002.650390625, empleadoBuscado3.calcularNomina());
	}
	
}
