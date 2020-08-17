package control;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidades.Empleado;

public class PruebaControl {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("Taller_JPA_GIT");
		EntityManager gestorBD = fabrica.createEntityManager();

		Empleado empleadoBuscado = gestorBD.find(Empleado.class, "123456789");
		System.out.println(empleadoBuscado.getNombre());
		gestorBD.close();
		
		
	}

}
