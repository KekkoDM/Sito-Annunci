package Associazioni;

public class Utente {
	private String Codu;
	private String Username;
	private String Password;
	private String Nome;
	private String Cognome;
	private String Tipo;
	
	public Utente(String u,String p,String n,String c,String t) {
		Username = u;
		Password = p;
		Nome = n;
		Cognome = c;
		Tipo = t;
	}
	public Utente() {
		Username = " ";
		Password = " ";
		Nome = " ";
		Cognome = " ";
		Tipo = " ";
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getCognome() {
		return Cognome;
	}
	public void setCognome(String cognome) {
		Cognome = cognome;
	}
	public String getTipo() {
		return Tipo;
	}
	public void setTipo(String tipo) {
		Tipo = tipo;
	}
	public String getCodu() {
		return Codu;
	}
	public void setCodu(String codu) {
		Codu = codu;
	}

}
