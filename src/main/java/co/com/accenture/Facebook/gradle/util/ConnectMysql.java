package co.com.accenture.Facebook.gradle.util;

import java.sql.*;
import java.util.ArrayList;

public class ConnectMysql {

	/**
	 * We establish the connection with the database <b>customerdb</b>. Establecemos
	 * la conexión con la base de datos <b>customerdb</b>.
	 * 
	 * @return
	 */
	public ArrayList<String> connectDatabase() {

		Persona info = new Persona();

		try {
			// We register the MySQL (MariaDB) driver
			// Registramos el driver de MySQL (MariaDB)
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException ex) {
				System.out.println("Error al registrar el driver de MySQL: " + ex);
			}
			Connection connection = null;
			// Database connect
			// Conectamos con la base de datos
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/usuarios", "root", "");
			boolean valid = connection.isValid(50000);
			// System.out.println(valid ? "TEST OK" : "TEST FAIL");

			try (PreparedStatement stmt = connection.prepareStatement("SELECT nombre FROM usuario")) {
				ResultSet rs = stmt.executeQuery();

				while (rs.next()) {
					rs.getString("nombre");

					String myName = rs.getString(1);
					info.setNombre(myName);

				}

			} catch (SQLException sqle) {
				System.out.println("Error en la ejecución:" + sqle.getErrorCode() + " " + sqle.getMessage());
			}

		} catch (java.sql.SQLException sqle) {
			System.out.println("Error: " + sqle);
		}
		return info.getNombres();
	}

	public static void main(String[] args) {

		int i;

		ConnectMysql x = new ConnectMysql();

		ArrayList<String> listDatos = x.connectDatabase();

		for (i = 0; i < listDatos.size(); i++) {
			System.out.println(listDatos.get(i));
		}

	}
}
