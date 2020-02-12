package Associazioni;

public class Alloggio {
	
	private String Nome;
	private String Città;
	private String Via;
	private String Civico;
	private String Telefono;
	private int codal;
	private int bagni;
	private int camere;
	private int metriq;
	private String tipo;
	
	
	public int getCodal() {
		return codal;
	}
	public void setCodal(int codal) {
		this.codal = codal;
	}
	public int getBagni() {
		return bagni;
	}
	public void setBagni(int bagni) {
		this.bagni = bagni;
	}
	public int getCamere() {
		return camere;
	}
	public void setCamere(int camere) {
		this.camere = camere;
	}
	public int getMetriq() {
		return metriq;
	}
	public void setMetriq(int metriq) {
		this.metriq = metriq;
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
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
