package Associazioni;

public class Recensione {
	private String Codice;
	private String Luogo;
	private String Titolo;
	private String Testo;
	private String Valutazione;
	private String Data;
	private String CodU;
	private String CodRi;
	private String CodAl;
	private String CodAt;
	private boolean Approvata;
	
	public String getTitolo() {
		return Titolo;
	}
	public void setTitolo(String titolo) {
		Titolo = titolo;
	}
	public String getTesto() {
		return Testo;
	}
	public void setTesto(String testo) {
		Testo = testo;
	}
	public String getValutazione() {
		return Valutazione;
	}
	public void setValutazione(String valutazione) {
		Valutazione = valutazione;
	}
	public String getData() {
		return Data;
	}
	public void setData(String data) {
		Data = data;
	}
	public String getCodU() {
		return CodU;
	}
	public void setCodU(String codU) {
		CodU = codU;
	}
	public String getCodRi() {
		return CodRi;
	}
	public void setCodRi(String codRi) {
		CodRi = codRi;
	}
	public String getCodAl() {
		return CodAl;
	}
	public void setCodAl(String codAl) {
		CodAl = codAl;
	}
	public String getCodAt() {
		return CodAt;
	}
	public void setCodAt(String codAt) {
		CodAt = codAt;
	}
	public boolean isApprovata() {
		return Approvata;
	}
	public void setApprovata(boolean approvata) {
		Approvata = approvata;
	}
	public String getLuogo() {
		return Luogo;
	}
	public void setLuogo(String luogo) {
		Luogo = luogo;
	}
	public String getCodice() {
		return Codice;
	}
	public void setCodice(String codice) {
		Codice = codice;
	}
}
