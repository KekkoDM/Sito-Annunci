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
	public ArrayList<Attrazione> getAllAttrazioni() {//funzione che permette di recuperare tutti gli elementi dal DB in un arraylist
		try {
			Connessione c = new Connessione();
			c.ConnessioneDB();
			ResultSet rs= c.Query("*","attrazione"," ");
			ArrayList<Attrazione> lista = new ArrayList<Attrazione>();
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
	
	public ArrayList<Attrazione> getAllAttrazioniCinema() {//funzione che permette di recuperare tutti gli elementi dal DB in un arraylist
		try {
			Connessione c = new Connessione();
			c.ConnessioneDB();
			ResultSet rs= c.Query("*","attrazione join cinema on codat = codat3"," ");
			ArrayList<Attrazione> lista = new ArrayList<Attrazione>();
			while(rs.next()) {
				Cinema r = new Cinema();
				r.setNome(rs.getString("nome"));
				r.setCittà(rs.getString("citta"));
				r.setVia(rs.getString("via"));
				r.setCivico(rs.getString("civico"));
				r.setDescrizione(rs.getString("descrizione"));
				r.setTelefono(rs.getString("telefono"));
				r.setCapienza(rs.getInt("capienza"));
				r.setNSale(rs.getInt("nsale"));
				lista.add(r);
			}
			return lista;
		}catch(SQLException e){
			System.err.println("Errore SQL");
			e.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<Attrazione> getAllAttrazioniMuseo() {//funzione che permette di recuperare tutti gli elementi dal DB in un arraylist
		try {
			Connessione c = new Connessione();
			c.ConnessioneDB();
			ResultSet rs= c.Query("*","attrazione join museo on codat = codat4"," ");
			ArrayList<Attrazione> lista = new ArrayList<Attrazione>();
			while(rs.next()) {
				Museo r = new Museo();
				r.setNome(rs.getString("nome"));
				r.setCittà(rs.getString("citta"));
				r.setVia(rs.getString("via"));
				r.setCivico(rs.getString("civico"));
				r.setDescrizione(rs.getString("descrizione"));
				r.setTelefono(rs.getString("telefono"));
				r.setPatrimonio(rs.getString("patrimonio"));
				r.setGuida(rs.getBoolean("guida"));
				lista.add(r);
			}
			return lista;
		}catch(SQLException e){
			System.err.println("Errore SQL");
			e.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<Attrazione> getAllAttrazioniParco() {//funzione che permette di recuperare tutti gli elementi dal DB in un arraylist
		try {
			Connessione c = new Connessione();
			c.ConnessioneDB();
			ResultSet rs= c.Query("*","attrazione join parco on codat = codat5"," ");
			ArrayList<Attrazione> lista = new ArrayList<Attrazione>();
			while(rs.next()) {
				Parco r = new Parco();
				r.setNome(rs.getString("nome"));
				r.setCittà(rs.getString("citta"));
				r.setVia(rs.getString("via"));
				r.setCivico(rs.getString("civico"));
				r.setDescrizione(rs.getString("descrizione"));
				r.setTelefono(rs.getString("telefono"));
				r.setNGiostre(rs.getInt("ngiostre"));
				r.setZoo(rs.getBoolean("zoo"));
				r.setSpettacoli(rs.getBoolean("spettacoli"));
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
