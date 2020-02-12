package Associazioni;

import java.sql.Time;

public class Attrazione {
	private String Nome;
	private String Città;
	private String Via;
	private String Civico;
	private String Telefono;
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
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getCittà() {
		return Città;
	}
	public void setCittà(String città) {
		Città = città;
	}
	public String getVia() {
		return Via;
	}
	public void setVia(String via) {
		Via = via;
	}
	public String getCivico() {
		return Civico;
	}
	public void setCivico(String civico) {
		Civico = civico;
	}
	public String getTelefono() {
		return Telefono;
	}
	public void setTelefono(String telefono) {
		Telefono = telefono;
	}
}
