package Associazioni;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;

public class Recensioni_Frame extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JComboBox ristocombo;
	private JTable ristotable;
	private ristoranteDAO rdao= new ristoranteDAO();
    

	public Recensioni_Frame(Controller ctr) {
		
		setBounds(100, 100, 525, 357);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		
		ristocombo = new JComboBox();
		ristocombo.setBounds(12, 27, 180, 20);
		contentPanel.add(ristocombo);
		this.updateComboBox("ristorante");
		
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						String luogo = ristocombo.getSelectedItem().toString();
						
						JScrollPane scrollPane4 = new JScrollPane();
						scrollPane4.setBounds(120, 78, 598, 426);
						contentPanel.add(scrollPane4);
					
						//TABELLA MODERATORE
						ristotable = new JTable(rdao.getRecRistoranti(luogo));
						scrollPane4.setViewportView(ristotable);
						ristotable.setFillsViewportHeight(true);
						ristotable.setColumnSelectionAllowed(true);
						ristotable.setEnabled(false);
						ristotable.setBackground(new Color(245, 245, 245));
						ristotable.setRowHeight(50);
						
					}
				});
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	
	
	public void updateComboBox(String from) {
		Connessione c = new Connessione();
		c.ConnessioneDB();
		try {
			ResultSet rs= c.Query("*",from," ");
			while(rs.next()) {
				this.getComboBox().addItem(rs.getString("nome"));
			}
		}catch(SQLException e){
			System.err.println("Errore SQL");
			e.printStackTrace();
		}
	}
	
	
	public JComboBox getComboBox() {
		return ristocombo;
	}
}
