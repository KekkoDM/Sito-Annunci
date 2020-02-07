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
		String col[] = {"Nome","Citt�","Via","Civico","Specialit�"};
		DefaultTableModel tableModel = new DefaultTableModel(col, 0);
		
		Connessione c = new Connessione();
					
		c.ConnessioneDB();
		String select = "nome, citta, via, civico, specialita";
		
		try {
			ResultSet rs=c.Query(select, "ristorante", "", tableModel);
			while(rs.next()) {
				String nome = rs.getString(1);
				String citta = rs.getString(2);
				String via = rs.getString(3);
				int civico = rs.getInt(4);
				String specialita = rs.getString(5);
				
				Object[] riga = {nome, citta, via, civico, specialita};
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
