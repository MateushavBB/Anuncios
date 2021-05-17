package view;

import java.sql.Connection;
import connection.ConnectionFactory;

public class Main {
	
	public static void main(String [] args) {
		Connection connection = ConnectionFactory.getConnection();
		System.out.println("Conectado!");
		
		
	}

}
