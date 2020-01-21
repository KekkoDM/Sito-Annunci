package Associazioni;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.swing.table.DefaultTableModel;

public class AlloggiDao{
	
	    public DefaultTableModel getAlloggio() {
		String col[] = {"Nome","citta","via","civico","bagni","camere","letti","metriQ","telefono"};
		DefaultTableModel tableModel = new DefaultTableModel(col, 0);
		
		try {
			Class.forName("org.postgresql.Driver");
		}
		catch(ClassNotFoundException e) {
			System.err.println("Classe non trovata");
		}
		
		String url = "jdbc:postgresql://localhost/prova";
		Properties props = new Properties();
		props.setProperty("user","postgres");
		props.setProperty("password","Password");
		
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(url, props);
			String query = "select nome,citta,via,civico,bagni,camere,letti,metriQ,telefono from alloggio";
			PreparedStatement s = conn.prepareStatement(query);
			ResultSet rs = s.executeQuery();
			while(rs.next()) {
				String nome = rs.getString(1);
				String citta = rs.getString(2);
				String via = rs.getString(3);
				int civico = rs.getInt(4);
				int bagni = rs.getInt(5);
				int camere = rs.getInt(6);
				int letti = rs.getInt(7);
				Float metriQ = rs.getFloat(8);
				String telefono = rs.getString(9);
				
				Object[] alloggi = {nome, citta, via, civico, bagni, camere, letti, metriQ, telefono};
				tableModel.addRow(alloggi);
			}
		}
		catch(SQLException e) {
			System.err.println("Errore SQL");
			e.printStackTrace();
		}
		
		return tableModel;
	}
}