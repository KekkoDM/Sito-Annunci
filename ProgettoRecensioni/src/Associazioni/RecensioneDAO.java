package Associazioni;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.swing.table.DefaultTableModel;

public class RecensioneDAO {
	public void AggiungiRecensione(int codre,float valutazione,String titolo,String testo,Date data) {
		try {
			Class.forName("org.postgresql.Driver");
		}
		catch(ClassNotFoundException e) {
			System.err.println("Classe non trovata");
		}
		String url = "jdbc:postgresql://localhost/progetto";
		Properties prop = new Properties();
		prop.setProperty("user","postgres");
		prop.setProperty("password","Password");
		
		Connection connect = null;
		
		try {
			connect = DriverManager.getConnection(url, prop);
			String query = "insert into recensione values ( , , , , , , , , , )";
			PreparedStatement st = connect.prepareStatement(query);
			st.clearParameters();
			st.setInt(1, codre);
			st.setFloat(2, valutazione);
			st.setString(3, titolo);
			st.setString(4, testo);
			st.setDate(5, data);
			
			st.executeUpdate();
		}
		catch(SQLException e) {
			System.err.println("Errore");
			e.printStackTrace();
		}
	}

	public DefaultTableModel getRecesnione() {
		String column[] = {"CodRe","Valutazione","Titolo","Testo","Data"};
		DefaultTableModel tab = new DefaultTableModel(column, 0);
		
		try {
			Class.forName("org.postgresql.Driver");
		}
		catch(ClassNotFoundException e) {
			System.err.println("Classe non trovata");
		}
		
		String url = "";
		Properties props = new Properties();
		props.setProperty("user","postgres");
		props.setProperty("password","Password");
		
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(url, props);
			String query = "select * from recensione";
			PreparedStatement s = conn.prepareStatement(query);
			ResultSet rs = s.executeQuery();
			
			while(rs.next()) {
				int codre = rs.getInt(1);
				String valutazione = rs.getString(2);
				String titolo = rs.getString(3);
				String testo = rs.getString(4);
				Date data= rs.getDate(4);
				
				Object[] recensione = {codre,valutazione,titolo,testo,data};
				tab.addRow(recensione);
			}
		}
		catch(SQLException e) {
			System.err.println("Errore SQL");
			e.printStackTrace();
		}
		
		return tab;
	}
}
