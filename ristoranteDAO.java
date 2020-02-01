package Associazioni;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.swing.table.DefaultTableModel;

public class ristoranteDAO {
	
	public DefaultTableModel getRistoranti() {
		String col[] = {"Nome","Città","Via","Civico","Specialità"};
		DefaultTableModel tableModel = new DefaultTableModel(col, 0);
		
		
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
		
		
		try {
			conn = DriverManager.getConnection(url, props);
			String query = "select nome, citta, via, civico, specialita from ristorante";
			PreparedStatement s = conn.prepareStatement(query);
			ResultSet rs = s.executeQuery();
			
			while(rs.next()) {
				String nome = rs.getString(1);
				String citta = rs.getString(2);
				String via = rs.getString(3);
				int civico = rs.getInt(4);
				String specialita = rs.getString(5);
				
				Object[] ristorante = {nome, citta, via, civico, specialita};
				tableModel.addRow(ristorante);
			}
		}catch(SQLException e) {
			System.err.println("Errore SQL");
			e.printStackTrace();
		}
		
		return tableModel;
	}

}
