package control;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidades.Empleado;
import entidades.FabricaEmpleados;
import persistencia.OrmEmpleados;
import persistencia.RepositorioEmpleados;


/**
 * Se crea una clase en la cual se crearan los tipos de empleados necesarios para el corecto desarrollo de 
 * las pruebas que se pieden en el ejercicio
 * @author Cristian David Guerrero  - Andres Felipe Castrillon - Juan Jose Paz
 * @version 1.0
 */
public class ClaseControl {
	
	private RepositorioEmpleados repositorioEmpleados;
	
	public ClaseControl() {
		repositorioEmpleados = new OrmEmpleados();
	}
	
	public ClaseControl(RepositorioEmpleados repositorioEmpleados) {
		this.repositorioEmpleados = repositorioEmpleados;
	}
	
	/**
	 * Se adiciona un empleado, es decir, se registra su información y se guarda.
	 * Usa la clase fabrica para crear el objeto especifico.
	 * @param tipo	que tipo de empleado es: 'a' para asalariado, 'c' para empleado por comision y 'h' para empleado por horas
	 * @param nombre nombre del empleado
	 * @param identificador identificador unico del empleado
	 * @param valorHora valor por hora de trabajo
	 * @param horasTrabajadas cantidad de horas trabajadas por un empleado
	 * @param salarioSemanal el salario que ha ganado un empleado en una semana
	 * @param salarioBaseSemanal el salario fijo que gana un empleado
	 * @param totalVentasRealizadas el valor total de las ventas realizadas por un empleado
	 * @return	un valor booleano indicando si se pudo adicionar el empleado
	 * 			o no (porque ya existia otro con ese mismo identificador).
	 * @throws EmpleadoException cuando alguna de las reglas del negocio no se cumple.
	 */
	public boolean adicionarEmpleado(char tipo,String nombre, String identificador, float valorHora, int horasTrabajadas, float salarioSemanal,float salarioBaseSemanal, float totalVentasRealizadas) 
			 throws EmpleadoException {
			    if(valorHora < 0){
					throw new EmpleadoException("El valor por hora no puede ser negativo");
				}else if(horasTrabajadas < 0){
					throw new EmpleadoException("Las horas trabajadas no pueden ser negativas");
				}else if(salarioSemanal < 0){
					throw new EmpleadoException("El salario semanal no puede puede ser negativo ");
				}else if(salarioBaseSemanal < 0){
					throw new EmpleadoException("El salario base semanal no puede puede ser negativo ");
				}else if(totalVentasRealizadas < 0){
					throw new EmpleadoException("El valor total de ventas realizadas no puede puede ser negativo ");
				}
				
				
				Empleado empleadoBuscado = buscarEmpleado(identificador);
				if (empleadoBuscado == null) {
					Empleado empleadoNuevo = FabricaEmpleados.CrearEmpleado( tipo, nombre,  identificador,  valorHora,  horasTrabajadas,  salarioSemanal, salarioBaseSemanal,  totalVentasRealizadas);
					return repositorioEmpleados.adicionarEmpleado(empleadoNuevo);
				}
				return false;
	}
	
	
	/**
	 * Busca un empleado entre los que ya estan registrados, por su identificacion
	 *@return el objeto empleado con la identificación dada, o null si no se encuentra
	 */
	public Empleado buscarEmpleado(String identificador){
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("Taller_JPA_GIT");
		EntityManager gestorBD = fabrica.createEntityManager();

		Empleado empleadoBuscado = gestorBD.find(Empleado.class, identificador);
		gestorBD.close();

		return empleadoBuscado;
	}
	
	public float calcularSalarioEmpleado(String identificador) {
		float salario = 0;
		Empleado empleadoBuscado = buscarEmpleado(identificador);
		try {
			salario = empleadoBuscado.calcularSalario();
		}catch(EmpleadoException e) {
			System.out.println("Imposible calcular el salario, el empleado no existe");
		}
		return salario;	
		
	}
	
	
	/**
	 * Extraer los empleados del repositorio y calcula la nomina que se debe pagar
	 *@return nomina retorna la nomina
	 */

	public double calcularNomina() throws EmpleadoException {
		List<Empleado> listaEmpleados = repositorioEmpleados.consultarEmpleados();
		double nomina = 0.0;
		try {
			for(int i=0; i < listaEmpleados.size(); i++) {
				nomina += listaEmpleados.get(i).calcularSalario();
			}
		}catch(EmpleadoException e) {
			System.out.println("Ocurrio un error al calcular el salario");
		}
		
		return nomina;
	}
	
	
}
