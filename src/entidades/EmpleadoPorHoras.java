package entidades;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Clase que recibe un salario semanal fijo
 * @author Cristian David Guerrero - Andres Felipe Castrillon - Juan Jose Paz
 * @version 1.0
 */
@Entity
@DiscriminatorValue("empleado_horas")
public class EmpleadoPorHoras extends Empleado {
		final static int HORAS_BONO = 40;
		private float valorHora;
		private int horasTrabajadas;
		
		/**
		 * 	
		 * @param nombre: Nos da el nombre del empleado especificado
		 * @param identificador: Nos da el identificador que posee el empleado
		 * @param valorHora: Nos da el valor de la hora equivalente para el empleado anteriormente especificado.
		 * @param horasTrabjadas: Nos da el total de horas trabajadas por el empleado.
		 */
			
		public EmpleadoPorHoras (String nombre, String identificador, float valorHora, int horasTrabajadas) {
			super(nombre,identificador);
			this.valorHora = valorHora;
			this.horasTrabajadas = horasTrabajadas;
		} 
		
		public EmpleadoPorHoras() {
			// TODO Auto-generated constructor stub
		}
		
		
		@Override
		public float calcularNomina() {
			float total_salario = 0;
			total_salario = this.valorHora * this.horasTrabajadas;
			if	(this.horasTrabajadas > HORAS_BONO) {
				total_salario += 200000;
			}
			return total_salario;
		}

		public float getValorHora() {
			return valorHora;
		}

		public void setValorHora(float valorHora) {
			this.valorHora = valorHora;
		}

		public int getHorasTrabajadas() {
			return horasTrabajadas;
		}

		public void setHorasTrabajadas(int horasTrabajadas) {
			this.horasTrabajadas = horasTrabajadas;
		}

		public static int getHorasBono() {
			return HORAS_BONO;
		}

		
}
