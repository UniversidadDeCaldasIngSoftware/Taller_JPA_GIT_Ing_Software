package entidades;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

import control.EmpleadoException;

/**
 * @version1.0
 * @author Cristian David Guerrero - Andres Felipe Castrillon - Juan Jose Paz
 *	Clase padre empleado que hara implementar el metodo de calcular el salario
 *	como tambien los atributos identificador y nombre
 */



@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")

public abstract class Empleado {
	
	// Se crean los atributos
	@Id
	private String identificador;
	private String nombre;
	
	public Empleado(String nombre, String identificador) {
		this.identificador = identificador;
		this.nombre = nombre;
	}
	
	public Empleado() {
	
	}
	
	
	
	/**
	 *  metodo que nos retorna el valor de la nomina para cada uno de los distintos tipos de empleados
	 * @return nos retorna el valor de la nomina dependiendo de cada una de sus implementaciones posteriores.
	 */
	public abstract float calcularNomina() throws EmpleadoException;

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	} 
	
	
	
}
