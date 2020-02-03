package Associazioni;

import java.sql.Time;

public class Attrazione {

	private int codat;
	private String nome;
	private String città;
	private String via;
	private int civico;
	private String descrizione;
	private String telefono;
	private Time orario;
	
	public int getCodat() {
		return codat;
	}
	public void setCodat(int codat) {
		this.codat = codat;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCittà() {
		return città;
	}
	public void setCittà(String città) {
		this.città = città;
	}
	public String getVia() {
		return via;
	}
	public void setVia(String via) {
		this.via = via;
	}
	public int getCivico() {
		return civico;
	}
	public void setCivico(int civico) {
		this.civico = civico;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Time getOrario() {
		return orario;
	}
	public void setOrario(Time orario) {
		this.orario = orario;
	}
}
