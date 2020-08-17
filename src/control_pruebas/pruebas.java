package control_pruebas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import control.EmpleadoException;
import entidades.Empleado;
import entidades.EmpleadoAsalariado;
import entidades.EmpleadoPorComision;
import entidades.EmpleadoPorHoras;
/**
 * Se crea una clase pruebas en la cual se hara uso de la herramienta JUnit
 * por medio de la cual se debe mirar que el programa funcione de manera adecuada
 * cumpliendo con cada una de las pruebas propuestas en el enunciado
 * @author Cristian David Guerrero  - Andres Felipe Castrillon - Juan Jose Paz
 * @version 1.0
 */
class pruebas {

	/**
	 * Test que verifica que el empleado inexistente que se compara en este caso, el que
	 * tiene como identificador el numero 15 sea inexistente y por ende debe lanzar
	 * excepcion
	 * @throws EmpleadoException: la cual indica que el empleado no existe
	 */
	
	@Test
	void calcularSinEmpleado() throws EmpleadoException{
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("Taller_JPA_GIT");
		EntityManager gestorBD = fabrica.createEntityManager();
		Empleado empleadoBuscado= gestorBD.find(Empleado.class, "15");
		gestorBD.close();
		assertThrows(Exception.class, ()-> empleadoBuscado.calcularNomina());
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
	EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("Taller_JPA_GIT");
	EntityManager gestorBD = fabrica.createEntityManager();
	Empleado empleadoBuscado1 = gestorBD.find(Empleado.class, "123456789");
	Empleado empleadoBuscado2 = gestorBD.find(Empleado.class, "1");
	Empleado empleadoBuscado3 = gestorBD.find(Empleado.class, "2");
	gestorBD.close();
	assertEquals("Juan Paz", empleadoBuscado1.getNombre());
	assertEquals("Cristian Guerrero", empleadoBuscado2.getNombre());
	assertEquals("Andres Castrillon", empleadoBuscado3.getNombre());
	}
	
	/**
	 * Se crea una prueba en la cual se calcula que su metodo de calcularNomina 
	 * retorne el valor correspondiente para cada uno y de esta manera se verifica
	 * el valor adecuado para cada uno de ellos y tambien para el funcionamiento
	 * correcto del programa
	 */
	
	@Test
	void calcularNomina () {
	EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("Taller_JPA_GIT");
	EntityManager gestorBD = fabrica.createEntityManager();
	Empleado empleadoBuscado1 = gestorBD.find(Empleado.class, "123456789");
	Empleado empleadoBuscado2 = gestorBD.find(Empleado.class, "1");
	Empleado empleadoBuscado3 = gestorBD.find(Empleado.class, "2");
	gestorBD.close();
	assertEquals(10000000.0, empleadoBuscado1.calcularNomina());
	assertEquals(760000.0, empleadoBuscado2.calcularNomina());
	assertEquals(30002.650390625, empleadoBuscado3.calcularNomina());
	}
	
}
