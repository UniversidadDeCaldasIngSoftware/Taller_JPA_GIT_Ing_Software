package entidades;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * 	Clase empleado por comision el cual tiene un salario base y ademas de esto
 *  tambien 
 * @author Cristian David Guerrero - Andres Felipe Castrillon - Juan Jose Paz
 * @version 1.0
 */
@Entity
@DiscriminatorValue("empleado_comision")
public class EmpleadoPorComision extends Empleado {
		
		private float salarioBaseSemanal ;
		private float totalVentasRealizadas;
	
	/**
	 * 	
	 * @param nombre: Nos da el nombre del empleado especificado
	 * @param identificador: Nos da el identificador que posee el empleado
	 * @param salarioBaseSemanal: Nos da el salario base del empleado que se especifico en los dos atributos anteriores
	 * @param totalVentasRealizadas: Nos da el valor total de las ventas realizadas por el empleado
	 */
		
	public EmpleadoPorComision (String nombre, String identificador, float salarioBaseSemanal, float totalVentasRealizadas) {
		super(nombre,identificador);
		this.salarioBaseSemanal = salarioBaseSemanal;
		this.totalVentasRealizadas = totalVentasRealizadas;
	} 	
		
	public EmpleadoPorComision() {
	}	
	
	
	
	@Override
	public float calcularSalario() {
		return (float) (this.salarioBaseSemanal+(this.totalVentasRealizadas*0.05));
	}

	public float getSalarioBaseSemanal() {
		return salarioBaseSemanal;
	}

	public void setSalarioBaseSemanal(float salarioBaseSemanal) {
		this.salarioBaseSemanal = salarioBaseSemanal;
	}

	public float getTotalVentasRealizadas() {
		return totalVentasRealizadas;
	}

	public void setTotalVentasRealizadas(float totalVentasRealizadas) {
		this.totalVentasRealizadas = totalVentasRealizadas;
	}
	
	

}
