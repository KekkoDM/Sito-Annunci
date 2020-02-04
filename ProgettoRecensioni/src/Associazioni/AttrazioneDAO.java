package Associazioni;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Properties;
import javax.swing.table.DefaultTableModel;

public class AttrazioneDAO {
		
		public DefaultTableModel getAttrazione() {
			String column[] = {"Nome","citt�","Via","Civico","Descrizione","Telefono","Orario"};
			DefaultTableModel tableModel = new DefaultTableModel(column, 0);
			
			Connessione c = new Connessione();
			
			c.ConnessioneDB();
			String select = "Nome, citta,Via,Civico,Descrizione,Telefono,Orario";
			
			try {
				ResultSet rs=c.Query(select, "attrazione", "", tableModel);
				while(rs.next()) {
					String nome = rs.getString(1);
					String citta = rs.getString(2);
					String via = rs.getString(3);
					int civico = rs.getInt(4);
					String Descrizione = rs.getString(5);
					String Telefono = rs.getString(6);
					Date Orario = rs.getDate(7);
					
					Object[] riga = {nome, citta, via, civico, Descrizione,Telefono,Orario};
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
