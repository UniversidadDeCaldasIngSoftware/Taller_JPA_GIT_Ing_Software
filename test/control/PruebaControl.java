package control;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidades.Empleado;
import entidades.EmpleadoAsalariado;
import entidades.EmpleadoPorComision;
import entidades.EmpleadoPorHoras;

public class PruebaControl {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("Taller_JPA_GIT");
		EntityManager gestorBD = fabrica.createEntityManager();
		
		ClaseControl control = new ClaseControl();
	
		
		gestorBD.getTransaction().begin();
		Empleado empleado = control.buscarEmpleado("123456789");
		if(!gestorBD.contains(empleado)) {
			empleado = gestorBD.merge(empleado);
		}
		gestorBD.remove(empleado);
		Empleado empleado2 = control.buscarEmpleado("1");
		if(!gestorBD.contains(empleado2)) {
			empleado2 = gestorBD.merge(empleado2);
		}
		gestorBD.remove(empleado2);
		Empleado empleado3 = control.buscarEmpleado("2");
		if(!gestorBD.contains(empleado3)) {
			empleado3 = gestorBD.merge(empleado3);
		}
		gestorBD.remove(empleado3);
		gestorBD.getTransaction().commit();
		gestorBD.close();
	}

}
