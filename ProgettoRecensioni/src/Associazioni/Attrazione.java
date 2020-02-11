package Associazioni;

import java.sql.Time;

public class Attrazione extends Luogo{

	private int codat;
	private String descrizione;
	private Time orario;
	
	public int getCodat() {
		return codat;
	}
	public void setCodat(int codat) {
		this.codat = codat;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public Time getOrario() {
		return orario;
	}
	public void setOrario(Time orario) {
		this.orario = orario;
	}
}
