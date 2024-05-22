package conexaojdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection {
	
	public static String url = "jdbc:postgresql://localhost:5432/posjava";
	public static String password = "admin";
	public static String user = "postgres";
	public static Connection connection = null;
	
	static {
		conectar();
	}
	
	//public SingleConnection() {
		//conectar();
	//}
	
	public static void conectar() {
		try {
			
			if (connection == null) {
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(url, user, password);
				connection.setAutoCommit(false);
				System.out.println("conectou");
			}
				
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	public static Connection getConnection() {
		return connection;
		
	}
	
}
	
