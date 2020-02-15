package Associazioni;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


//CLASSE UTILIZZATA PER INTERFACCIARSI CON IL DATABASE
public class Connessione{
	
	private Connection conn;
	private ResultSet rs;
	
	//METODO CHE SI COLLEGA AL DATABASE
	public void ConnessioneDB() {
		
		try {
			Class.forName("org.postgresql.Driver");
		}catch(ClassNotFoundException e) {
			System.err.println("Classe non trovata");
		}
		
		String url = "jdbc:postgresql://localhost/progetto";
		Properties props = new Properties();
		props.setProperty("user","postgres");
		props.setProperty("password","F123");
		
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

	
	//METODO CHE PERMETTE DI AGGIUNGERE ELEMENTI NEL DATABASE
	public void Insert (String table ,String attr,String values) {
		
        try {
			
        	String query = "insert into "+ table + "(" + attr + ") values(" + values + ");";
			PreparedStatement st = conn.prepareStatement(query);
			st.executeUpdate();
		}
		catch(SQLException e) {
			System.err.println("Errore SQL");
			e.printStackTrace();
		}
		
	}
	
	//METODO CHE RECUPERA GLI ELEMENTI DAL DATABASE
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
	
	
	//METODO CHE PERMETTE DI ELIMINARE ELEMENTI DAL DATABASE
	public void Delete(String from, String where) {
		
		 try {
				
	        	String query = "delete from "+ from + " where "+ where;
				PreparedStatement st = conn.prepareStatement(query);
				st.executeUpdate();
			}
			catch(SQLException e) {
				System.err.println("Errore");
				e.printStackTrace();
			}
	}
	
	
	//METODO CHE PERMETTE DI AGGIORNRNARE GLI ELEMENTI DEL DATABASE
	public void Update(String table,String values, String where) {
		
		try {
			
        	String query = "update "+ table + " set " + values + " where "+ where;
			PreparedStatement st = conn.prepareStatement(query);
			st.executeUpdate();
		}
		catch(SQLException e) {
			System.err.println("Errore");
			e.printStackTrace();
		}
		
	}
	
	
	public void ChiudiConn() {
		try {
			conn.close();
		}catch(SQLException e) {
			System.err.println("Errore Connessione Chiusura");
			e.printStackTrace();
		}
	}
	
	public Connection getConn() {
		return conn;
	}
}
