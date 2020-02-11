package Associazioni;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.swing.table.DefaultTableModel;

public class ristoranteDAO {
	
	public ArrayList<ristorante> getAllRistoranti() {
		try {
			Connessione c = new Connessione();
			c.ConnessioneDB();
			ResultSet rs= c.Query("*","ristorante"," ");
			ArrayList<ristorante> lista = new ArrayList();
			while(rs.next()) {
				ristorante r = new ristorante();
				r.setNome(rs.getString("nome"));
				r.setCitt�(rs.getString("citta"));
				r.setVia(rs.getString("via"));
				r.setCivico(rs.getString("civico"));
				r.setSpecialita(rs.getString("specialita"));
				lista.add(r);
			}
			return lista;
		}catch(SQLException e){
			System.err.println("Errore SQL");
			e.printStackTrace();
			return null;
		}
	}
	

/*	public DefaultTableModel getRistoranti() {
		String col[] = {"Nome","Citt�","Via","Civico","Specialit�"};
		DefaultTableModel tableModel = new DefaultTableModel(col, 0);
		
		Connessione c = new Connessione();
					
		c.ConnessioneDB();
		String select = "nome, citta, via, civico, specialita";
		ristorante r = new ristorante();
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
	
	
	public DefaultTableModel getRecRistoranti(String luogo) {
		String col[] = {"Nome","Citt�","Specialit�","Valutazione","Titolo" ,"Testo"};
		DefaultTableModel tableModel = new DefaultTableModel(col, 0);
		
		Connessione c = new Connessione();
					
		c.ConnessioneDB();
		String select = "nome, citta, specialita, valutazione ,titolo , testo";
		String from = " ristorante join recensione on codri=codri2 ";
		String where = " nome = '"+ luogo+"' and approvata <> false";
		
		try {
			ResultSet rs=c.Query(select, from, where, tableModel);
			while(rs.next()) {
				String nome = rs.getString(1);
				String citta = rs.getString(2);
				String specialita = rs.getString(3);
				String valutazione = rs.getString(4);
				String titolo = rs.getString(5);
				String testo = rs.getString(6);
				
				Object[] riga = {nome, citta,specialita,valutazione,titolo,testo};
				tableModel.addRow(riga);
				
			}
		}catch(SQLException e) {
			System.err.println("Errore SQL");
			e.printStackTrace();
		}
		c.ChiudiConn();
		return tableModel;
	}*/

}
