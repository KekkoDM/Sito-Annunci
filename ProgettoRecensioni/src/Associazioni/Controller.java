package Associazioni;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class Controller {
	
	Main_Frame main;
	
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
	public void goAccedi(Main_Frame button )
	{
		Accedi_Frame accedi = new Accedi_Frame();
		accedi.setVisible(true);
		button.setEnabled(false);
		accedi.addWindowListener(new WindowAdapter(){
		    public void windowClosing(WindowEvent e)
		    {
		    	button.setEnabled(true);
		    }
		});
	}
}
