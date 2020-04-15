package Associazioni;

import java.awt.Color;
import java.awt.Panel;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AddPanel {

	Controller ctr;
	
	
	public void addRisto(JPanel ristopanel,Main_Frame main) {
		
		JTable ristotable;
		
		
		ristopanel.setForeground(new Color(255, 255, 255));
		ristopanel.setBackground(new Color(255, 255, 255));
		
		ristopanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 149, 823, 436);
		ristopanel.add(scrollPane);
		
		//Tabella del ristorante
				ristotable = new JTable();
				ristotable.setEnabled(false);
				ristotable.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"Nome", "Città", "Via", "Civico", "Specialità"
					}
				));
				
				
				main.populateJTableRisto(ctr.getAllRistoranti(),ristotable); //Aggiungo in tabella tutti i ristoranti presenti nel DB
				
				
				scrollPane.setViewportView(ristotable);
				ristotable.setFillsViewportHeight(true);
				ristotable.setColumnSelectionAllowed(true);
				ristotable.setBackground(new Color(245, 245, 245));
				ristotable.setRowHeight(50);		
		
	}
}
