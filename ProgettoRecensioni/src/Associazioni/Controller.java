package Associazioni;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

//Classe controller 
public class Controller {
	
	ArrayList<Recensione> ListaRec;
	RecensioneDAO Recdao;
	
	ArrayList<ristorante> ListaR;
	ristoranteDAO Rdao;
	
	ArrayList<Alloggio> ListaAl;
	AlloggioDAO Adao;
	
	ArrayList<Attrazione> ListaAt;
	AttrazioneDAO Atdao;
	
	private Utente UtenteCorrente;//Utente che ha appena loggato 
	
	Main_Frame main; //Frame principale del programma
	Accedi_Frame accedi; // Frame di accesso per i vari utenti
	Inserisci_Frame inserisci; // Frame di inserimento della recensione
	Recensioni_Frame rframe; // Frame di visualizzazione delle recensioni
	
	public static void main(String[] args) {
		Controller ctr = new Controller();
	}
	
	//costruttore Controller
	public Controller() {
		UtenteCorrente = new Utente();
		ListaR = new ArrayList<ristorante>();
		Rdao = new ristoranteDAO();
		ListaAl = new ArrayList<Alloggio>();
		Adao = new AlloggioDAO();
		ListaAt = new ArrayList<Attrazione>();
		Atdao = new AttrazioneDAO();
		ListaRec = new ArrayList<Recensione>();
		Recdao = new RecensioneDAO();
		main = new Main_Frame(this);
		main.setVisible(true);
	}
	
	
	public void inserisciRecensione(Recensione r, String from, String codi) {
		Recdao.AggiungiRecensione(r, from, codi);
	}
	public void approvaRecensione(Recensione r) {
		Recdao.approvaRecensione(r);
	}
	public ArrayList<Recensione> getRecensioniRistorante(String l){
		ListaRec = Recdao.getRecensioniRistorante(l);
		return ListaRec;
	}
	public ArrayList<Recensione> getRecensioniAlloggio(String l){
		ListaRec = Recdao.getRecensioniAlloggio(l);
		return ListaRec;
	}
	public ArrayList<Recensione> getRecensioniAttrazione(String l){
		ListaRec = Recdao.getRecensioniAttrazione(l);
		return ListaRec;
	}
	
	//metodi che permettono di recuperare ristoranti attraverso oggetto DAO
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
	//metodi che permettono di recuperare Alloggi attraverso oggetto DAO
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
	//metodi che permettono di recuperare Attrazioni attraverso oggetto DAO
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
	
	public void switchPanel(JLayeredPane panel,JPanel newpanel) { //Metodo che permette di cambiare il panel 
		panel.removeAll();
		panel.add(newpanel);
		panel.repaint();
		panel.revalidate();
	}
	
	public void apriAccedi(){ // Metodo che permette di poter aprire il Frame di Accesso bloccano il MainFrame
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
	
	public void chiudiAccedi() {//Chiude Frame di Accesso
		accedi.dispose();
		main.setEnabled(true);
	}
	
	public void apriInserisci(String from){ //Apre il frame per poter inserire una recensione
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
	
	public void chiudiInserisci() { //chiude il frame di inserimento
		inserisci.dispose();
		main.setEnabled(true);
	}
	
	public void apriRecensioni(String from){//apre il frame che permette di visualizzare le recensioni dei vari elementi
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
	
	public void chiudiRecensioni() {//chiude il frame di visualizzazione delle recensioni
		inserisci.dispose();
		main.setEnabled(true);
	}
	
}
