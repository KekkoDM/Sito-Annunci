package Associazioni;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class Controller {
	public static void main(String[] args) {
		Main_Frame main = new Main_Frame();
		main.setVisible(true);
	}
	
	public void switchPanel(JLayeredPane panel,JPanel newpanel) {
		panel.removeAll();
		panel.add(newpanel);
		panel.repaint();
		panel.revalidate();
	}
}