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

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ristoranteDAO {
	
	public ArrayList<ristorante> getAllRistoranti() {//funzione che permette di recuperare tutti gli elementi dal DB in un arraylist
		try {
			Connessione c = new Connessione();
			c.ConnessioneDB();
			ResultSet rs= c.Query("*","ristorante"," ");
			ArrayList<ristorante> lista = new ArrayList<ristorante>();
			while(rs.next()) {
				ristorante r = new ristorante();
				r.setNome(rs.getString("nome"));
				r.setCittà(rs.getString("citta"));
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
	
	public ArrayList<ristorante> getAllRistorantiTerra() {//funzione che permette di recuperare tutti gli elementi specializzati dal DB in un arraylist
		try {
			Connessione c = new Connessione();
			c.ConnessioneDB();
			ResultSet rs= c.Query("*","ristorante join terra on codt2=codt"," ");
			ArrayList<ristorante> lista = new ArrayList<ristorante>();
			while(rs.next()) {
				ristorante r = new ristorante();//viene creato l'oggetto ristorante e viene settato con il valori presi dalla query
				r.setNome(rs.getString("nome"));
				r.setCittà(rs.getString("citta"));
				r.setVia(rs.getString("via"));
				r.setCivico(rs.getString("civico"));
				r.setSpecialita(rs.getString("specialita"));
				r.setTipo(rs.getString("tipot"));
				lista.add(r);
			}
			return lista;
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null,"Aa");
			System.err.println("Errore SQL");
			e.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<ristorante> getAllRistorantiMare() {//funzione che permette di recuperare tutti gli elementi specializzati dal DB in un arraylist
		try {
			Connessione c = new Connessione();
			c.ConnessioneDB();
			ResultSet rs= c.Query("*","ristorante join mare on codm2=codm"," ");
			ArrayList<ristorante> lista = new ArrayList<ristorante>();
			while(rs.next()) {
				ristorante r = new ristorante();//viene creato l'oggetto ristorante e viene settato con il valori presi dalla query
				r.setNome(rs.getString("nome"));
				r.setCittà(rs.getString("citta"));
				r.setVia(rs.getString("via"));
				r.setCivico(rs.getString("civico"));
				r.setSpecialita(rs.getString("specialita"));
				r.setTipo(rs.getString("tipom"));
				lista.add(r);
			}
			return lista;
		}catch(SQLException e){
			System.err.println("Errore SQL");
			e.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<ristorante> getAllRistorantiVegan() {//funzione che permette di recuperare tutti gli elementi specializzati dal DB in un arraylist
		try {
			Connessione c = new Connessione();
			c.ConnessioneDB();
			ResultSet rs= c.Query("*","ristorante join vegan on codv2=codv"," ");
			ArrayList<ristorante> lista = new ArrayList<ristorante>();
			while(rs.next()) {
				ristorante r = new ristorante();//viene creato l'oggetto ristorante e viene settato con il valori presi dalla query
				r.setNome(rs.getString("nome"));
				r.setCittà(rs.getString("citta"));
				r.setVia(rs.getString("via"));
				r.setCivico(rs.getString("civico"));
				r.setSpecialita(rs.getString("specialita"));
				r.setTipo(rs.getString("tipov"));
				lista.add(r);
			}
			return lista;
		}catch(SQLException e){
			System.err.println("Errore SQL");
			e.printStackTrace();
			return null;
		}
	}
	
	
    public void AggiungiRistorante(ristorante risto, String from) {
    	Connessione c = new Connessione();
		c.ConnessioneDB();
		
		String values= "'"+risto.getNome()+"','"+risto.getCittà()+"','"+risto.getProvenienza()+"','"+risto.getQualita()+"','"+risto.getSpecialita()+"','"+risto.getVia()+"',"+risto.getCodm2()+risto.getCodt2()+risto.getCodv2()+risto.getCivico();
		String attr ="nome,citta,provenienza,qualita,specialita,via,codm2,codt2,codv2,civico" ;
		c.Insert("ristorante",attr, values);
		c.ChiudiConn();
    }
}
