package Associazioni;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class UtentiDAO {
	
	public Utente checkUtente(String u, String p) {
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
		
		Utente user = new Utente();
		try {
			conn = DriverManager.getConnection(url, props);
			String query = "select username,password,nome,cognome,tipo from utente where username='" + u + "' and password ='" + p +"'";
			PreparedStatement s = conn.prepareStatement(query);
			ResultSet rs = s.executeQuery();
			while(rs.next()) {
				String username = rs.getString(1);
				String password = rs.getString(2);
				String nome = rs.getString(3);
				String cognome = rs.getString(4);
				String tipo = rs.getString(5);
				if(p.equals(password) && u.equals(username)) {
					user.setUsername(username);
					user.setPassword(password);
					user.setNome(nome);
					user.setCognome(cognome);
					user.setTipo(tipo);
					break;
				}
			}
		}catch(SQLException e) {
			System.err.println("Errore SQL");
			e.printStackTrace();
		}
		return user;
	}
}
