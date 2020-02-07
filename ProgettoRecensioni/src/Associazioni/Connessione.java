package Associazioni;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Connessione{
	
	private Connection conn;
	private ResultSet rs;
	
	public void ConnessioneDB() {
		
		try {
			Class.forName("org.postgresql.Driver");
		}catch(ClassNotFoundException e) {
			System.err.println("Classe non trovata");
		}
		
		String url = "jdbc:postgresql://localhost/progetto";
		Properties props = new Properties();
		props.setProperty("user","postgres");
		props.setProperty("password","ale123");
		
		 this.conn = null;
		
		try {
			this.conn = DriverManager.getConnection(url, props);
		}catch(SQLException e) {
			System.err.println("Errore SQL");
			e.printStackTrace();
		}
	}
	
	
	
	public ResultSet Query(String select,String from ,String where, DefaultTableModel t) {
		String query="";
		
		
		try {
			
			if(where.contentEquals("")) {
				query = "select "+select +" from "+from;
			}else {
				query = "select "+select +" from "+from + " where " + where;
			}
			
			
			PreparedStatement s = conn.prepareStatement(query);
			rs = s.executeQuery();
			
			
		}catch(SQLException e) {
			System.err.println("Errore SQL");
			e.printStackTrace();
		}
		
		return rs;
	}

	
	
	public void Insert (String table ,String values) {
		
        try {
			
        	String query = "insert into (titolo,testo,"+ table + " values(" + values + ");";
			PreparedStatement st = conn.prepareStatement(query);
			st.executeUpdate();
		}
		catch(SQLException e) {
			System.err.println("Errore");
			e.printStackTrace();
		}
		
	}
	
	public ResultSet Query(String select,String from ,String where) {
		String query=" ";
		try {
			
			if(where.contentEquals(" ")) {
				query = "select "+select +" from "+from;
			}else {
				query = "select "+select +" from "+from + " where " + where;
			}
			PreparedStatement s = conn.prepareStatement(query);
			rs = s.executeQuery();
		}catch(SQLException e) {
			System.err.println("Errore SQL");
			e.printStackTrace();
		}
		
		return rs;
	}
	
	
	
	public void ChiudiConn() {
		try {
			conn.close();
		}catch(SQLException e) {
			System.err.println("Errore Connessione Chiusura");
			e.printStackTrace();
		}
	}
}
