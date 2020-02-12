package Associazioni;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class UtentiDAO {
	
	public Utente checkUtente(String u, String p) {
		Connessione c = new Connessione();
		c.ConnessioneDB();
		
		Utente user = new Utente();
		String select = "username,password,nome,cognome,tipo";
		String where = "username='" + u + "' and password ='" + p +"'";
		try {
			
			ResultSet rs = c.Query(select, "utente", where);
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
			c.ChiudiConn();
		}catch(SQLException e) {
			System.err.println("Errore SQL");
			e.printStackTrace();
		}
		return user;
	}
}
