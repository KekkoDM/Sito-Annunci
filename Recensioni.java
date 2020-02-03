package Associazioni;

import java.sql.Date;

public class Recensioni {
	private int codre;
	private String valutazione;
	private String titolo;
	private String testo;
	private Date data;
	
	public int getCodre() {
		return codre;
	}
	public void setCodre(int codre) {
		this.codre = codre;
	}
	public String getValutazione() {
		return valutazione;
	}
	public void setValutazione(String valutazione) {
		this.valutazione = valutazione;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getTesto() {
		return testo;
	}
	public void setTesto(String testo) {
		this.testo = testo;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}

}
