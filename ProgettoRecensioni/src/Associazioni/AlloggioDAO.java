package Associazioni;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.swing.table.DefaultTableModel;

public class AlloggioDAO {
	
	public DefaultTableModel getAlloggio() {
		String column[] = {"Nome","Città","Via","Civico","Bagni","Camere","Letti"};
		DefaultTableModel tableModel = new DefaultTableModel(column, 0);
		
		Connessione c = new Connessione();
		
		c.ConnessioneDB();
		String select = "nome, citta, via, civico, bagni,camere,letti";
		
		try {
			ResultSet rs=c.Query(select, "alloggio", "", tableModel);
			while(rs.next()) {
				String nome = rs.getString(1);
				String citta = rs.getString(2);
				String via = rs.getString(3);
				int civico = rs.getInt(4);
				int bagni = rs.getInt(5);
				int camere = rs.getInt(6);
				int letti = rs.getInt(7);
				
				Object[] riga = {nome, citta, via, civico, bagni,camere,letti};
				tableModel.addRow(riga);
				
			}
		}catch(SQLException e) {
			System.err.println("Errore SQL");
			e.printStackTrace();
		}
		c.ChiudiConn();
		return tableModel;
	}


}
