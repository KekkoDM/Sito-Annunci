package Associazioni;

public class Controller {

	public static void main(String[] args) {
		
		Controller ctr = new Controller();
		Main_Men� frame = new Main_Men�(ctr);
		frame.setVisible(true);
	}
	//funzione goBack che permette di tornare alla schermata iniziale
	public void goBack(Controller ctr) {
		Main_Men� frame = new Main_Men�(ctr);
		frame.setVisible(true);
	}
	//funzione che permette di attivare la schermata di Ristorazione
	public void goRisto(Controller ctr) {
		Schermata_Risto frame = new Schermata_Risto(ctr);
		frame.setVisible(true);
	}
}
