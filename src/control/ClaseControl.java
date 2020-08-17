package control;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidades.Empleado;
import entidades.EmpleadoAsalariado;
import entidades.EmpleadoPorComision;
import entidades.EmpleadoPorHoras;
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
	
	public Puerto(RepositorioBarcos repositorioBarcos) {
		this.repositorioBarcos = repositorioBarcos;
	}
	

	public static void main(String[] args) {
				EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("Taller_JPA_GIT");
				EntityManager gestorBD = fabrica.createEntityManager();
				gestorBD.getTransaction().begin();
				Empleado empleado = new EmpleadoAsalariado("Juan Paz","123456789", 10000000);
				gestorBD.persist(empleado);
				
				Empleado empleado2 = new EmpleadoPorHoras("Cristian Guerrero","1", 10000,56);
				gestorBD.persist(empleado2);
			
				Empleado empleado3 = new EmpleadoPorComision("Andres Castrillon","2", 30000,53);
				gestorBD.persist(empleado3);
				gestorBD.getTransaction().commit();
				Empleado empleadoBuscado = gestorBD.find(Empleado.class, "123456789");
				System.out.println(empleadoBuscado.getNombre());
				gestorBD.close();

	}

}
