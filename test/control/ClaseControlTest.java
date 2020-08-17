package control;

import static org.junit.jupiter.api.Assertions.*;

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
	 * Se verifica que lanza una exeptcion cuando se pide el salario a un  empelado inexistente
	 * @throws EmpleadoException: la cual indica que el empleado no existe
	 */
	
	@Test
	void calcularSalarioSinEmpleado() {
		ClaseControl control = new ClaseControl();
		assertThrows(Exception.class, ()-> control.calcularSalarioEmpleado("15"));
	}
	
	/**
	 * Calcula la nomina cuando no se tiene ningun empleado en la base de datos
	 */
	@Test
	void calcularNominaSinEmpleado () throws EmpleadoException {
	ClaseControl control = new ClaseControl();
	double nomina = control.calcularNomina();
	double nominaEsperada = 0.0;
	assertEquals(nominaEsperada,nomina);
	}
		
	/**
	 * Crea tres empleados y los agrega a la base de datos, luego se extraen de la base
	 * y se comprueba la información de estos.
	 */
	
	@Test
	void crearEmpleadosDeCadaTipo () {
	ClaseControl control = new ClaseControl();
	try {
		control.adicionarEmpleado('A', "Juan Paz", "1", 0, 0, 150000, 0, 0);
		control.adicionarEmpleado('C', "Cristian Guerrero", "2", 0, 0, 0, 100000, 300000);
		control.adicionarEmpleado('H', "Andres Castrillon", "3", 5000, 59, 0, 0, 0);
	} catch (EmpleadoException e) {
		e.printStackTrace();
	}
	Empleado empleadoBuscado1 = control.buscarEmpleado("1");
	Empleado empleadoBuscado2 = control.buscarEmpleado("2");
	Empleado empleadoBuscado3 = control.buscarEmpleado("3");
	assertEquals("Juan Paz", empleadoBuscado1.getNombre());
	assertEquals("Cristian Guerrero", empleadoBuscado2.getNombre());
	assertEquals("Andres Castrillon", empleadoBuscado3.getNombre());
	}
	
	
	
	/**
	 * Prueba para calcula la nomina que se debe pagar esa semana cuando hay empleados en la base de datos
	 * @throws EmpleadoException 
	 */
	
	@Test
	void calcularNomina () throws EmpleadoException {
	ClaseControl control = new ClaseControl();
	double nomina = control.calcularNomina();
	double nominaEsperada = 760000;
	assertEquals(nominaEsperada,nomina);
	}
	
	
	/**
	 * prueba para calcular el salario de un empleado especificado
	 * @throws EmpleadoException 
	 */

	@Test
	void calcularSalarioDeUnEmpleado () throws EmpleadoException {
	ClaseControl control = new ClaseControl();
	float salario = control.calcularSalarioEmpleado("1");
	float salarioEsperado = (float) 150000.0;
	assertEquals(salarioEsperado, salario);
	
	}
	
}
