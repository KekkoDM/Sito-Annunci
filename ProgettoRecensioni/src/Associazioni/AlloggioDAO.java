package Associazioni;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.table.DefaultTableModel;

public class AlloggioDAO {

	public ArrayList<Alloggio> getAllAlloggi() {
		try {
			Connessione c = new Connessione();
			c.ConnessioneDB();
			ResultSet rs= c.Query("*","alloggio"," ");
			ArrayList<Alloggio> lista = new ArrayList();
			while(rs.next()) {
				Alloggio r = new Alloggio();
				r.setNome(rs.getString("nome"));
				r.setCittà(rs.getString("citta"));
				r.setVia(rs.getString("via"));
				r.setCivico(rs.getString("civico"));
				r.setBagni(rs.getInt("bagni"));
				r.setCamere(rs.getInt("camere"));
				lista.add(r);
			}
			return lista;
		}catch(SQLException e){
			System.err.println("Errore SQL");
			e.printStackTrace();
			return null;
		}	
	}
	
	public ArrayList<Alloggio> getAllAlloggiHotel() {
		try {
			Connessione c = new Connessione();
			c.ConnessioneDB();
			ResultSet rs= c.Query("*","alloggio join hotel on codal=codal3"," ");
			ArrayList<Alloggio> lista = new ArrayList();
			while(rs.next()) {
				Hotel r = new Hotel();
				r.setNome(rs.getString("nome"));
				r.setCittà(rs.getString("citta"));
				r.setVia(rs.getString("via"));
				r.setCivico(rs.getString("civico"));
				r.setBagni(rs.getInt("bagni"));
				r.setCamere(rs.getInt("camere"));
				r.setServizio(rs.getString("servizio"));
				r.setStelle(rs.getInt("stelle"));
				lista.add(r);
			}
			return lista;
		}catch(SQLException e){
			System.err.println("Errore SQL");
			e.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<Alloggio> getAllAlloggiBandB() {
		try {
			Connessione c = new Connessione();
			c.ConnessioneDB();
			ResultSet rs= c.Query("*","alloggio join beb on codal=codal4"," ");
			ArrayList<Alloggio> lista = new ArrayList<Alloggio>();
			while(rs.next()) {
				Hotel r = new Hotel();
				r.setNome(rs.getString("nome"));
				r.setCittà(rs.getString("citta"));
				r.setVia(rs.getString("via"));
				r.setCivico(rs.getString("civico"));
				r.setBagni(rs.getInt("bagni"));
				r.setCamere(rs.getInt("camere"));
				r.setServizio(rs.getString("servizio"));
				r.setStelle(rs.getInt("stelle"));
				lista.add(r);
			}
			return lista;
		}catch(SQLException e){
			System.err.println("Errore SQL");
			e.printStackTrace();
			return null;
		}
	}
	public ArrayList<Alloggio> getAllAlloggiCasa() {
		try {
			Connessione c = new Connessione();
			c.ConnessioneDB();
			ResultSet rs= c.Query("*","alloggio join casa on codal=codal5"," ");
			ArrayList<Alloggio> lista = new ArrayList<Alloggio>();
			while(rs.next()) {
				Casa r = new Casa();
				r.setNome(rs.getString("nome"));
				r.setCittà(rs.getString("citta"));
				r.setVia(rs.getString("via"));
				r.setCivico(rs.getString("civico"));
				r.setBagni(rs.getInt("bagni"));
				r.setCamere(rs.getInt("camere"));
				r.setGiardino(rs.getString("giardino"));
				r.setLocation(rs.getString("location"));
				lista.add(r);
			}
			return lista;
		}catch(SQLException e){
			System.err.println("Errore SQL");
			e.printStackTrace();
			return null;
		}
	}	
}
