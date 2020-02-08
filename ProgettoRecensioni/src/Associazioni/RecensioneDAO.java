package Associazioni;

import java.awt.Checkbox;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.swing.JCheckBox;
import javax.swing.table.DefaultTableModel;

public class RecensioneDAO {
	
	
	public void AggiungiRecensione(String luogo,String titolo,String testo, String valutazione) {
		
		
		Connessione c = new Connessione();
		String codri2 = "";
		c.ConnessioneDB();
		
		try {
			
			ResultSet rs =c.Query("codri", "ristorante", "nome = '" + luogo + "'" );
			
			while(rs.next()) {
				int cod = rs.getInt(1);
				codri2= String.valueOf(cod);
			}
			
		}
		catch(SQLException e) {
			System.err.println("Errore SQL");
			e.printStackTrace();
		}
		
		String values= "'" + titolo+ "'"  + "," + codri2 + "," + "'" + testo + "'," + valutazione + "," +"NOW()";
		String attr = "titolo,codri2,testo,valutazione,data";
		
		c.Insert("recensione",attr, values);
		c.ChiudiConn();
	}
	
	
	
	
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
}
