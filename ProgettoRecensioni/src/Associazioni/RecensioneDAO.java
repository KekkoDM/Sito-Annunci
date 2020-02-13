package Associazioni;

import java.awt.Checkbox;
import java.awt.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class RecensioneDAO {
		
	public void AggiungiRecensione(Recensione r,String from,String codi) {
		Connessione c = new Connessione();
		String codice = "";
		c.ConnessioneDB();
		try {
			ResultSet rs =c.Query(codi,from, "nome = '" + r.getLuogo() + "'" );
			while(rs.next()) {
				int cod = rs.getInt(1);
				codice= String.valueOf(cod);
			}	
		}
		catch(SQLException e) {
			System.err.println("Errore SQL");
			e.printStackTrace();
		}
		String values= "'" +r.getTitolo()+ "'"  + "," + codice + "," + "'" + r.getTitolo() + "'," + r.getValutazione() + "," +"NOW(), "+r.getCodU();
		String attr = "titolo,"+codi+"2,testo,valutazione,data,codu2";
		c.Insert("recensione",attr, values);
		c.ChiudiConn();
	}
	
	public ArrayList<Recensione> getAllRecensioniNA(){
		try {
			Connessione c = new Connessione();
			c.ConnessioneDB();
			ResultSet rs= c.Query("*","recensione","approvata = 'f'");
			ArrayList<Recensione> lista = new ArrayList();
			while(rs.next()) {
				Recensione r = new Recensione();
				r.setCodice(rs.getString("codre"));
				r.setTitolo(rs.getString("titolo"));
				r.setValutazione(rs.getString("valutazione"));
				r.setTesto(rs.getString("testo"));
				r.setData(rs.getString("data"));
				r.setCodAl(rs.getString("codal2"));
				r.setCodAt(rs.getString("codat2"));
				r.setCodRi(rs.getString("codri2"));
				r.setCodU(rs.getString("codu2"));
				lista.add(r);
			}
			return lista;
		}catch(SQLException e){
			System.err.println("Errore SQL");
			e.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<Recensione> getRecensioniRistorante(String l){
		try {
			Connessione c = new Connessione();
			c.ConnessioneDB();
			String from="recensione AS re join ristorante AS ri on codri = codri2";
			String where="re.approvata = 't' AND ri.nome = '"+l+"'";
			ResultSet rs= c.Query("titolo,testo,valutazione,data,codu2",from,where);
			ArrayList<Recensione> lista = new ArrayList();
			while(rs.next()) {
				Recensione r = new Recensione();
				
				r.setTitolo(rs.getString("titolo"));
				r.setValutazione(rs.getString("valutazione"));
				r.setTesto(rs.getString("testo"));
				r.setData(rs.getString("data"));
				r.setCodU(rs.getString("codu2"));
				lista.add(r);
			}
			return lista;
		}catch(SQLException e){
			System.err.println("Errore SQL");
			e.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<Recensione> getRecensioniAlloggio(String l){
		try {
			Connessione c = new Connessione();
			c.ConnessioneDB();
			String from ="recensione AS re join alloggio AS al on codal = codal2";
			String where ="re.approvata = 't' AND al.nome = '"+l+"'";
			ResultSet rs= c.Query("*",from,where);
			ArrayList<Recensione> lista = new ArrayList();
			while(rs.next()) {
				Recensione r = new Recensione();
				r.setCodice(rs.getString("codre"));
				r.setTitolo(rs.getString("titolo"));
				r.setValutazione(rs.getString("valutazione"));
				r.setTesto(rs.getString("testo"));
				r.setData(rs.getString("data"));
				r.setCodAl(rs.getString("codal2"));
				r.setCodAt(rs.getString("codat2"));
				r.setCodRi(rs.getString("codri2"));
				r.setCodU(rs.getString("codu2"));
				lista.add(r);
			}
			return lista;
		}catch(SQLException e){
			System.err.println("Errore SQL");
			e.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<Recensione> getRecensioniAttrazione(String l){
		try {
			Connessione c = new Connessione();
			c.ConnessioneDB();
			String from ="recensione AS re join attrazione AS at on codat = codat2";
			String where = "re.approvata = 't' AND at.nome = '"+l+"'";
			ResultSet rs= c.Query("*",from,where);
			ArrayList<Recensione> lista = new ArrayList();
			while(rs.next()) {
				Recensione r = new Recensione();
				r.setCodice(rs.getString("codre"));
				r.setTitolo(rs.getString("titolo"));
				r.setValutazione(rs.getString("valutazione"));
				r.setTesto(rs.getString("testo"));
				r.setData(rs.getString("data"));
				r.setCodAl(rs.getString("codal2"));
				r.setCodAt(rs.getString("codat2"));
				r.setCodRi(rs.getString("codri2"));
				r.setCodU(rs.getString("codu2"));
				lista.add(r);
			}
			return lista;
		}catch(SQLException e){
			System.err.println("Errore SQL");
			e.printStackTrace();
			return null;
		}
	}
	
	public void approvaRecensione(Recensione r) {
		
		Connessione c = new Connessione();
		c.ConnessioneDB();
		c.Update("recensione", "approvata = true", "codre = "+ r.getCodice());
		c.ChiudiConn();
	}
	
	public void cancellaRecensione(Recensione r) {
		
		Connessione c =new Connessione();
		c.ConnessioneDB();
		c.Delete("recensione", "codre = "+r.getCodice());
		c.ChiudiConn();
	}
/*
	public DefaultTableModel getRistoNonApprovate() {
		String column[] = {"Nome","Valutazione","Titolo","Testo","Data","Approva"};
		DefaultTableModel tab = new DefaultTableModel(column, 0);
		Connessione c = new Connessione();
		
		c.ConnessioneDB();
		String select = "nome,valutazione,titolo,testo,data";
		
		try {
			
			ResultSet rs =c.Query(select, "ristorante join recensione on codri=codri2", "approvata <> true", tab);
			
			while(rs.next()) {
				String nome = rs.getString(1);
				String valutazione = rs.getString(2);
				String titolo = rs.getString(3);
				String testo = rs.getString(4);
				Date data= rs.getDate(5);
				JCheckBox approva = new JCheckBox();
				
				Object[] recensione = {nome,valutazione,titolo,testo,data,approva};
				tab.addRow(recensione);
				
			}
			c.ChiudiConn();
		}
		catch(SQLException e) {
			System.err.println("Errore SQL");
			e.printStackTrace();
		}
		return tab;
	}
	*/
}
