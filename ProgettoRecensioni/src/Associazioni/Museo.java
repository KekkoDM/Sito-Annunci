package Associazioni;

public class Museo extends Attrazione {
	private boolean Guida;
	private String Patrimonio;
	
	
	public boolean isGuida() {
		return Guida;
	}
	public void setGuida(boolean guida) {
		Guida = guida;
	}
	public String getPatrimonio() {
		return Patrimonio;
	}
	public void setPatrimonio(String patrimonio) {
		Patrimonio = patrimonio;
	}
	
	
}
