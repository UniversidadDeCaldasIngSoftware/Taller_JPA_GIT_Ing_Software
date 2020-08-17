package entidades;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import control.EmpleadoException;

/**
 * Clase que recibe un salario semanal fijo
 * @author Cristian David Guerrero - Andres Felipe Castrillon - Juan Jose Paz
 * @version 1.0
 */

@Entity
@DiscriminatorValue("empleado_asalariado")
public class EmpleadoAsalariado extends Empleado {
	
	private float salarioSemanal;
	
	/**
	 * 	
	 * @param nombre: Nos da el nombre del empleado especificado
	 * @param identificador: Nos da el identificador que posee el empleado
	 * @param salarioSemanal: Nos da el salario base del empleado que se especifico en los dos atributos anteriores
	 
	 */
		
	public EmpleadoAsalariado (String nombre, String identificador, float salarioSemanal) {
		super(nombre,identificador);
		this.salarioSemanal = salarioSemanal;
	} 	
	
	
	public EmpleadoAsalariado() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public float calcularSalario() throws EmpleadoException{
		
		return this.salarioSemanal;
	}


	public float getSalarioSemanal() {
		return salarioSemanal;
	}


	public void setSalarioSemanal(float salarioSemanal) {
		this.salarioSemanal = salarioSemanal;
	}

	
}
