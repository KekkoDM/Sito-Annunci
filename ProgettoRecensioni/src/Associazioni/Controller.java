package Associazioni;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class Controller {
	
	Main_Frame main;
	Accedi_Frame accedi;
	Inserisci_recensione inserisci;
	
	public static void main(String[] args) {
		Controller ctr = new Controller();
	}
	
	public Controller() {
		main = new Main_Frame(this);
		main.setVisible(true);
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
	
	public void apriInserisci(){
		inserisci = new Inserisci_recensione(this);
		inserisci.setVisible(true);
		main.setEnabled(false);
		inserisci.addWindowListener(new WindowAdapter(){ //chiudi tramite la X
		    public void windowClosing(WindowEvent e)
		    {
		    	main.setEnabled(true);
		    }
		});
	}
	
	public void chiudiInsrisci() {
		accedi.dispose();
		main.setEnabled(true);
	}
	
}
