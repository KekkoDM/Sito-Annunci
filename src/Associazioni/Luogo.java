package Associazioni;

public class Luogo<T> {
	private T Contenuto;
	
	public Luogo(T t) {
		Contenuto = t;
	}
	
	public T getLuogo() {
		return Contenuto;
	}
}
