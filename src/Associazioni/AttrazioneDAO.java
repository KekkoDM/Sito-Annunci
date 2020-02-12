package Associazioni;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Properties;
import javax.swing.table.DefaultTableModel;

public class AttrazioneDAO {
	public ArrayList<Attrazione> getAllAttrazioni() {
		try {
			Connessione c = new Connessione();
			c.ConnessioneDB();
			ResultSet rs= c.Query("*","attrazione"," ");
			ArrayList<Attrazione> lista = new ArrayList();
			while(rs.next()) {
				Attrazione r = new Attrazione();
				r.setNome(rs.getString("nome"));
				r.setCittà(rs.getString("citta"));
				r.setVia(rs.getString("via"));
				r.setCivico(rs.getString("civico"));
				r.setDescrizione(rs.getString("descrizione"));
				r.setTelefono(rs.getString("telefono"));
				lista.add(r);
			}
			return lista;
		}catch(SQLException e){
			System.err.println("Errore SQL");
			e.printStackTrace();
			return null;
		}
	}

/*
		public DefaultTableModel getAttrazione() {
			String column[] = {"Nome","città","Via","Civico","Descrizione","Telefono","Orario"};
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
*/

	}
