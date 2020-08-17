package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Se crea la clase GestorConexionBd el cual nos permitira realizar la 
 * conexion de manera adecuada de la base de datos la cual tendra la siguiente
 * cadena necesaria para la conexion "jdbc:sqlite:empleados.db"
 * @author Cristian David Guerrero  - Andres Felipe Castrillon - Juan Jose Paz
 * @version 1.0
 */
 
public class GestorConexionBd {
	/**
	 * Permite obtener un objeto "Connection" para conectarse con la base de datos.
	 * Se llamará este método cada vez que se necesite crear una nueva conexión
	 * a la base de datos para realizar alguna operación (SQL). 
	 * 
	 * Si se presenta alguna excepción, el método retornará null, pero mostrará el error.
	 * 
	 * El método que obtiene esta conexión deberá llamar al método cerrarConexión
	 * (después de realizar la operación), para que no queden conexiones abiertas
	 * que consuman recursos.
	 * 
	 * @return	el objeto Connection que permite realizar operaciones en la base de datos,
	 * 			o null si no se pudo conectar (por que no encontró el driver o algún
	 * 			error en la cadena de conexión).
	 */
	Connection abrirConexion() {
		Connection conexion = null;
		try {
			DriverManager.registerDriver(new org.sqlite.JDBC());
			String cadenaConexion = "jdbc:sqlite:empleados.db";
			conexion = DriverManager.getConnection(cadenaConexion);
		} catch (SQLException e) {
			System.err.println("No se pudo obtener la conexión con la Base de Datos");
		}
		return conexion;
	}
	
	/**
	 * Cierra una conexión para liberar los recursos.
	 * Si se presenta alguna excepción en el proceso, se escribe el error.
	 * @param conexión la conexión que se cerrará. 
	 */
	void cerrarConexion(Connection conexion) {
		if (conexion != null) {
			try {
				conexion.close();
				conexion = null;
			} catch (SQLException e) {
				System.err.println("No se pudo obtener la conexión con la Base de Datos:"+conexion);
			}
		}
	}
}
