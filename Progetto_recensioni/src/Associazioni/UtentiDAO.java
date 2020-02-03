package Associazioni;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class UtentiDAO {
	
	public int checkUtente(String u, String p) {
		try {
			Class.forName("org.postgresql.Driver");
		}catch(ClassNotFoundException e) {
			System.err.println("Classe non trovata");
		}
		
		
		String url = "jdbc:postgresql://localhost/progetto";
		Properties props = new Properties();
		props.setProperty("user","postgres");
		props.setProperty("password","F123");
		Connection conn = null;
		int flag = 1;
		
		try {
			conn = DriverManager.getConnection(url, props);
			String query = "select username,password from utente where username='" + u + "' and password ='" + p +"'";
			PreparedStatement s = conn.prepareStatement(query);
			ResultSet rs = s.executeQuery();
			while(rs.next()) {
				String username = rs.getString(1);
				String password = rs.getString(2);
				if(p.equals(password) && u.equals(username)) {
					flag = 0;
					break;
				}
			}
		}catch(SQLException e) {
			System.err.println("Errore SQL");
			e.printStackTrace();
		}
		
		return flag;
	}
}
