package persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entidades.Empleado;

/**
 * Usa una base de datos como repositorio de los datos de los empleados,
 * y ofrece los servicios definidos en RepositorioEmpleados.
 * 
 * usa JPA y EclipseLink
 * para el trabajo con la base de datos (es decir, un ORM). 
 * La base de datos es "empleadosOrm.db" (motor SQLite),
 * y es creada por el Orm con una tabla: Empleado.
 * 
 * Usa diferentes instancias del EntityManager en cada método
 * (se abre y cierra para cada operación)
 * 
 * @author Cristian David Guerrero  - Andres Felipe Castrillon - Juan Jose Paz
 * @version 1.0
 */

public class OrmEmpleados implements RepositorioEmpleados {
	
	private EntityManagerFactory fabrica;
	
	/** 
	 * La unidad de persistencia ("Persistence unit") llamada Empleados
	 * está definida en el archivo de configuración persistence.xml,
	 * en la carpeta META-INF
	 */
	public OrmEmpleados() {
		fabrica = Persistence.createEntityManagerFactory("Taller_JPA_GIT");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Empleado> consultarEmpleados() {
		EntityManager gestorBd = fabrica.createEntityManager();
		Query query = gestorBd.createQuery("select a from Empleado a");
		List<Empleado> empleados = query.getResultList();
		gestorBd.close();
		return empleados;
	}

	@Override
	public boolean adicionarEmpleado(Empleado empleado) {
		try	{
			EntityManager gestorBd = fabrica.createEntityManager();
			gestorBd.getTransaction().begin();	
			gestorBd.persist(empleado);
			gestorBd.getTransaction().commit();
			gestorBd.close();
		}
		catch (Exception errorCrear)	{
			return false;
		}
		return true;
	}

	@Override
	public Empleado buscarEmpleado(String identificador) {
		EntityManager gestorBd = fabrica.createEntityManager();
		Empleado empleado = gestorBd.find(Empleado.class, identificador);
		gestorBd.close();
		return empleado;
	}

	@Override
	public boolean borrarEmpleado(Empleado empleado) {
		try	{
			EntityManager gestorBd = fabrica.createEntityManager();
			gestorBd.getTransaction().begin();
			
			// Primero se busca el barco para "enlazarlo" con la base de datos
			// También se puede usar la instrucción: gestorBd.merge(barco);
			empleado = gestorBd.find(Empleado.class, empleado.getIdentificador());
			
			gestorBd.remove(empleado);
			gestorBd.getTransaction().commit();
			gestorBd.close();
		}
		catch (Exception errorBorrar)	{
			return false;
		}
		return true;
	}
}
