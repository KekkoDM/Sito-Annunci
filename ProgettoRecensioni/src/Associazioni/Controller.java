package Associazioni;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class Controller {
	
	ArrayList<ristorante> ListaR;
	ristoranteDAO Rdao;
	
	ArrayList<Alloggio> ListaAl;
	AlloggioDAO Adao;
	
	ArrayList<Attrazione> ListaAt;
	AttrazioneDAO Atdao;
	
	private Utente UtenteCorrente;
	
	Main_Frame main;
	Accedi_Frame accedi;
	Inserisci_Frame inserisci;
	Recensioni_Frame rframe;
	
	public static void main(String[] args) {
		Controller ctr = new Controller();
	}
	
	public Controller() {
		UtenteCorrente = new Utente();
		ListaR = new ArrayList<ristorante>();
		Rdao = new ristoranteDAO();
		ListaAl = new ArrayList<Alloggio>();
		Adao = new AlloggioDAO();
		ListaAt = new ArrayList<Attrazione>();
		Atdao = new AttrazioneDAO();
		main = new Main_Frame(this);
		main.setVisible(true);
	}
	
	public ArrayList<ristorante> getAllRistoranti(){
		ListaR = Rdao.getAllRistoranti();
		return ListaR;
	}
	public ArrayList<ristorante> getAllRistorantiTerra(){
		ListaR = Rdao.getAllRistorantiTerra();
		return ListaR;
	}
	public ArrayList<ristorante> getAllRistorantiMare(){
		ListaR = Rdao.getAllRistorantiMare();
		return ListaR;
	}
	public ArrayList<ristorante> getAllRistorantiVegan(){
		ListaR = Rdao.getAllRistorantiVegan();
		return ListaR;
	}
	
	public ArrayList<Alloggio> getAllAlloggio(){
		ListaAl = Adao.getAllAlloggi();
		return ListaAl;
	}
	public ArrayList<Alloggio> getAllAlloggioHotel(){
		ListaAl = Adao.getAllAlloggiHotel();
		return ListaAl;
	}
	public ArrayList<Alloggio> getAllAlloggioBB(){
		ListaAl = Adao.getAllAlloggiBandB();
		return ListaAl;
	}
	public ArrayList<Alloggio> getAllAlloggioCasa(){
		ListaAl = Adao.getAllAlloggiCasa();
		return ListaAl;
	}
	
	public ArrayList<Attrazione> getAllAttrazioni(){
		ListaAt = Atdao.getAllAttrazioni();
		return ListaAt;
	}
	public ArrayList<Attrazione> getAllAttrazioniCinema(){
		ListaAt = Atdao.getAllAttrazioniCinema();
		return ListaAt;
	}
	public ArrayList<Attrazione> getAllAttrazioniMuseo(){
		ListaAt = Atdao.getAllAttrazioniMuseo();
		return ListaAt;
	}
	public ArrayList<Attrazione> getAllAttrazioniParco(){
		ListaAt = Atdao.getAllAttrazioniParco();
		return ListaAt;
	}
	
	public void setUtenteCorrente(Utente u) {
		UtenteCorrente = u;
	}
	
	public Utente getUtenteCorrente() {
		return UtenteCorrente;
	}
	
	public void switchPanel(JLayeredPane panel,JPanel newpanel) {
		panel.removeAll();
		panel.add(newpanel);
		panel.repaint();
		panel.revalidate();
	}
	
	public void apriAccedi(){
		accedi = new Accedi_Frame(this);
		accedi.setVisible(true);
		main.setEnabled(false);
		accedi.addWindowListener(new WindowAdapter(){ //chiudi tramite la X
		    public void windowClosing(WindowEvent e)
		    {
		    	main.setEnabled(true);
		    }
		});
	}
	
	public void chiudiAccedi() {
		accedi.dispose();
		main.setEnabled(true);
	}
	
	public void apriInserisci(String from){
		inserisci = new Inserisci_Frame(this,from,this.getUtenteCorrente());
		inserisci.setVisible(true);
		main.setEnabled(false);
		inserisci.addWindowListener(new WindowAdapter(){ //chiudi tramite la X
		    public void windowClosing(WindowEvent e)
		    {
		    	main.setEnabled(true);
		    }
		});
	}
	
	public void chiudiInserisci() {
		inserisci.dispose();
		main.setEnabled(true);
	}
	
	public void apriRecensioni(String from){
		rframe = new Recensioni_Frame(this,from);
		rframe.setVisible(true);
		main.setEnabled(false);
		rframe.addWindowListener(new WindowAdapter(){ //chiudi tramite la X
		    public void windowClosing(WindowEvent e)
		    {
		    	main.setEnabled(true);
		    }
		});
	}
	
	public void chiudiRecensioni() {
		inserisci.dispose();
		main.setEnabled(true);
	}
	
}
